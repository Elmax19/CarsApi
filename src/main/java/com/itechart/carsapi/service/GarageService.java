package com.itechart.carsapi.service;

import com.itechart.carsapi.model.Garage;
import com.itechart.carsapi.model.dto.GarageDto;

public interface GarageService {
    Garage findById(int id);

    int save(GarageDto garage);
}
