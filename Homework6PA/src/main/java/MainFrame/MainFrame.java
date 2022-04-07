package MainFrame;




import javax.swing.*;

import java.awt.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
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
        this.add(canvas,BorderLayout.CENTER);





        this.setSize(400,500);

 //...TODO

        //invoke the layout manager
        this.setTitle("LAB6");
        pack();
    }


}
