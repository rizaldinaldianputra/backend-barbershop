package com.sinar12.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sinar12.barbershop.model.OrderBooking;

@Repository
public interface OrderBookingRepository extends JpaRepository<OrderBooking, Long> {
}
