import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Squares implements ActionListener
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
                squares[i][j].getButton().addActionListener(this);
            }
        }
       
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public void actionPerformed(ActionEvent e)
    {
        Square currentSquare = new Square();
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                if (e.getSource() == squares[i][j].getButton())
                    currentSquare = squares[i][j];
            }
        } 
        System.out.println(currentSquare.getX());
        System.out.println(currentSquare.getY());
        System.out.println("h65h5h5h6");
    }



}