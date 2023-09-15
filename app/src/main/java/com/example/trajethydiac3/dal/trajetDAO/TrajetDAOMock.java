package com.example.trajethydiac3.dal.trajetDAO;

import android.os.Build;

import com.example.trajethydiac3.bo.TrajetDistant;

import java.util.ArrayList;
import java.util.List;

public class TrajetDAOMock implements TrajetDAO {

    private List<TrajetDistant> lstTrajets = new ArrayList<>();
    private static Integer cptTrajet = 0;
    @Override
    public void insert(TrajetDistant trajet) {
        trajet.setId(cptTrajet);
        lstTrajets.add(trajet);
    }

    @Override
    public List<TrajetDistant> getAll() {
        return lstTrajets;
    }

    @Override
    public TrajetDistant findByType(String type) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return lstTrajets.stream()
                    .filter(t->t.getType()==type)
                    .findFirst().orElse(null);
        }
        return null;
    }


}
