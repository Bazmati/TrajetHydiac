package com.example.trajethydiac3.bo;

import java.time.LocalDateTime;


public class TrajetDistant {
    private int id;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;

    private double distance;

    private String type;

    private User user;

    private Car car;

    public TrajetDistant(LocalDateTime dateStart, LocalDateTime dateEnd, double distance, String type, User user, Car car) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.distance = distance;
        this.type = type;
        this.user = user;
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Trajet{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", distance=" + distance +
                ", type='" + type + '\'' +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}
