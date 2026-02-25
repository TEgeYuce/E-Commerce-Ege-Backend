package com.example.workintech.ecommege.service;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.example.workintech.ecommege.exceptions.*;
import com.example.workintech.ecommege.mapper.UserMapper;
import com.example.workintech.ecommege.jwt.JwtUtil;
import com.example.workintech.ecommege.entity.User;
import com.example.workintech.ecommege.entity.Role;
import com.example.workintech.ecommege.repository.UserRepository;
import com.example.workintech.ecommege.repository.RoleRepository;
import com.example.workintech.ecommege.dto.UserSignupRequest;
import com.example.workintech.ecommege.dto.UserResponse;
import com.example.workintech.ecommege.dto.LoginRequest;
import com.example.workintech.ecommege.dto.BackendResponse;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final JwtUtil jwtUtil;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;

    @Autowired
    private final RoleRepository roleRepository;

    @Override
    public UserResponse getByEmail(String email) {

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
        String token = jwtUtil.generateToken(user.getEmail());
        Long roleId = user.getRoles().get(0).getId();

        return new UserResponse(token, user.getFullName(), user.getEmail(), roleId);
    }

    @Override
    public BackendResponse save(UserSignupRequest signupRequest) {

        if (userRepository.findByEmail(signupRequest.email()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered!!");
        }

        Role role = roleRepository.findById(signupRequest.role_id()).orElseThrow(() -> new RoleNotFoundException("Role not found!!"));

        User user = userMapper.toEntity(signupRequest);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(List.of(role));
        user.setIsVerified(true);
        user.setVerificationToken(null);

        userRepository.save(user);

        String jwtToken = jwtUtil.generateToken(user.getEmail());

        System.out.println("\n" + "=" .repeat(60));
        System.out.println("User Registered Successfully...");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getFullName());
        System.out.println("Role: " + role.getName());
        System.out.println("\n JWT Token for Authentication: ");
        System.out.println(jwtToken);
        System.out.println("\n Use this token in Authorization header: ");
        System.out.println("Authorization: Bearer " + jwtToken);
        System.out.println("=" .repeat(60) + "\n");
        return new BackendResponse("User registered successfully!! Check console for JWT token.");
    }

    @Override
    public UserResponse verify(String token) {

        User user = userRepository.findByVerificationToken(token)
                .orElseThrow(() -> new TokenNotValidException("Invalid verification token!!"));

        if (user.getIsVerified()) {
            throw new TokenNotValidException("User is already verified!!");
        }
        user.setIsVerified(true);
        user.setVerificationToken(null);
        userRepository.save(user);

        String jwtToken = jwtUtil.generateToken(user.getEmail());

        System.out.println("\n" + "=" .repeat(60));
        System.out.println("User Verified Successfully...");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getFullName());
        System.out.println("\n JWT Token for Authentication: ");
        System.out.println(jwtToken);
        System.out.println("\n Use this token in Authorization header: ");
        System.out.println("Authorization: Bearer " + jwtToken);
        System.out.println("=" .repeat(60) + "\n");
        return new UserResponse(jwtToken, user.getFullName(), user.getEmail(), user.getRoles().get(0).getId());
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {

        User user = userRepository.findByEmail(loginRequest.email()).orElseThrow(() -> new UserNotFoundException("User not found!!"));
        if (!passwordEncoder.matches(loginRequest.password(), user.getPassword())) {
            throw new InvalidPasswordException("Wrong login information!!");
        }

        if (!user.getIsVerified()) {
            throw new TokenNotValidException("User isn't verified!! Please verify your account first.");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        System.out.println("\n" + "=" .repeat(60));
        System.out.println("User Logged in Successfully...");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Name: " + user.getFullName());
        System.out.println("\n JWT Token for Authentication: ");
        System.out.println(token);
        System.out.println("\n Use this token in Authorization header: ");
        System.out.println("Authorization: Bearer " + token);
        System.out.println("=" .repeat(60) + "\n");
        return new UserResponse(token, user.getFullName(), user.getEmail(), user.getRoles().get(0).getId());

    }


}

