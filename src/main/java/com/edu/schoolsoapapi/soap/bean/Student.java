package com.edu.schoolsoapapi.soap.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;

    @Override
    public String toString() {
        return String.format("Student [id=%s, name=%s, age=%s]", id, name, age);
    }
}
