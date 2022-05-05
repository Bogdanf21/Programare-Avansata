package BackEnd;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BoardLogic {
    int rows;
    int columns;
    Node[][] board;
    List<Stick> sticks = new ArrayList<>();

    public BoardLogic(int rows, int columns)
    {
        board = new Node[rows][columns];
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
                board[i][j] = new Node();
        this.rows = rows;
        this.columns = columns;
        initSticks();
    }

    public List<Stick> getSticks() {
        return sticks;
    }

    private void initSticks()
    {
        for(int i=0;i<rows;i++)
            for(int j=0;j<columns;j++)
            {
                //i+1 OR i-1 OR j+1 OR j-1
               if(i>1) //i-1
                   addConnection(i,j,i-1,j);
               if(i+1<rows)
                   addConnection(i,j,i+1,j);
               if(j>1)
                   addConnection(i,j-1,i,j);
               if(j+1<columns)
                   addConnection(i,j+1,i,j);
            }

    }

    public void addConnection(int x1, int y1, int x2, int y2)
    {
        sticks.add(new Stick(x1,y1,x2,y2));
        board[x1][y1].addConnectionTo(board[x2][y2]);
        board[x2][y2].addConnectionTo(board[x1][y1]);
    }
}

