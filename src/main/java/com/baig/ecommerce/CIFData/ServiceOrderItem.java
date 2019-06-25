package com.baig.ecommerce.CIFData;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrderItem {
    @Id
    private int id;
    private String status;
    private List<CustomFields> customFieldsList;

    public ServiceOrderItem(int id, String status){
        this.id = id;
        this.status = status;
        customFieldsList = new ArrayList<>();
        customFieldsList.add(new CustomFields(1, "custom1","value1"));
        customFieldsList.add(new CustomFields(2, "custom2","value2"));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<CustomFields> getCustomFieldsList() {
        return customFieldsList;
    }

    public void setCustomFieldsList(List<CustomFields> customFieldsList) {
        this.customFieldsList = customFieldsList;
    }
}
