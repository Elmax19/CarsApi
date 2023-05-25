package com.itechart.carsapi.controller.rest;

import com.itechart.carsapi.model.Car;
import com.itechart.carsapi.model.Garage;
import com.itechart.carsapi.model.User;
import com.itechart.carsapi.repository.CarRepository;
import com.itechart.carsapi.repository.GarageRepository;
import com.itechart.carsapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;

import static com.itechart.carsapi.model.UserRole.ROLE_USER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CarControllerIntegrationTest {
    private static final String RESOURCE_URL = "http://localhost:8082/carsAPI/";
    private static User testUser =
            new User(0,
                    "testUser",
                    "testUser.mail@mail.com",
                    "$2a$10$r8l4RRte2sfM30i9L/2mtOpIUl.c/qIhQN7/PYCJwGVclychVOB2u",
                    28,
                    ROLE_USER);
    private static Garage garage =
            new Garage(
                    0,
                    "test garage",
                    5,
                    new ArrayList<>());
    private static Car testCar =
            new Car(0,
                    "BMW 3 Series Sedan 320",
                    "112231",
                    5,
                    2650,
                    "White",
                    new BigDecimal("8900.00"),
                    garage);
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private GarageRepository garageRepository;

    void getCarById() {
        populateDatabase();
        Car carToFind = carRepository.findByModel(testCar.getModel()).get();

        TestRestTemplate testRestTemplate = new TestRestTemplate().withBasicAuth(
                testUser.getLogin(), "1111");
        ResponseEntity<Car> response = testRestTemplate.
                getForEntity(RESOURCE_URL + "car/" + carToFind.getId(), Car.class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), carToFind);

        cleanUpTestData();
    }

    public void populateDatabase() {
        garage = garageRepository.save(garage);
        testUser = userRepository.save(testUser);
        testCar = carRepository.save(testCar);
    }

    @Transactional
    public void cleanUpTestData() {
        userRepository.delete(testUser);
        carRepository.delete(testCar);
        garageRepository.delete(garage);
    }
}