package com.base.model;

public class Item
{
    private String id;
    private String name;
    private int quantity;
    private int price;
    private int dicountPercentage;
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


    public void setDicountPercentage(int dicountPercentage)
    {
        this.dicountPercentage = dicountPercentage;
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


    public int getPrice()
    {
        return price;
    }


    public int getDicountPercentage()
    {
        return dicountPercentage;
    }


    public TaxCategory getTaxCategory()
    {
        return taxCategory;
    }


    private Item(String id, String name, int quantity, int price, int dicountPercentage, TaxCategory taxCategory)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.dicountPercentage = dicountPercentage;
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
        private int price;
        private int dicountPercentage;
        private TaxCategory taxCategory;


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


        public ItemBuilder setPrice(int price)
        {
            this.price = price;
            return this;
        }


        public ItemBuilder setDicountPercentage(int dicountPercentage)
        {
            this.dicountPercentage = dicountPercentage;
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
        if (dicountPercentage != item.dicountPercentage)
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


    @Override
    public int hashCode()
    {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + price;
        result = 31 * result + dicountPercentage;
        result = 31 * result + (taxCategory != null ? taxCategory.hashCode() : 0);
        return result;
    }
}
