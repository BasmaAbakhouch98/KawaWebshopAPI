package com.kawa.service.dto.response.mongo;

import com.kawa.domain.bean.Customer;

public class CustomerFindAllMongoResponseDTO extends FindAllMongoResponseDTO<Customer>{

    @Override
    public String toString() {
        return "CustomerFindAllMongoResponseDTO{" + "documents=" + documents + '}';
    }
}
