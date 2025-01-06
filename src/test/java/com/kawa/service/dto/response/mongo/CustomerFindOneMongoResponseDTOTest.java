package com.kawa.service.dto.response.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerFindOneMongoResponseDTOTest {

    private static final String JSON =
        "{\"document\":{\"_id\":\"5ff9f9b0e4b0b5b9b0b9b9b9\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}}";

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerFindOneMongoResponseDTO customerFindOneMongoResponseDTO = new ObjectMapper()
            .readerFor(CustomerFindOneMongoResponseDTO.class)
            .readValue(JSON);

        assertEquals("5ff9f9b0e4b0b5b9b0b9b9b9", customerFindOneMongoResponseDTO.getDocumentId());
        assertEquals("Product 1", customerFindOneMongoResponseDTO.getDocumentName());
        assertEquals("user_name", customerFindOneMongoResponseDTO.getDocumentUsername());
        assertEquals("first_Name", customerFindOneMongoResponseDTO.getDocumentFirstName());
        assertEquals("last_Name", customerFindOneMongoResponseDTO.getDocumentLastName());

        assertEquals("59000", customerFindOneMongoResponseDTO.getDocumentAdressPostalCode());
        assertEquals("Lille", customerFindOneMongoResponseDTO.getDocumentAdressCity());
        assertEquals("first_Name", customerFindOneMongoResponseDTO.getDocumentProfileFirstName());
        assertEquals("last_Name", customerFindOneMongoResponseDTO.getDocumentProfileLastName());
        assertEquals("company_Name", customerFindOneMongoResponseDTO.getDocumentCompanyName());
    }

}
