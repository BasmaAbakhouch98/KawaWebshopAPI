package com.kawa.service.mapper.response;

import com.kawa.service.dto.response.CustomerResponseDTO;
import com.kawa.service.dto.response.mongo.CustomerFindAllMongoResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the Response DTO {@link CustomerResponseDTO} and its Mongo DTO {@link CustomerFindAllMongoResponseDTO}.
 */
@Mapper(componentModel = "spring")
public interface FindAllMongoResponseMapper {
    @Mapping(target = "customers", source = "documents")
    CustomerResponseDTO toEntity(CustomerFindAllMongoResponseDTO dtoList);

    @Mapping(target = "documents", source = "customers")
    CustomerFindAllMongoResponseDTO toDto(CustomerResponseDTO entityList);
}
