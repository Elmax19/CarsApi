package com.itechart.carsapi.controller;

import com.itechart.carsapi.model.Garage;
import com.itechart.carsapi.model.dto.GarageDto;
import com.itechart.carsapi.service.GarageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsAPI")
public class GarageController {
    private final GarageService garageService;

    @PreAuthorize("hasAuthority('garage:read')")
    @GetMapping("/garage/{id}")
    public Garage getCarById(@PathVariable int id) {
        return garageService.findById(id);
    }

    @PreAuthorize("hasAuthority('garage:write')")
    @PostMapping("/garage")
    public Integer getCarById(@RequestBody GarageDto garage) {
        return garageService.save(garage);
    }
}
