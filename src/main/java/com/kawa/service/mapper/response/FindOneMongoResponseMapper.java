package com.kawa.service.mapper.response;

import com.kawa.domain.bean.Customer;
import com.kawa.service.dto.response.CustomerResponseDTO;
import com.kawa.service.dto.response.mongo.CustomerFindOneMongoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Mapper for the Response DTO {@link CustomerResponseDTO} and its Mongo DTO {@link CustomerFindOneMongoResponseDTO}.
 */
@Mapper(componentModel = "spring", imports = { Arrays.class })
public interface FindOneMongoResponseMapper {
    @Mapping(target = "customers", expression = "java(toEntityList(dto.getDocument()))")
    CustomerResponseDTO toEntity(CustomerFindOneMongoResponseDTO dto);

    @Mapping(target = "document", expression = "java(entityList.getCustomers().get(0))")
    CustomerFindOneMongoResponseDTO toDto(CustomerResponseDTO entityList);

    default List<Customer> toEntityList(Customer customer) {
        return (customer.isNull()) ? Collections.emptyList() : Collections.singletonList(customer);
    }
}
