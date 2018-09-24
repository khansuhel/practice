package com.base.model;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class Bill
{
    private String invoiceNum;
    private Date invoiceDate;
    private Map<String, Integer> orderDetails;
    private Double totalPrice;
    private Double totalDiscount;
    private Double tax;
    private Double grandTotal;


    public String getInvoiceNum()
    {
        return invoiceNum;
    }


    public Date getInvoiceDate()
    {
        return invoiceDate;
    }


    public Map<String, Integer> getOrderDetails()
    {
        return orderDetails;
    }


    public Double getTotalPrice()
    {
        return totalPrice;
    }


    public Double getTotalDiscount()
    {
        return totalDiscount;
    }


    public Double getTax()
    {
        return tax;
    }


    public Double getGrandTotal()
    {
        return grandTotal;
    }


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


    private Bill(Map<String, Integer> orderDetails, Double totalPrice, Double totalDiscount, Double tax, Double grandTotal)
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
        private Double totalPrice;
        private Double totalDiscount;
        private Double tax;
        private Double grandTotal;

        static DecimalFormat decimalFormat = new DecimalFormat(".##");

        public Builder setOrderDetails(Map<String, Integer> orderDetails)
        {
            this.orderDetails = orderDetails;
            return this;
        }


        public Builder setTotalPrice(Double totalPrice)
        {
            this.totalPrice = Double.parseDouble(decimalFormat.format(totalPrice));
            return this;
        }


        public Builder setTotalDiscount(Double totalDiscount)
        {
            this.totalDiscount = Double.parseDouble(decimalFormat.format(totalDiscount));
            return this;
        }


        public Builder setTax(Double tax)
        {
            this.tax = Double.parseDouble(decimalFormat.format(tax));
            return this;
        }


        public Builder setGrandTotal(Double grandTotal)
        {
            this.grandTotal = Double.parseDouble(decimalFormat.format(grandTotal));
            return this;
        }

        public Bill build(){
            return new Bill(orderDetails,totalPrice,totalDiscount,tax,grandTotal);
        }
    }
}
