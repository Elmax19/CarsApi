package com.itechart.carsapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "car")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="model", nullable = false)
    private String model;
    @Column(name="number", nullable = false)
    private String number;
    @Column(name= "age_of_issue", nullable = false)
    private int ageOfIssue;
    @Column(name="mileage", nullable = false)
    private long mileage;
    @Column(name="color", nullable = false)
    private String color;
    @Column(name="price", nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "garage_id")
    @JsonIgnore
    private Garage garage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && ageOfIssue == car.ageOfIssue && mileage == car.mileage && Objects.equals(model, car.model) && Objects.equals(number, car.number) && Objects.equals(color, car.color) && Objects.equals(price, car.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, number, ageOfIssue, mileage, color, price);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                ", ageOfIssue=" + ageOfIssue +
                ", mileage=" + mileage +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
