package com.kawa.service.dto.request;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerRequestDTOTest {

    private static final String JSON_WITH_ID = "{\"id\":\"5ff9f9b0e4b0b5b9b0b9b9b9\"}";
    private static final String JSON_WITHOUT_ID = "{\"id\":null}";

    @Test
    void whenUsingJsonNodeWithId() throws JsonProcessingException {
        CustomerRequestDTO customerRequestDTO = new ObjectMapper().readerFor(CustomerRequestDTO.class).readValue(JSON_WITH_ID);
        assertEquals("5ff9f9b0e4b0b5b9b0b9b9b9", customerRequestDTO.getId());
    }

    @Test
    void whenUsingJsonNodeWithoutId() throws JsonProcessingException {
        CustomerRequestDTO customerRequestDTO = new ObjectMapper().readerFor(CustomerRequestDTO.class).readValue(JSON_WITHOUT_ID);
        assertNull(customerRequestDTO.getId());
    }

    @Test
    void dtoEqualsVerifier() {
        CustomerRequestDTO customerRequestDTO1 = new CustomerRequestDTO();
        customerRequestDTO1.setId("id");
        CustomerRequestDTO customerRequestDTO2 = new CustomerRequestDTO();
        assertNotEquals(customerRequestDTO1, customerRequestDTO2);
        customerRequestDTO2.setId(customerRequestDTO1.getId());
        assertEquals(customerRequestDTO1, customerRequestDTO2);
    }

    @Test
    void testToString() {
        CustomerRequestDTO customerRequestDTO1 = new CustomerRequestDTO();
        customerRequestDTO1.setId("id");
        assertEquals("CustomerRequestDTO{id='id'}", customerRequestDTO1.toString());
    }

    @Test
    void testHashcode() {
        CustomerRequestDTO customerRequestDTO1 = new CustomerRequestDTO();
        customerRequestDTO1.setId("id");
        CustomerRequestDTO customerRequestDTO2 = new CustomerRequestDTO();
        customerRequestDTO2.setId(customerRequestDTO1.getId());
        assertEquals(customerRequestDTO1.hashCode(), customerRequestDTO2.hashCode());
    }

    @Test
    void testEqualSameObject() {
        CustomerRequestDTO customerRequestDTO1 = new CustomerRequestDTO();
        customerRequestDTO1.setId("id");
        CustomerRequestDTO customerRequestDTO2 = customerRequestDTO1;
        assertThat(customerRequestDTO1).isEqualTo(customerRequestDTO2);
    }
}
