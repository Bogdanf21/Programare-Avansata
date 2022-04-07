package MainFrame;




import BackEnd.BoardLogic;
import BackEnd.Stick;

import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    BoardLogic boardLogic;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame(BoardLogic boardLogic) {
        super("My Drawing Application");
        this.boardLogic = boardLogic;
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //create the components
        this.configPanel = new ConfigPanel(this);
        this.controlPanel = new ControlPanel(this);
        this.canvas = new DrawingPanel(this);

        // canvas = new DrawingPanel(this);


        //arrange the components in the container (frame)
        this.add(configPanel, BorderLayout.NORTH);
        this.add(controlPanel, BorderLayout.SOUTH);
        this.add(canvas, BorderLayout.CENTER);


        this.setSize(400, 500);

        //...TODO

        //invoke the layout manager
        this.setTitle("LAB6");
        pack();
    }

    public void updateCanvasSize() {

        this.remove(canvas);
        System.out.println("CREATEBUTTONONCLICK");
        this.canvas = new DrawingPanel(this);
        this.add(canvas, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    public BoardLogic getBoardLogic()
    {
        return boardLogic;
    }

}
