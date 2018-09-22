package com.base.repository;

import com.base.model.Item;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// This is a thread-safe singleton defined as a Google Guice
// mapping in com.base.di_mappings.ApplicationMappings

public class DefaultInventory implements Inventory
{
    private static Map<String, Item> map = new HashMap<String, Item>();


    public void add(Item item)
    {
        map.put(item.getId(), item);
    }


    public void remove(String itemId)
    {
        map.remove(itemId);
    }


    public synchronized Item purchase(String itemId, int quantity)
    {
        Item item = get(itemId).get();
        checkQuantity(item.getQuantity(), quantity);
        item.setQuantity(item.getQuantity() - quantity);
        return item;
    }


    public void setDiscount(int discountPercentage, String itemId)
    {

    }


    public void modify(String itemId, Item item)
    {

    }


    public Optional<Item> get(String itemId)
    {
        return Optional.ofNullable(map.get(itemId));
    }

    private void checkQuantity(int availableQuantity, int purchaseQuantity){
        if(availableQuantity < purchaseQuantity)
            throw new RuntimeException("Cannot make purchase");
    }
}
