package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface adminRepository  extends JpaRepository<Admin, Long> {
}
