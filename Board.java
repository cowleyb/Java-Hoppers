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
    private int currentNext;
    private int currentSquare;

    public Board()
    {
        frame = new JFrame();
        frame.setTitle("Hoppers");
        frame.setSize(700,700);

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


        for (int i = 0; i <25; i++){
            squares.getSquare(i).getButton().addActionListener(this);
        }
        options.getNextLevelButton().addActionListener(this);
        options.getPreviousLevelButton().addActionListener(this);
        options.getResetButton().addActionListener(this);
        options.getOpenButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == options.getResetButton()){
            
        } else if (e.getSource() == options.getNextLevelButton()) {
            
        } else if (e.getSource() == options.getPreviousLevelButton()) {
            
        }else if (e.getSource() == options.getOpenButton()) {
            
        } else {
                for (int i=0; i<25; i++) {
                        if (e.getSource() == squares.getSquare(i).getButton())
                            if (currentNext == 0){
                                if (squares.getSquare(i).validStarter() == true) {
                                    currentSquare = i;
                                    currentNext = 1;}
                            } else {
                                if (squares.validNext(currentSquare, i) == true) {
                                    squares.getSquare(currentSquare).moveTo(squares.getSquare(i));
                                    currentNext = 0;
                                }
                            }
                    
                }  
            }
        }
    }

}


