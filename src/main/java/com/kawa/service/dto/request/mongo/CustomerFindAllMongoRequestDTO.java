package com.kawa.service.dto.request.mongo;

public class CustomerFindAllMongoRequestDTO extends FindAllMongoRequestDTO {

    public CustomerFindAllMongoRequestDTO() {
        this.collection = "customers";
    }

    @Override
    public String toString() {
        return (
            "CustomerFindAllMongoRequestDTO{" +
                "dataSource='" +
                dataSource +
                '\'' +
                ", database='" +
                database +
                '\'' +
                ", collection='" +
                collection +
                '\'' +
                '}'
        );
    }
}
