package com.itechart.carsapi.service.impl;

import com.itechart.carsapi.annotation.LogExecutionTime;
import com.itechart.carsapi.exception.CarNotFoundException;
import com.itechart.carsapi.model.Car;
import com.itechart.carsapi.repository.CarRepository;
import com.itechart.carsapi.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;


    @LogExecutionTime
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @LogExecutionTime
    @Override
    public Car getCarById(int id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() -> new CarNotFoundException("There is no Car with id: " + id));
    }
}
