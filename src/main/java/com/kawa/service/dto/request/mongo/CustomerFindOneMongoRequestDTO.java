package com.kawa.service.dto.request.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CustomerFindOneMongoRequestDTO extends FindOneMongoRequestDTO {

    public CustomerFindOneMongoRequestDTO() {
        this.collection = "customers";
    }

    private String filterId;

    private final Map<String, Object> filter = new HashMap<>();

    @Override
    protected void unpackNested(Map<String, Object> filter) {
        this.filterId = (String) filter.get("_id");
    }

    @JsonIgnore
    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public Map<String, Object> getFilter() {
        Map<String, Object> filterMap = new HashMap<>();
        filterMap.put("$oid", filterId);
        filter.put("_id", filterMap);
        return filter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerFindOneMongoRequestDTO)) return false;
        if (!super.equals(o)) return false;
        CustomerFindOneMongoRequestDTO that = (CustomerFindOneMongoRequestDTO) o;
        return Objects.equals(filterId, that.filterId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), filterId);
    }

    @Override
    public String toString() {
        return (
            "CustomerFindOneMongoRequestDTO{" +
                "dataSource='" +
                dataSource +
                '\'' +
                ", database='" +
                database +
                '\'' +
                ", collection='" +
                collection +
                '\'' +
                ", filterId='" +
                filterId +
                '\'' +
                '}'
        );
    }

}
