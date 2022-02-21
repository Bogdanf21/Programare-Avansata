package com.company;

public class Pacient extends Person {
    private String boala;
    public Pacient(String nume,String boala)
    {
        this.nume = nume;
        this.boala = boala;
    }
    public String getBoala(){return boala;}
    public String getNume(){return nume;}
    @Override
    public String toString() {
        return "Pacientul " + this.nume + ", boala: " + this.boala ;
    }
}
