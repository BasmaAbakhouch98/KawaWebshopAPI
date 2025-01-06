package com.kawa.service.dto.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class CustomerInsertRequestDTOTest {

    private static final String JSON =
        "{\"name\":\"User 1\",\"username\":\"user_name\",\"firstName\":\"first_Name\",\"lastName\":\"last_Name\",\"adress\":{\"postalCode\":\"59000\",\"city\":\"Lille\"},\"profile\":{\"firstName\":\"first_Name\",\"lastName\":\"last_Name\"},\"company\":{\"companyName\":\"company_Name\"}}";

    @Test
    void whenUsingJsonNode() throws Exception {
        CustomerInsertRequestDTO customerInsertRequestDTO = new ObjectMapper().readerFor(CustomerInsertRequestDTO.class).readValue(JSON);
        assertEquals("User 1", customerInsertRequestDTO.getName());
        assertEquals("user_name", customerInsertRequestDTO.getUsername());
        assertEquals("first_Name", customerInsertRequestDTO.getFirstName());
        assertEquals("last_Name", customerInsertRequestDTO.getLastName());

        assertEquals("59000", customerInsertRequestDTO.getAdressPostalCode());
        assertEquals("Lille", customerInsertRequestDTO.getAdressCity());
        assertEquals("first_Name", customerInsertRequestDTO.getProfileFirstName());
        assertEquals("last_Name", customerInsertRequestDTO.getProfileLastName());
        assertEquals("company_Name", customerInsertRequestDTO.getCompanyName());
    }

    @Test
    void dtoEqualsVerifier() {
        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName("name");
        customerInsertRequestDTO.setUsername("user_name");
        customerInsertRequestDTO.setFirstName("first");
        customerInsertRequestDTO.setLastName("last");
        customerInsertRequestDTO.setAdressPostalCode("59000");
        customerInsertRequestDTO.setAdressCity("Lille");
        customerInsertRequestDTO.setProfileFirstName("first");
        customerInsertRequestDTO.setProfileLastName("last");
        customerInsertRequestDTO.setCompanyName("company");

        CustomerInsertRequestDTO customerInsertRequestDTO2 = new CustomerInsertRequestDTO();
        assertNotEquals(customerInsertRequestDTO, customerInsertRequestDTO2);

        customerInsertRequestDTO2.setName(customerInsertRequestDTO.getName());
        customerInsertRequestDTO2.setUsername(customerInsertRequestDTO.getUsername());
        customerInsertRequestDTO2.setFirstName(customerInsertRequestDTO.getFirstName());
        customerInsertRequestDTO2.setLastName(customerInsertRequestDTO.getLastName());
        customerInsertRequestDTO2.setAdressPostalCode(customerInsertRequestDTO.getAdressPostalCode());
        customerInsertRequestDTO2.setAdressCity(customerInsertRequestDTO.getAdressCity());
        customerInsertRequestDTO2.setProfileFirstName(customerInsertRequestDTO.getFirstName());
        customerInsertRequestDTO2.setProfileLastName(customerInsertRequestDTO.getLastName());
        customerInsertRequestDTO2.setCompanyName(customerInsertRequestDTO.getCompanyName());
        assertEquals(customerInsertRequestDTO, customerInsertRequestDTO2);
    }

    @Test
    void testToString() {
        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName("name");
        customerInsertRequestDTO.setUsername("user_name");
        customerInsertRequestDTO.setFirstName("first");
        customerInsertRequestDTO.setLastName("last");
        customerInsertRequestDTO.setAdressPostalCode("59000");
        customerInsertRequestDTO.setAdressCity("Lille");
        customerInsertRequestDTO.setProfileFirstName("first");
        customerInsertRequestDTO.setProfileLastName("last");
        customerInsertRequestDTO.setCompanyName("company");

        assertThat(customerInsertRequestDTO.toString())
            .hasToString(
                "CustomerInsertRequestDTO{" +
                    "name='name', username='user_name', firstName='first', lastName='last', adressPostalCode='59000', adressCity='Lille', profileFirstName='first', profileLastName='last', companyName='company'}"
        );

    }

    @Test
    void testHashCode() {
        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName("name");
        customerInsertRequestDTO.setUsername("user_name");
        customerInsertRequestDTO.setFirstName("first");
        customerInsertRequestDTO.setLastName("last");
        customerInsertRequestDTO.setAdressPostalCode("59000");
        customerInsertRequestDTO.setAdressCity("Lille");
        customerInsertRequestDTO.setProfileFirstName("first");
        customerInsertRequestDTO.setProfileLastName("last");
        customerInsertRequestDTO.setCompanyName("company");

        CustomerInsertRequestDTO customerInsertRequestDTO1 = new CustomerInsertRequestDTO();
        customerInsertRequestDTO1.setName(customerInsertRequestDTO.getName());
        customerInsertRequestDTO1.setUsername(customerInsertRequestDTO.getUsername());
        customerInsertRequestDTO1.setFirstName(customerInsertRequestDTO.getFirstName());
        customerInsertRequestDTO1.setLastName(customerInsertRequestDTO.getLastName());
        customerInsertRequestDTO1.setAdressPostalCode(customerInsertRequestDTO.getAdressPostalCode());
        customerInsertRequestDTO1.setAdressCity(customerInsertRequestDTO.getAdressCity());
        customerInsertRequestDTO1.setProfileFirstName(customerInsertRequestDTO.getFirstName());
        customerInsertRequestDTO1.setProfileLastName(customerInsertRequestDTO.getLastName());
        customerInsertRequestDTO1.setCompanyName(customerInsertRequestDTO.getCompanyName());

        assertThat(customerInsertRequestDTO).hasSameHashCodeAs(customerInsertRequestDTO1);
    }

    @Test
    void testEqualSameObject() {
        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName("name");
        customerInsertRequestDTO.setUsername("user_name");
        customerInsertRequestDTO.setFirstName("first");
        customerInsertRequestDTO.setLastName("last");
        customerInsertRequestDTO.setAdressPostalCode("59000");
        customerInsertRequestDTO.setAdressCity("Lille");
        customerInsertRequestDTO.setProfileFirstName("first");
        customerInsertRequestDTO.setProfileLastName("last");
        customerInsertRequestDTO.setCompanyName("company");

        CustomerInsertRequestDTO customerInsertRequestDTO1 = customerInsertRequestDTO;
        assertThat(customerInsertRequestDTO).isEqualTo(customerInsertRequestDTO1);
    }
}
