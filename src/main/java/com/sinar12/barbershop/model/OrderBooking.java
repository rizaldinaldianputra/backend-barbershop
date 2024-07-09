package com.sinar12.barbershop.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_bookings")
public class OrderBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nama;

    @Column(nullable = false)
    private String orderStatus;

    @Column(nullable = false)
    private String invoice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    // Constructors, getters, setters, equals, and hashCode methods

    public OrderBooking() {
    }

    public OrderBooking(String nama, String orderStatus, String invoice, User user, Store store) {
        this.nama = nama;
        this.orderStatus = orderStatus;
        this.invoice = invoice;
        this.user = user;
        this.store = store;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        OrderBooking that = (OrderBooking) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nama, that.nama) &&
                Objects.equals(orderStatus, that.orderStatus) &&
                Objects.equals(invoice, that.invoice) &&
                Objects.equals(user, that.user) &&
                Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nama, orderStatus, invoice, user, store);
    }
}
