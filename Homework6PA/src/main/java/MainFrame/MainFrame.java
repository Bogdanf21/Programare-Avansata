package MainFrame;




import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

public class MainFrame extends JFrame {
  //  ConfigPanel configPanel;
  //  ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
      // canvas = new DrawingPanel(this);
        JButton b = new JButton("Hello World");
        b.setBounds(130,200,100,40);


 //...TODO

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        add(b, CENTER); //this is BorderLayout.CENTER
        this.setSize(400,500);

 //...TODO

        //invoke the layout manager
        pack();
    }


}
