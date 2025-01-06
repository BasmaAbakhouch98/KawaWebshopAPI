package com.kawa.domain.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerWithoutId {

    protected final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    protected Date createdAt;

    protected String name;

    protected String username;

    protected String firstName;

    protected String lastName;

    protected String adressPostalCode;

    protected String adressCity;

    protected final Map<String, Object> adress = new HashMap<>();

    protected String profileFirstName;

    protected String profileLastName;

    protected final Map<String, Object> profile = new HashMap<>();

    protected String companyName;

    protected final Map<String, Object> company = new HashMap<>();

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

    @SuppressWarnings("unchecked")
    public void unpackNestedMap(Map<String, Object> map) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        this.createdAt = formatter.parse((String) map.get("createdAt"));
        this.name = (String) map.get("name");
        this.username = (String) map.get("username");
        this.firstName = (String) map.get("firstName");
        this.lastName = (String) map.get("lastName");

        Map<String, Object> unpackNestedAdress = (Map<String, Object>) map.get("adress");
        unpackNestedAdress(unpackNestedAdress);

        Map<String, Object> unpackNestedProfile = (Map<String, Object>) map.get("profile");
        unpackNestedProfile(unpackNestedProfile);

        Map<String, Object> unpackNestedCompany = (Map<String, Object>) map.get("company");
        unpackNestedCompany(unpackNestedCompany);
    }

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "UTC")
    public Date getCreatedAt() {
        return createdAt;
    }

    public CustomerWithoutId createdAt(Date createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @JsonIgnore
    public String getAdressPostalCode() {
        return adressPostalCode;
    }

    public void setAdressPostalCode(String adressPostalCode) {
        this.adressPostalCode = adressPostalCode;
    }
    @JsonIgnore
    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }
    @JsonIgnore
    public String getProfileFirstName() {
        return profileFirstName;
    }

    public void setProfileFirstName(String profileFirstName) {
        this.profileFirstName = profileFirstName;
    }
    @JsonIgnore
    public String getProfileLastName() {
        return profileLastName;
    }

    public void setProfileLastName(String profileLastName) {
        this.profileLastName = profileLastName;
    }
    @JsonIgnore
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Map<String, Object> getAdress() {
        this.adress.put("postalCode", adressPostalCode);
        this.adress.put("city", adressCity);

        return adress;
    }

    public Map<String, Object> getProfile() {
        this.profile.put("firstName", profileFirstName);
        this.profile.put("lastName", profileLastName);

        return profile;
    }

    public Map<String, Object> getCompany() {
        this.company.put("companyName", companyName);

        return company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerWithoutId)) {
            return false;
        }
        CustomerWithoutId that = (CustomerWithoutId) o;
        return (
            createdAt != null &&
                name != null &&
                username != null &&
                firstName != null &&
                lastName != null &&
                adressPostalCode != null &&
                adressCity != null &&
                profileFirstName != null &&
                profileLastName != null &&
                companyName != null &&

                Objects.equals(createdAt, that.createdAt) &&
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

    @JsonIgnore
    public boolean isNull() {
        return (createdAt == null && name == null && username == null && firstName == null && lastName == null && adressPostalCode == null
        && adressCity == null && profileFirstName == null && profileLastName == null && companyName == null
        );
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        String createdAtStr = (this.createdAt == null) ? null : dateFormat.format(this.createdAt);

        return new StringJoiner(", ", CustomerWithoutId.class.getSimpleName() + "{", "}")
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
