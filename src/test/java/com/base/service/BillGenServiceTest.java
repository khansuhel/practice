package com.base.service;

import com.base.model.Bill;
import com.base.model.Item;
import com.base.model.Order;
import com.base.model.TaxCategory;
import com.base.repository.Inventory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BillGenServiceTest
{
    @Mock
    Inventory inventory;

    @InjectMocks
    BillGenService billGenService;

    @Test
    public void generateBill()
    {
        Item mockItem = new Item.ItemBuilder().setId("123")
            .setName("suhel")
            .setPrice(100.00)
            .setQuantity(1)
            .setTaxCategory(TaxCategory.GST).build();

        Mockito.when(inventory.purchase(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockItem);

        Order order = new Order();
        order.add("123", 1);

        Bill bill  = billGenService.generateBill(order);

        Assert.assertEquals(new Double(115), bill.getGrandTotal());
    }
}