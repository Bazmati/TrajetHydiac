package com.example.trajethydiac3.bo;




public class Car {

    private Integer idCar;

    private String name;

    private String registration;

    private Integer mile;

    public Car(String name, String registration, Integer mile) {
        this.name = name;
        this.registration = registration;
        this.mile = mile;
    }

    public Car() {
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Integer getMile() {
        return mile;
    }

    public void setMile(Integer mile) {
        this.mile = mile;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", name='" + name + '\'' +
                ", registration='" + registration + '\'' +
                ", mile=" + mile +
                '}';
    }
}
