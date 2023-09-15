package com.example.trajethydiac3.bll.car;

import com.example.trajethydiac3.bo.Car;

import java.util.List;

public interface CarManager {
    public void addCar(Car car) throws CarManagerException;

    public List<Car> getAllCar();

    public Car findById(Integer id);


}
