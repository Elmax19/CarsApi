package com.itechart.carsapi.mapper;

import com.itechart.carsapi.model.Garage;
import com.itechart.carsapi.model.dto.GarageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;

@Mapper
public interface GarageMapper {
    @Mapping(target = "cars", ignore = true)
    Garage mapToEntity(GarageDto garageDto);

    default void setCars(GarageDto garageDto, @MappingTarget Garage garage) {
        garage.setCars(new ArrayList<>());
    }
}
