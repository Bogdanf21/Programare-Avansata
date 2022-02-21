package com.Bogdan;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        compulsory();
        homework();
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

    public static void homework()
    {
        //1
        int n,p;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> letters = new ArrayList<>();

           try {
               n = scanner.nextInt();
               p = scanner.nextInt();
               if(n < 0 || p < 0)
                   throw new Exception();
           } catch (Exception e) {
               throw new IllegalArgumentException("Expected positive int as first 2 parameters");
           }
           System.out.printf("Numbers (n,p) = (%d,%d);\n", n, p);


           while (scanner.hasNext()) {
               char temp = scanner.next().charAt(0);
               if (temp == '0') {
                //   System.out.println("0 encountered \n");
                   break;
               } else if (Character.isLetter(temp)) {
                   letters.add(temp);
               } else throw new IllegalArgumentException("Expected letters or 0 (as end of reading)");
           }

           ////////////////////////////////////////////////// 2 //////////////////////

        String[] words = new String[n];
        System.out.println("Random Words: ");
       for(int i=0;i<n;i++)
       {
            StringBuilder word = new StringBuilder(p);
            for(int j=0;j<p;j++)
            {
                int randomIndex = ThreadLocalRandom.current().nextInt(0,letters.size());
                char randomCharFromLetters = letters.get(randomIndex);
                word.append(randomCharFromLetters);
                //System.out.printf("Random letter: %s ",randomCharFromLetters);
            }
            words[i]=word.toString();
           System.out.printf("   %s", word);


       }
       //////////////////////////////////////////////////////////////////////

        System.out.println(words[1].charAt(3));

    }
}


