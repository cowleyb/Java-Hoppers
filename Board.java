import javax.swing.*;
import java.awt.*;

public class Board
{
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel levelPanel;
    private Options options;
    private Squares squares;
    //private Square[][] squares;

    public Board()
    {
        /*
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(5,5));

        squares = new Square[5][5];
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j]=new Square(i,j,0);
                gamePanel.add(squares[i][j].getButton());
            }
        }
     */


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
    }

}


