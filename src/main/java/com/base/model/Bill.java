package com.base.model;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Bill
{
    private String invoiceNum;
    private Date invoiceDate;
    private Map<String, Integer> orderDetails;
    private Integer totalPrice;
    private Integer totalDiscount;
    private Integer tax;
    private Integer grandTotal;


    @Override
    public String toString()
    {
        return "Bill{" +
            "invoiceNum='" + invoiceNum + '\'' +
            ", invoiceDate=" + invoiceDate +
            ", orderDetails=" + orderDetails +
            ", totalPrice=" + totalPrice +
            ", totalDiscount=" + totalDiscount +
            ", tax=" + tax +
            ", grandTotal=" + grandTotal +
            '}';
    }


    private Bill(Map<String, Integer> orderDetails, Integer totalPrice, Integer totalDiscount, Integer tax, Integer grandTotal)
    {
        this.invoiceNum = UUID.randomUUID().toString();
        this.invoiceDate = new Date();
        this.orderDetails = orderDetails;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.tax = tax;
        this.grandTotal = grandTotal;
    }

    public static Builder BillBuilder(){
        return new Builder();
    }

    public static class Builder{

        private Map<String, Integer> orderDetails;
        private Integer totalPrice;
        private Integer totalDiscount;
        private Integer tax;
        private Integer grandTotal;

        public Builder setOrderDetails(Map<String, Integer> orderDetails)
        {
            this.orderDetails = orderDetails;
            return this;
        }


        public Builder setTotalPrice(Integer totalPrice)
        {
            this.totalPrice = totalPrice;
            return this;
        }


        public Builder setTotalDiscount(Integer totalDiscount)
        {
            this.totalDiscount = totalDiscount;
            return this;
        }


        public Builder setTax(Integer tax)
        {
            this.tax = tax;
            return this;
        }


        public Builder setGrandTotal(Integer grandTotal)
        {
            this.grandTotal = grandTotal;
            return this;
        }

        public Bill build(){
            return new Bill(orderDetails,totalPrice,totalDiscount,tax,grandTotal);
        }
    }
}
