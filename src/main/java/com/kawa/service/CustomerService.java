package com.kawa.service;

import com.kawa.service.dto.request.CustomerInsertRequestDTO;
import com.kawa.service.dto.response.CustomerResponseDTO;
import com.kawa.service.dto.response.InsertResponseDTO;

public interface CustomerService {

    CustomerResponseDTO getCustomer(String id);

    CustomerResponseDTO getCustomers();

    InsertResponseDTO insertCustomer(CustomerInsertRequestDTO requestDTO);
}
