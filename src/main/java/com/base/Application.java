package com.base;

import com.base.di_mappings.MappingModule;
import com.base.service.BillGenService;
import com.base.model.Order;
import com.base.model.Bill;
import com.base.model.Item;
import com.base.model.TaxCategory;
import com.base.repository.Inventory;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class Application
{
    @Inject
    Inventory inventory;


    public void prepareInventory()
    {
        Item item1 = Item.newItemBuilder().setName("Item 1")
            .setId("Item001")
            .setPrice(10)
            .setDicountPercentage(10)
            .setQuantity(5)
            .setTaxCategory(TaxCategory.GST)
            .build();

        Item item2 = Item.newItemBuilder().setName("Item 2")
            .setId("Item002")
            .setPrice(100)
            .setDicountPercentage(1)
            .setQuantity(50)
            .setTaxCategory(TaxCategory.IGST)
            .build();

        inventory.add(item1);
        inventory.add(item2);
    }


    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new MappingModule());

        Application application = injector.getInstance(Application.class);
        application.prepareInventory();

        Order order = injector.getInstance(Order.class);
        order.add("Item001", 2);
        order.add("Item002", 2);

        BillGenService billGenService = injector.getInstance(BillGenService.class);
        Bill bill = billGenService.generateBill(order);

        System.out.println(bill.toString());
    }
}
