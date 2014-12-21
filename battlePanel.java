/* 
 * battlePanel.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class creates a panel that is called by PokemonGame.java to display a battle screen.
 * This interactive screen allows the user to battle the computer's Pokemon.
*/ 

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*; 

public class battlePanel extends JPanel // inherits the JPanel class 
{
  private JButton moveOne; // Button for the Pokemon's Move One
  private JButton moveTwo; // Button for the Pokemon's Move Two 
  private JButton moveThree; // Button for the Pokemon's Move Three
  private JButton moveFour; // Button for the Pokemon's Move Four
  private static int moveChoice = 0; // Integer that stores the number of the Move that the user selects (moveChoice = 1 would relate to moveOne)
  
  private String message; // Stores a message based on game events
  private JLabel aMessage; // Displays a message based on game events
  private int counter = 0; // Counter for loops in main
  
  private JLabel userPic; // Label to display a picture of the user's current Pokemon
  private JLabel computerPic; // Label to display a picture of the computer's current Pokemon 
  private JLabel userPokemonInfo; // Lqbel to display the name, type, and healthPoints of the user's current Pokemon
  private JLabel computerPokemonInfo; // Label to display the name, type, and healthPoints of the computer's current Pokemon
  
  // IMAGEICONS TO VISUALLY DISPLAY THE POKEMON 
  ImageIcon pikachu = new ImageIcon("pikachuPic.jpeg");
  ImageIcon squirtle = new ImageIcon("squirtlePic.jpeg");
  ImageIcon charizard = new ImageIcon("charizardPic.jpeg");
  ImageIcon ivysaur = new ImageIcon("ivysaurPic.jpeg");
  ImageIcon onix = new ImageIcon("onixPic.jpeg");
  ImageIcon magnemite = new ImageIcon("magnemitePic.jpeg");
  ImageIcon poliwhirl = new ImageIcon("poliwhirlPic.jpeg");
  ImageIcon vulpix = new ImageIcon("vulpixPic.jpeg");
  ImageIcon bayleef = new ImageIcon("bayleefPic.jpeg");
  ImageIcon geodude = new ImageIcon("geodudePic.jpeg");
  ImageIcon jolteon = new ImageIcon("jolteonPic.jpeg");
  ImageIcon staryu = new ImageIcon("staryuPic.jpeg");
  ImageIcon growlithe = new ImageIcon("growlithePic.jpeg");
  ImageIcon weepinbell = new ImageIcon("weepinbellPic.jpeg");
  ImageIcon sudowoodo = new ImageIcon("sudowoodoPic.jpeg");
  ImageIcon electrode = new ImageIcon("electrodePic.jpeg");
  ImageIcon feraligatr = new ImageIcon("feraligatrPic.jpeg");
  ImageIcon rapidash = new ImageIcon("rapidashPic.jpeg");
  ImageIcon bellosom = new ImageIcon("bellosomPic.jpeg");
  ImageIcon tyranitar = new ImageIcon("tyranitarPic.jpeg");
  ImageIcon electabuzz = new ImageIcon("electabuzzPic.jpeg");
  ImageIcon seel = new ImageIcon("seelPic.jpeg");
  ImageIcon flareon = new ImageIcon("flareonPic.jpeg");
  ImageIcon tangela = new ImageIcon("tangelaPic.jpeg");
  ImageIcon rhydon = new ImageIcon("rhydonPic.jpeg"); 
  ImageIcon raichu = new ImageIcon("raichuPic.jpeg");
  ImageIcon seadra = new ImageIcon("seadraPic.jpeg");
  ImageIcon typhlosion = new ImageIcon("typhlosionPic.jpeg");
  ImageIcon vileplume = new ImageIcon("vileplumePic.jpeg");
  ImageIcon aerodactyl = new ImageIcon("aerodactylPic.jpeg"); 
  
