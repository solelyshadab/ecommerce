package com.baig.ecommerce.CIFData;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class CustomerOrder {
    @Id
    private int id;
    private String status;
    private List<CustomerOrderItem> customerOrderItemList;
    private List<ServiceOrder> serviceOrderList;

    public CustomerOrder(int id , String status){
        this.id = id;
        this.status = status;
        serviceOrderList = new ArrayList<>();
        serviceOrderList.add(new ServiceOrder(1,"Open"));
        serviceOrderList.add(new ServiceOrder(1,"Open"));
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

    public List<CustomerOrderItem> getCustomerOrderItemList() {
        return customerOrderItemList;
    }

    public void setCustomerOrderItemList(List<CustomerOrderItem> customerOrderItemList) {
        this.customerOrderItemList = customerOrderItemList;
    }

    public List<ServiceOrder> getServiceOrderList() {
        return serviceOrderList;
    }

    public void setServiceOrderList(List<ServiceOrder> serviceOrderList) {
        this.serviceOrderList = serviceOrderList;
    }

}
