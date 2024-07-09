package com.sinar12.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinar12.barbershop.model.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
