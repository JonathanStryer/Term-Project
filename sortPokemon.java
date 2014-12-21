/* 
 * sortPokemon.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class creates a panel that allows the user to select whether or not the Pokemon are sorted or not.
 * The user has the option to sort the Pokemon by alphabet or type, or not sort the Pokemon at all.
*/ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class sortPokemon extends JPanel // inherits JPanel
{
  private int count = 0; // Count integer for loops
  
  JButton noSort = new JButton("Do not sort Pokemon!"); // Button to not sort Pokemon array
  JButton sortAlphabetical = new JButton("Sort Pokemon by Alphabet"); // Button to sort Pokemon array by alphabet
  JButton sortType = new JButton("Sort Pokemon by Type"); // Button to sort Pokemon array by type
  
  public sortPokemon() // Constructor for sortPokemon
  { 
    // Adds actionListeners to Buttons
    noSort.addActionListener(new ButtonClick());
    sortAlphabetical.addActionListener(new ButtonClick());
    sortType.addActionListener(new ButtonClick());
    // Adds Buttons to sortPokemon panel
    add(noSort);
    add(sortAlphabetical);
    add(sortType);
    
    setBackground(Color.orange); // Set panel color to orange
  }
  
  public int getCount() // Returns count
  {
    return count;
  }
  
  private class ButtonClick implements ActionListener // ActionListener for sortPokemon Buttons
  {
    public void actionPerformed(ActionEvent event)
    {
      if (event.getSource() == noSort)
      {
        count = 1; // Set to this count for no sorting
      }
      else if (event.getSource() == sortAlphabetical)
      {
        count = 2; // Set to this count for alphabetical sorting
      }
      else if (event.getSource() == sortType)
      {
        count = 3; // Set to this count for type sorting
      }
    }
  }
}