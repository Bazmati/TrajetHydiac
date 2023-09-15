package com.example.trajethydiac3.dal.util;

import com.example.trajethydiac3.dal.carDAO.CarDAO;
import com.example.trajethydiac3.dal.carDAO.CarDAOMock;
import com.example.trajethydiac3.dal.trajetDAO.TrajetDAO;
import com.example.trajethydiac3.dal.trajetDAO.TrajetDAOMock;


public class DAOFact {
    public static CarDAO getCarDAO(){
        return new CarDAOMock();
    }
    public static TrajetDAO getTrajetDAO() {
        return new TrajetDAOMock();
    }

}
