package com.example.workintech.ecommege.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.workintech.ecommege.entity.Address;


public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

}