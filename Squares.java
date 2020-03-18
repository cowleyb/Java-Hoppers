import javax.swing.*;
import java.awt.*;

public class Squares
{
    private Square[][] squares;
    private JPanel panel;

    public Squares()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,5));

        squares = new Square[5][5];
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j]=new Square(i,j,0);
                panel.add(squares[i][j].getButton());
            }
        }
    }

    public JPanel getPanel()
    {
        return panel;
    }

}