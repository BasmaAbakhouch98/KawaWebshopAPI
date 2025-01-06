package com.kawa.service.dto.request.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kawa.domain.bean.Customer;
import com.kawa.domain.bean.CustomerWithoutId;
import com.kawa.service.dto.response.mongo.CustomerFindOneMongoResponseDTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.StringJoiner;

public class CustomerInsertMongoRequestDTO extends InsertMongoRequestDTO {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private String documentId;
    private Date documentCreatedAt;

    private String documentName;

    private String documentUsername;

    private String documentFirstName;

    private String documentLastName;

    private String documentAdressPostalCode;

    private String documentAdressCity;

    private String documentProfileFirstName;

    private String documentProfileLastName;

    private String documentCompanyName;


    private final CustomerWithoutId document = new CustomerWithoutId();

    public CustomerInsertMongoRequestDTO() {
        this.collection = "customers";
        dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("UTC"));
    }

    @JsonIgnore
    public Date getDocumentCreatedAt() {
        return documentCreatedAt;
    }

    public void setDocumentCreatedAt(Date documentCreatedAt) {
        this.documentCreatedAt = documentCreatedAt;
    }
    @JsonIgnore
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }
    @JsonIgnore
    public String getDocumentUsername() {
        return documentUsername;
    }

    public void setDocumentUsername(String documentUsername) {
        this.documentUsername = documentUsername;
    }
    @JsonIgnore
    public String getDocumentFirstName() {
        return documentFirstName;
    }

    public void setDocumentFirstName(String documentFirstName) {
        this.documentFirstName = documentFirstName;
    }
    @JsonIgnore
    public String getDocumentLastName() {
        return documentLastName;
    }

    public void setDocumentLastName(String documentLastName) {
        this.documentLastName = documentLastName;
    }
    @JsonIgnore
    public String getDocumentAdressPostalCode() {
        return documentAdressPostalCode;
    }

    public void setDocumentAdressPostalCode(String documentAdressPostalCode) {
        this.documentAdressPostalCode = documentAdressPostalCode;
    }
    @JsonIgnore
    public String getDocumentAdressCity() {
        return documentAdressCity;
    }

    public void setDocumentAdressCity(String documentAdressCity) {
        this.documentAdressCity = documentAdressCity;
    }
    @JsonIgnore
    public String getDocumentProfileFirstName() {
        return documentProfileFirstName;
    }

    public void setDocumentProfileFirstName(String documentProfileFirstName) {
        this.documentProfileFirstName = documentProfileFirstName;
    }
    @JsonIgnore
    public String getDocumentProfileLastName() {
        return documentProfileLastName;
    }

    public void setDocumentProfileLastName(String documentProfileLastName) {
        this.documentProfileLastName = documentProfileLastName;
    }
    @JsonIgnore
    public String getDocumentCompanyName() {
        return documentCompanyName;
    }

    public void setDocumentCompanyName(String documentCompanyName) {
        this.documentCompanyName = documentCompanyName;
    }

    @JsonProperty("document")
    private void unpackNested(Map<String, Object> document) throws ParseException {
        CustomerWithoutId customer = new CustomerWithoutId();
        customer.unpackNestedMap(document);
        documentCreatedAt = customer.getCreatedAt();
        documentName = customer.getName();
        documentUsername = customer.getUsername();
        documentFirstName = customer.getFirstName();
        documentLastName = customer.getLastName();
        documentAdressPostalCode = customer.getAdressPostalCode();
        documentAdressCity = customer.getAdressCity();
        documentProfileFirstName = customer.getProfileFirstName();
        documentProfileLastName = customer.getProfileLastName();
        documentCompanyName = customer.getCompanyName();
    }

    @JsonIncludeProperties({ "createdAt", "name", "username", "firstName", "lastName", "adress", "profile", "company" })
    public CustomerWithoutId getDocument() {
        document.setCreatedAt(documentCreatedAt);
        document.setName(documentName);
        document.setUsername(documentUsername);
        document.setFirstName(documentFirstName);
        document.setLastName(documentLastName);
        document.setAdressPostalCode(documentAdressPostalCode);
        document.setAdressCity(documentAdressCity);
        document.setProfileFirstName(documentProfileFirstName);
        document.setProfileLastName(documentProfileLastName);
        document.setCompanyName(documentCompanyName);
        return document;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerInsertMongoRequestDTO)) return false;
        if (!super.equals(o)) return false;
        CustomerInsertMongoRequestDTO that = (CustomerInsertMongoRequestDTO) o;
        return (
            Objects.equals(documentCreatedAt, that.documentCreatedAt) &&
            Objects.equals(documentName, that.documentName) &&
            Objects.equals(documentUsername, that.documentUsername) &&
            Objects.equals(documentFirstName, that.documentFirstName) &&
            Objects.equals(documentLastName, that.documentLastName) &&
            Objects.equals(documentAdressPostalCode, that.documentAdressPostalCode) &&
            Objects.equals(documentAdressCity, that.documentAdressCity) &&
            Objects.equals(documentProfileFirstName, that.documentProfileFirstName) &&
            Objects.equals(documentProfileLastName, that.documentProfileLastName) &&
            Objects.equals(documentCompanyName, that.documentCompanyName)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            super.hashCode(),
            documentCreatedAt,
            documentName,
            documentUsername,
            documentFirstName,
            documentLastName,
            documentAdressPostalCode,
            documentAdressCity,
            documentProfileFirstName,
            documentProfileLastName,
            documentCompanyName
        );
    }

    @Override
    public String toString() {

        return new StringJoiner(", ", CustomerInsertMongoRequestDTO.class.getSimpleName() + "{", "}")
            .add("dataSource='" + dataSource + "'")
            .add("database='" + database + "'")
            .add("collection='" + collection + "'")
            .add("documentCreatedAt='" + dateFormat.format(documentCreatedAt) + "'")
            .add("documentName='" + documentName + "'")
            .add("documentUsername='" + documentUsername + "'")
            .add("documentFirstName='" + documentFirstName + "'")
            .add("documentLastName='" + documentLastName + "'")
            .add("documentAdressPostalCode='" + documentAdressPostalCode + "'")
            .add("documentAdressCity='" + documentAdressCity + "'")
            .add("documentProfileFirstName='" + documentProfileFirstName + "'")
            .add("documentProfileLastName='" + documentProfileLastName + "'")
            .add("documentCompanyName='" + documentCompanyName + "'")
            .toString();


    }

}
