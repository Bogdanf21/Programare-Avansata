package MainFrame;

import BackEnd.BoardLogic;
import BackEnd.Stick;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import static sun.tools.jconsole.OutputViewer.init;


public class DrawingPanel extends JPanel {
    private final BasicStroke regular = new BasicStroke();
    private final BasicStroke bold = new BasicStroke(5);
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(frame.configPanel.getRows(), frame.configPanel.getCols());
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        g.setStroke(regular);
        paintGrid(g);
        g.setStroke(bold);
        paintSticks(g);
        g.setStroke(regular);
        //paintStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);

        }

        for(int column = 0;column < cols ;column++)
        {
            int x1 = padX + column * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);

        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    void paintSticks(Graphics2D g)
    {
        BoardLogic board = frame.getBoardLogic();
       var stickList =  board.getSticks();
        for (Stick stick : stickList) {
            g.drawLine(stick.getNode1X(),stick.getNode1Y(),stick.getNode2X(),stick.getNode2Y());
        }


    }
}

