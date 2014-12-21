/* 
 * choosePokemonPanel.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class creates a panel that allows the user to see buttons of the Pokemon available to choose from.
 * The user can click buttons to select the Pokemon they want to use in battle. 
*/ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class choosePokemonPanel extends JPanel // inherits the JPanel class
{ 
  private int pokemonSelected = 0; // Integer for the number of pokemon currently selected
  private static int count = 0; // Counter to be used in while loops in the main method
  private Pokemon[] pokemonChoices; // This instance variable holds an array of the available Pokemon choices passed in by the main method

  private String pokemon1; // Holds the name of the user's first Pokemon to use
  private String pokemon2; // Holds the name of the user's second Pokemon to use
  private String pokemon3; // Holds the name of the user's third Pokemon to use 
  
  private JLabel selected; // Displays the number of Pokemon currently selected
  
  private pokemonButton[] pButtons = new pokemonButton[30]; // An array that holds thirty Buttons that will allow the user to choose Pokemon to battle with
  
  private JLabel pokemonOne = new JLabel("Choice One"); // Displays the user's first Pokemon choice
  private JLabel pokemonTwo = new JLabel("Choice Two"); // Displays the user's second Pokemon choice
  private JLabel pokemonThree = new JLabel("Choice Three"); // Displays the user's third Pokemon choice 
  
  public choosePokemonPanel(Pokemon[] initPokemonChoices) // Contructor for the choosePokemonPanel class which passes through an array of Pokemon 
  {
    pokemonChoices = initPokemonChoices; // Sets pokemonChoices to the array of pokemon passed through
    
    /*NORTH PANEL (Title Panel)*/
    JPanel title = new JPanel();
    title.setPreferredSize(new Dimension(100, 50));
    JLabel chooseTitle = new JLabel("Select Three Pokemon To Fight With!"); // Title label for title panel
    title.add(chooseTitle);
    title.setBackground(Color.orange);
    /*NORTH PANEL (Title Panel)*/
    
    /*CENTER PANEL (Buttons for Pokemon choices)*/
    JPanel pokemonButtons = new JPanel();
    pokemonButtons.setPreferredSize(new Dimension(100, 100));
    pokemonButtons.setBackground(Color.orange);
    pokemonButtons.setLayout(new GridLayout(6, 5));

    for (int i = 0; i < pokemonChoices.length; i++) // For-loop that creates an array of pokemonButtons
    {
      String temp = pokemonChoices[i].getName();
      pButtons[i] = new pokemonButton(temp, i);
      pokemonButtons.add(pButtons[i]);
      pButtons[i].addActionListener(new pokemonButtonStatus());
    }
    /*CENTER PANEL (Buttons for Pokemon choices)*/
    
    /*SOUTH PANEL (Submit, # Selected, Clear)*/
    JPanel submitSelected = new JPanel();
    submitSelected.setPreferredSize(new Dimension(100, 50));
    JButton submit = new JButton("Submit Choices"); // Button to submit Pokemon choices
    selected = new JLabel("Pokemon selected: " + pokemonSelected); // Label to display number of Pokemon selected
    submitSelected.add(submit);
    submitSelected.add(selected);
    submit.addActionListener(new pokemonSubmit());  
    JButton clearSelections = new JButton("Clear Selections"); // Button to clear Pokemon choices 
    submitSelected.add(clearSelections);
    clearSelections.addActionListener(new clear());
    submitSelected.setBackground(Color.orange);
    /*SOUTH PANEL (Submit, # Selected, Clear)*/
    
    /*EAST PANEL (Displays Selected Pokemon)*/
    JPanel selectedPokemon = new JPanel();
    JLabel eastTitle = new JLabel("Selected Pokemon:");
    selectedPokemon.add(eastTitle);
    selectedPokemon.add(pokemonOne);
    selectedPokemon.add(pokemonTwo);
    selectedPokemon.add(pokemonThree);
    selectedPokemon.setPreferredSize(new Dimension(150, 200));
    selectedPokemon.setBackground(Color.orange);
    selectedPokemon.setLayout(new GridLayout(0, 1));
    /*EAST PANEL (Selected Pokemon)*/
    
    setLayout(new BorderLayout()); // Sets layout of panel to BorderLayout
    setPreferredSize(new Dimension(700, 500)); // Sets size of panel
    setBackground(Color.black); // Sets color of panel to black 
    
    // Adds panels to choosePokemonPanel 
    add(title, BorderLayout.NORTH);
    add(selectedPokemon, BorderLayout.EAST);
    add(pokemonButtons, BorderLayout.CENTER);
    add(submitSelected, BorderLayout.SOUTH);
  }
  
  //--------------------------------------------------------------------------------\\
  // Methods: Update the instance variables and return the values of variables. 
  //--------------------------------------------------------------------------------\\
  
  public int getCount() // Returns the count integer
  {
    return count;
  }
  
  public String return1() // Returns the user choice for Pokemon one
  {
    return pokemon1;
  }
  
  public String return2() // Returns the user choice for Pokemon two
  {
    return pokemon2;
  }
  
  public String return3() // Returns the user choice for Pokemon three
  {
    return pokemon3;
  }
  
  //-----------------------------------------------------------------------------------------------\\
  // Buttons: Classes that implement ActionListener to provide a response when a Button is pressed 
  //-----------------------------------------------------------------------------------------------\\
  
  private class pokemonSubmit implements ActionListener
  {
    public void actionPerformed(ActionEvent event)
    {
      if (pokemonSelected == 3) // If there are three Pokemon selected
      {
        count++; // Count is incremented by 1
      }
    }
  } 
  
  private class clear implements ActionListener // Clear resets the user's choices so there are no choices selected
  {
    public void actionPerformed(ActionEvent event)
    {
      pokemonOne.setText("Choice One");          
      pokemonTwo.setText("Choice Two");          
      pokemonThree.setText("Choice Three");
      
      pokemonSelected = 0;
      selected.setText("Pokemon selected: " + pokemonSelected);
      
      for (int i = 0; i < pButtons.length; i++)
      {
        pButtons[i].setAllFalse();
      }
    }
  } 
  
  private class pokemonButtonStatus implements ActionListener // Allows the user to choose and select Pokemon 
  {
    public void actionPerformed(ActionEvent event)
    {
      int index = 0; 
      
      for (int i = 0; i < 30; i++)
      {
        if (event.getSource() == pButtons[i])
        {
          index = i; 
        }
      }
      
      pButtons[index].setSelectedTrue();
      
      if (pButtons[index].getSelected() == true)
      {
        if (pokemonSelected < 3)
        {
          pokemonSelected++;

          
          if (pokemonSelected == 1)
          {
            pokemonOne.setText(pButtons[index].getName());
            pokemon1 = pokemonOne.getText();
          }
          else if (pokemonSelected == 2)
          {
            if (pokemon1.equals(pButtons[index].getName()))
            {
              pokemonSelected--;
            }
            else
            {
              pokemonTwo.setText(pButtons[index].getName());
              pokemon2 = pokemonTwo.getText();
            }
          }
          else if (pokemonSelected == 3)
          {
            if (pokemon1.equals(pButtons[index].getName()))
            {
              pokemonSelected--;
            }
            else if (pokemon2.equals(pButtons[index].getName()))
            {
              pokemonSelected--;
            }
            else
            {
              pokemonThree.setText(pButtons[index].getName());
              pokemon3 = pokemonThree.getText();
            }
          }
          
          selected.setText("Pokemon selected: " + pokemonSelected);
        }   
      } 
    }
  }
}