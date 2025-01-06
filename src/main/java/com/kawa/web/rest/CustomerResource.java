package com.kawa.web.rest;

import com.kawa.service.CustomerService;
import com.kawa.service.dto.request.CustomerInsertRequestDTO;
import com.kawa.service.dto.response.CustomerResponseDTO;
import com.kawa.service.dto.response.InsertResponseDTO;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * CustomerResource controller
 */
@RestController
@SecurityRequirement(name = "bearer")
@RequestMapping("/api")
public class CustomerResource {

    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * {@code GET  /customers} : get all the customers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of customers in body.
     */
    @GetMapping("/customers")
    public ResponseEntity<CustomerResponseDTO> getCustomers() {
        log.info("REST request to get all Customers");
        CustomerResponseDTO result = customerService.getCustomers();
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /customers/:id} : get the "id" customer.
     *
     * @param id the id of the customerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the customerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/customers/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable String id) {
        log.info("REST request to get Customer : {}", id);
        CustomerResponseDTO result = customerService.getCustomer(id);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code POST  /customers} : Create a new customer.
     *
     * @param customerRequestDTO the customerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new customerDTO, or with status {@code 400 (Bad Request)} if the customer has already an ID.
     */
    @PostMapping("/customers")
    public ResponseEntity<InsertResponseDTO> createCustomer(@Valid @RequestBody CustomerInsertRequestDTO customerRequestDTO) {
        log.info("REST request to save Customer : {}", customerRequestDTO);
        InsertResponseDTO result = customerService.insertCustomer(customerRequestDTO);
        return ResponseEntity.ok().body(result);
    }
}
