package com.systemzarzadzaniaapteka.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer extends AppUser {

    @OneToOne(cascade = CascadeType.ALL)
    private CustomerCard customerCard;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OnlineOrder> orders = new ArrayList<>();

    public Customer() {
        super();
    }

    public Customer( String name, String email, String phone, String role, String password) {
        super(name, email, phone, "Customer", password);
    }

    public List<OnlineOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<OnlineOrder> orders) {
        this.orders = orders;
    }

    public List<Medicine> viewAvailableMedicines() {
        // Tu powinna byc logika pobierania lekow z bazy (np. przez serwis)
        System.out.println("Viewing available medicines");
        return new ArrayList<>();
    }

    public void reportComplaint(String description) {
        DrugComplaint complaint = new DrugComplaint(description, this);
        complaint.submitComplaint();
    }

    public void register() {
        CustomerRegistration reg = new CustomerRegistration();
        reg.registerCustomer();
        System.out.println("Customer registration processed.");
    }
}
