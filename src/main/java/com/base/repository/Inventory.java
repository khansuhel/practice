package com.base.repository;

import com.base.model.Item;

public interface Inventory
{
    /**
     * Add an item to repository
     * @param item
     */
    void add(Item item);

    /**
     * Remove an item from repository
     * @param itemId
     */
    void remove(String itemId);

    /**
     * Purchase an item from repository
     * @param itemId
     */
    Item purchase(String itemId, int quantity);

    /**
     * Set the doscount percentage of an item
     * @param discountPercentage
     */
    void setDiscount(int discountPercentage, String itemId);

    /**
     * Modify an item
     * @param itemId
     * @param item
     */
    void modify(String itemId, Item item);

    /**
     * Returns an {@link Item}
     * @param itemId
     */
    Item get(String itemId);

}
