package com.example.MeowDate.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @NotNull
    private Long id;

    @NotNull
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Positive
    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "sex")
    private char sex;

    @NotNull
    @Column(name = "coordinates")
    private double[] coordinates;

    @NotNull
    @Column(name = "info")
    private String info;

    public UserProfile() {}

    public UserProfile(String firstName, int age, char sex, @NotNull double[] coordinates, String info) {
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
        this.coordinates = coordinates;
        this.info = info;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getInfo() {
        return info;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
