package com.example.trajethydiac3.bo;

import java.time.LocalDateTime;


public class Trajet {

    private int id;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    private double distance;

    private String type;

    public Trajet( LocalDateTime dateStart, LocalDateTime dateEnd, Double distance, String type) {

        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.distance = distance;
        this.type = type;
    }

    public Trajet() {
    }

    public Trajet(int id, LocalDateTime dateStart, LocalDateTime dateEnd, double distance, String type) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.distance = distance;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDateTime dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDateTime getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDateTime dateEnd) {
        this.dateEnd = dateEnd;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                '}';
    }
}
