import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board implements ActionListener
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel levelPanel;
    private Options options;
    private Squares squares;
    private int currentSquare[];
    private int nextSquare[];

    public Board()
    { 
        currentSquare = new int[]{0,0};
        nextSquare = new int[]{0,0};
        frame = new JFrame();
        frame.setTitle("Hoppers");
        frame.setSize(900,900);

        squares = new Squares();
        gamePanel = new JPanel();
        gamePanel = squares.getPanel();

        options = new Options();
        levelPanel = new JPanel();
        levelPanel = options.getPanel();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add("Center",gamePanel);
        mainPanel.add("South",levelPanel);

        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
            squares.getSquare(new int[]{i,j}).getButton().addActionListener(this);
            }
        }
        options.getNextLevelButton().addActionListener(this);
        options.getPreviousLevelButton().addActionListener(this);
        options.getResetButton().addActionListener(this);
        options.getOpenButton().addActionListener(this);
        options.openFile("Levels.txt");
    }

    private void reset()
    {
        squares.changeLevel(options.getCurrentLevel());
    }

    private void nextLevel()
    {
        options.setLevel(options.getLevel() + 1);
        squares.changeLevel(options.getCurrentLevel());
        options.updateLevelButton();
    }

    private void previousLevel()
    {
        options.setLevel(options.getLevel() - 1);
        squares.changeLevel(options.getCurrentLevel());
        options.updateLevelButton();
    }

    private void openLevel(String pLevel)
    {
        options.setLevel(Integer.parseInt(pLevel));
        squares.changeLevel(options.getCurrentLevel());
        options.updateLevelButton();
    } 
    private void selectCurrent(int i,int j)
    {
        if (squares.getSquare(new int[]{i,j}).validStarter()){
            currentSquare[0] = i;
            currentSquare[1] = j;
            squares.getSquare(currentSquare).setSelected(true);
        }
    }

    private void selectNext(int i,int j)
    {
        if (squares.getSquare(new int[]{i,j}).validStarter()){
            nextSquare[0] = i;
            nextSquare[1] = j;
            squares.getSquare(nextSquare).setSelected(true);
        }
    }

    private void move()
    {
        int[] midSquare = squares.getMidSquare(currentSquare, nextSquare);
        squares.getSquare(currentSquare).moveTo( squares.getSquare(nextSquare),  squares.getSquare(midSquare));
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == options.getResetButton()){
            reset();
        } else if (e.getSource() == options.getNextLevelButton()) {
            nextLevel();
        } else if (e.getSource() == options.getPreviousLevelButton()) {
            previousLevel();
        }else if (e.getSource() == options.getOpenButton()) {
            openLevel(options.getOpenButton().getText());
        } else {
            for (int i=0; i<5; i++) {
                for (int j=0; j< 5;j++){
                    if (e.getSource() == squares.getSquare(new int[]{i,j}).getButton())
                        if (squares.getSquare(currentSquare).isSelected()){
                            selectNext(i,j);
                            move();
                        } else { 
                            selectCurrent(i,j);
                        } 
                        
                    }
            } 
        }
    }


}


