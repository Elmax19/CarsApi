package com.itechart.carsapi.controller;

import com.itechart.carsapi.exception.CarNotFoundException;
import com.itechart.carsapi.model.Car;
import com.itechart.carsapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/carsAPI")
public class CarController {
    private final CarService carService;

    @PreAuthorize("hasAuthority('cars:read')")
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @PreAuthorize("hasAuthority('cars:read')")
    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable int id) {
        return carService.getCarById(id);
    }

    @ExceptionHandler(CarNotFoundException.class)
    public ResponseEntity handleException(CarNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(e.getLocalizedMessage());
    }
}
