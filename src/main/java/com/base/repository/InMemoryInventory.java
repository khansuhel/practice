package com.base.repository;

import com.base.exception.ItemNotFoundException;
import com.base.model.Item;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// This is a thread-safe singleton defined as a Google Guice
// mapping in com.base.di_mappings.MappingModule
public class InMemoryInventory implements Inventory
{
    private static Map<String, Item> map = new ConcurrentHashMap<>();


    public void add(Item item)
    {
        map.put(item.getId(), item);
    }


    public void remove(String itemId)
    {
        map.remove(itemId);
    }


    public Item purchase(String itemId, int quantity)
    {
        return map.computeIfPresent(itemId, (k,v) -> {
            if(v.getQuantity() < quantity)
                throw new RuntimeException("");
            v.setQuantity(v.getQuantity() - quantity);
            return v;
        });
    }


    public void setDiscount(int discountPercentage, String itemId)
    {

    }


    public void modify(String itemId, Item item)
    {

    }


    public Item get(String itemId)
    {
        return Optional.ofNullable(map.get(itemId))
            .orElseThrow(()-> new ItemNotFoundException("Item not found"));
    }

    private void checkQuantity(int availableQuantity, int purchaseQuantity){
        if(availableQuantity < purchaseQuantity)
            throw new RuntimeException("Cannot make purchase");
    }
}
