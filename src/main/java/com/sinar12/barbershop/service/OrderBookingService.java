package com.sinar12.barbershop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinar12.barbershop.model.OrderBooking;
import com.sinar12.barbershop.repository.OrderBookingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderBookingService {

    @Autowired
    private OrderBookingRepository orderBookingRepository;

    public List<OrderBooking> getAllOrderBookings() {
        return orderBookingRepository.findAll();
    }

    public Optional<OrderBooking> getOrderBookingById(Long id) {
        return orderBookingRepository.findById(id);
    }

    public OrderBooking createOrderBooking(OrderBooking orderBooking) {
        return orderBookingRepository.save(orderBooking);
    }

    public OrderBooking updateOrderBooking(Long id, OrderBooking orderBookingDetails) {
        Optional<OrderBooking> optionalOrderBooking = orderBookingRepository.findById(id);

        if (optionalOrderBooking.isPresent()) {
            OrderBooking orderBooking = optionalOrderBooking.get();
            orderBooking.setNama(orderBookingDetails.getNama());
            orderBooking.setOrderStatus(orderBookingDetails.getOrderStatus());
            orderBooking.setInvoice(orderBookingDetails.getInvoice());
            orderBooking.setUser(orderBookingDetails.getUser());
            orderBooking.setStore(orderBookingDetails.getStore());

            return orderBookingRepository.save(orderBooking);
        } else {
            throw new RuntimeException("OrderBooking not found with id " + id);
        }
    }

    public void deleteOrderBooking(Long id) {
        orderBookingRepository.deleteById(id);
    }
}