  public battlePanel() // Constructor for the battlePanel() class 
  {
    setLayout(new BorderLayout()); // Sets layout of battlePanel to BorderLayout
    setPreferredSize(new Dimension(700, 500)); // Sets the size of the panel
    setBackground(Color.white); // Sets color of panel to white 
    
    /*WEST PANEL*/
    JPanel moves = new JPanel(); // Panel for Pokemon Move buttons 
    moves.setBackground(new Color(130, 250, 100)); // Sets color of moves panel
    moves.setPreferredSize(new Dimension(150, 600)); // Sets size of moves panel
    JLabel pickMove = new JLabel("Pick A Move");
    // Move Buttons for Pokemon
    moveOne = new JButton("one"); 
    moveTwo = new JButton("two"); 
    moveThree = new JButton("three"); 
    moveFour = new JButton("four"); 
    // ActionListeners added to Move Buttons
    moveOne.addActionListener(new MoveOneClick());
    moveTwo.addActionListener(new MoveTwoClick());
    moveThree.addActionListener(new MoveThreeClick());
    moveFour.addActionListener(new MoveFourClick());
    // Label and Buttons added to panel 
    moves.add(pickMove);
    moves.add(moveOne);
    moves.add(moveTwo);
    moves.add(moveThree);
    moves.add(moveFour);
    /*WEST PANEL*/
    
    /*CENTER PANEL*/
    JPanel pictures = new JPanel();
    // PANEL TO DISPLAY USER'S POKEMON AND POKEMON INFO 
    JPanel userPanel = new JPanel(); 
    userPanel.setBackground(Color.white);
    JLabel userPanelTitle = new JLabel("User"); // title label for userPanel
    userPanelTitle.setFont(userPanelTitle.getFont().deriveFont(32.0f));
    userPic = new JLabel(pikachu); // pic label for userPanel
    userPokemonInfo = new JLabel(""); // info label for userPanel 
    // Adds labels to userPanel
    userPanel.add(userPanelTitle);
    userPanel.add(userPokemonInfo);
    userPanel.add(userPic);
    // PANEL TO DISPLAY COMPUTER"S POKEMON AND POKEMON INFO 
    JPanel computerPanel = new JPanel();
    computerPanel.setBackground(Color.white);
    JLabel computerPanelTitle = new JLabel("Computer"); // title for computerPanel
    computerPanelTitle.setFont(computerPanelTitle.getFont().deriveFont(32.0f));
    computerPic = new JLabel(pikachu); // pic label for computerPanel
    computerPokemonInfo = new JLabel(""); // info label for computerPanel
    // Adds labels to computerPanel
    computerPanel.add(computerPanelTitle);
    computerPanel.add(computerPokemonInfo);
    computerPanel.add(computerPic);
    
    pictures.setBackground(Color.white); // Sets color pictures panel to white
    pictures.setLayout(new GridLayout(0, 2)); // Sets layout of pictures to GridLayout
    pictures.add(userPanel); // Adds userPanel to pictures panel
    pictures.add(computerPanel); // Adds computerPanel to pictures panel 
    /*CENTER PANEL*/
    
    /*SOUTH PANEL*/
    JPanel message = new JPanel();
    message.setBackground(Color.black); // Sets color of panel
    message.setPreferredSize(new Dimension(250, 75)); // Sets the size of panel
    JButton cont = new JButton("Press to Continue"); // Adds Button to panel that allows the user to go to the next on-screen message
    cont.addActionListener(new ContinueClick()); // Adds actionListener to cont Button
    aMessage = new JLabel("TEMP"); // Displays a message to user based on current game state
    aMessage.setForeground(Color.white); // Changes color of message text to white
    // Adds Button and Message to panel 
    message.add(cont);
    message.add(aMessage);
    /*SOUTH PANEL*/
    
    /*NORTH PANEL*/
    JPanel title = new JPanel(); 
    JLabel battleTitle = new JLabel("User Vs. Computer Pokemon Battle!"); // Label to display battleScreen title
    battleTitle.setFont(battleTitle.getFont().deriveFont(32.0f)); // Changes appearance of label text
    title.add(battleTitle); // Adds label to panel 
    title.setBackground(new Color(130, 250, 100)); // Sets color of panel
    title.setPreferredSize(new Dimension(100, 50)); // Sets size of panel
    /*NORTH PANEL*/
   
    // Adds panels to battlePanel
    add(title, BorderLayout.NORTH);
    add(pictures, BorderLayout.CENTER);
    add(moves, BorderLayout.WEST);
    add(message, BorderLayout.SOUTH);
  }
  
  //--------------------------------------------------------------------------------\\
  // Methods: Update the instance variables and return the values of variables. 
  //--------------------------------------------------------------------------------\\
  
  public void updateUserPokemonInfo(String info) // Updates the userPokemonInfo 
  {
    userPokemonInfo.setText(info);
  }

  public void updateComputerPokemonInfo(String info) // Updates the computerPokemonInfo 
  {
    computerPokemonInfo.setText(info);
  }
  
