package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;
@Entity
public class InventoryAlert {
    private String message;
    @ManyToOne

    private InventoryCheck triggeredBy;

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // private String message;

  //  private InventoryCheck triggeredBy;

    @ManyToOne
    private Medicine medicine;

    public InventoryAlert() {
    }

    public InventoryAlert(String message, InventoryCheck triggeredBy, Medicine medicine) {
        this.message = message;
        this.triggeredBy = triggeredBy;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InventoryCheck getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(InventoryCheck triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public void sendAlert() {
        String medInfo = (medicine != null) ? medicine.getName() : "Unknown medicine";
        System.out.println("Inventory alert for " + medInfo + ": " + message);
    }
}