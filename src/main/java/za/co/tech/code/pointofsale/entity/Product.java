package za.co.tech.code.pointofsale.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private String barcode;
    private String name;
    private double price;
    private int stock;

    public Product() {}

    public Product(String barcode, String name, double price, int stock) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getBarcode() { return barcode; }
    public void setBarcode(String barcode) { this.barcode = barcode; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}