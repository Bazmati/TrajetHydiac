package com.example.trajethydiac3.dal.carDAO;

import com.example.trajethydiac3.bo.Car;

import java.util.List;

public interface CarDAO {
    public void insert(Car car);
    public List<Car> getAll();
    public Car findById(Integer id);
}
