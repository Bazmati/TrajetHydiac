package com.example.trajethydiac3.dal.trajetDAO;

import com.example.trajethydiac3.bo.TrajetDistant;

import java.util.List;

public interface TrajetDAO {
    public void insert(TrajetDistant trajet);
    public List<TrajetDistant> getAll();
    public TrajetDistant findByType(String type);
}
