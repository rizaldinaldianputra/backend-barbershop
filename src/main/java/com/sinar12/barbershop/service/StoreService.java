package com.sinar12.barbershop.service;

import java.util.List;
import java.util.Optional;

import com.sinar12.barbershop.model.Store;

public interface StoreService {
    List<Store> getAllStores();

    Optional<Store> getStoreById(Long id);

    Store createOrUpdateStore(Store store);

    void deleteStore(Long id);
}
