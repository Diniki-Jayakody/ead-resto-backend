package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface customerRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByNic(String nic);
}
