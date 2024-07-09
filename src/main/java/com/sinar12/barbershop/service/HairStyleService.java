package com.sinar12.barbershop.service;

import com.sinar12.barbershop.model.HairStyle;

import java.util.List;
import java.util.Optional;

public interface HairStyleService {
    List<HairStyle> getAllHairstyles();

    Optional<HairStyle> getHairstyleById(Long id);

    HairStyle createOrUpdateHairstyle(HairStyle hairstyle);

    void deleteHairstyle(Long id);
}
