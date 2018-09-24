package com.base.model;

import java.text.DecimalFormat;

public class Item
{
    private String id;
    private String name;
    private int quantity;
    private double price;
    private double discountPercentage;
    private TaxCategory taxCategory;


    public void setId(String id)
    {
        this.id = id;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }


    public void setPrice(int price)
    {
        this.price = price;
    }


    public void setDiscountPercentage(double discountPercentage)
    {
        this.discountPercentage = discountPercentage;
    }


    public void setTaxCategory(TaxCategory taxCategory)
    {
        this.taxCategory = taxCategory;
    }


    public String getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }


    public int getQuantity()
    {
        return quantity;
    }


    public double getPrice()
    {
        return price;
    }


    public double getDiscountPercentage()
    {
        return discountPercentage;
    }


    public TaxCategory getTaxCategory()
    {
        return taxCategory;
    }


    private Item(String id, String name, int quantity, double price, double discountPercentage, TaxCategory taxCategory)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.discountPercentage = discountPercentage;
        this.taxCategory = taxCategory;
    }


    public static ItemBuilder newItemBuilder()
    {
        return new ItemBuilder();
    }


    public static class ItemBuilder
    {
        private String id;
        private String name;
        private int quantity;
        private double price;
        private double dicountPercentage;
        private TaxCategory taxCategory;

        static DecimalFormat decimalFormat = new DecimalFormat(".##");

        public ItemBuilder setId(String id)
        {
            this.id = id;
            return this;
        }


        public ItemBuilder setName(String name)
        {
            this.name = name;
            return this;
        }


        public ItemBuilder setQuantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }


        public ItemBuilder setPrice(double price)
        {
            this.price = Double.parseDouble(decimalFormat.format(price));
            return this;
        }


        public ItemBuilder setDicountPercentage(double dicountPercentage)
        {
            this.dicountPercentage = Double.parseDouble(decimalFormat.format(dicountPercentage));
            return this;
        }


        public ItemBuilder setTaxCategory(TaxCategory taxCategory)
        {
            this.taxCategory = taxCategory;
            return this;
        }

        public Item build(){
            return new Item(id,name, quantity, price, dicountPercentage, taxCategory);
        }
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Item item = (Item) o;

        if (quantity != item.quantity)
        {
            return false;
        }
        if (price != item.price)
        {
            return false;
        }
        if (discountPercentage != item.discountPercentage)
        {
            return false;
        }
        if (id != null ? !id.equals(item.id) : item.id != null)
        {
            return false;
        }
        if (name != null ? !name.equals(item.name) : item.name != null)
        {
            return false;
        }
        return taxCategory == item.taxCategory;
    }

}
