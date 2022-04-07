package MainFrame;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner rowSpinner;
    JSpinner columnSpinner;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();

    }

    private void init() {
        //create the label and the spinner
        label = new JLabel("Grid size:");
        rowSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        columnSpinner = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));


        createButton = new JButton("Create");
        createButton.addActionListener(e -> createButtonOnClick());
        //create spinners for rows and cols, and the button
        add(label); //JPanel uses FlowLayout by default
        add(rowSpinner);
        add(columnSpinner);
        add(createButton);
    }

    private void createButtonOnClick()
    {

        frame.updateCanvasSize();
    }

    public int getRows()
    {
        return (int) rowSpinner.getValue();
    }
    public int getCols()
    {
    return (int) columnSpinner.getValue();
    }

}
