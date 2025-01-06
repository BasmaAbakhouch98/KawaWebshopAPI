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

public class CustomerWithoutIdTest {

    private static final String JSON =
        "{\"createdAt\":\"2020-01-01T00:00:00.000Z\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}";

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @BeforeAll
    static void setUp() {
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    }

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerWithoutId customer = new ObjectMapper().readerFor(CustomerWithoutId.class).readValue(JSON);
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
        TestUtil.equalsVerifier(CustomerWithoutId.class);
        CustomerWithoutId customer1 = new CustomerWithoutId();
        customer1.setCreatedAt(Date.from(java.time.Instant.parse("2020-01-01T00:00:00.000Z")));
        customer1.setName("name");
        customer1.setUsername("user_name");
        customer1.setFirstName("first");
        customer1.setLastName("last");
        customer1.setAdressPostalCode("59000");
        customer1.setAdressCity("Lille");
        customer1.setProfileFirstName("first");
        customer1.setProfileLastName("last");
        customer1.setCompanyName("company");

        CustomerWithoutId customer2 = new CustomerWithoutId();
        customer2.setCreatedAt(customer1.getCreatedAt());
        customer2.setName(customer1.getName());

        customer2.setUsername(customer1.getUsername());
        customer2.setFirstName(customer1.getFirstName());
        customer2.setLastName(customer1.getLastName());
        customer2.setAdressPostalCode(customer1.getAdressPostalCode());
        customer2.setAdressCity(customer1.getAdressCity());
        customer2.setProfileFirstName(customer1.getFirstName());
        customer2.setProfileLastName(customer1.getLastName());
        customer2.setCompanyName(customer1.getCompanyName());
        assertEquals(customer1, customer2);
    }

    @Test
    void testHashCode() {
        Date createdAt = Date.from(java.time.Instant.parse("2020-01-01T00:00:00.000Z"));
        CustomerWithoutId customer = new CustomerWithoutId();
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
        assertThat(customer.hashCode()).hasSameHashCodeAs(customer.getClass());
    }

    @Test
    void testToString() {
        Date createdAt = Date.from(java.time.Instant.parse("2020-01-01T00:00:00.000Z")); // Todo ajoute une heure ??
        CustomerWithoutId customer = new CustomerWithoutId();
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
                "CustomerWithoutId{createdAt='2020-01-01T01:00:00.000Z', name='name', username='user_name', firstName='first', lastName='last', adressPostalCode='59000', adressCity='Lille', profileFirstName='first', profileLastName='last', companyName='company'}"
            );
    }

    @Test
    void testEqualsSameObject() {
        Date createdAt = Date.from(java.time.Instant.parse("2020-01-01T00:00:00.000Z"));
        CustomerWithoutId customer = new CustomerWithoutId();
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
        CustomerWithoutId customer2 = customer;
        assertThat(customer).isEqualTo(customer2);
    }

}
