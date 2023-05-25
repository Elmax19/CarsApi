package com.itechart.carsapi.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GarageDto {
    private String title;
    private int capacity;
    private List<Integer> carIdList;
}
