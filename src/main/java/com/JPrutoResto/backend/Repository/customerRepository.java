package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface customerRepository extends JpaRepository<Customers, Long> {
}
