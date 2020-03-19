import javax.swing.*;


//import java.awt.*;
//import java.awt.event.*;

public class Square
{
    private char state;
    private boolean selected;
   // private JPanel panel;
    private JButton button;

    public Square()
    {
        state = '0';
        selected = false;
        button = new JButton();
    }

    public Square(char pstate)
    {
        state = pstate;
        //x = px;
        //y = py;
        button = new JButton();
        update();
    }
    /*

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }
*/
    public int getState()
    {
        return state;
    }

    public void setState(char pstate)
    {
        state = pstate;
        update();
    }

    public boolean isSelected()
    {
        return selected;
    }

    public void setSelected(boolean pSelected)
    {
        selected = pSelected;
    }
    
    public void update()
    {
        
        if (state == '1'){
            ImageIcon i = new ImageIcon("LilyPad.png");
            button.setIcon(i);
        }else if (state == '2'&& selected == false ){
            ImageIcon i = new ImageIcon("GreenFrog.png");
            button.setIcon(i);
        }
        else if (state == '3' && selected == false){
            ImageIcon i = new ImageIcon("RedFrog.png");
            button.setIcon(i);
        }
        else if (state == '2' && selected == true){
            ImageIcon i = new ImageIcon("GreenFrog2.png");
            button.setIcon(i);
        }
        else if (state == '3' && selected == true){
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

    public void moveTo(Square pSquare, Square pMiddleSquare)
    {   
        //this.state = 1;
        pSquare.setState(state);
        state = '1';
        selected = false;
        pMiddleSquare.setState('1');
        update();
        pSquare.update();
        pMiddleSquare.update();

    }

    public boolean validStarter()
    {
        if (state == '2' || state == '3'){
            return true;
        } else {
            return false;
        }
    }

    public boolean validNext()
    {
        if (state == '1'){
            return true;
        } else {
            return false;
        }
    }

    public boolean validMid()
    {
        if (state == '2'){
            return true;
        } else {
            return false;
        }
    }
}