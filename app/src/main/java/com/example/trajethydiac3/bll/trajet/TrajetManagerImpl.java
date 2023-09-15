package com.example.trajethydiac3.bll.trajet;

import android.os.Build;

import com.example.trajethydiac3.bo.TrajetDistant;
import com.example.trajethydiac3.dal.util.DAOFact;
import com.example.trajethydiac3.dal.trajetDAO.TrajetDAO;


import java.util.List;
import java.util.stream.Collectors;

public class TrajetManagerImpl implements TrajetManager{

    private TrajetDAO dao = DAOFact.getTrajetDAO();
    @Override
    public void addTrajet(TrajetDistant trajet) throws TrajetManagerException {
        if(trajet.getDistance() == 0.0){
            throw new TrajetManagerException("La distance enregistré pour ce trajet est null");
        }
        dao.insert(trajet);
    }

    @Override
    public List<TrajetDistant> getAllTrajet() {
        List<TrajetDistant> lst = dao.getAll();
        return lst;
    }

    @Override
    public TrajetDistant findByType(String type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return (TrajetDistant) dao.getAll().stream()
                    .filter(t->type.equals(t.getType()))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
