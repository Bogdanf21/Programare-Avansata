package com.company;
import java.util.ArrayList;
import java.util.Arrays;


public class Doctor extends Person {
   public String profesie;
  public  ArrayList<Pacient> pacienti;

    public Doctor(String name, String profesie, Pacient[] pacienti) {
        this.nume = name;
        this.profesie=profesie;
        if (pacienti != null) {
       this.pacienti = new ArrayList<Pacient>(Arrays.asList(pacienti));
        }
        else this.pacienti = new ArrayList<Pacient>();

    }
    public void printPacienti()
    {
        System.out.printf("Doctorul %s (%s) (",nume,profesie);
        for (Pacient pacient : pacienti) {
            System.out.printf("Pacientul %s : boala %s, ", pacient.getNume(), pacient.getBoala());
        }
        System.out.println(")\n");
    }
    public void addPacient(Pacient pacient)
    {
        pacienti.add(pacient);
    }

    @Override
    public String toString() {
        String temp;
        temp = "Doctorul" + this.nume + "(" + this.profesie + ")" + "(" ;
        for (Pacient pacient : pacienti) {
            temp+= pacient;
        }
        temp+= ")";
        return temp;
    }



}
