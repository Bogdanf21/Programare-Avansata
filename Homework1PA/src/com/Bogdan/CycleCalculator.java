package com.Bogdan;

import java.util.ArrayList;
import java.util.List;

public class CycleCalculator {
    private final boolean[][] _m;
    private final int _matrixLength;
    private List<Integer> _longestList;
    CycleCalculator(boolean[][] matrix)
    {
        _m = matrix;
        _matrixLength = _m[0].length;
        List<Integer> temp = new ArrayList<Integer>();
        _longestList = new ArrayList<>();

       for(int i=0;i<_matrixLength;i++)
       {
           temp.add(i);
           List<Integer> temporaryList2 = _calculate(i,temp);
           System.out.println("CE AM PRIMIT IN MAIN: " + temporaryList2);
           if(temporaryList2 != null)
                    if(temporaryList2.size() > _longestList.size())
                        _longestList = temporaryList2;
           temp.clear();

       }

        System.out.println("FINAL: " + _longestList);
    }

    private List<Integer> _calculate(int pos, List<Integer> visited)
    {
       List<Integer> tempList = new ArrayList<Integer>();
        if(_m[pos][visited.get(0)] == true && visited.size() > 2) {
            if(visited.size() > tempList.size())
                tempList = visited;
        }
        for(int i=0;i<_matrixLength;i++)
        {

            if(_m[pos][i] == true && i!=pos && !visited.contains(i))
            {
                int currentLength = visited.size();
                visited.add(i);
                _calculate(i,visited);
                while(visited.size() != currentLength)
                    visited.remove(visited.size()-1);

            }
        }
    if(tempList.size() != 0)
    {
        System.out.println("Cel mai lung ciclu pentru subproblema " + pos + " este " + tempList);
    return tempList;
    }

    return null;


    }

    @Override
    public String toString() {
        return "CycleCalculator{" +
                "_longestList=" + _longestList +
                '}';
    }
}
