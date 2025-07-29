package com.systemzarzadzaniaapteka.repository;

import com.systemzarzadzaniaapteka.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.systemzarzadzaniaapteka.model.Order;
import com.systemzarzadzaniaapteka.model.PaymentStatus;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
       // Przyklad: znajdz platnosci po statusie
    List<Payment> findByOrderId(Long orderId);
    List<Payment> findByOrder(Order order);
    List<Payment> findByStatus(PaymentStatus status);
    List<Payment> findByStripePaymentIntentId(String stripePaymentIntentId);



    // Przyklad: znajdz platnosci po zamowieniu (jesli Payment ma pole order)
    // List<Payment> findByOrder(Order order);
    
}