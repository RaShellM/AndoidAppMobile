package com.example.appandroidrachou.Model;

public class User {


    private String mIdentifiant;

    public String getIdentifiant() {
        return mIdentifiant;
    }

    public void setIdentifiant(String identifiant) {
        mIdentifiant = identifiant;
    }
    public User(String identifiant) {
        mIdentifiant = identifiant;
    }

    @Override
    public String toString() {
        return "User{" +
                "mIdentifiant='" + mIdentifiant + '\'' +
                '}';
    }
}
