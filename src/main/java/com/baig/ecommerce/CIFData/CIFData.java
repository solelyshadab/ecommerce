package com.baig.ecommerce.CIFData;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document
public class CIFData {
    @Id
    private Integer id;
    private String projectManager;
    private String customerName;
    private String quoteID;
    private String startDate;
    private String endDate;
    private String status;
    @Field(value = "customerOrderList")
    private List<CustomerOrder> customerOrderList;

    public CIFData(Integer id, String projectManager, String customerName, String quoteID) {
        this.id = id;
        this.projectManager = projectManager;
        this.customerName = customerName;
        this.quoteID = quoteID;
        customerOrderList = new ArrayList<>();
        customerOrderList.add(new CustomerOrder(1,"Open"));
        customerOrderList.add(new CustomerOrder(2,"Open"));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getQuoteID() {
        return quoteID;
    }

    public void setQuoteID(String quoteID) {
        this.quoteID = quoteID;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = "";
        try {
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            jsonString = mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }
}
