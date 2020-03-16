import javax.swing.*;
import java.awt.*;

public class Square 
{
    private int state;
    private int x;
    private int y;
   // private JPanel panel;
    private JButton button;

    public Square(int px,int py,int pstate)
    {
        state = pstate;
        x = px;
        y = py;
       // panel = new JPanel();
        button = new JButton();
 this.update("Water.png");
      //  panel.add(button);
       
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
    
    public void update(String icon)
    {
        ImageIcon i = new ImageIcon(icon);
        button.setIcon(i);
    }

    public JButton getButton()
    {
        return button;
    }







}