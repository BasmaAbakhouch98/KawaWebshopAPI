package com.kawa.service.dto.response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawa.domain.bean.Customer;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerResponseDTOTest {

    private static final String JSON =
        "{\"customers\":[{\"_id\":\"5ff9f9b0e4b0b5b9b0b9b9b9\",\"createdAt\":\"2021-01-01T00:00:00.000Z\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}]}";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @BeforeAll
    static void setUp() {
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    }

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerResponseDTO customerResponseDTO = new ObjectMapper().readerFor(CustomerResponseDTO.class).readValue(JSON);
        assertEquals(1, customerResponseDTO.getCustomers().size());
        Customer firstCustomer = customerResponseDTO.getCustomers().get(0);
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

    @Test
    void dtoEqualsVerifier() {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        Customer customer = new Customer();
        customer.setCreatedAt(Date.from(Instant.now()));
        customer.setName("name");
        customer.setUsername("user_name");
        customer.setFirstName("first");
        customer.setLastName("last");
        customer.setAdressPostalCode("59000");
        customer.setAdressCity("Lille");
        customer.setProfileFirstName("first");
        customer.setProfileLastName("last");
        customer.setCompanyName("company");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customerResponseDTO.setCustomers(customers);
        CustomerResponseDTO customerResponseDTO2 = new CustomerResponseDTO();
        assertNotEquals(customerResponseDTO, customerResponseDTO2);
        customerResponseDTO2.setCustomers(customers);
        assertEquals(customerResponseDTO, customerResponseDTO2);
    }

    @Test
    void testToString() {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        Date createdAt = Date.from(java.time.Instant.parse("2020-01-01T00:00:00.000Z"));
        Customer customer = new Customer();
        customer.setId("1");
        customer.setCreatedAt(createdAt);
        customer.setName("name");
        customer.setUsername("user_name");
        customer.setFirstName("first");
        customer.setLastName("last");
        customer.setAdressPostalCode("59000");
        customer.setAdressCity("Lille");
        customer.setProfileFirstName("first");
        customer.setProfileLastName("last");
        customer.setCompanyName("company");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customerResponseDTO.setCustomers(customers);
        assertEquals(
            "CustomerResponseDTO{customers=[Customer{id='1', createdAt='2020-01-01T01:00:00.000Z'" +
                ", name='name', username='user_name', firstName='first', lastName='last', adressPostalCode='59000', adressCity='Lille', profileFirstName='first', profileLastName='last', companyName='company'}]}",
            customerResponseDTO.toString()
        );
    }

    @Test
    void testHashcode() {
        CustomerResponseDTO customerResponseDTO1 = new CustomerResponseDTO();
        Date createdAt = Date.from(Instant.now());
        Customer customer = new Customer();
        customer.setCreatedAt(createdAt);
        customer.setName("name");
        customer.setUsername("user_name");
        customer.setFirstName("first");
        customer.setLastName("last");
        customer.setAdressPostalCode("59000");
        customer.setAdressCity("Lille");
        customer.setProfileFirstName("first");
        customer.setProfileLastName("last");
        customer.setCompanyName("company");

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        customerResponseDTO1.setCustomers(customers);
        CustomerResponseDTO customerResponseDTO2 = new CustomerResponseDTO();
        assertNotEquals(customerResponseDTO1.hashCode(), customerResponseDTO2.hashCode());
        customerResponseDTO2.setCustomers(customers);
        assertThat(customerResponseDTO1).hasSameHashCodeAs(customerResponseDTO2);
    }

    @Test
    void testEqualSameObject() {
        CustomerResponseDTO customerResponseDTO1 = new CustomerResponseDTO();
        customerResponseDTO1.setCustomers(new ArrayList<>());
        CustomerResponseDTO customerResponseDTO2 = customerResponseDTO1;
        assertThat(customerResponseDTO1).isEqualTo(customerResponseDTO2);
    }
}
