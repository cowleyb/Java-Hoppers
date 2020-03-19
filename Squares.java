import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Squares implements ActionListener
{
    private Square[][] squares;
    private JPanel panel;
    private Square currentSquare;
    private Square nextSquare;
    private int currentNext;

    public Squares()
    {
        currentSquare = new Square();
        nextSquare = new Square();
        currentNext = 0;
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
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                if (e.getSource() == squares[i][j].getButton())
                    if (currentNext == 0){
                        currentSquare = squares[i][j];
                        currentNext = 1;
                    }  else {
                        nextSquare = squares[i][j];
                        currentNext = 0;
                    }
            }
        } 

        if (currentNext == 0){
            currentSquare.moveTo(nextSquare);
        }
    }

    private boolean hasFrog()
    {
        if (currentSquare.getState() == 1 || currentSquare.getState() == 2)
        {
            return true;
        }  else return false;
    }



}