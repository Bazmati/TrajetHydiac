package com.example.trajethydiac3.bll.trajet;

import com.example.trajethydiac3.bo.TrajetDistant;

import java.util.List;

public interface TrajetManager {
    public void addTrajet(TrajetDistant trajet) throws TrajetManagerException;
    public List<TrajetDistant> getAllTrajet();
    public TrajetDistant findByType(String type);
}
