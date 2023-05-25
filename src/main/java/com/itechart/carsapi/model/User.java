package com.itechart.carsapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name="login", nullable = false, unique = true)
    private String login;
    @Column(name="mail", unique = true)
    private String mail;
    @Column(name="password", nullable = false)
    private String password;
    @Column(name="age")
    private int age;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private UserRole role;
}
