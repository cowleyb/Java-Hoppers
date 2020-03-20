import javax.swing.*;
import java.awt.*;

//did because i thought this would make code cleaner
public class Squares  
{
    //squares is a two dimensional array, each index marks the sqaures position on x and y
    private Square[][] squares;
    private JPanel panel;

    public Squares()
    {
        //Contructor
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,5));

        squares = new Square[5][5];
   
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j]=new Square('0');
                panel.add(squares[i][j].getButton());
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
        //Works out middle sqaure using mid point formula
        return new int[]{(pCurrentSquare[0] + pNextSquare[0])/2 , (pCurrentSquare[1] + pNextSquare[1])/2 };
    }

    public boolean validMove(int pCurrentSquare[], int pNextSquare[])
    {
        //Returns true if the jump is valid horizontal, vertical or diagnol
        int xDiff = Math.abs(pCurrentSquare[0] -pNextSquare[0]);
        int yDiff = Math.abs(pCurrentSquare[1] -pNextSquare[1]);
        
        if (xDiff == 0 && yDiff == 4){
            return true;
        } else if (xDiff == 4 && yDiff == 0){
            return true;
        } else if ( xDiff == 2 && yDiff == 2){
            return true;
        } 
        return false;
    }

    public void changeLevel(String level)
    {
        //Loops through all squares changing their state and updating their image
        int k = 0;
        for (int i=0; i<5; i++) {
            for (int j=0; j< 5;j++){
                squares[i][j].setState(level.charAt(k));
                squares[i][j].setSelected(false);
                squares[i][j].update();
                k++;
            }
        }
    }







}