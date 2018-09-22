package com.base.engines;

import com.base.repository.Inventory;
import com.base.model.Bill;
import com.base.model.Item;
import com.base.repository.TaxUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.Map;

@Singleton
public class BillGenEngine
{

    @Inject
    private Inventory inventory;



    public Bill generateBill(Order order)
    {
        int totalPrice = 0, totalDiscount = 0, totalTax = 0, grandTotal = 0;

        if (order == null)
        {
            throw new RuntimeException("No order to process bill.");
        }

        Map map = order.getOrderDetails();
        Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();

        while (entries.hasNext())
        {
            Map.Entry<String, Integer> entry = entries.next();
            String itemId = entry.getKey();
            Integer itemQuantity = entry.getValue();

            Item item = inventory.purchase(itemId, itemQuantity);

            int itemWiseTotalPrice = item.getPrice() * itemQuantity;
            totalPrice += itemWiseTotalPrice;
            int taxApplicable = TaxUtil.getTaxPercentage(item.getTaxCategory());
            int itemWiseTax = (itemWiseTotalPrice * taxApplicable) / 100;
            totalTax += itemWiseTax;
            int itemWiseGrandTotal = itemWiseTotalPrice + itemWiseTax;
            grandTotal += itemWiseGrandTotal;
        }

        return Bill.BillBuilder().setGrandTotal(grandTotal)
            .setTax(totalTax)
            .setTotalDiscount(0)
            .setTotalPrice(totalPrice)
            .build();

    }

}
