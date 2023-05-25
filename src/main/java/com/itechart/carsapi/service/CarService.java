package com.itechart.carsapi.service;

import com.itechart.carsapi.model.Car;

import java.util.List;

public interface CarService {
    List<Car> getAllCars();

    Car getCarById(int id);
}
