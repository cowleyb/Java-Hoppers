import javax.swing.*;

public class Square
{
    //State indicates which image is displayed on sqaure
    //0 = water, 1 = lily, 2 = green frog, 3 = red frog
    //Selected indicated whether the current sqaure is selected and will highlight it 
    private char state;
    private boolean selected;
    private JButton button;

    public Square()
    {
        //Constructor
        state = '0';
        selected = false;
        button = new JButton();
    }

    public Square(char pstate)
    {
         //Constructor
        state = pstate;
        //x = px;
        //y = py;
        button = new JButton();
        update();
    }

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
        //Updates image of button based on the state the sqaure is in.        
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
        //Change state of sqaures passed in as parameters.
        //Set state of sqaure jumping to as the same as this sqaure
        //Set state of this sqaure to 1
        //Update sqaures images
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
        //returns true if the square has a frog on it
        if (state == '2' || state == '3'){
            return true;
        } else {
            return false;
        }
    }

    public boolean validNext()
    {
        //returns true if the square is a lily
        if (state == '1'){
            return true;
        } else {
            return false;
        }
    }

    public boolean validMid()
    {
        //returns true if the sqaure has a green frog on it
        if (state == '2'){
            return true;
        } else {
            return false;
        }
    }
}