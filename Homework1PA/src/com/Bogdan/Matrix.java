package com.Bogdan;


import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private final boolean[][] _m;
    private final int _size;
    private final ArrayList<String>[] _neighbours;
    private final String[] _words;

    public Matrix(String[] strings)
    {
        _words = strings;
        _size = strings.length;
      _neighbours = (ArrayList<String>[])new ArrayList[_size]; // lista (fixa care e egal cu nr de cuvinte) de arrayList (dinamica) unde vor fi vecinii
        _m = new boolean[_size][_size]; // matricea NxN
        for(int i=0;i<_size;i++)
        {   _neighbours[i] = new ArrayList<String>(); // initializez lista de vecini
            if(i%1000 == 0)
            System.out.printf("i=%d\n",i); // doar un check sa vad la ce pas a ajuns (din 30k)
            for(int j=0; j<_size;j++)
            {
                if(i!=j)
                _m[i][j] = areNeighbours(strings[i], strings[j]); // 0-daca nu sunt vecini 1-daca sunt
                else
                    _m[i][j] = false;
                if(_m[i][j] && i != j) // i != j sa nu il pun pe string-ul x ca fiind vecinul lui x
                    _neighbours[i].add(strings[j]);
            }
        }


    }

    private static boolean areNeighbours(String a, String b)
    {

        for(int i=0;i<a.length();i++)
            for(int j=0;j<b.length();j++)
                if(a.charAt(i) == b.charAt(j))
                    return true;
        return false;
    }
    public String toString()
    {
        StringBuilder temp = new StringBuilder();
        for(int i=0;i<_size;i++)
        {
            for(int j=0; j<_size;j++)
                temp.append(_m[i][j] + " ");
            temp.append("\n");
        }

        return temp.toString();
    }

    public String printNeighbourLists()
    {
        StringBuilder temp = new StringBuilder( "Neighbours of LHS are RHS\n");
        for(int i=0;i<_size;i++)
        {
            temp.append(_words[i] + ":");
            temp.append(_neighbours[i]);
            temp.append("\n");
        }
        return temp.toString();
    }

   public boolean[][] getMatrix()
   {
       return _m;
   }

}
