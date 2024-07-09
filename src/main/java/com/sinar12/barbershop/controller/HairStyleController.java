package com.sinar12.barbershop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sinar12.barbershop.model.HairStyle;
import com.sinar12.barbershop.repository.HairStyleRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hairstyles")
public class HairStyleController {

    @Autowired
    private HairStyleRepository HairStyleRepository;

    // Get all HairStyles
    @GetMapping
    public ResponseEntity<List<HairStyle>> getAllHairStyles() {
        List<HairStyle> HairStyles = HairStyleRepository.findAll();
        return ResponseEntity.ok(HairStyles);
    }

    // Get HairStyle by ID
    @GetMapping("/{id}")
    public ResponseEntity<HairStyle> getHairStyleById(@PathVariable Long id) {
        Optional<HairStyle> HairStyleOptional = HairStyleRepository.findById(id);
        return HairStyleOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new HairStyle
    @PostMapping
    public ResponseEntity<HairStyle> createHairStyle(@RequestBody HairStyle HairStyle) {
        HairStyle savedHairStyle = HairStyleRepository.save(HairStyle);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHairStyle);
    }

    // Update an existing HairStyle
    @PutMapping("/{id}")
    public ResponseEntity<HairStyle> updateHairStyle(@PathVariable Long id, @RequestBody HairStyle HairStyleDetails) {
        Optional<HairStyle> HairStyleOptional = HairStyleRepository.findById(id);
        if (HairStyleOptional.isPresent()) {
            HairStyle existingHairStyle = HairStyleOptional.get();
            existingHairStyle.setName(HairStyleDetails.getName());
            existingHairStyle.setType(HairStyleDetails.getType());
            existingHairStyle.setImage(HairStyleDetails.getImage());
            existingHairStyle.setCategory(HairStyleDetails.getCategory());
            HairStyle updatedHairStyle = HairStyleRepository.save(existingHairStyle);
            return ResponseEntity.ok(updatedHairStyle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a HairStyle
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHairStyle(@PathVariable Long id) {
        HairStyleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
