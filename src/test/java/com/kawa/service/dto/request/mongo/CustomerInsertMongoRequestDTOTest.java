package com.kawa.service.dto.request.mongo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerInsertMongoRequestDTOTest {
    private static final String JSON =
        "{\"dataSource\":\"MainCluster\",\"database\":\"kawawebshopapi\",\"collection\":\"customers\",\"document\":{\"createdAt\":\"2020-01-01T00:00:00.000Z\",\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}}";


    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    @BeforeAll
    static void setUp() {
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    }

    @Test
    void whenUsingJsonNode() throws JsonProcessingException {
        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO = new ObjectMapper()
            .readerFor(CustomerInsertMongoRequestDTO.class)
            .readValue(JSON);
        assertEquals("MainCluster", customerInsertMongoRequestDTO.getDataSource());
        assertEquals("kawawebshopapi", customerInsertMongoRequestDTO.getDatabase());
        assertEquals("customers", customerInsertMongoRequestDTO.getCollection());
        assertEquals("User 1", customerInsertMongoRequestDTO.getDocumentName());
        assertEquals("user_name", customerInsertMongoRequestDTO.getDocumentUsername());
        assertEquals("first_Name", customerInsertMongoRequestDTO.getDocumentFirstName());
        assertEquals("last_Name", customerInsertMongoRequestDTO.getDocumentLastName());
        assertEquals("59000", customerInsertMongoRequestDTO.getDocumentAdressPostalCode());
        assertEquals("Lille", customerInsertMongoRequestDTO.getDocumentAdressCity());
        assertEquals("first_Name", customerInsertMongoRequestDTO.getDocumentProfileFirstName());
        assertEquals("last_Name", customerInsertMongoRequestDTO.getDocumentProfileLastName());
        assertEquals("company_Name", customerInsertMongoRequestDTO.getDocumentCompanyName());
    }

    @Test
    void dtoEqualsVerifier() {
        Date date = new Date();

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO1 = new CustomerInsertMongoRequestDTO();
        customerInsertMongoRequestDTO1.setDocumentName("User 1");
        customerInsertMongoRequestDTO1.setDocumentUsername("user name");
        customerInsertMongoRequestDTO1.setDocumentFirstName("first");
        customerInsertMongoRequestDTO1.setDocumentLastName("last");
        customerInsertMongoRequestDTO1.setDocumentAdressPostalCode("59650");
        customerInsertMongoRequestDTO1.setDocumentAdressCity("Lille");
        customerInsertMongoRequestDTO1.setDocumentProfileFirstName("pfirst");
        customerInsertMongoRequestDTO1.setDocumentProfileLastName("plast");
        customerInsertMongoRequestDTO1.setDocumentCompanyName("Company");
        customerInsertMongoRequestDTO1.setDocumentCreatedAt(date);

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO2 = new CustomerInsertMongoRequestDTO();
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentName(customerInsertMongoRequestDTO1.getDocumentName());
        customerInsertMongoRequestDTO2.setDocumentUsername(customerInsertMongoRequestDTO1.getDocumentUsername());
        customerInsertMongoRequestDTO2.setDocumentFirstName(customerInsertMongoRequestDTO1.getDocumentFirstName());
        customerInsertMongoRequestDTO2.setDocumentLastName(customerInsertMongoRequestDTO1.getDocumentLastName());
        customerInsertMongoRequestDTO2.setDocumentAdressPostalCode(customerInsertMongoRequestDTO1.getDocumentAdressPostalCode());
        customerInsertMongoRequestDTO2.setDocumentAdressCity(customerInsertMongoRequestDTO1.getDocumentAdressCity());
        customerInsertMongoRequestDTO2.setDocumentProfileFirstName(customerInsertMongoRequestDTO1.getDocumentProfileFirstName());
        customerInsertMongoRequestDTO2.setDocumentProfileLastName(customerInsertMongoRequestDTO1.getDocumentProfileLastName());
        customerInsertMongoRequestDTO2.setDocumentCompanyName(customerInsertMongoRequestDTO1.getDocumentCompanyName());
        customerInsertMongoRequestDTO2.setDocumentCreatedAt(customerInsertMongoRequestDTO1.getDocumentCreatedAt());

        assertEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentName("Customer 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentName(customerInsertMongoRequestDTO1.getDocumentName());
        customerInsertMongoRequestDTO2.setDocumentUsername("user name 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentUsername(customerInsertMongoRequestDTO1.getDocumentUsername());
        customerInsertMongoRequestDTO2.setDocumentFirstName("first 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentFirstName(customerInsertMongoRequestDTO1.getDocumentFirstName());
        customerInsertMongoRequestDTO2.setDocumentLastName("last 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentLastName(customerInsertMongoRequestDTO1.getDocumentLastName());
        customerInsertMongoRequestDTO2.setDocumentAdressPostalCode("75000");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentAdressPostalCode(customerInsertMongoRequestDTO1.getDocumentAdressPostalCode());
        customerInsertMongoRequestDTO2.setDocumentAdressCity("Paris");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentAdressCity(customerInsertMongoRequestDTO1.getDocumentAdressCity());
        customerInsertMongoRequestDTO2.setDocumentProfileFirstName("pfirst 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentProfileFirstName(customerInsertMongoRequestDTO1.getDocumentProfileFirstName());
        customerInsertMongoRequestDTO2.setDocumentProfileLastName("last 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentProfileLastName(customerInsertMongoRequestDTO1.getDocumentProfileLastName());
        customerInsertMongoRequestDTO2.setDocumentCompanyName("Company 2");
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);


    }

    @Test
    void testToString() {
        Date date = new Date();

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO1 = new CustomerInsertMongoRequestDTO();
        customerInsertMongoRequestDTO1.setDocumentName("User 1");
        customerInsertMongoRequestDTO1.setDocumentUsername("user name");
        customerInsertMongoRequestDTO1.setDocumentFirstName("first");
        customerInsertMongoRequestDTO1.setDocumentLastName("last");
        customerInsertMongoRequestDTO1.setDocumentAdressPostalCode("59650");
        customerInsertMongoRequestDTO1.setDocumentAdressCity("Lille");
        customerInsertMongoRequestDTO1.setDocumentProfileFirstName("pfirst");
        customerInsertMongoRequestDTO1.setDocumentProfileLastName("plast");
        customerInsertMongoRequestDTO1.setDocumentCompanyName("Company");
        customerInsertMongoRequestDTO1.setDocumentCreatedAt(date);
        assertEquals(
            "CustomerInsertMongoRequestDTO{dataSource='MainCluster', database='kawawebshopapi', collection='customers', documentCreatedAt='" +
                dateFormat.format(date) +
                "', documentName='User 1', documentUsername='user name', documentFirstName='first', documentLastName='last', documentAdressPostalCode='59650', " +
                "documentAdressCity='Lille', documentProfileFirstName='pfirst', documentProfileLastName='plast', documentCompanyName='Company'}",
            customerInsertMongoRequestDTO1.toString()
        );
    }

    @Test
    void testHashcode() {
        Date date = new Date();

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO1 = new CustomerInsertMongoRequestDTO();
        customerInsertMongoRequestDTO1.setDocumentName("User 1");
        customerInsertMongoRequestDTO1.setDocumentUsername("user name");
        customerInsertMongoRequestDTO1.setDocumentFirstName("first");
        customerInsertMongoRequestDTO1.setDocumentLastName("last");
        customerInsertMongoRequestDTO1.setDocumentAdressPostalCode("59650");
        customerInsertMongoRequestDTO1.setDocumentAdressCity("Lille");
        customerInsertMongoRequestDTO1.setDocumentProfileFirstName("pfirst");
        customerInsertMongoRequestDTO1.setDocumentProfileLastName("plast");
        customerInsertMongoRequestDTO1.setDocumentCompanyName("Company");
        customerInsertMongoRequestDTO1.setDocumentCreatedAt(date);

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO2 = new CustomerInsertMongoRequestDTO();
        assertNotEquals(customerInsertMongoRequestDTO1, customerInsertMongoRequestDTO2);

        customerInsertMongoRequestDTO2.setDocumentName(customerInsertMongoRequestDTO1.getDocumentName());
        customerInsertMongoRequestDTO2.setDocumentUsername(customerInsertMongoRequestDTO1.getDocumentUsername());
        customerInsertMongoRequestDTO2.setDocumentFirstName(customerInsertMongoRequestDTO1.getDocumentFirstName());
        customerInsertMongoRequestDTO2.setDocumentLastName(customerInsertMongoRequestDTO1.getDocumentLastName());
        customerInsertMongoRequestDTO2.setDocumentAdressPostalCode(customerInsertMongoRequestDTO1.getDocumentAdressPostalCode());
        customerInsertMongoRequestDTO2.setDocumentAdressCity(customerInsertMongoRequestDTO1.getDocumentAdressCity());
        customerInsertMongoRequestDTO2.setDocumentProfileFirstName(customerInsertMongoRequestDTO1.getDocumentProfileFirstName());
        customerInsertMongoRequestDTO2.setDocumentProfileLastName(customerInsertMongoRequestDTO1.getDocumentProfileLastName());
        customerInsertMongoRequestDTO2.setDocumentCompanyName(customerInsertMongoRequestDTO1.getDocumentCompanyName());
        customerInsertMongoRequestDTO2.setDocumentCreatedAt(customerInsertMongoRequestDTO1.getDocumentCreatedAt());


        assertThat(customerInsertMongoRequestDTO1).hasSameHashCodeAs(customerInsertMongoRequestDTO2);
    }

    @Test
    void testEqualSameObject() {
        Date date = new Date();

        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO1 = new CustomerInsertMongoRequestDTO();
        customerInsertMongoRequestDTO1.setDocumentName("User 1");
        customerInsertMongoRequestDTO1.setDocumentUsername("user name");
        customerInsertMongoRequestDTO1.setDocumentFirstName("first");
        customerInsertMongoRequestDTO1.setDocumentLastName("last");
        customerInsertMongoRequestDTO1.setDocumentAdressPostalCode("59650");
        customerInsertMongoRequestDTO1.setDocumentAdressCity("Lille");
        customerInsertMongoRequestDTO1.setDocumentProfileFirstName("pfirst");
        customerInsertMongoRequestDTO1.setDocumentProfileLastName("plast");
        customerInsertMongoRequestDTO1.setDocumentCompanyName("Company");
        customerInsertMongoRequestDTO1.setDocumentCreatedAt(date);
        CustomerInsertMongoRequestDTO customerInsertMongoRequestDTO2 = customerInsertMongoRequestDTO1;
        assertThat(customerInsertMongoRequestDTO1).isEqualTo(customerInsertMongoRequestDTO2);
    }
}
