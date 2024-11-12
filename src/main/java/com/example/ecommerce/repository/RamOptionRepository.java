package com.example.ecommerce.repository;

import com.example.ecommerce.model.RamOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RamOptionRepository extends JpaRepository<RamOption, Long> {
}
