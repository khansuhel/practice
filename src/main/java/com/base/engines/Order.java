package com.base.engines;

import com.base.exception.ItemNotFoundException;
import com.base.exception.ItemQuantityExhaustedException;
import com.base.repository.Inventory;
import com.base.model.Item;
import com.google.inject.Inject;
import java.util.HashMap;
import java.util.Map;

public class Order
{
    @Inject
    private Inventory inventory;

    private static Map<String, Integer> orderDetails;

    public Order(){
        this.orderDetails = new HashMap<>();
    }

    public void add(String itemId, Integer quantity){
        Item item = inventory.get(itemId).orElseThrow(() -> new ItemNotFoundException("Item Not found"));
        if(item.getQuantity() < quantity)
            throw new ItemQuantityExhaustedException("Available Item Quantity: "+item.getQuantity()+" is less than ordered quantity of "+quantity);
        orderDetails.put(itemId, quantity);
    }

    public Map getOrderDetails(){
        if(orderDetails.size()==0)
            throw new RuntimeException("The order is empty");
        return orderDetails;
    }



}
