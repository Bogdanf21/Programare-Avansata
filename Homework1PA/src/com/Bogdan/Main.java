package com.Bogdan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
      //  compulsory();
        if(args.length>=3)
      homeworkPlusBonus(args);
        else
            throw new RuntimeException("No program arguments");

    }

    public static void homeworkPlusBonus(String[] args)
    {
        System.out.println("Running...");
        boolean debug = true; // am scos print-urile cu asta
        long start = System.currentTimeMillis(); // timp pentru ultimul punct
        int counter = 2, noOfArguments = args.length;

        //1
        int n,p;
        ArrayList<Character> letters = new ArrayList<>();

        try { // puteam sa las direct throw-ul default de la parseInt, am facut asa sa se vada ca e "tratat" cazul asta
            n = parseInt(args[0]);
            p = parseInt(args[1]);
            if(n < 0 || p < 0)
                throw new Exception(); // Nu conteaza ce scrie in exceptia asta, e catched de cea de la linia 39
        } catch (Exception e) {
            throw new IllegalArgumentException("Expected positive int as first 2 parameters or run arguments not found");
        }
        if(debug) System.out.printf("Numbers (n,p) = (%d,%d);\n", n, p);


        while (counter < noOfArguments) {
            //Am mers pe premisa ca trebuie cate un spatiu intre fiecare litera, din acest motiv abordarea asta. Daca e scris un cuvant, va fi luata in considerare doar prima litera
            char temp = args[counter].charAt(0);
            counter++;
            if (Character.isLetter(temp)) {
                if(!letters.contains(temp)) // duplicatele nu influenteaza probabilitatea de a fi aleasa o litera
                    letters.add(temp);
            } else throw new IllegalArgumentException("Expected letters after 2 ints");
        }

        ////////////////////////////////////////////////// 2 //////////////////////

        String[] words = new String[n];
        if(debug)  System.out.println("Random Words: ");
        for(int i=0;i<n;i++)
        {
            StringBuilder word = new StringBuilder(p);
            for(int j=0;j<p;j++)
            {// Asta e ce am gasit pe internet legat de random strings, am vazut ca implementarea din suportul de laborator e mai simpla dar am lasat asa.
                int randomIndex = ThreadLocalRandom.current().nextInt(0,letters.size()); // index random dintre (origin,end-1)
                char randomCharFromLetters = letters.get(randomIndex);
                word.append(randomCharFromLetters); // litera adaugata la cuvant
            }
            words[i]=word.toString(); // word copiat
            if(debug) System.out.printf("   %s", word);


        }
        /////////////////////////////////////////3/////////////////////////////
        if(debug)  System.out.println("\nMatrix: \n");
        Matrix matrice = new Matrix(words);
        if(debug) System.out.println(matrice);
        if(debug) System.out.println(matrice.printNeighbourLists());
        long end = System.currentTimeMillis();
        NumberFormat formatter = new DecimalFormat("#0.00000");
        System.out.print("\nExecution time is " + formatter.format((end - start) / 1000d) + " seconds\n");
        System.out.printf("%d Milliseconds.",end-start);
/////////////////////////////////////////////////////////////BONUS////////////////////////////////////////////////////

        CycleCalculator instance = new CycleCalculator(matrice.getMatrix());


    }
    public static void compulsory()
    {
        //1
        System.out.println("Hello World");
        //2
        String[] languages = {"C","C++","C#","Python","Go","Rust","JavaScript","PHP","Swift","Java"};
        //3
        int n=(int) (Math.random()*1_000_000);
        //4
        n*=3;
        int bin = 0b10101;
        n+=bin;
        int hex = 0XFF;
        n+=hex;
        n*=6;

        //5
        int sum=0;
        while(n!=0)
        {
            int digit = n%10;
            n/=10;
            sum+=digit;
            if(n==0 && sum>10) // daca am ajuns in punctul in care am scos toate cifrele si suma e mai mare ca 10, mai trec o data prin while cu suma cifrelor
            {
                n=sum;
                sum=0;
            }
        }
        //6
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }

}
