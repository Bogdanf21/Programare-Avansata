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
      _neighbours = (ArrayList<String>[])new ArrayList[_size];
        _m = new boolean[_size][_size];
        for(int i=0;i<_size;i++)
        {   _neighbours[i] = new ArrayList<String>(_size/2);
            if(i%1000 == 0)
            System.out.printf("i=%d\n",i);
            for(int j=0; j<_size;j++)
            {

                _m[i][j] = areNeighbours(strings[i], strings[j]);
                if(_m[i][j] && i != j)
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
        String temp = "";
        for(int i=0;i<_size;i++)
        {
            for(int j=0; j<_size;j++)
                temp = temp + _m[i][j] + " ";

            temp = temp + "\n";
        }
        return temp;
    }

    public String printNeighbourLists()
    {
        String temp = "Neighbours of LHS are RHS\n";
        for(int i=0;i<_size;i++)
        {
            temp = temp + _words[i] + ":";
            temp += _neighbours[i];
            temp += "\n";

        }
        return temp;
    }

    public void printLongestSequence()
    {

    }

}
