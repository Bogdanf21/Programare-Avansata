package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Pacient pac1 = new Pacient("Popescu","boala1");
        Pacient pac2 = new Pacient("Ionescu","boala2");
        Pacient pac3 = new Pacient("Vasilescu","boala3");
        Pacient pac4 = new Pacient("Petrescu","boala3");



        Doctor doc1 = new Doctor("Popescu","ORL",null);
        Doctor doc2 = new Doctor("Georgescu", "Inima",new Pacient[]{pac1,pac4});

        doc1.addPacient(pac1);
        doc1.addPacient(pac2);
        doc1.addPacient(pac3);
        System.out.println(doc1);
        System.out.println(doc2);
    }

}

