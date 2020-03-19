import javax.swing.*;


import java.awt.*;
import java.awt.event.*;

public class Square
{
    private char state;
    private int x;
    private int y;
   // private JPanel panel;
    private JButton button;

    public Square()
    {
        state = '0';
        x = -1;
        y = -1;
        button = new JButton();
    }

    public Square(int px,int py,char pstate)
    {
        state = pstate;
        x = px;
        y = py;
       
        button = new JButton();
        update();
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getState()
    {
        return state;
    }

    public void setState(int pstate)
    {
        state = pstate;
    }
    
    public void update()
    {
        
        if (state == '1'){
            ImageIcon i = new ImageIcon("LilyPad.png");
            button.setIcon(i);
        }else if (state == '2'){
            ImageIcon i = new ImageIcon("GreenFrog.png");
            button.setIcon(i);
        }
        else if (state == '3'){
            ImageIcon i = new ImageIcon("RedFrog.png");
            button.setIcon(i);
        }
        else if (state == '4'){
            ImageIcon i = new ImageIcon("GreenFrog2.png");
            button.setIcon(i);
        }
        else if (state == '5'){
            ImageIcon i = new ImageIcon("RedFrog2.png");
            button.setIcon(i);
        } else {
            ImageIcon i = new ImageIcon("Water.png");
            button.setIcon(i);
        }
    }

    public JButton getButton()
    {
        return button;
    }

    public void moveTo(Square pSquare)
    {   
        //this.state = 1;
        pSquare.setState(state);
        state = '1';
        update();
        pSquare.update();
    }

    public boolean validStarter()
    {
        if (state == '2' || state == '3'){
            return true;
        } else {
            return false;
        }
    }
}