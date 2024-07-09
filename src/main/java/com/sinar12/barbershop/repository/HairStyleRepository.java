package com.sinar12.barbershop.repository;

import com.sinar12.barbershop.model.HairStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HairStyleRepository extends JpaRepository<HairStyle, Long> {
}
