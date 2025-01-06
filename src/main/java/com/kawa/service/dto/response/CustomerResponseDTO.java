package com.kawa.service.dto.response;

import com.kawa.domain.bean.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CustomerResponseDTO {
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerResponseDTO that = (CustomerResponseDTO) o;
        return Objects.equals(customers, that.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customers);
    }

    @Override
    public String toString() {
        return "CustomerResponseDTO{" + "customers=" + customers + '}';
    }
}