  public void changeMessage(String initMessage) // Changes the String the message variable holds
  {
    message = initMessage;
    updateMessage();
  }
  
  public void updateMessage() // Updates the aMessage label based on the message variable 
  {
    aMessage.setText(message);
  }
  
  public void setMoveOne(String name) // Sets the name of moveOne
  {
    moveOne.setText(name);
  }
  
  public void setMoveTwo(String name) // Sets the name of moveTwo
  {
    moveTwo.setText(name);
  }
  
  public void setMoveThree(String name) // Sets the name of moveThree
  {
    moveThree.setText(name);
  }
  
  public void setMoveFour(String name) // Sets the name of moveFour
  {
    moveFour.setText(name);
  }
  
  public int getMoveChoice() // Returns the moveChoice variable (this indicates what move of the current Pokemon the user chose)
  {
    return moveChoice;
  }
  
  public void setMoveChoice(int numChoice) // This sets the moveChoice variable based on the Button that was pressed 
  {
    if (numChoice == 1)
    {
      moveChoice = 1;
    }
    else if (numChoice == 2)
    {
      moveChoice = 2;
    }
    else if (numChoice == 3)
    {
      moveChoice = 3;
    }
    else if (numChoice == 4)
    {
      moveChoice = 4;
    }
    else
    {
      moveChoice = 0; 
    }
  }
  
  public int getCounter() // This returns the integer counter
  {
    return counter;
  }
  
  public void resetCounter() // This resets the integer counter to 0
  {
    counter = 0; 
  }
  
  public void changeUserPic(String name) // This method changes the userPic based on the current Pokemon of the user
  {
    if (name.equals("Pikachu"))
    {
      userPic.setIcon(pikachu);
    }
    else if (name.equals("Squirtle"))
    {
      userPic.setIcon(squirtle);
    }
    else if (name.equals("Charizard"))
    {
      userPic.setIcon(charizard);
    }
    else if (name.equals("Ivysaur"))
    {
      userPic.setIcon(ivysaur);
    }
    else if (name.equals("Onix"))
    {
      userPic.setIcon(onix);
    }
    else if (name.equals("Magnemite"))
    {
      userPic.setIcon(magnemite);
    }
    else if (name.equals("Poliwhirl"))
    {
      userPic.setIcon(poliwhirl);
    }
    else if (name.equals("Vulpix"))
    {
      userPic.setIcon(vulpix);
    }
    else if (name.equals("Bayleef"))
    {
      userPic.setIcon(bayleef);
    }
    else if (name.equals("Geodude"))
    {
      userPic.setIcon(geodude);
    }
    else if (name.equals("Jolteon"))
    {
      userPic.setIcon(jolteon);
    }
    else if (name.equals("Staryu"))
    {
      userPic.setIcon(staryu);
    }
    else if (name.equals("Growlithe"))
    {
      userPic.setIcon(growlithe);
    }
    else if (name.equals("Weepinbell"))
    {
      userPic.setIcon(weepinbell);
    }
    else if (name.equals("Sudowoodo"))
    {
      userPic.setIcon(sudowoodo);
    }
    else if (name.equals("Electrode"))
    {
      userPic.setIcon(electrode);
    }
    else if (name.equals("Feraligatr"))
    {
      userPic.setIcon(feraligatr);
    }
    else if (name.equals("Rapidash"))
    {
      userPic.setIcon(rapidash);
    }
    else if (name.equals("Bellossom"))
    {
      userPic.setIcon(bellosom);
    }
    else if (name.equals("Tyranitar"))
    {
      userPic.setIcon(tyranitar);
    }
    else if (name.equals("Electabuzz"))
    {
      userPic.setIcon(electabuzz);
    }
    else if (name.equals("Seel"))
    {
      userPic.setIcon(seel);
    }
    else if (name.equals("Flareon"))
    {
      userPic.setIcon(flareon);
    }
    else if (name.equals("Tangela"))
    {
      userPic.setIcon(tangela);
    }
    else if (name.equals("Rhydon"))
    {
      userPic.setIcon(rhydon);
    }
    else if (name.equals("Raichu"))
    {
      userPic.setIcon(raichu);
    }
    else if (name.equals("Seadra"))
    {
      userPic.setIcon(seadra);
    }
    else if (name.equals("Typhlosion"))
    {
      userPic.setIcon(typhlosion);
    }
    else if (name.equals("Vileplume"))
    {
      userPic.setIcon(vileplume);
    }
    else if (name.equals("Aerodactyl"))
    {
      userPic.setIcon(aerodactyl);
    }
  }
  
