import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Squares  
{
    private Square[][] squares;
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

        squares = new Square[5][5];
        /*
        int count = -1;
        for (int i=0; i<25; i++) {
            if (i % 5 == 0){
                count++;
            }
            squares[i] = new Square(count, i % 5, '0');
            panel.add(squares[i].getButton());
        }
        */
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j]=new Square('0');
                panel.add(squares[i][j].getButton());
                //squares[i+j].getButton().addActionListener(this);
            }
        }
        
       
    }

    public JPanel getPanel()
    {
        return panel;
    }

    public Square getSquare(int pSqaure[])
    {
        return squares[pSqaure[0]][pSqaure[1]];
    }

    public int[] getMidSquare(int pCurrentSquare[], int pNextSquare[])
    {
        //int midSquare[] = new int[]
        return new int[]{pCurrentSquare[0] + pNextSquare[0]/2 , pCurrentSquare[1] + pNextSquare[1] /2 };
    }
/*
    public boolean validNext(int pCurrentSquare[], int pNextSquare[], int pMiddleSquare[])
    {
        int xDiff = Math.abs(pCurrentSquare[0] -pNextSquare[0]);
        int yDiff = Math.abs(pCurrentSquare[1] -pNextSquare[1]);
        
        if (squares[pNextSquare[0]][pNextSquare[1]].getState() == '1'){
            if (squares[pMiddleSquare[0]][pMiddleSquare[1]].validStarter()){
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
*/

    public void changeLevel(String level)
    {
        int k = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j].setState(level.charAt(k));
                squares[i][j].update();
                k++;
            }
        }
        //System.out.println("hehasfuihsifh");
    }







}