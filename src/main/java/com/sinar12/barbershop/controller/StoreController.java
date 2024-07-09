package com.sinar12.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sinar12.barbershop.dto.StoreResponse;
import com.sinar12.barbershop.model.Store;
import com.sinar12.barbershop.repository.StoreRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreRepository storeRepository;

    // Get all stores
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return ResponseEntity.ok(stores);
    }

    // Get store by ID
    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getStoreById(@PathVariable Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isPresent()) {
            StoreResponse response = new StoreResponse();
            response.setSuccess(true);
            response.setMessage("Store found");
            response.setData(storeOptional.get());
            return ResponseEntity.ok(response);
        } else {
            StoreResponse response = new StoreResponse();
            response.setSuccess(false);
            response.setMessage("Store not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Create a new store
    @PostMapping
    public ResponseEntity<StoreResponse> createStore(@RequestBody Store store) {
        Store savedStore = storeRepository.save(store);
        StoreResponse response = new StoreResponse();
        response.setSuccess(true);
        response.setMessage("Store created successfully");
        response.setData(savedStore);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Update an existing store
    @PutMapping("/{id}")
    public ResponseEntity<StoreResponse> updateStore(@PathVariable Long id, @RequestBody Store storeDetails) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isPresent()) {
            Store existingStore = storeOptional.get();
            existingStore.setName(storeDetails.getName());
            existingStore.setAddress(storeDetails.getAddress());
            existingStore.setPhoneNumber(storeDetails.getPhoneNumber());
            existingStore.setWebsite(storeDetails.getWebsite());
            existingStore.setLat(storeDetails.getLat());
            existingStore.setLonglat(storeDetails.getLonglat());
            storeRepository.save(existingStore);

            StoreResponse response = new StoreResponse();
            response.setSuccess(true);
            response.setMessage("Store updated successfully");
            response.setData(existingStore);
            return ResponseEntity.ok(response);
        } else {
            StoreResponse response = new StoreResponse();
            response.setSuccess(false);
            response.setMessage("Store not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    // Delete a store
    @DeleteMapping("/{id}")
    public ResponseEntity<StoreResponse> deleteStore(@PathVariable Long id) {
        Optional<Store> storeOptional = storeRepository.findById(id);
        if (storeOptional.isPresent()) {
            storeRepository.deleteById(id);
            StoreResponse response = new StoreResponse();
            response.setSuccess(true);
            response.setMessage("Store deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            StoreResponse response = new StoreResponse();
            response.setSuccess(false);
            response.setMessage("Store not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
