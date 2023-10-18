package com.example.demo.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class StudentEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private Integer age;
    private String address;
    private String phone;

    public StudentEntity(Integer id, String name, Integer age, String address, String phone){
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    public StudentEntity(){

    }
    public StudentEntity(String name, Integer age, String address, String phone){
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
