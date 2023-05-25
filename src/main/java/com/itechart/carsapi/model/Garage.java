package com.itechart.carsapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "garage")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "capacity", nullable = false)
    private int capacity;
    @OneToMany(mappedBy = "garage")
    private List<Car> cars;
}
