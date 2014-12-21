/* 
 * pokemonButton.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class extends the JButton class to create a custom button that represents a Pokemon. 
 * These buttons will be used in choosePokemonPanel.java.
*/ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class pokemonButton extends JButton // inherits JButton class 
{
  private boolean selected; // If true, the button was pressed
  private int pokemonChoicesIndex; // Stores the index of the pokemon object in the array that was used to create this pokemonButton 
  private String name; // The name of the Pokemon object associated with this pokemonButton 
  
  public pokemonButton(String initname, int initpokemonChoicesIndex) // Constructor for the pokemonButton class 
  {
    // Sets the instance variables based on what is passed through the parameters
    name = initname;
    setText(name);
    pokemonChoicesIndex = initpokemonChoicesIndex;
    selected = false; // Every pokemonButton is auto-selected to false because it hasn't been pressed yet
  }
  
  public void setSelectedTrue() // Sets selected in the pokemonButton to true
  {
    if (selected == false)
    {
      selected = true;
    }
  }
  
  public String getName() // Returns the name of the pokemonButton
  {
    return name;
  }
  
  public void setAllFalse() // Sets boolean selected to false
  {
    selected = false;
  }
  
  public int getIndex() // Returns the index of the location of the Pokemon object in the array associated with this pokemonButton
  {
    return pokemonChoicesIndex;
  }
  
  public boolean getSelected() // Returns selected
  {
    return selected;
  }
}