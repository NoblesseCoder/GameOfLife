package com.company.gui;

import com.company.Config;
import com.company.gol.Cell;
import com.company.gol.Universe;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class BoardPanel extends JPanel implements ActionListener{

    private final int PANEL_HEIGHT_SIZE = 90;
    private final double CELL_WIDTH_SIZE;
    private final double CELL_HEIGHT_SIZE;
    private final int BOARD_MARGIN = 20;
    List<Cell> grid;
    public Timer timer;
    Move move;
    Click click;
    private boolean flag ;

    public BoardPanel(){
        Universe universe = Universe.getInstance();
        CELL_WIDTH_SIZE = (Config.GUI_WINDOW_FRAME_WIDTH - 2 * BOARD_MARGIN) /
                (double) Config.UNIVERSE_WIDTH;

        CELL_HEIGHT_SIZE = (Config.GUI_WINDOW_FRAME_HEIGHT - PANEL_HEIGHT_SIZE
                - (2 * BOARD_MARGIN)) / (double) Config.UNIVERSE_HEIGHT;
        grid = universe.getCells();

        setBorder(new LineBorder(Color.LIGHT_GRAY,3));
        setLayout(new FlowLayout(FlowLayout.TRAILING, FlowLayout.TRAILING,
                FlowLayout.TRAILING));
        setBackground(Color.DARK_GRAY);

        move = new Move(this);
        addMouseMotionListener(move);

        click = new Click(this);
        addMouseListener(click);

        int TIME = 100;
        timer = new Timer(TIME,this);
    }

    @Override
    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        drawBoard(graphics);
        display(graphics);
    }

    public void drawBoard(Graphics graphics){
        graphics.setColor(Color.BLACK);

        for (int i=0;i<=Config.UNIVERSE_HEIGHT;i++){
            Shape horizontalLine = new Line2D.Double(BOARD_MARGIN,
                    i * CELL_HEIGHT_SIZE + BOARD_MARGIN,
                    Config.GUI_WINDOW_FRAME_WIDTH - BOARD_MARGIN,
                    i * CELL_HEIGHT_SIZE + BOARD_MARGIN);

            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.draw(horizontalLine);
        }

        for (int j=0;j<=Config.UNIVERSE_WIDTH;j++){
            Shape verticalLine = new Line2D.Double( j * CELL_WIDTH_SIZE +
                    BOARD_MARGIN,BOARD_MARGIN,
                    j * CELL_WIDTH_SIZE + BOARD_MARGIN,
                    (Config.GUI_WINDOW_FRAME_HEIGHT - PANEL_HEIGHT_SIZE
                            - BOARD_MARGIN));
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.draw(verticalLine);
        }
    }

    public void unSeed(){
        Universe.getInstance().resetCells();
    }

    public void display(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D) graphics;

        for (int x=0;x<Config.UNIVERSE_HEIGHT;x++) {
            for (int y = 0; y < Config.UNIVERSE_WIDTH; y++) {
                graphics2D.setColor(Color.GREEN);
                int index = Config.UNIVERSE_WIDTH*x + y;
                Rectangle2D rect = new Rectangle2D.Double(
                        y * CELL_WIDTH_SIZE + BOARD_MARGIN,
                        x * CELL_HEIGHT_SIZE + BOARD_MARGIN,
                        CELL_WIDTH_SIZE, CELL_HEIGHT_SIZE);

                if(grid.get(index).isAlive()){
                    graphics2D.setColor(Color.GREEN);
                    graphics2D.fill(rect);
                }

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Universe.getInstance().tick();
        repaint();
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void seed(int mX, int mY){
        for (int x = 0; x < Config.UNIVERSE_HEIGHT; x++) {
            for (int y = 0; y < Config.UNIVERSE_WIDTH; y++) {
                int index = Config.UNIVERSE_WIDTH * x + y;
                if((mX >= y * CELL_WIDTH_SIZE + BOARD_MARGIN &&
                        mX <= (y+1) * CELL_WIDTH_SIZE + BOARD_MARGIN)
                        && (mY >= x * CELL_HEIGHT_SIZE + BOARD_MARGIN &&
                        mY <= (x+1) * CELL_HEIGHT_SIZE + BOARD_MARGIN)){
                            boolean isAlive = grid.get(index).isAlive();
                            grid.get(index).setAlive(!isAlive);
                }
            }
        }
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

