package com.example.students.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String  name;

    @Column(nullable = false)
    private int age;

    @Email(message="Email should be valid")
    @Column(unique = true, nullable = false)
    private String email;

    public Students() {}
    public Students(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
