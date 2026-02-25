package com.example.workintech.ecommege.service;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.workintech.ecommege.entity.Address;
import com.example.workintech.ecommege.entity.User;
import com.example.workintech.ecommege.mapper.AddressMapper;
import com.example.workintech.ecommege.dto.BackendResponse;
import com.example.workintech.ecommege.dto.AddressUpdateRequest;
import com.example.workintech.ecommege.dto.AddressResponse;
import com.example.workintech.ecommege.dto.AddressRequest;
import com.example.workintech.ecommege.repository.UserRepository;
import com.example.workintech.ecommege.repository.AddressRepository;
import com.example.workintech.ecommege.exceptions.EntityNotFoundException;
import com.example.workintech.ecommege.exceptions.AddressNotFoundException;


@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressResponse> getAddresses() {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));

        return addressRepository.findByUserId(user.getId()).stream().map(addressMapper::toResponse).toList();
    }

    @Override
    public AddressResponse save(AddressRequest addressRequest) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
        Address address = addressMapper.toEntity(addressRequest);
        address.setUser(user);

        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public AddressResponse update(AddressUpdateRequest updateRequest) {

        Address existingAddress = addressRepository.findById(updateRequest.id()).orElseThrow(() -> new AddressNotFoundException("Address not found!!"));
        Address address = addressMapper.toEntity(updateRequest);
        address.setCreatedAt(existingAddress.getCreatedAt());
        address.setUser(existingAddress.getUser());

        return addressMapper.toResponse(addressRepository.save(address));
    }

    @Override
    public BackendResponse delete(Long id) {

        if (!addressRepository.findById(id).isPresent()) {
            throw new EntityNotFoundException("Address not found!!");
        }
        addressRepository.deleteById(id);

        return new BackendResponse("Record deleted successfully...");

    }


}

