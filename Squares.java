import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Squares  
{
    private Square[] squares;
    private JPanel panel;
    //private Square currentSquare;
    //private Square nextSquare;
    //private int currentNext;

    public Squares()
    {
        //currentSquare = new Square();
        //nextSquare = new Square();
        //currentNext = 0;
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,5));

        squares = new Square[25];
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i+j]=new Square(i,j,0);
                panel.add(squares[i+j].getButton());
                //squares[i+j].getButton().addActionListener(this);
            }
        }
       
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public Square getSquare(int i)
    {
        return squares[i];
    }

    public boolean validNext(int pCurrentSquare, int pNextSquare)
    {
        int xDiff = Math.abs(squares[pCurrentSquare].getX() - squares[pNextSquare].getX());
        int yDiff = Math.abs(squares[pCurrentSquare].getY() - squares[pNextSquare].getY());
        int middleSquare = Math.abs(pCurrentSquare - pNextSquare)/2 + pCurrentSquare; 
        
        if (squares[pNextSquare].getState() == 1){
            if (squares[middleSquare].getState() == 2 || squares[middleSquare].getState() == 3){
                if (xDiff == 0 && yDiff == 4){
                    return true;
                } else if (xDiff == 4 && yDiff == 0){
                    return true;
                } else if ( xDiff == 2 && yDiff == 2){
                    return true;
                } 
            }
        } 
        return false;
    }


    public void changeLevel(String level)
    {
        
    }







}