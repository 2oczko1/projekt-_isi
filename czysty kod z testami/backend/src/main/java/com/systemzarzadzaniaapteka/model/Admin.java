package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;
@Entity
public class Admin extends AppUser {
    public Admin() {}

    public Admin(String name, String email, String phone, String role, String password) {
        super(name, email, phone, "Admin", password);
    }

    // Dodatkowe metody
    public void addSystemUser(AppUser user) {
        System.out.println("System user added: " + user.getName());
    }

    public void manageAccessRights(AppUser user) {
        System.out.println("Access rights managed for user: " + user.getName());
    }
}
