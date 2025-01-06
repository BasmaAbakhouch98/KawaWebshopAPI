package com.kawa.service.dto.request.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerFindAllMongoRequestDTOTest {
    private static final String JSON = "{\"dataSource\":\"MainCluster\",\"database\":\"kawawebshopapi\",\"collection\":\"customers\"}";

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO = new ObjectMapper()
            .readerFor(CustomerFindAllMongoRequestDTO.class)
            .readValue(JSON);
        assertEquals("MainCluster", customerFindAllMongoRequestDTO.getDataSource());
        assertEquals("kawawebshopapi", customerFindAllMongoRequestDTO.getDatabase());
        assertEquals("customers", customerFindAllMongoRequestDTO.getCollection());
    }

    @Test
    void testToString() {
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO = new CustomerFindAllMongoRequestDTO();

        assertEquals(
            "CustomerFindAllMongoRequestDTO{dataSource='MainCluster', database='kawawebshopapi', collection='customers'}",
            customerFindAllMongoRequestDTO.toString()
        );
    }

    @Test
    void testHashcode() {
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO1 = new CustomerFindAllMongoRequestDTO();
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO2 = new CustomerFindAllMongoRequestDTO();

        assertThat(customerFindAllMongoRequestDTO1).hasSameHashCodeAs(customerFindAllMongoRequestDTO2);
    }

    @Test
    void testEqualSameObject() {
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO1 = new CustomerFindAllMongoRequestDTO();
        CustomerFindAllMongoRequestDTO customerFindAllMongoRequestDTO2 = customerFindAllMongoRequestDTO1;

        assertThat(customerFindAllMongoRequestDTO1).isEqualTo(customerFindAllMongoRequestDTO2);
    }
}
