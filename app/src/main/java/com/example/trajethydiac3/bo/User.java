package com.example.trajethydiac3.bo;



public class User {


    private Integer userId;
    private String formerId;

    private String name;

    private String firstName;

    private String pseudo;

    private String phonePro;

    private String emailPro;

    private String status;

    public User(Integer userId, String formerId, String name, String firstName, String pseudo, String phonePro, String emailPro, String status) {
        this.userId = userId;
        this.formerId = formerId;
        this.name = name;
        this.firstName = firstName;
        this.pseudo = pseudo;
        this.phonePro = phonePro;
        this.emailPro = emailPro;
        this.status = status;
    }

    public User(String formerId, String name, String firstName, String pseudo, String phonePro, String emailPro, String status) {
        this.formerId = formerId;
        this.name = name;
        this.firstName = firstName;
        this.pseudo = pseudo;
        this.phonePro = phonePro;
        this.emailPro = emailPro;
        this.status = status;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFormerId() {
        return formerId;
    }

    public void setFormerId(String formerId) {
        this.formerId = formerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhonePro() {
        return phonePro;
    }

    public void setPhonePro(String phonePro) {
        this.phonePro = phonePro;
    }

    public String getEmailPro() {
        return emailPro;
    }

    public void setEmailPro(String emailPro) {
        this.emailPro = emailPro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", formerId='" + formerId + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", pseudo='" + pseudo + '\'' +
                ", phonePro='" + phonePro + '\'' +
                ", emailPro='" + emailPro + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
