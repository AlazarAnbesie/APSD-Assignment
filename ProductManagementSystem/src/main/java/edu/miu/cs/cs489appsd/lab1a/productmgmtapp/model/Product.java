package edu.miu.cs.cs489appsd.lab1a.productmgmtapp.model;

import java.time.LocalDate;

public class Product {
    long productId;
    String name;
    LocalDate dateSupplied;
    int quantityInStock;
    double unitPrice;

    public Product(long productId, String name, LocalDate dateSupplied, int quantityInStock, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.quantityInStock = quantityInStock;
        this.unitPrice = unitPrice;
    }

    public Product(long productId, String name, LocalDate dateSupplied, double unitPrice) {
        this.productId = productId;
        this.name = name;
        this.dateSupplied = dateSupplied;
        this.unitPrice = unitPrice;
    }

    public Product() {
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("productId=").append(productId);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dateSupplied=").append(dateSupplied);
        sb.append(", quantityInStock=").append(quantityInStock);
        sb.append(", unitPrice=").append(unitPrice);
        return sb.toString();
    }
}
