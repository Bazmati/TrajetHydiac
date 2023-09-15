package com.example.trajethydiac3.dal.carDAO;

import android.os.Build;

import com.example.trajethydiac3.bo.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDAOMock implements CarDAO{

    private List<Car> lstCars = new ArrayList<>();

    private static Integer cptCar = 0;


    @Override
    public void insert(Car car) {
        car.setIdCar(cptCar++);
        lstCars.add(car);
    }

    @Override
    public List<Car> getAll() {
        return lstCars;
    }

    @Override
    public Car findById(Integer id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lstCars.stream()
                    .filter(c->c.getIdCar()==id)
                    .findFirst().orElse(null);
        }else{
        return null;}
    }
}
