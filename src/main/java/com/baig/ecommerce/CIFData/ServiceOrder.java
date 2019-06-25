package com.baig.ecommerce.CIFData;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class ServiceOrder {
    @Id
    private int id;
    private String status;
    private List<ServiceOrderItem> serviceOrderItemList;

    public ServiceOrder(int id, String status){
        this.id = id;
        this.status = status;
        serviceOrderItemList = new ArrayList<>();
        serviceOrderItemList.add(new ServiceOrderItem(1, "Open"));
        serviceOrderItemList.add(new ServiceOrderItem(1, "Open"));
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

    public List<ServiceOrderItem> getServiceOrderItemList() {
        return serviceOrderItemList;
    }

    public void setServiceOrderItemList(List<ServiceOrderItem> serviceOrderItemList) {
        this.serviceOrderItemList = serviceOrderItemList;
    }

}
