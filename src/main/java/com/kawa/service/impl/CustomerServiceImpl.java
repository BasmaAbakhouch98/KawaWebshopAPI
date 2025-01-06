package com.kawa.service.impl;

import com.kawa.management.MongoRequestService;
import com.kawa.service.CustomerService;
import com.kawa.service.dto.request.CustomerInsertRequestDTO;
import com.kawa.service.dto.request.mongo.CustomerFindAllMongoRequestDTO;
import com.kawa.service.dto.request.mongo.CustomerFindOneMongoRequestDTO;
import com.kawa.service.dto.request.mongo.CustomerInsertMongoRequestDTO;
import com.kawa.service.dto.response.CustomerResponseDTO;
import com.kawa.service.dto.response.InsertResponseDTO;
import com.kawa.service.dto.response.mongo.CustomerFindAllMongoResponseDTO;
import com.kawa.service.dto.response.mongo.CustomerFindOneMongoResponseDTO;
import com.kawa.service.dto.response.mongo.InsertMongoResponseDTO;
import com.kawa.service.mapper.request.FindOneMongoRequestMapper;
import com.kawa.service.mapper.request.InsertMongoRequestMapper;
import com.kawa.service.mapper.response.FindAllMongoResponseMapper;
import com.kawa.service.mapper.response.FindOneMongoResponseMapper;
import com.kawa.service.mapper.response.InsertMongoResponseMapper;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final FindOneMongoRequestMapper findOneMongoRequestMapper;

    private final FindOneMongoResponseMapper findOneMongoResponseMapper;

    private final FindAllMongoResponseMapper findAllMongoResponseMapper;

    private final InsertMongoRequestMapper insertMongoRequestMapper;

    private final InsertMongoResponseMapper insertMongoResponseMapper;

    private final MongoRequestService mongoRequestService;

    public CustomerServiceImpl(
        FindOneMongoRequestMapper findOneMongoRequestMapper,
        MongoRequestService mongoRequestService,
        FindOneMongoResponseMapper findOneMongoResponseMapper,
        FindAllMongoResponseMapper findAllMongoResponseMapper,
        InsertMongoRequestMapper insertMongoRequestMapper,
        InsertMongoResponseMapper insertMongoResponseMapper
    ) {
        this.findOneMongoRequestMapper = findOneMongoRequestMapper;
        this.mongoRequestService = mongoRequestService;
        this.findOneMongoResponseMapper = findOneMongoResponseMapper;
        this.findAllMongoResponseMapper = findAllMongoResponseMapper;
        this.insertMongoRequestMapper = insertMongoRequestMapper;
        this.insertMongoResponseMapper = insertMongoResponseMapper;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        CustomerFindOneMongoRequestDTO mongoRequestDTO = findOneMongoRequestMapper.toDto(id);

        return findOneMongoResponseMapper.toEntity(mongoRequestService.findOne(mongoRequestDTO, CustomerFindOneMongoResponseDTO.class));
    }

    @Override
    public CustomerResponseDTO getCustomers() {
        CustomerFindAllMongoRequestDTO mongoRequestDTO = new CustomerFindAllMongoRequestDTO();

        return findAllMongoResponseMapper.toEntity(mongoRequestService.findAll(mongoRequestDTO, CustomerFindAllMongoResponseDTO.class));
    }

    @Override
    public InsertResponseDTO insertCustomer(CustomerInsertRequestDTO requestDTO) {
        CustomerInsertMongoRequestDTO mongoRequestDTO = insertMongoRequestMapper.toDto(requestDTO);

        return insertMongoResponseMapper.toEntity(mongoRequestService.insert(mongoRequestDTO, InsertMongoResponseDTO.class));
    }
}
