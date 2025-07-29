package com.systemzarzadzaniaapteka.repository;

import com.systemzarzadzaniaapteka.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Mozesz dodac dodatkowe metody, np. wyszukiwanie po emailu:
    boolean existsByEmail(String email);
}
