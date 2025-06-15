package com.example.tabledemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)   
private int id;
private String name;
private String place;
//getters
public int getId(){
    return id;
}
public String getName(){
    return name;
}
public String getPlace(){
    return place;
}

public void setName(String name) {
    this.name = name;
}
public void setId(int id) {
    this.id = id;
}
public void setPlace(String place) {
    this.place = place;
}
}
