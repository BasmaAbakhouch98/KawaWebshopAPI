package com.kawa.domain.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kawa.web.rest.TestUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerTest {

    private static final String JSON =
        "{\"_id\":\"1\",\"createdAt\":\"2020-01-01T00:00:00.000Z\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @BeforeAll
    static void setUp() {
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    }

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        Customer customer = new ObjectMapper().readerFor(Customer.class).readValue(JSON);
        assertEquals("1", customer.getId());
        // assert createdAt date
        assertEquals("User 1", customer.getName());
        assertEquals("user_name", customer.getUsername());
        assertEquals("first_Name", customer.getFirstName());
        assertEquals("last_Name", customer.getLastName());

        assertEquals("59000", customer.getAdressPostalCode());
        assertEquals("Lille", customer.getAdressCity());
        assertEquals("first_Name", customer.getProfileFirstName());
        assertEquals("last_Name", customer.getProfileLastName());
        assertEquals("company_Name", customer.getCompanyName());
    }

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Customer.class);
        Customer customer1 = new Customer();
        customer1.setId("1");
        Customer customer2 = new Customer();
        customer2.setId(customer1.getId());
        assertEquals(customer1, customer2);
        customer2.setId("2");
        assertNotEquals(customer1, customer2);
        customer1.setId(null);
        assertNotEquals(customer1, customer2);
    }

    @Test
    void testHashCode() {
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
        // test that the hashcode is the same as the class hashcode
        assertThat(customer.hashCode()).hasSameHashCodeAs(customer.getClass());
    }

    @Test
    void testToString() {
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
        assertThat(customer.toString())
            .hasToString(
        "Customer{id='1', createdAt='2020-01-01T01:00:00.000Z', name='name', username='user_name', firstName='first', lastName='last', adressPostalCode='59000', adressCity='Lille', profileFirstName='first', profileLastName='last', companyName='company'}"
            );
    }

    @Test
    void testEqualsSameObject() {
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
        Customer customer2 = customer;
        assertThat(customer).isEqualTo(customer2);
    }
}
