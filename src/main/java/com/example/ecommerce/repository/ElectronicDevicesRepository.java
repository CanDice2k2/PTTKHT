package com.example.ecommerce.repository;

import com.example.ecommerce.model.ElectronicDevices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicDevicesRepository extends JpaRepository<ElectronicDevices, Long> {
}
