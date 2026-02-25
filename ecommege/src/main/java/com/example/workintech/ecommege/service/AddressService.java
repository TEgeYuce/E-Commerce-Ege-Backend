package com.example.workintech.ecommege.service;
import java.util.List;
import com.example.workintech.ecommege.dto.BackendResponse;
import com.example.workintech.ecommege.dto.AddressUpdateRequest;
import com.example.workintech.ecommege.dto.AddressResponse;
import com.example.workintech.ecommege.dto.AddressRequest;


public interface AddressService {

    List<AddressResponse> getAddresses();
    AddressResponse save(AddressRequest addressRequest);
    AddressResponse update(AddressUpdateRequest updateRequest);
    BackendResponse delete(Long id);

}

