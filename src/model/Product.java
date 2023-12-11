package model;

import java.math.BigDecimal;
import java.util.Date;

public class Product {

    private String name;
    private Date expirationDate;
    private String type;
    private int stock;
    private int minStock;
    private BigDecimal price;
    private int barcode;
    
    public Product(String name, Date expirationDate, String type, int stock, int minStock, BigDecimal price, int barcode) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.type = type;
        this.stock = stock;
        this.minStock = minStock;
        this.price = price;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
}
