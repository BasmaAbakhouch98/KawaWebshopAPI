package com.kawa.domain.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.util.Map;
import java.util.StringJoiner;

public class Customer extends CustomerWithoutId{

    public Customer() {
        super();
    }

    @JsonProperty("_id")
    private String id;

    @Override
    public void unpackNestedMap(Map<String, Object> map) throws ParseException {
        super.unpackNestedMap(map);
        this.id = (String) map.get("_id");
    }

    public String getId() {
        return id;
    }

    public Customer id(String id) {
        this.setId(id);
        return this;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        return id != null && id.equals(((Customer) o).id);
    }

    @Override
    @JsonIgnore
    public boolean isNull() {
        return this.id == null && super.isNull();
    }

    @Override
    public String toString() {
        String createdAtStr = (this.createdAt == null) ? null : dateFormat.format(this.createdAt);

        return new StringJoiner(", ", Customer.class.getSimpleName() + "{", "}")
            .add("id='" + id + "'")
            .add("createdAt='" + createdAtStr + "'")
            .add("name='" + getName() + "'")
            .add("username='" + getUsername() + "'")
            .add("firstName='" + getFirstName() + "'")
            .add("lastName='" + getLastName() + "'")
            .add("adressPostalCode='" + getAdressPostalCode() + "'")
            .add("adressCity='" + getAdressCity() + "'")
            .add("profileFirstName='" + getProfileFirstName() + "'")
            .add("profileLastName='" + getProfileLastName() + "'")
            .add("companyName='" + getCompanyName() + "'")
            .toString();
    }
}
