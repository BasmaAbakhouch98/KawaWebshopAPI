package com.kawa.service.dto.request.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerFindOneMongoRequestDTOTest {

    private static final String JSON =
        "{\"dataSource\":\"MainCluster\",\"database\":\"kawawebshopapi\",\"collection\":\"customers\",\"filter\":{\"_id\":\"1\"}}";

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO = new ObjectMapper()
            .readerFor(CustomerFindOneMongoRequestDTO.class)
            .readValue(JSON);
        assertEquals("MainCluster", customerFindOneMongoRequestDTO.getDataSource());
        assertEquals("kawawebshopapi", customerFindOneMongoRequestDTO.getDatabase());
        assertEquals("customers", customerFindOneMongoRequestDTO.getCollection());
        assertEquals("1", customerFindOneMongoRequestDTO.getFilterId());
    }

    @Test
    void dtoEqualsVerifier() {
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO1 = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO1.setFilterId("1");
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO2 = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO2.setFilterId(customerFindOneMongoRequestDTO1.getFilterId());
        assertEquals(customerFindOneMongoRequestDTO1, customerFindOneMongoRequestDTO2);
        customerFindOneMongoRequestDTO2.setFilterId("2");
        assertNotEquals(customerFindOneMongoRequestDTO1, customerFindOneMongoRequestDTO2);
        customerFindOneMongoRequestDTO2.setFilterId(null);
        assertNotEquals(customerFindOneMongoRequestDTO1, customerFindOneMongoRequestDTO2);
    }

    @Test
    void testToString() {
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO.setFilterId("1");

        assertEquals(
            "CustomerFindOneMongoRequestDTO{dataSource='MainCluster', database='kawawebshopapi', collection='customers', filterId='1'}",
            customerFindOneMongoRequestDTO.toString()
        );
    }

    @Test
    void testHashcode() {
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO1 = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO1.setFilterId("1");
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO2 = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO2.setFilterId(customerFindOneMongoRequestDTO1.getFilterId());

        assertThat(customerFindOneMongoRequestDTO1).hasSameHashCodeAs(customerFindOneMongoRequestDTO2);
    }

    @Test
    void testEqualSameObject() {
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO = new CustomerFindOneMongoRequestDTO();
        customerFindOneMongoRequestDTO.setFilterId("1");
        CustomerFindOneMongoRequestDTO customerFindOneMongoRequestDTO1 = customerFindOneMongoRequestDTO;

        assertThat(customerFindOneMongoRequestDTO).isEqualTo(customerFindOneMongoRequestDTO1);
    }

}
