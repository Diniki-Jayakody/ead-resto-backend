package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository  extends JpaRepository<Admin, Long> {
}
