package com.example.ecommerce.repository;

import com.example.ecommerce.model.Fashion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FashionRepository extends JpaRepository<Fashion, Long> {
}
