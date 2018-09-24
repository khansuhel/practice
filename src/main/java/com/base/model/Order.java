package com.base.model;

import java.util.HashMap;
import java.util.Map;

public class Order
{
    private static Map<String, Integer> orderDetails;


    public Order()
    {
        this.orderDetails = new HashMap<>();
    }


    public void add(String itemId, Integer quantity)
    {
        orderDetails.put(itemId, quantity);
    }


    public Map getOrderDetails()
    {
        if (orderDetails.size() == 0)
        {
            throw new RuntimeException("The order is empty");
        }
        return orderDetails;
    }


}
