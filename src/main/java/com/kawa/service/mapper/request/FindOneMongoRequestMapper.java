package com.kawa.service.mapper.request;

import com.kawa.service.dto.request.mongo.CustomerFindOneMongoRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the id of the entity {@link com.kawa.domain.bean.Customer} and its Mongo DTO {@link CustomerFindOneMongoRequestDTO}.
 */
@Mapper(componentModel = "spring")
public interface FindOneMongoRequestMapper {
    @Mapping(target = "filterId", source = "id")
    CustomerFindOneMongoRequestDTO toDto(String id);
}
