package com.example.ecommerce.repository;

import com.example.ecommerce.model.CashOnDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashOnDeliveryRepository extends JpaRepository<CashOnDelivery, Long> {
}