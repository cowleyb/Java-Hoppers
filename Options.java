import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

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
    private JLabel winner1;
    private JLabel winner2;
    private JTextField level;
    private int currentLevel;
    private String[] levels;



    public Options()
    {
        //Contructor
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
        winner1 = new JLabel();
        winner2 = new JLabel();

        panel.add(winner1);
        panel.add(levelNow);
        panel.add(reset);
        panel.add(nextLevel);
        panel.add(previousLevel);
        panel.add(level);
        panel.add(open);
        panel.add(winner2);
        
    }

    public void openFile(String pFileName)
    { 
        //Open file based of parameter, use scanner to read lines out of the file and place them into an array of strings in which one line out of the file is a single element in the array. Close file. If doesnt work throw exception and do nothing
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
        //Modulus is used because there is only 40 levels, therefore what ever the user tries to input it will be changed so its valid
        currentLevel = pLevel % 40;
        if (currentLevel < 0){
            currentLevel += 40;
        }
    }

    public String getLevelText()
    {
        return level.getText();
    }
    public String getCurrentLevel()
    {
        return levels[currentLevel];
    }

    public void updateLevelButton()
    {
        levelNow.setText("Level " + Integer.toString(currentLevel + 1) );
    }

    public int getLevel()
    {
        return currentLevel;
    }

    public void winner()
    {
        winner1.setText("WINNER");
        winner2.setText("WINNER");
    }

    public void inTheProcessOfWinning()
    {
        winner1.setText("");
        winner2.setText("");
    }

  


} 