package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface packageRepository extends JpaRepository<Packages , Long> {
}
