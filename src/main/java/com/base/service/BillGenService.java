package com.base.service;

import com.base.model.Bill;
import com.base.model.Item;
import com.base.model.Order;
import com.base.repository.Inventory;
import com.base.repository.TaxUtil;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Iterator;
import java.util.Map;

@Singleton
public class BillGenService
{

    @Inject
    private Inventory inventory;


    public Bill generateBill(Order order)
    {
        if (order == null)
        {
            throw new RuntimeException("No order to process bill.");
        }

        double totalPrice = 0, totalDiscount = 0, grandTotal = 0;
        double totalTax = 0;

        Map<String, Integer> orderDetails = order.getOrderDetails();

        Iterator<Map.Entry<String, Integer>> entries = orderDetails.entrySet().iterator();

        while (entries.hasNext())
        {
            Map.Entry<String, Integer> entry = entries.next();
            String itemId = entry.getKey();
            Integer purchaseQuantity = entry.getValue();

            Item item = inventory.purchase(itemId, purchaseQuantity);

            double itemWiseTotalPrice = item.getPrice() * purchaseQuantity;
            totalPrice += itemWiseTotalPrice;

            int taxApplicable = TaxUtil.getTaxPercentage(item.getTaxCategory());
            double itemWiseTax = (itemWiseTotalPrice * taxApplicable) / 100;
            totalTax += itemWiseTax;

            double itemWiseGrandTotal = itemWiseTotalPrice + itemWiseTax;
            grandTotal += itemWiseGrandTotal;
        }

        return Bill.BillBuilder().setGrandTotal(grandTotal)
            .setTax(totalTax)
            .setTotalDiscount(new Double(0))
            .setTotalPrice(totalPrice)
            .build();

    }

}
