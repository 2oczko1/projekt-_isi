package com.systemzarzadzaniaapteka.repository;

import com.systemzarzadzaniaapteka.model.Cart;
import com.systemzarzadzaniaapteka.model.AppUser;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(AppUser user);
}