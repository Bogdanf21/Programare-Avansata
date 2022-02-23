package com.Bogdan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) {
        compulsory();
      HomeworkPlusBonus(args);

    }

    public static void HomeworkPlusBonus(String[] args)
    {
        System.out.println("Running...");
        boolean debug = false;
        long start = System.currentTimeMillis();
        int counter = 2, noOfArguments = args.length;

        //1
        int n,p;
        ArrayList<Character> letters = new ArrayList<>();

        try {
            n = parseInt(args[0]);
            p = parseInt(args[1]);
            if(n < 0 || p < 0)
                throw new Exception();
        } catch (Exception e) {
            throw new IllegalArgumentException("Expected positive int as first 2 parameters");
        }
        if(debug) System.out.printf("Numbers (n,p) = (%d,%d);\n", n, p);


        while (counter < noOfArguments) {
            char temp = args[counter].charAt(0);
            counter++;
            if (Character.isLetter(temp)) {
                if(!letters.contains(temp))
                    letters.add(temp);
            } else throw new IllegalArgumentException("Expected letters or 0 (as end of reading)");
        }

        ////////////////////////////////////////////////// 2 //////////////////////

        String[] words = new String[n];
        if(debug)  System.out.println("Random Words: ");
        for(int i=0;i<n;i++)
        {
            StringBuilder word = new StringBuilder(p);
            for(int j=0;j<p;j++)
            {
                int randomIndex = ThreadLocalRandom.current().nextInt(0,letters.size());
                char randomCharFromLetters = letters.get(randomIndex);
                word.append(randomCharFromLetters);
            }
            words[i]=word.toString();
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
            if(n==0 && sum>10)
            {
                n=sum;
                sum=0;
            }
        }
        //6
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }

}
