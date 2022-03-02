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


       for(int i=0;i<_matrixLength;i++)
       {
           temp.add(i);
          _calculate(i,temp);
           temp.clear();
       }
       if(_longestList != null)
        System.out.println("FINAL: " + _longestList);
       else
           System.out.println("N-am gasit nimic");

    }

    private void _calculate(int pos, List<Integer> visited)
    {
       List<Integer> tempList = new ArrayList<Integer>();
        if(_m[pos][visited.get(0)] == true && visited.size() > 2) {
            visited.add(visited.get(0));
        if(_longestList == null)
            _longestList = new ArrayList<Integer>(visited);
        else
        {
            if(_longestList.size() < visited.size() && visited.size() > 2)
            {
                _longestList.clear();
                _longestList = new ArrayList<Integer>(visited);
            }
        }

            visited.remove(visited.size()-1);
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
    }


    }

    @Override
    public String toString() {
        return "CycleCalculator{" +
                "_longestList=" + _longestList +
                '}';
    }
}
