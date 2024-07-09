package com.sinar12.barbershop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinar12.barbershop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
