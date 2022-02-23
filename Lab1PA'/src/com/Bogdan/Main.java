package com.Bogdan;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        compulsory();
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

