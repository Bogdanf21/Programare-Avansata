
import BackEnd.BoardLogic;
import MainFrame.MainFrame;


public class Main {
    public static void main(String[] args)
    {
        BoardLogic boardLogic = new BoardLogic(10,10);
        new MainFrame(boardLogic).setVisible(true);


    }

}
