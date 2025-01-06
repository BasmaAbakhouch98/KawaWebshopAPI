package com.kawa.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.kawa.IntegrationTest;
import com.kawa.domain.bean.Customer;
import com.kawa.management.MongoRequestService;
import com.kawa.security.AuthoritiesConstants;
import com.kawa.service.dto.request.CustomerInsertRequestDTO;
import com.kawa.service.dto.request.mongo.FindAllMongoRequestDTO;
import com.kawa.service.dto.request.mongo.FindOneMongoRequestDTO;
import com.kawa.service.dto.request.mongo.InsertMongoRequestDTO;
import com.kawa.service.dto.response.mongo.CustomerFindAllMongoResponseDTO;
import com.kawa.service.dto.response.mongo.CustomerFindOneMongoResponseDTO;
import com.kawa.service.dto.response.mongo.InsertMongoResponseDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * Test class for the CustomerResource REST controller.
 *
 * @see CustomerResource
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class CustomerResourceIT {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAB";

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAC";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAD";

    private static final String DEFAULT_ADRESS_CP = "AAAAAAAAAE";
    private static final String DEFAULT_ADRESS_CITY = "AAAAAAAAAF";
    private static final String DEFAULT_PROFILE_FIRST_NAME = "AAAAAAAAAG";
    private static final String DEFAULT_PROFILE_LAST_NAME = "AAAAAAAAAH";
    private static final String DEFAULT_COMPANY_NAME = "AAAAAAAAAI";


    private static final String DEFAULT_ID = "AAAAAAAAAJ";

    private static final String DEFAULT_CREATED_AT = "2021-09-22T09:00:00.000Z";

    private static final String ENTITY_API_URL = "/api/customers";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private MockMvc restMockMvc;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private static final Logger log = (Logger) LoggerFactory.getLogger(CustomerResource.class);

    private static ListAppender<ILoggingEvent> memoryAppender;


    @MockBean
    private MongoRequestService mongoRequestService;

    public static Customer createCustomer(
        String name,
        String username,
        String firstName,
        String lastName,
        String adressCP,
        String adressCity,
        String profileFirstName,
        String profileLastName,
        String companyName,
        String id,
        Date createdAt
    ) {
        Customer customer = new Customer();

        customer.setName(name);
        customer.setId(id);
        customer.setCreatedAt(createdAt);
        customer.setUsername(username);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setAdressPostalCode(adressCP);
        customer.setAdressCity(adressCity);
        customer.setProfileFirstName(profileFirstName);
        customer.setProfileLastName(profileLastName);
        customer.setCompanyName(companyName);

        return customer;
    }

    @BeforeAll
    public static void setup() {
        DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @BeforeEach
    public void initTest() {
        memoryAppender = new ListAppender<>();

        memoryAppender.start();
        log.addAppender(memoryAppender);
    }

    @AfterEach
    public void teardown() {
        memoryAppender.stop();
    }

    @Test
    @WithMockUser(authorities = { AuthoritiesConstants.USER })
    void insertCustomer() throws Exception {
        InsertMongoResponseDTO insertMongoResponseDTO = new InsertMongoResponseDTO();
        insertMongoResponseDTO.setInsertedId(DEFAULT_ID);

        CustomerInsertRequestDTO customerInsertRequestDTO = new CustomerInsertRequestDTO();
        customerInsertRequestDTO.setName(DEFAULT_NAME);
        customerInsertRequestDTO.setUsername(DEFAULT_USER_NAME);
        customerInsertRequestDTO.setFirstName(DEFAULT_FIRST_NAME);
        customerInsertRequestDTO.setLastName(DEFAULT_LAST_NAME);
        customerInsertRequestDTO.setAdressPostalCode(DEFAULT_ADRESS_CP);
        customerInsertRequestDTO.setAdressCity(DEFAULT_ADRESS_CITY);
        customerInsertRequestDTO.setProfileFirstName(DEFAULT_PROFILE_FIRST_NAME);
        customerInsertRequestDTO.setProfileLastName(DEFAULT_PROFILE_LAST_NAME);
        customerInsertRequestDTO.setCompanyName(DEFAULT_COMPANY_NAME);

        // Mock RestTemplate returning InsertMongoResponseDTO class
        Mockito
            .when(mongoRequestService.insert(Mockito.any(InsertMongoRequestDTO.class), Mockito.eq(InsertMongoResponseDTO.class)))
            .thenReturn(insertMongoResponseDTO);

        restCustomerMockMvc
            .perform(
                post(ENTITY_API_URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(customerInsertRequestDTO))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.insertedId").value(DEFAULT_ID));

        assertThat(memoryAppender.list)
            .extracting(ILoggingEvent::getFormattedMessage)
            .containsExactly(
                "REST request to save Customer : CustomerInsertRequestDTO{name='AAAAAAAAAA', username='AAAAAAAAAB', firstName='AAAAAAAAAC', lastName='AAAAAAAAAD', adressPostalCode='AAAAAAAAAE', adressCity='AAAAAAAAAF', profileFirstName='AAAAAAAAAG', profileLastName='AAAAAAAAAH', companyName='AAAAAAAAAI'}"
            );
    }

    @Test
    @WithMockUser(authorities = { AuthoritiesConstants.USER })
    void getCustomer() throws Exception {
        CustomerFindOneMongoResponseDTO customerFindOneMongoResponseDTO = new CustomerFindOneMongoResponseDTO();
        customerFindOneMongoResponseDTO.setDocumentName(DEFAULT_NAME);
        customerFindOneMongoResponseDTO.setDocumentUsername(DEFAULT_USER_NAME);
        customerFindOneMongoResponseDTO.setDocumentFirstName(DEFAULT_FIRST_NAME);
        customerFindOneMongoResponseDTO.setDocumentLastName(DEFAULT_LAST_NAME);
        customerFindOneMongoResponseDTO.setDocumentAdressPostalCode(DEFAULT_ADRESS_CP);
        customerFindOneMongoResponseDTO.setDocumentAdressCity(DEFAULT_ADRESS_CITY);
        customerFindOneMongoResponseDTO.setDocumentProfileFirstName(DEFAULT_PROFILE_FIRST_NAME);
        customerFindOneMongoResponseDTO.setDocumentProfileLastName(DEFAULT_PROFILE_LAST_NAME);
        customerFindOneMongoResponseDTO.setDocumentCompanyName(DEFAULT_COMPANY_NAME);
        customerFindOneMongoResponseDTO.setDocumentCreatedAt(DATE_FORMAT.parse(DEFAULT_CREATED_AT));
        customerFindOneMongoResponseDTO.setDocumentId(DEFAULT_ID);

        Mockito
            .when(mongoRequestService.findOne(Mockito.any(FindOneMongoRequestDTO.class), Mockito.eq(CustomerFindOneMongoResponseDTO.class)))
            .thenReturn(customerFindOneMongoResponseDTO);

        restCustomerMockMvc
            .perform(get(ENTITY_API_URL + "/{id}", DEFAULT_ID))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.customers[0].name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.customers[0].username").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.customers[0].firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.customers[0].lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.customers[0].adress.postalCode").value(DEFAULT_ADRESS_CP))
            .andExpect(jsonPath("$.customers[0].adress.city").value(DEFAULT_ADRESS_CITY))
            .andExpect(jsonPath("$.customers[0].profile.firstName").value(DEFAULT_PROFILE_FIRST_NAME))
            .andExpect(jsonPath("$.customers[0].profile.lastName").value(DEFAULT_PROFILE_LAST_NAME))
            .andExpect(jsonPath("$.customers[0].company.companyName").value(DEFAULT_COMPANY_NAME))


            .andExpect(jsonPath("$.customers[0].createdAt").value(DEFAULT_CREATED_AT))
            .andExpect(jsonPath("$.customers[0]._id").value(DEFAULT_ID));

        assertThat(memoryAppender.list)
            .extracting(ILoggingEvent::getFormattedMessage)
            .containsExactly("REST request to get Customer : " + DEFAULT_ID);
    }


    @Test
    @WithMockUser(authorities = { AuthoritiesConstants.USER })
    void getAllCustomers() throws Exception {

        Customer customer1 = createCustomer(
            DEFAULT_NAME,
            DEFAULT_USER_NAME,
            DEFAULT_FIRST_NAME,
            DEFAULT_LAST_NAME,
            DEFAULT_ADRESS_CP,
            DEFAULT_ADRESS_CITY,
            DEFAULT_PROFILE_FIRST_NAME,
            DEFAULT_PROFILE_LAST_NAME,
            DEFAULT_COMPANY_NAME,
            DEFAULT_ID,
            DATE_FORMAT.parse(DEFAULT_CREATED_AT)
        );

        Customer customer2 = createCustomer(
            DEFAULT_NAME+"2",
            DEFAULT_USER_NAME+"2",
            DEFAULT_FIRST_NAME+"2",
            DEFAULT_LAST_NAME+"2",
            DEFAULT_ADRESS_CP+"2",
            DEFAULT_ADRESS_CITY+"2",
            DEFAULT_PROFILE_FIRST_NAME+"2",
            DEFAULT_PROFILE_LAST_NAME+"2",
            DEFAULT_COMPANY_NAME+"2",
            DEFAULT_ID+"2",
            DATE_FORMAT.parse("2021-09-26T09:00:00.000Z")
        );

        List<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);

        CustomerFindAllMongoResponseDTO customerFindAllMongoResponseDTO = new CustomerFindAllMongoResponseDTO();
        customerFindAllMongoResponseDTO.setDocuments(customers);

        Mockito
            .when(mongoRequestService.findAll(Mockito.any(FindAllMongoRequestDTO.class), Mockito.eq(CustomerFindAllMongoResponseDTO.class)))
            .thenReturn(customerFindAllMongoResponseDTO);

        restCustomerMockMvc
            .perform(get(ENTITY_API_URL))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.customers[0].name").value(DEFAULT_NAME))
            .andExpect(jsonPath("$.customers[0].username").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.customers[0].firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.customers[0].lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.customers[0].adress.postalCode").value(DEFAULT_ADRESS_CP))
            .andExpect(jsonPath("$.customers[0].adress.city").value(DEFAULT_ADRESS_CITY))
            .andExpect(jsonPath("$.customers[0].profile.firstName").value(DEFAULT_PROFILE_FIRST_NAME))
            .andExpect(jsonPath("$.customers[0].profile.lastName").value(DEFAULT_PROFILE_LAST_NAME))
            .andExpect(jsonPath("$.customers[0].company.companyName").value(DEFAULT_COMPANY_NAME))


            .andExpect(jsonPath("$.customers[0].createdAt").value(DEFAULT_CREATED_AT))
            .andExpect(jsonPath("$.customers[0]._id").value(DEFAULT_ID))

        .andExpect(jsonPath("$.customers[1].name").value(DEFAULT_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].username").value(DEFAULT_USER_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].firstName").value(DEFAULT_FIRST_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].lastName").value(DEFAULT_LAST_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].adress.postalCode").value(DEFAULT_ADRESS_CP+"2"))
            .andExpect(jsonPath("$.customers[1].adress.city").value(DEFAULT_ADRESS_CITY+"2"))
            .andExpect(jsonPath("$.customers[1].profile.firstName").value(DEFAULT_PROFILE_FIRST_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].profile.lastName").value(DEFAULT_PROFILE_LAST_NAME+"2"))
            .andExpect(jsonPath("$.customers[1].company.companyName").value(DEFAULT_COMPANY_NAME+"2"))


            .andExpect(jsonPath("$.customers[1].createdAt").value("2021-09-26T09:00:00.000Z"))
            .andExpect(jsonPath("$.customers[1]._id").value(DEFAULT_ID+"2"));

        assertThat(memoryAppender.list).extracting(ILoggingEvent::getFormattedMessage).containsExactly("REST request to get all Customers");
    }



}
