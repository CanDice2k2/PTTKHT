package com.example.ecommerce.repository;

import com.example.ecommerce.model.StorageOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageOptionRepository extends JpaRepository<StorageOption, Long> {
}
