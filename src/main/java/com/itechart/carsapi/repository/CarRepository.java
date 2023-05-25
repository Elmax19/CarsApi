package com.itechart.carsapi.repository;

import com.itechart.carsapi.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Integer> {
    Optional<Car> findByModel(String model);

    @Modifying
    @Query(value = "UPDATE car SET garage_id = ?2 WHERE id IN (?1)", nativeQuery = true)
    void updateGarageIdForCars(List<Integer> carIdList, int garageId);
}
