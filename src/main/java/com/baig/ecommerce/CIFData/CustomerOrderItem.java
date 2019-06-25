package com.baig.ecommerce.CIFData;

import org.springframework.data.annotation.Id;

public class CustomerOrderItem {

    public CustomerOrderItem(int id, String status, String itemName) {
        this.id = id;
        this.status = status;
        this.itemName = itemName;
    }

    @Id
    private int id;
    private String status;
    private String itemName;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }



}
