package com.example.workintech.ecommege.service;
import java.util.stream.Collectors;
import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import com.example.workintech.ecommege.mapper.OrderMapper;
import com.example.workintech.ecommege.exceptions.AddressNotFoundException;
import com.example.workintech.ecommege.entity.User;
import com.example.workintech.ecommege.entity.Product;
import com.example.workintech.ecommege.entity.Order;
import com.example.workintech.ecommege.entity.Address;
import com.example.workintech.ecommege.dto.OrderResponse;
import com.example.workintech.ecommege.dto.OrderRequest;
import com.example.workintech.ecommege.dto.OrderProductsRequest;
import com.example.workintech.ecommege.repository.UserRepository;
import com.example.workintech.ecommege.repository.ProductRepository;
import com.example.workintech.ecommege.repository.OrderRepository;
import com.example.workintech.ecommege.repository.AddressRepository;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final AddressRepository addressRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponse> getOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));
        Long userId = user.getId();

        return orderRepository.findByUserId(userId).stream().map(orderMapper::toResponse).collect(Collectors.toList());
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!!"));

        Address address = addressRepository.findById(orderRequest.address_id()).orElseThrow(() -> new AddressNotFoundException("Address not found!!"));

        List<Long> productIds = orderRequest.products().stream().map(OrderProductsRequest::product_id).toList();
        List<Product> products = productRepository.findAllById(productIds);

        Order order = orderRepository.save(orderMapper.toEntity(orderRequest, user, address, products));

        return orderMapper.toResponse(orderRepository.save(order));

    }


}

