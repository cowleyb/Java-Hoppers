import javax.swing.*;

//import sun.net.www.content.text.plain;

import java.awt.*;
import java.awt.event.*;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Options 
{
    private JPanel panel;
    private JButton reset;
    private JButton nextLevel;
    private JButton previousLevel;
    private JButton open;
    private JLabel levelNow;
    private JTextField level;
    private int currentLevel;
    private String[] levels;



    public Options()
    {
        levels = new String[40];
        currentLevel = 0;
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        reset = new JButton("Reset Level");
        nextLevel = new JButton("Next Level");
        previousLevel = new JButton("Previous Level");
        open = new JButton("Open Level");
        level = new JTextField();
        level.setColumns(5);
        levelNow = new JLabel();

        panel.add(levelNow);
        panel.add(reset);
        panel.add(nextLevel);
        panel.add(previousLevel);
        panel.add(level);
        panel.add(open);
        
    }

    public void openFile(String pFileName)
    { 
        int line = 0;
        try {
            File fileObject = new File(pFileName);
            Scanner reader = new Scanner(fileObject);
            while (reader.hasNextLine()){
                levels[line] = reader.nextLine();
                line++;
            }
            reader.close();
        } catch (FileNotFoundException e){}
    }

    public JButton getResetButton()
    {
        return reset;
    }
    public JButton getOpenButton()
    {
        return open;
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

    public void setLevel(int pLevel)
    {
        if (pLevel < 0 || pLevel > 40){
            currentLevel = 0;
        } else {
            currentLevel = pLevel;  
        }
    }

    public String getCurrentLevel()
    {
        return levels[currentLevel];
    }

    public void updateLevelButton()
    {
        levelNow.setText(Integer.toString(currentLevel));
    }

    public int getLevel()
    {
        return currentLevel;
    }

  


} 