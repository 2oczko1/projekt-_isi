package com.systemzarzadzaniaapteka.repository;

import com.systemzarzadzaniaapteka.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
