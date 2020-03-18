import javax.swing.*;
import java.awt.*;

public class Options
{
    private JPanel panel;
    private JButton reset;
    private JButton nextLevel;
    private JButton previousLevel;
    private JButton open;
    private JTextField level;


    public Options()
    {
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        reset = new JButton("Reset Level");
        nextLevel = new JButton("Next Level");
        previousLevel = new JButton("Previous Level");
        open = new JButton("Open Level");
        level = new JTextField();
        level.setColumns(5);

        panel.add(reset);
        panel.add(nextLevel);
        panel.add(previousLevel);
        panel.add(level);
        panel.add(open);
        
    }

    public JButton getResetButton()
    {
        return reset;
    }

    public JButton getNextLevelButton()
    {
        return nextLevel;
    }

    public JButton getPreviousLevelButton()
    {
        return previousLevel;
    }

    public JPanel getPanel()
    {
        return  panel;
    }


} 