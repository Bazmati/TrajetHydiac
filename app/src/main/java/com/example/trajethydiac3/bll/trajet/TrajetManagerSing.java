package com.example.trajethydiac3.bll.trajet;

public class TrajetManagerSing {
    private static TrajetManager instance;
    public static TrajetManager getInstance(){
        if(instance == null){
            instance = new TrajetManagerImpl();

        }
        return instance;
    }
}
