package com.kawa.service.dto.response.mongo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kawa.domain.bean.Customer;
import com.kawa.domain.bean.CustomerWithoutId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.*;

public class CustomerFindOneMongoResponseDTO extends FindOneMongoResponseDTO {

    private static final Logger log = LoggerFactory.getLogger(CustomerFindOneMongoResponseDTO.class);

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


    private final Customer document = new Customer();

    private void setDocumentValues(Customer innerCustomer) {
        this.documentId = innerCustomer.getId();
        this.documentCreatedAt = innerCustomer.getCreatedAt();
        this.documentName = innerCustomer.getName();
        this.documentUsername = innerCustomer.getUsername();
        this.documentFirstName = innerCustomer.getFirstName();
        this.documentLastName = innerCustomer.getLastName();
        this.documentAdressPostalCode = innerCustomer.getAdressPostalCode();
        this.documentAdressCity = innerCustomer.getAdressCity();
        this.documentProfileFirstName = innerCustomer.getProfileFirstName();
        this.documentProfileLastName = innerCustomer.getProfileLastName();
        this.documentCompanyName = innerCustomer.getCompanyName();

    }

    @JsonProperty("document")
    @Override
    protected void unpackNested(Map<String, Object> document) throws ParseException {
        log.info("document: {}", document);
        if (document != null) {
            Customer customer = new Customer();
            customer.unpackNestedMap(document);
            setDocumentValues(customer);
        }
    }

    @JsonIgnore
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
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
    @JsonIncludeProperties({ "createdAt", "name", "username", "firstName", "lastName", "adress", "profile", "company", "_id" })
    public Customer getDocument() {
        document.setId(documentId);
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

    public void setDocument(Customer document) {
        setDocumentValues(document);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerFindOneMongoResponseDTO)) return false;
        CustomerFindOneMongoResponseDTO that = (CustomerFindOneMongoResponseDTO) o;
        return (
                Objects.equals(documentId, that.documentId) &&
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
            documentId,
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

        return new StringJoiner(", ", "CustomerFindOneMongoResponseDTO{", "}")
            .add("documentId='" + documentId + "'")
            .add("documentCreatedAt='" + documentCreatedAt + "'")
            .add("documentName=" + documentName)
            .add("documentUsername=" + documentUsername)
            .add("documentFirstName=" + documentFirstName)
            .add("documentLastName=" + documentLastName)
            .add("documentAdressPostalCode=" + documentAdressPostalCode)
            .add("documentAdressCity=" + documentAdressCity)
            .add("documentProfileFirstName=" + documentProfileFirstName)
            .add("documentProfileLastName=" + documentProfileLastName)
            .add("documentCompanyName=" + documentCompanyName)
            .toString();


    }

}
