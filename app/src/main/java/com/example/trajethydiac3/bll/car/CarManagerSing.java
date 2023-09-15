package com.example.trajethydiac3.bll.car;

public class CarManagerSing {
    private static  CarManager instance;

    public static CarManager getInstance(){
        if(instance == null){
            instance = new CarManagerImpl();
            }
            return instance;

    }
}
