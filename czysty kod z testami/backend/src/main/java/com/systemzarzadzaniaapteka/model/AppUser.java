package com.systemzarzadzaniaapteka.model;
import jakarta.persistence.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

import java.util.List;

/*
 * Model classes for Pharmacy Management System
 */

// Base User class
@Entity
@Table(name = "app_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected String name;
    protected String email;
    protected String phone;
    protected String role;
    @Column(nullable = false)
    protected String password;

    public AppUser() {}

    public AppUser(String name, String email, String phone, String role, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.password = password;
    }

    // Gettery i settery
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // UserDetails methods
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Przyklad: przypisanie roli jako authority
        String authority = "ROLE_" + role;
        System.out.println("Assigned authority: " + authority);
        return List.of(new SimpleGrantedAuthority(authority));
    }

    @Override
    public String getUsername() {
        return email; // lub name, w zaleznosci od identyfikatora
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // lub wlasna logika
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // lub wlasna logika
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // lub wlasna logika
    }

    @Override
    public boolean isEnabled() {
        return true; // lub wlasna logika
    }

    public void login() {
        // Login logic (Facade pattern could simplify calls)
        System.out.println(name + " logged in.");
    }

    public void logout() {
        // Logout logic
        System.out.println(name + " logged out.");
    }

    public void displayDetails() {
        System.out.println("User [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]");
    }

}