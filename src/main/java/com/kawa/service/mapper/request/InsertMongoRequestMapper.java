package com.kawa.service.mapper.request;

import com.kawa.service.dto.request.CustomerInsertRequestDTO;
import com.kawa.service.dto.request.mongo.CustomerInsertMongoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the DTO {@link CustomerInsertRequestDTO} and its Mongo DTO {@link CustomerInsertMongoRequestDTO}.
 */
@Mapper(componentModel = "spring")
public interface InsertMongoRequestMapper {
    @Mapping(target = "documentCreatedAt", expression = "java(new java.util.Date())")

    @Mapping(target = "documentName", source = "name")
    @Mapping(target = "documentUsername", source = "username")
    @Mapping(target = "documentFirstName", source = "firstName")
    @Mapping(target = "documentLastName", source = "lastName")
    @Mapping(target = "documentAdressPostalCode", source = "adressPostalCode")
    @Mapping(target = "documentAdressCity", source = "adressCity")
    @Mapping(target = "documentProfileFirstName", source = "profileFirstName")
    @Mapping(target = "documentProfileLastName", source = "profileLastName")
    @Mapping(target = "documentCompanyName", source = "companyName")
    CustomerInsertMongoRequestDTO toDto(CustomerInsertRequestDTO dto);
}
