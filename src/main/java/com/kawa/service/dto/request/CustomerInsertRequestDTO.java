package com.kawa.service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kawa.domain.bean.CustomerWithoutId;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class CustomerInsertRequestDTO {

    protected String name;

    protected String username;

    protected String firstName;

    protected String lastName;

    protected String adressPostalCode;

    protected String adressCity;

    protected String profileFirstName;

    protected String profileLastName;

    protected String companyName;

    @JsonProperty("adress")
    protected void unpackNestedAdress(Map<String, Object> adress) {

        this.adressPostalCode = (String) adress.get("postalCode");
        this.adressCity = (String) adress.get("city");
    }

    @JsonProperty("profile")
    protected void unpackNestedProfile(Map<String, Object> profile) {

        this.profileFirstName = (String) profile.get("firstName");
        this.profileLastName = (String) profile.get("lastName");
    }

    @JsonProperty("company")
    protected void unpackNestedCompany(Map<String, Object> company) {

        this.companyName = (String) company.get("companyName");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdressPostalCode() {
        return adressPostalCode;
    }

    public void setAdressPostalCode(String adressPostalCode) {
        this.adressPostalCode = adressPostalCode;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    public String getProfileFirstName() {
        return profileFirstName;
    }

    public void setProfileFirstName(String profileFirstName) {
        this.profileFirstName = profileFirstName;
    }

    public String getProfileLastName() {
        return profileLastName;
    }

    public void setProfileLastName(String profileLastName) {
        this.profileLastName = profileLastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInsertRequestDTO that = (CustomerInsertRequestDTO) o;
        return (
                Objects.equals(name, that.name) &&
                Objects.equals(username, that.username) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(adressPostalCode, that.adressPostalCode) &&
                Objects.equals(adressCity, that.adressCity) &&
                Objects.equals(profileFirstName, that.profileFirstName) &&
                Objects.equals(profileLastName, that.profileLastName) &&
                Objects.equals(companyName, that.companyName)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, firstName, lastName, adressPostalCode, adressCity, profileFirstName, profileLastName, companyName);
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", CustomerInsertRequestDTO.class.getSimpleName() + "{", "}")
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
