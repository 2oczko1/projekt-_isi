package com.systemzarzadzaniaapteka.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;
    public Float price;
    private Integer quantity;
    private Integer minimumStockLevel;
    private String manufacturer;
    private String description;
    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @ManyToMany(mappedBy = "medicines")
    private List<EPrescription> prescriptions;
    // Odwolanie do hurtownika, ktory dostarcza dany lek
    @ManyToOne
    @JoinColumn(name = "wholesaler_id")
    private Wholesaler wholesaler;


    public Medicine() {} // domyslny konstruktor

    public Medicine(String name, Float price, Integer quantity, Integer minimumStockLevel, String manufacturer,  String description) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.minimumStockLevel = minimumStockLevel;
        this.manufacturer = manufacturer;
        this.description = description;

    }

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public Integer getMinimumStockLevel() { return minimumStockLevel; }
    public void setMinimumStockLevel(Integer minimumStockLevel) { this.minimumStockLevel = minimumStockLevel; }
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }


    public boolean checkStock() {
        return quantity <= minimumStockLevel;
    }

    public void updateQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public void changePrice(float newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return name + " (Price: " + price + ", Qty: " + quantity + ")";
    }
} 