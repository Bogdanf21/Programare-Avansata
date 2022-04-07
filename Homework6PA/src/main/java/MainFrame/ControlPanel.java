package MainFrame;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Exit, etc.)

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons ...TODO
        this.add(loadBtn);
        this.add(saveBtn);
        this.add(exitBtn);


        //configure listeners for all buttons
        exitBtn.addActionListener(e -> exitGame());
        loadBtn.addActionListener(e->loadGame());
        saveBtn.addActionListener(e->saveGame());
        //...TODO
    }

    private void exitGame() {
        frame.dispose();
    }

    private void loadGame()
    {

    }
    private void saveGame()
    {

    }


}
