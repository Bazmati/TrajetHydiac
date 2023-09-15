package com.example.trajethydiac3.bll.car;

import com.example.trajethydiac3.bo.Car;
import com.example.trajethydiac3.dal.carDAO.CarDAO;
import com.example.trajethydiac3.dal.util.DAOFact;



import java.util.List;

public class CarManagerImpl implements CarManager{

    private CarDAO dao = DAOFact.getCarDAO();

    @Override
    public void addCar(Car car) throws CarManagerException {
        dao.insert(car);
    }

    @Override
    public List<Car> getAllCar() {
        List<Car> lst = dao.getAll();

        return lst;
    }

    @Override
    public Car findById(Integer id) {
        return dao.findById(id);
    }
}
