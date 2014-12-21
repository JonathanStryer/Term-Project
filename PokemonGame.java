 /* 
 * PokemonGame.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class contains the main method that plays the Pokemon game utilizing 
 * battlePanel.java, choosePokemonPanel.java, Move.java, Pokemon.java, pokemonButton.java, PokemonGame.java, sortPokemon.java, and startButtonPanel.java.
*/ 

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import javax.swing.*;

public class PokemonGame 
{
  private static boolean battle = true; // When false, the Pokemon battle is over
  
  public static void main (String args[]) throws IOException
  {
    Random rand = new Random(); // Random number generator
    int i = 0; // For for-loops
    Pokemon temp; // To store Pokemon object
    int randNum; // To store random ints
    double randDouble; // To store random doubles
    int moveChoice; // To store the move choice of the user
    int indexNum = 27; // Number of Pokemon objects in array after user picks pokemon 
    int num; // Store temporary numbers
    String tempMessage; // Stores a message to pass through changeMessage() method
    
    // ALLOWS TO PRINT TO AN OUTPUT FILE "winner.txt"
    FileWriter fw = new FileWriter ("winner.txt");
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter fileOut = new PrintWriter (bw);
    
    // MOVE OBJECTS
    Move thunderbolt = new Move("Thunderbolt", "Electric", 0, 1.0, true, 90);   
    Move quickAttack = new Move("Quick Attack", "Normal", 1, 1.0, false, 40);
    Move thunder = new Move("Thunder", "Electric", 0, .7, true, 110);
    Move thunderPunch = new Move("Thunder Punch", "Electric", 0, 1.0, false, 75);
    Move surf = new Move("Surf", "Water", 0, 1.0, true, 90);  
    Move bubble = new Move("Bubble", "Water", 0, 1.0, true, 40);
    Move waterPulse = new Move("Water Pulse", "Water", 0, 1.0, true, 60);
    Move hydroPump = new Move("Hydro Pump", "Water", 0, .8, true, 110);
    Move flamethrower = new Move("Flamethrower", "Fire", 0, 1.0, true, 90); 
    Move steelWing = new Move("Steel Wing", "Steel", 0, .9, false, 70);
    Move inferno = new Move("Inferno", "Fire", 0, .5, true, 100);
    Move scratch = new Move("Scratch", "Normal", 0, 1.0, false, 40);
    Move vineWhip = new Move("Vine Whip", "Grass", 0, 1.0, false, 45);
    Move razorLeaf = new Move("Razor Leaf", "Grass", 0, .95, false, 55);
    Move venoshock = new Move("Venoshock", "Poison", 0, 1.0, true, 65);
    Move cut = new Move("Cut", "Normal", 0, .95, false, 50);
    Move rockTomb = new Move("Rock Tomb", "Rock", 0, .95, false, 60);
    Move ironTail = new Move("Iron Tail", "Steel", 0, .75, false, 100);
    Move slam = new Move("Slam", "Normal", 0, .75, false, 80);
    Move rockThrow = new Move("Rock Throw", "Rock", 0, .9, false, 40); 
    Move spark = new Move("Spark", "Electric", 0, 100.0, true, 60);
    Move zapCannon = new Move("Zap Cannon", "Electric", 0, .5, true, 120);
    Move waterGun = new Move("Water Gun", "Water", 0, 1.0, true, 40);
    Move bubbleBeam = new Move("Bubble Beam", "Water", 0, 1.0, true, 65);
    Move waterfall = new Move("Waterfall", "Water", 0, 1.0, false, 80);
    Move fireBlast = new Move("Fire Blast", "Fire", 0, .85, true, 110);
    Move flameBurst = new Move("Flame Burst", "Fire", 0, 1.0, true, 70);
    Move magicalLeaf = new Move("Magical Leaf", "Grass", 0, 100.0, true, 60);
    Move bodySlam = new Move("Body Slam", "Normal", 0, 1.0, false, 85);
    Move secretPower = new Move("Secret Power", "Normal", 0, 1.0, false, 70);
    Move smackDown = new Move("Smack Down", "Rock", 0, 1.0, false, 50); 
    Move strength = new Move("Strength", "Normal", 0, 1.0, false, 80);
    Move hiddenPower = new Move("Hidden Power", "Normal", 0, 1.0, true, 60);
    Move takeDown = new Move("Take Down", "Normal", 0, .85, false, 90);  
    Move swift = new Move("Swift", "Normal", 0, 100.0, true, 60);
    Move flameWheel = new Move("Flame Wheel", "Fire", 0, 1.0, false, 60);
    Move bite = new Move("Bite", "Dark", 0, 1.0, false, 60);
    Move suckerPunch = new Move("Sucker Punch", "Dark", 0, 1.0, false, 80);
    Move headbutt = new Move("Headbutt", "Normal", 0, 1.0, false, 70);
    Move discharge = new Move("Discharge", "Electric", 0, 1.0, true, 80);
    Move slash = new Move("Slash", "Normal", 0, 1.0, false, 70);
    Move sludgeBomb = new Move("Sludge Bomb", "Poison", 0, 1.0, true, 95);
    Move rockSlide = new Move("Rock Slide", "Rock", 0, .9, false, 75);
    Move stoneEdge = new Move("Stone Edge", "Rock", 0, .8, false, 100);
    Move chipAway = new Move("Chip Away", "Normal", 0, 1.0, false, 70);
    Move iceBeam = new Move("Ice Beam", "Ice", 0, 1.0, true, 90);
    Move aquaTail = new Move("Aqua Tail", "Water", 0, .9, false, 90);
    Move fireFang = new Move("Fire Fang", "Fire", 0, .95, false, 65);
    Move heatWave = new Move("Heat Wave", "Fire", 0, .9, true, 95);
    Move facade = new Move("Facade", "Normal", 0, 1.0, false, 70);
    Move leafStorm = new Move("Leaf Storm", "Grass", 0, .9, true, 130); 
    Move ancientPower = new Move("Ancient Power", "Rock", 0, 1.0, true, 60);
    Move megaPunch = new Move("Mega Punch", "Normal", 0, .85, false, 80);
    Move knockOff = new Move("Knock Off", "Dark", 0, 1.0, false, 65);
    Move lavaPlume = new Move("Lava Plume", "Fire", 0, 1.0, true, 80);
    Move energyBall = new Move("Energy Ball", "Grass", 0, 1.0, true, 90);
    Move wingAttack = new Move("Wing Attack", "Flying", 0, 1.0, false, 60);
    Move thunderFang = new Move("Thunder Fang", "Electric", 0, .95, false, 65); 
    
    // POKEMON OBJECTS
    Pokemon pikachu = new Pokemon("Pikachu", "Electric", 185, 121, 88, 92, 103, 163, thunderbolt, quickAttack, thunder, thunderPunch);  
    Pokemon squirtle = new Pokemon("Squirtle", "Water", 190, 110, 125, 92, 124, 92, surf, bubble, waterPulse, hydroPump); 
    Pokemon charizard = new Pokemon("Charizard", "Fire", 235, 169, 145, 171, 155, 178, flamethrower, steelWing, inferno, scratch);
    Pokemon ivysaur = new Pokemon("Ivysaur", "Grass", 198, 133, 122, 133, 148, 118, vineWhip, razorLeaf, venoshock, cut);
    Pokemon onix = new Pokemon("Onix", "Rock", 160, 104, 268, 65, 95, 133, rockTomb, ironTail, slam, rockThrow);
    Pokemon magnemite = new Pokemon("Magnemite", "Electric", 145, 88, 133, 153, 110, 95, thunderbolt, spark, zapCannon, thunder);
    Pokemon poliwhirl = new Pokemon("Poliwhirl", "Water", 205, 137, 125, 92, 103, 163, waterGun, bubbleBeam, hydroPump, waterfall);
    Pokemon vulpix = new Pokemon("Vulpix", "Fire", 165, 97, 88, 92, 125, 125, flamethrower, fireBlast, flameBurst, quickAttack);
    Pokemon bayleef = new Pokemon("Bayleef", "Grass", 198, 133, 148, 109, 148, 118, razorLeaf, magicalLeaf, bodySlam, secretPower); 
    Pokemon geodude = new Pokemon("Geodude", "Rock", 168, 162, 178, 65, 73, 58, rockThrow, smackDown, strength, hiddenPower);
    Pokemon jolteon = new Pokemon("Jolteon", "Electric", 205, 137, 118, 173, 170, 223, quickAttack, thunder, takeDown, thunderbolt);
    Pokemon staryu = new Pokemon("Staryu", "Water", 153, 104, 110, 119, 110, 155, hydroPump, waterGun, bubbleBeam, swift);  
    Pokemon growlithe = new Pokemon("Growlithe", "Fire", 190, 146, 95, 119, 103, 118, flameWheel, bite, flamethrower, takeDown);  
    Pokemon weepinbell = new Pokemon("Weepinbell", "Grass", 205, 179, 103, 139, 95, 110, vineWhip, razorLeaf, magicalLeaf, slam);
    Pokemon sudowoodo = new Pokemon("Sudowoodo", "Rock", 213, 195, 200, 65, 125, 73, rockThrow, rockTomb, suckerPunch, headbutt); 
    Pokemon electrode = new Pokemon("Electrode", "Electric", 198, 113, 133, 133, 148, 238, discharge, swift, spark, hiddenPower); 
    Pokemon feraligatr = new Pokemon("Feraligatr", "Water", 235, 203, 178, 131, 152, 145, bite, slash, hydroPump, waterPulse);   
    Pokemon rapidash = new Pokemon("Rapidash", "Fire", 205, 195, 133, 133, 148, 185, takeDown, flameWheel, quickAttack, inferno);
    Pokemon bellossom = new Pokemon("Bellossom", "Grass", 220, 162, 170, 146, 178, 103, magicalLeaf, razorLeaf, secretPower, sludgeBomb);   
    Pokemon tyranitar = new Pokemon("Tyranitar", "Rock", 258, 251, 193, 153, 178, 119, bite, rockSlide, stoneEdge, chipAway);
    Pokemon electabuzz = new Pokemon("Electabuzz", "Electric", 205, 167, 113, 153, 155, 185, thunder, thunderbolt, thunderPunch, quickAttack);
    Pokemon seel = new Pokemon("Seel", "Water", 205, 104, 110, 85, 133, 95, takeDown, iceBeam, waterPulse, aquaTail); 
    Pokemon flareon = new Pokemon("Flareon", "Fire", 205, 245, 118, 153, 193, 125, quickAttack, fireFang, flamethrower, heatWave);  
    Pokemon tangela = new Pokemon("Tangela", "Grass", 205, 121, 200, 160, 88, 118, secretPower, facade, leafStorm, vineWhip);
    Pokemon rhydon = new Pokemon("Rhydon", "Rock", 265, 245, 208, 85, 95, 88, smackDown, rockTomb, ancientPower, megaPunch);
    Pokemon raichu = new Pokemon("Raichu", "Electric", 198, 179, 110, 146, 148, 193, thunderPunch, thunderbolt, ironTail, knockOff);  
    Pokemon seadra = new Pokemon("Seadra", "Water", 190, 137, 170, 153, 95, 155, hydroPump, bubbleBeam, waterGun, waterPulse); 
    Pokemon typhlosion = new Pokemon("Typhlosion", "Fire", 225, 169, 145, 171, 155, 178, flamethrower, lavaPlume, strength, rockTomb);
    Pokemon vileplume = new Pokemon("Vileplume", "Grass", 220, 162, 155, 173, 163, 103, hiddenPower, sludgeBomb, venoshock, energyBall); 
    Pokemon aerodactyl = new Pokemon("Aerodactyl", "Rock", 228, 203, 125, 106, 140, 223, bite, wingAttack, thunderFang, rockSlide);  
    
    // ArrayList for Pokemon Objects  
    ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
    
    // Adds Pokemon Objects to ArrayList
    pokemon.add(pikachu);
    pokemon.add(squirtle);
    pokemon.add(charizard);
    pokemon.add(ivysaur);
    pokemon.add(onix);
    pokemon.add(magnemite);
    pokemon.add(poliwhirl);
    pokemon.add(vulpix);
    pokemon.add(bayleef);
    pokemon.add(geodude);
    pokemon.add(jolteon);
    pokemon.add(staryu);
    pokemon.add(growlithe);
    pokemon.add(weepinbell);
    pokemon.add(sudowoodo);
    pokemon.add(electrode);
    pokemon.add(feraligatr);
    pokemon.add(rapidash);
    pokemon.add(bellossom);
    pokemon.add(tyranitar);
    pokemon.add(electabuzz);
    pokemon.add(seel);
    pokemon.add(flareon);
    pokemon.add(tangela);
    pokemon.add(rhydon);
    pokemon.add(raichu);
    pokemon.add(seadra);
    pokemon.add(typhlosion);
    pokemon.add(vileplume);
    pokemon.add(aerodactyl);
    
    /*SETS UP START SCREEN GUI-----------------------------------------------------*/
    JFrame frame = new JFrame("Pokemon Orange"); // Frame for GUI 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    startButtonPanel primary = new startButtonPanel();
    primary.setBackground(Color.white);
    primary.setPreferredSize(new Dimension(550, 250));
    frame.getContentPane().add(primary);
    frame.pack(); 
    frame.setLocation(300,150); // Sets location of frame
    frame.setSize(700,500); // Sets size of frame
    frame.setVisible(true); // Makes frame visible
    
    while (primary.getCount() == 0) // Runs until the user clicks to start
    {
      System.out.print("");
    }
    frame.remove(primary);
    /*----------------------------------------------------------------*/
    
    /*ALLOWS USER TO SORT POKEMON BEFORE CHOOSING POKEMON-------------------------------------------------*/
    sortPokemon sorter = new sortPokemon();
    frame.getContentPane().add(sorter);
    sorter.setPreferredSize(new Dimension(700, 500));
    frame.pack();
    
    Pokemon[] tempArray = new Pokemon[pokemon.size()]; // Tepmorary array to store Pokemon objects
    tempArray = pokemon.toArray(tempArray); // Converst ArrayList pokemon to an array in tempArray
    
    do
    {
      System.out.print("");
    }
    while(sorter.getCount() == 0); // Runs until the user chooses a sort option
    
    if (sorter.getCount() == 1) // NO SORT
    {
    }
    else if (sorter.getCount() == 2) // ALPHABET SORT
    {
      tempArray = Pokemon.sortAlphabet(tempArray);
    }
    else if (sorter.getCount() == 3) // TYPE SORT
    {
      tempArray = Pokemon.sortType(tempArray);
    }
    
    frame.remove(sorter);
    
    /*----------------------------------------------------------------------------------------------------*/
    
    /*ALLOWS USER TO PICK POKEMON (COMPUTER RANDOMLY PICKS POKEMON)---------------------------------------*/
    choosePokemonPanel choices = new choosePokemonPanel(tempArray);
    frame.getContentPane().add(choices);
    frame.pack();
    
    while (choices.getCount() == 0) // Runs until user selects three Pokemon and submits 
    {
      System.out.print("");
    }
    
    ArrayList<Pokemon> user = new ArrayList<Pokemon>(); // ArrayList for the user's Pokemon 
    // Gets names of Pokemon chosen by user
    String[] tempNames = new String[3];
    tempNames[0] = choices.return1();
    tempNames[1] = choices.return2();
    tempNames[2] = choices.return3();

    
    for (i = 0; i < 3; i++) // Stores the Pokemon chosen by user into the user ArrayList
    {
      for (int a = 0; a < pokemon.size(); a++)
      {
        if (tempNames[i].equals(pokemon.get(a).getName()))
        {
          user.add(pokemon.get(a));
        }
      }     
    }
    
    frame.remove(choices);

    // Searches for Pokemon objects chosen by user and removes them from the ArrayList pokemon
    num = Pokemon.indexOfPokemon(pokemon, user.get(0).getName()); 
    pokemon.remove(num);
    num = Pokemon.indexOfPokemon(pokemon, user.get(1).getName());
    pokemon.remove(num);
    num = Pokemon.indexOfPokemon(pokemon, user.get(2).getName());
    pokemon.remove(num);
    
    // Computer: ArrayList to store three Pokemon objects randomly chosen by computer
    ArrayList<Pokemon> computer = new ArrayList<Pokemon>();
    
    for (i = 0; i < 3; i++)
    {
      randNum = rand.nextInt(indexNum);
      temp = pokemon.remove(randNum);
      computer.add(temp);
      indexNum--;
    }
    /*-----------------------------------------------------------------------------------------------------------*/
    
    /*POKEMON BATTLE(START)------------------------------------------------------------------------------------------------*/ 
    
    // BATTLE SCREEN GUI 
    battlePanel battleScreen = new battlePanel();
    frame.getContentPane().add(battleScreen);
    
    do
    {
      // UPDATE BATTLE SCREEN GUI 
      battleScreen.updateUserPokemonInfo("Name: " + user.get(0).getName() + "\n Type: " + user.get(0).getType() + "\n HP: " + user.get(0).getHealthPoints());
      battleScreen.updateComputerPokemonInfo("Name: " + computer.get(0).getName() + "\n Type: " + computer.get(0).getType() + "\n HP: " + computer.get(0).getHealthPoints());
      battleScreen.setMoveOne(user.get(0).getMoveOne().getMoveName());
      battleScreen.setMoveTwo(user.get(0).getMoveTwo().getMoveName());
      battleScreen.setMoveThree(user.get(0).getMoveThree().getMoveName());
      battleScreen.setMoveFour(user.get(0).getMoveFour().getMoveName());
      battleScreen.setMoveChoice(0);
      battleScreen.resetCounter();
      battleScreen.changeMessage("Pick A Move!");
      battleScreen.changeComputerPic(computer.get(0).getName());
      battleScreen.changeUserPic(user.get(0).getName());
      frame.pack();
      
      /*MOVE CHOICES*/
      // USER CHOICES
      do
      {
        System.out.print("");
      }
      while(battleScreen.getMoveChoice() == 0);
      
      user.get(0).setMove(battleScreen.getMoveChoice());
      
      // COMPUTER CHOICES
      randNum = rand.nextInt(4) + 1;
      computer.get(0).setMove(randNum);
      
      /*CONDUCT ATTACKS*/
      // CHECK PRIORITY
      
      if (user.get(0).checkPriority(computer.get(0)) == 0) // User's Pokemon goes first
      {
        // CHECK TO SEE IF ATTACK HITS (User's Pokemon)
        randDouble = rand.nextDouble();
        
        if (user.get(0).HitOrMiss(user.get(0).getCurrentMove(), computer.get(0)) > randDouble) // If user hits
        {
          // DEAL DAMAGE
          user.get(0).dealDamage(user.get(0), user.get(0).getCurrentMove(), computer.get(0));
          
          battleScreen.resetCounter();
          tempMessage = (user.get(0).getName() + " attacked with " + user.get(0).getCurrentMove().getMoveName());
          battleScreen.changeMessage(tempMessage);
          do 
          {
            System.out.print("");
          }
          while(battleScreen.getCounter() == 0);
          
          battleScreen.resetCounter();
        }
        else // User doesn't hit
        {
          battleScreen.resetCounter();
          tempMessage = ("Your " + user.get(0).getName() + " missed!");
          battleScreen.changeMessage(tempMessage);
          do 
          {
            System.out.print("");
          }
          while(battleScreen.getCounter() == 0);
          
          battleScreen.resetCounter();
        }
        
        // CHECK TO SEE IF ATTACK HITS (Computer's Pokemon)
        randDouble = rand.nextDouble();
        
        if (computer.get(0).HitOrMiss(computer.get(0).getCurrentMove(), user.get(0)) > randDouble) // If computer hits,
        {
          // CHECK ALIVE to DEAL DAMAGE
          if (computer.get(0).getHealthPoints() > 0) // If computer is alive,
          {
            computer.get(0).dealDamage(computer.get(0), computer.get(0).getCurrentMove(), user.get(0));
            
            battleScreen.resetCounter();
            tempMessage = (computer.get(0).getName() + " attacked with " + computer.get(0).getCurrentMove().getMoveName());
            battleScreen.changeMessage(tempMessage);
            do 
            {
              System.out.print("");
            }
            while(battleScreen.getCounter() == 0);
            
            battleScreen.resetCounter();
          }
          
        }
        else
        {
          // CHECK ALIVE FOR OUTPUT
          if (computer.get(0).getHealthPoints() > 0) // Computer misses
          {
            battleScreen.resetCounter();
            tempMessage = ("Computer's " + computer.get(0).getName() + " missed!");
            battleScreen.changeMessage(tempMessage);
            do 
            {
              System.out.print("");
            }
            while(battleScreen.getCounter() == 0);
            
            battleScreen.resetCounter();
          }
          
        } 
      }
      
      else // Computer's Pokemon goes first
      {
        // CHECK TO SEE IF ATTACK HITS (Computer's Pokemon)
        randDouble = rand.nextDouble();
        
        if (computer.get(0).HitOrMiss(computer.get(0).getCurrentMove(), user.get(0)) > randDouble) // If computer hits
        {
          // DEAL DAMAGE
          computer.get(0).dealDamage(computer.get(0), computer.get(0).getCurrentMove(), user.get(0));
          
          battleScreen.resetCounter();
          tempMessage = (computer.get(0).getName() + " attacked with " + computer.get(0).getCurrentMove().getMoveName());
          battleScreen.changeMessage(tempMessage);
          do 
          {
            System.out.print("");
          }
          while(battleScreen.getCounter() == 0);
          
          battleScreen.resetCounter();
        }
        else // Computer misses
        {
          battleScreen.resetCounter();
          tempMessage = ("Computer's " + computer.get(0).getName() + " missed!");
          battleScreen.changeMessage(tempMessage);
          do 
          {
            System.out.print("");
          }
          while(battleScreen.getCounter() == 0);
          
          battleScreen.resetCounter();
        } 
        
        // CHECK TO SEE IF ATTACK HITS (User's Pokemon)
        randDouble = rand.nextDouble();
        
        if (user.get(0).HitOrMiss(user.get(0).getCurrentMove(), computer.get(0)) > randDouble) // If user hits
        {
          // CHECK ALIVE to DEAL DAMAGE
          if (user.get(0).getHealthPoints() > 0) // If user is alive
          {
            user.get(0).dealDamage(user.get(0), user.get(0).getCurrentMove(), computer.get(0)); 
            
            battleScreen.resetCounter();
            tempMessage = (user.get(0).getName() + " attacked with " + user.get(0).getCurrentMove().getMoveName());
            battleScreen.changeMessage(tempMessage);
            do 
            {
              System.out.print("");
            }
            while(battleScreen.getCounter() == 0);
            
            battleScreen.resetCounter();
          }
          
        }
        else // If user misses
        {
          // CHECK ALIVE FOR OUTPUT
          if (user.get(0).getHealthPoints() > 0)
          {
            battleScreen.resetCounter();
            tempMessage = ("Your " + user.get(0).getName() + " missed!");
            battleScreen.changeMessage(tempMessage);
            do 
            {
              System.out.print("");
            }
            while(battleScreen.getCounter() == 0);
            
            battleScreen.resetCounter();
          }
          
        }
      }
      
      if (user.get(0).getHealthPoints() <= 0)
      {
        battleScreen.resetCounter();
        tempMessage = (user.get(0).getName() + " is dead.");
        battleScreen.changeMessage(tempMessage);
        do 
        {
          System.out.print("");
        }
        while(battleScreen.getCounter() == 0);
        
        battleScreen.resetCounter();
        user.remove(0);
      }
      else if (computer.get(0).getHealthPoints() <= 0)
      {
        battleScreen.resetCounter();
        tempMessage = (computer.get(0).getName() + " is dead.");
        battleScreen.changeMessage(tempMessage);
        do 
        {
          System.out.print("");
        }
        while(battleScreen.getCounter() == 0);
        
        battleScreen.resetCounter();
        computer.remove(0);
      }
      
      if (user.size() == 0 || computer.size() == 0) // If the user or computer have no Pokemon left
      {
        battle = false; // Assign false to battle
      }
    }
    while (battle); // Do-while both the user and the computer have at least one Pokemon to fight with 
    /*POKEMON BATTLE(END)------------------------------------------------------------------------------------------------*/     
    
    
    // DECLARE A WINNER   
    if (computer.size() == 0)
    {
      tempMessage = ("You win! Computer lose!");
      battleScreen.changeMessage(tempMessage);
      fileOut.print("User won with " + user.get(0)); // Prints the winning Pokemon
      
      do 
      {
        System.out.print("");
      }
      while(battle);
    }
    else
    {
      tempMessage = ("Computer win! You lose!");
      battleScreen.changeMessage(tempMessage);
      fileOut.print("Computer won with " + computer.get(0)); // Prints the winnning computer Pokemon 
      
      do 
      {
        System.out.print("");
      }
      while(battle);
    }
    
    fileOut.close(); // Closes output file
  }
}