package com.example.ecommerce.repository;

import com.example.ecommerce.model.ShippingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingStatusRepository extends JpaRepository<ShippingStatus, Long> {
}