  public void changeComputerPic(String name) // This method changes the computerPic based on the current Pokemon of the computer
  {
    if (name.equals("Pikachu"))
    {
      computerPic.setIcon(pikachu);
    }
    else if (name.equals("Squirtle"))
    {
      computerPic.setIcon(squirtle);
    }
    else if (name.equals("Charizard"))
    {
      computerPic.setIcon(charizard);
    }
    else if (name.equals("Ivysaur"))
    {
      computerPic.setIcon(ivysaur);
    }
    else if (name.equals("Onix"))
    {
      computerPic.setIcon(onix);
    }
    else if (name.equals("Magnemite"))
    {
      computerPic.setIcon(magnemite);
    }
    else if (name.equals("Poliwhirl"))
    {
      computerPic.setIcon(poliwhirl);
    }
    else if (name.equals("Vulpix"))
    {
      computerPic.setIcon(vulpix);
    }
    else if (name.equals("Bayleef"))
    {
      computerPic.setIcon(bayleef);
    }
    else if (name.equals("Geodude"))
    {
      computerPic.setIcon(geodude); 
    }
    else if (name.equals("Jolteon"))
    {
      computerPic.setIcon(jolteon);
    }
    else if (name.equals("Staryu"))
    {
      computerPic.setIcon(staryu);
    }
    else if (name.equals("Growlithe"))
    {
      computerPic.setIcon(growlithe);
    }
    else if (name.equals("Weepinbell"))
    {
      computerPic.setIcon(weepinbell);
    }
    else if (name.equals("Sudowoodo"))
    {
      computerPic.setIcon(sudowoodo);
    }
    else if (name.equals("Electrode"))
    {
      computerPic.setIcon(electrode);
    }
    else if (name.equals("Feraligatr"))
    {
      computerPic.setIcon(feraligatr);
    }
    else if (name.equals("Rapidash"))
    {
      computerPic.setIcon(rapidash);
    }
    else if (name.equals("Bellossom"))
    {
      computerPic.setIcon(bellosom);
    }
    else if (name.equals("Tyranitar"))
    {
      computerPic.setIcon(tyranitar);
    }
    else if (name.equals("Electabuzz"))
    {
      computerPic.setIcon(electabuzz);
    }
    else if (name.equals("Seel"))
    {
      computerPic.setIcon(seel);
    }
    else if (name.equals("Flareon"))
    {
      computerPic.setIcon(flareon);
    }
    else if (name.equals("Tangela"))
    {
      computerPic.setIcon(tangela);
    }
    else if (name.equals("Rhydon"))
    {
      computerPic.setIcon(rhydon);
    }
    else if (name.equals("Raichu"))
    {
      computerPic.setIcon(raichu);
    }
    else if (name.equals("Seadra"))
    {
      computerPic.setIcon(seadra);
    }
    else if (name.equals("Typhlosion"))
    {
      computerPic.setIcon(typhlosion);
    }
    else if (name.equals("Vileplume"))
    {
      computerPic.setIcon(vileplume);
    }
    else if (name.equals("Aerodactyl"))
    {
      computerPic.setIcon(aerodactyl);
    }
  }
  
  //-----------------------------------------------------------------------------------------------\\
  // Buttons: Classes that implement ActionListener to provide a response when a Button is pressed 
  //-----------------------------------------------------------------------------------------------\\
  
  private class ContinueClick implements ActionListener // ActionListener for cont Button
  {
    public void actionPerformed(ActionEvent event)
    {
      counter++; // Increments counter by 1
    } 
  }
  
  private class MoveOneClick implements ActionListener // ActionListener for moveOne Button
  {
    public void actionPerformed(ActionEvent event)
    {
      moveChoice = 1; // Sets moveChoice to 1
    }
  }
  
  private class MoveTwoClick implements ActionListener // ActionListener for moveTwo Button
  {
    public void actionPerformed(ActionEvent event)
    {
      moveChoice = 2; // Sets moveChoice to 2
    }
  }
  
  private class MoveThreeClick implements ActionListener // ActionListener for moveThree Button
  {
    public void actionPerformed(ActionEvent event)
    {
      moveChoice = 3; // Sets moveChoice to 3
    }
  }
    
  private class MoveFourClick implements ActionListener // ActionListener for moveFour Button
  {
    public void actionPerformed(ActionEvent event)
    {
      moveChoice = 4; // Sets moveChoice to 4
    }
  }
}