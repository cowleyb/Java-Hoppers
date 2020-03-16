import javax.swing.*;
import java.awt.*;

public class Board
{
    private JFrame frame;
    private JPanel panel;
    private Square[][] squares;
    

    public Board()
    {
        frame = new JFrame();
        frame.setTitle("Hoppers");
        frame.setSize(500,500);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5,5));
        frame.add(panel);

        squares = new Square[5][5];
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j]=new Square(i,j,0);
            }
        }



        frame.setVisible(true);
    }

}


