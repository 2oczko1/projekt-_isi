// src/test/java/com/systemzarzadzaniaapteka/service/OrderServiceIT.java
package com.systemzarzadzaniaapteka.service;

import com.systemzarzadzaniaapteka.dto.OrderDto;
import com.systemzarzadzaniaapteka.model.AppUser;
import com.systemzarzadzaniaapteka.model.Medicine;
import com.systemzarzadzaniaapteka.repository.MedicineRepository;
import com.systemzarzadzaniaapteka.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class OrderServiceIT {

    @Autowired OrderService orderService;
    @Autowired UserRepository userRepo;
    @Autowired MedicineRepository medRepo;

    private AppUser user;
    private Medicine med;

    @BeforeEach
    void setup() {
        user = userRepo.save(new AppUser("Jan","j@p.pl","999","CLIENT","pw"));
        med  = medRepo.save(new Medicine("APAP",15f,100,10,"US",""));
    }

    @Test
    void createOrderSuccessfully() {
        OrderDto dto = new OrderDto();
        dto.setCustomerId(user.getId());
        dto.setItems(List.of(new com.systemzarzadzaniaapteka.dto.OrderItemDto() {{
            setMedicineId(med.getId());
            setQuantity(2);
            setPrice(15f);
        }}));

        // wymagane pola logiczne
        dto.setSubtotal(30f);
        dto.setTax(0f);
        dto.setDeliveryFee(0f);
        dto.setTotal(30f);

        var order = orderService.createOrder(dto);

        assertThat(order.getId()).isNotNull();
        assertThat(order.getItems()).hasSize(1);
        assertThat(order.getTotalAmount()).isEqualTo(30f);
    }
}
