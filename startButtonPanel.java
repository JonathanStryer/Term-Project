/* 
 * startButtonPanel.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class creates a panel which is the start screen to Pokemon Orange. The user can click to start the game. 
*/ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class startButtonPanel extends JPanel // inherits JPanel
{
  private JButton button; // JButton button variable
  private int count; // Integer count variable 
  
  public startButtonPanel() // Constructor for startButtonPanel
  {
    setLayout(new BorderLayout()); // Sets layout to BorderLayout
    
    // Button to allow user to click to start
    button = new JButton("Click to Start");
    button.addActionListener(new ButtonClick());
    
    // Image for start screen
    ImageIcon startScreen = new ImageIcon("startScreen.jpeg");
    JLabel start = new JLabel(startScreen);
    
    // Adds button and label to panel
    add(start, BorderLayout.CENTER);
    add(button, BorderLayout.SOUTH);
    
    setPreferredSize(new Dimension(300, 40)); // Sets size
    setBackground(Color.white); // Sets color to white
  }
  
  public int getCount() // Returns count (so main knows when to stop displaying the start screen)
  {
    return count;
  }
  
  private class ButtonClick implements ActionListener // ActionListener for button
  {
    public void actionPerformed(ActionEvent event)
    {
       count++; // Increments count by 1
    }
  }
}