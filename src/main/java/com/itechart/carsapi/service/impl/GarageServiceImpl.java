package com.itechart.carsapi.service.impl;

import com.itechart.carsapi.mapper.GarageMapper;
import com.itechart.carsapi.model.Garage;
import com.itechart.carsapi.model.dto.GarageDto;
import com.itechart.carsapi.repository.CarRepository;
import com.itechart.carsapi.repository.GarageRepository;
import com.itechart.carsapi.service.GarageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GarageServiceImpl implements GarageService {
    private final GarageRepository garageRepository;
    private final CarRepository carRepository;
    private final GarageMapper garageMapper;

    @Override
    public Garage findById(int id) {
        return garageRepository.findById(id).orElse(null);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int save(GarageDto garageDto) {
        Garage garage = garageMapper.mapToEntity(garageDto);
        Garage savedGarage = garageRepository.save(garage);
        setGarageForCars(garageDto.getCarIdList(), savedGarage);
        return savedGarage.getId();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void setGarageForCars(List<Integer> carIdList, Garage garage) {
        carRepository.updateGarageIdForCars(carIdList, garage.getId());
    }
}
