package com.kawa.service.dto.response.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawa.domain.bean.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerFindAllMongoResponseDTOTest {

    private static final String JSON =
        "{\"documents\":[{\"_id\":\"5ff9f9b0e4b0b5b9b0b9b9b9\",\"createdAt\":\"2021-01-01T00:00:00.000Z\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}]}";

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerFindAllMongoResponseDTO customerFindAllMongoResponseDTO = new ObjectMapper()
            .readerFor(CustomerFindAllMongoResponseDTO.class)
            .readValue(JSON);

        assertEquals(1, customerFindAllMongoResponseDTO.getDocuments().size());
        Customer firstCustomer = customerFindAllMongoResponseDTO.getDocuments().get(0);
        assertEquals("5ff9f9b0e4b0b5b9b0b9b9b9", firstCustomer.getId());
        assertEquals("User 1", firstCustomer.getName());
        assertEquals("user_name", firstCustomer.getUsername());
        assertEquals("first_Name", firstCustomer.getFirstName());
        assertEquals("last_Name", firstCustomer.getLastName());

        assertEquals("59000", firstCustomer.getAdressPostalCode());
        assertEquals("Lille", firstCustomer.getAdressCity());
        assertEquals("first_Name", firstCustomer.getProfileFirstName());
        assertEquals("last_Name", firstCustomer.getProfileLastName());
        assertEquals("company_Name", firstCustomer.getCompanyName());
    }

    }
