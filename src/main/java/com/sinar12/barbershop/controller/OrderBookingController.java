package com.sinar12.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sinar12.barbershop.model.OrderBooking;
import com.sinar12.barbershop.service.OrderBookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orderbookings")
public class OrderBookingController {

    @Autowired
    private OrderBookingService orderBookingService;

    @GetMapping
    public List<OrderBooking> getAllOrderBookings() {
        return orderBookingService.getAllOrderBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderBooking> getOrderBookingById(@PathVariable Long id) {
        Optional<OrderBooking> orderBooking = orderBookingService.getOrderBookingById(id);

        if (orderBooking.isPresent()) {
            return ResponseEntity.ok(orderBooking.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public OrderBooking createOrderBooking(@RequestBody OrderBooking orderBooking) {
        return orderBookingService.createOrderBooking(orderBooking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderBooking> updateOrderBooking(@PathVariable Long id,
            @RequestBody OrderBooking orderBookingDetails) {
        OrderBooking updatedOrderBooking = orderBookingService.updateOrderBooking(id, orderBookingDetails);

        return ResponseEntity.ok(updatedOrderBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderBooking(@PathVariable Long id) {
        orderBookingService.deleteOrderBooking(id);
        return ResponseEntity.noContent().build();
    }
}
