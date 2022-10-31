package com.JPrutoResto.backend.Repository;

import com.JPrutoResto.backend.Entity.Packages;
import com.JPrutoResto.backend.Entity.packageUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface packageUrlRepository extends JpaRepository<packageUrl, Long> {
    Optional<packageUrl> findByName(String name);
}
