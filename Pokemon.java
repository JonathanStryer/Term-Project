/* 
 * Pokemon.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class includes the constructor for a Pokemon object as well as other methods that will be used in a Pokemon battle.
*/ 

import java.util.*;

public class Pokemon 
{
  Random rand = new Random(); // Random number generator
  
  private String name; // Pokemon object's name
  private String type; // Pokemon object's type
  private int level; // Pokemon object's level
  private int healthPoints; // Pokemon object's healthPoints
  private int attack; // Attack power of Pokemon object
  private int defense; // Defense power of Pokemon object
  private int specialAttack; // Special attack power of Pokemon object 
  private int specialDefense; // Special defense power of Pokemon object
  private int speed; // Speed of Pokemon object
  private double accuracy; // Accuracy of Pokemon object
  private double evasion; // Evasiveness of Pokemon object
  private Move a; // Move One for Pokemon Object
  private Move b; // Move Two for Pokemon Object
  private Move c; // Move Three for Pokemon Object
  private Move d; // Move Four for Pokemon Object
  private Move current; // Current Move of Pokemon Object
  
  //----------------------------------------------------------------
  //  Constructor: Sets the initial values for the Pokemon object.
  //----------------------------------------------------------------
  
  public Pokemon(String initName, String initType, int initHP, int initAttack, int initDefense, int initSpecialAttack, int initSpecialDefense, int initSpeed, Move initA, Move initB, Move initC, Move initD) // Constructor for Pokemon Object
  {
    // Sets instance variables to what is being passed through the constructor
    name = initName;
    type = initType;
    level = 75; // All Pokemon are level 75
    healthPoints = initHP;
    attack = initAttack;
    defense = initDefense;
    specialAttack = initSpecialAttack;
    specialDefense = initSpecialDefense;
    speed = initSpeed;
    accuracy = 1.0; // All Pokemon have accuracy 1.0
    evasion = 1.0; // All Pokemon have evasion 1.0
    
    a = initA;
    b = initB;
    c = initC;
    d = initD;
    
    current = initA;    
  }
  
  //----------------------------------------------------------------------
  // The following are various printing methods. 
  //----------------------------------------------------------------------
  
  public String toString()
  {
    String names = getName();
      
    return names;
  }
  
  public void getMoves()
  {
      System.out.println("Move 1: " + a.getMoveName());
      System.out.println("Move 2: " + b.getMoveName());
      System.out.println("Move 3: " + c.getMoveName());
      System.out.println("Move 4: " + d.getMoveName());
  }
  
  //----------------------------------------------------------------------
  // The following methods return the instance variables of the object.
  //----------------------------------------------------------------------
  
  public String getName() // Returns name
  {
    return name;
  }
  
  public String getType() // Returns type
  {
    return type;
  }
  
  public int getLevel() // Returns level
  {
    return level;
  }

  public int getHealthPoints() // Returns healthPoints
  {
    return healthPoints;
  }

  public int getAttack() // Returns attack
  {
    return attack;
  }
  
  public int getDefense() // Returns defense
  {
    return defense;
  }
  
  public int getSpecialAttack() // Returns specialAttack
  {
    return specialAttack;
  }
  
  public int getSpecialDefense() // Returns specialDefense
  {
    return specialDefense;
  }
  
  public int getSpeed() // Returns speed
  {
    return speed;
  }
  
  public double getPokemonAccuracy() // Returns accuracy 
  {
    return accuracy;
  }
  
  public double getPokemonEvasion() // Returns evasion 
  {
    return evasion;
  }
  
  public Move getCurrentMove() // Returns the Move object 'current' of a Pokemon object
  {
    return current;
  }
  
  public Move getMoveOne() // Returns moveOne of the Pokemon object
  {
    return a;
  }
  
  public Move getMoveTwo() // Returns moveTwo of the Pokemon object
  {
    return b;
  }
  
  public Move getMoveThree() // Returns moveThree of the Pokemon object 
  {
    return c;
  }
  
  public Move getMoveFour() // Returns moveFour of the Pokmeon object
  {
    return d;
  }
  
  //-----------------------------------------------------------------------------------
  // The following methods assign new values to the instance variables of the objects. 
  //-----------------------------------------------------------------------------------
  
  public void setHealthPoints(int changeHealthPoints) // Changes the healthPoints of the Pokemon object 
  {
    healthPoints += changeHealthPoints;
  }
  
  public void setMove(int index) // Assigns a Move object the Pokemon object based on the Move object that the user or computer chose
  {
    if (index == 1)
      current = a;
    else if (index == 2)
      current = b;
    else if (index == 3)
      current = c;
    else if (index == 4)
      current = d; 
  }
  
  //--------------------------------------------------------------------
  // The following methods are basic functions of the game.
  //--------------------------------------------------------------------
  
  
  public void dealDamage(Pokemon attacker, Move attackMove, Pokemon defender) // This method assigns damage to the defender based on the stats of the attacker, attacking move, and defender
  {
    int damage = 0;
    double modifier = attacker.modifier(attackMove, defender);
    
    if (!attackMove.isSpecial())
    {
      damage = (((2*getLevel()+10)/250) * ((getAttack())/defender.getDefense()) * attackMove.getBaseDmg() + 2) * (int) modifier; 
    }
    else 
    {
      damage = (((2*getLevel()+10)/250) * ((getSpecialAttack())/defender.getSpecialDefense()) * attackMove.getBaseDmg() + 2) * (int) modifier; 
    }
    
    damage *= -4;
    
    defender.setHealthPoints(damage);
  }
  
  
  public double modifier(Move B, Pokemon C) // This method is a modifier which can increase or decrease the damage of an attack 
  {
    double STAB = 1.0; // SAME-TYPE-ATTACK-BONUS
    double type = 1.5; // MODIFIER THAT AFFECTS DAMAGE BASED ON TYPE OF DEFENDING POKEMON AND TYPE OF ATTACK
    double critical = 1.0; // RANDOM CRITICAL HIT MODIFIER
    double randMod = 1.0; // RANDOM MODIFIER FOR DAMAGE
    
    if (getType().compareTo(B.getMoveType()) == 0) // If the attacking Pokemon has the same type as the move
    {
      STAB = 1.5; // The STAB Modifer goes from 1.0 to 1.5
    }
   
    // One-out-of-Ten chance that the critical modifier will multiply the modifier by 2
    int criticalA = rand.nextInt(10) + 1;
    
    if (criticalA == 1) 
    {
      critical = 2.0;
    }
    
    randMod = 1.85 + (.15)*rand.nextDouble(); // Modifer to randomly affect damage
    
    
    // Type modifier that affects damage based on type of attack and type of defending Pokemon 
    String moveType = B.getMoveType();
    String defendingType = C.getType();
    
    if (moveType.compareTo("Electric") == 0)
    {
      if (defendingType.compareTo("Electric") == 0)
      {
        type = .75;
      }
      else if (defendingType.compareTo("Water") == 0)
      {
        type = 4.0;
      }
      else if (defendingType.compareTo("Grass") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Fire") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Rock") == 0)
      {
        type = 0.75;
      }
    }
      
    if (moveType.compareTo("Water") == 0)
    {
      if (defendingType.compareTo("Electric") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Water") == 0)
      {
        type = .75;
      }
      else if (defendingType.compareTo("Grass") == 0)
      {
        type = .50;
      }
      else if (defendingType.compareTo("Fire") == 0)
      {
        type = 3.0;
      }
      else if (defendingType.compareTo("Rock") == 0)
      {
        type = 4.0;
      }
    }
    
    if (moveType.compareTo("Grass") == 0)
    {
      if (defendingType.compareTo("Electric") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Water") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Grass") == 0)
      {
        type = .75;
      }
      else if (defendingType.compareTo("Fire") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Rock") == 0)
      {
        type = 3.0;
      }
    }
    
    if (moveType.compareTo("Fire") == 0)
    {
      if (defendingType.compareTo("Electric") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Water") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Grass") == 0)
      {
        type = 4.0;
      }
      else if (defendingType.compareTo("Fire") == 0)
      {
        type = 1.0;
      }
      else if (defendingType.compareTo("Rock") == 0)
      {
        type = 2.5;
      }
    }
    
    if (moveType.compareTo("Rock") == 0)
    {
      if (defendingType.compareTo("Electric") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Water") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Grass") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Fire") == 0)
      {
        type = 1.5;
      }
      else if (defendingType.compareTo("Rock") == 0)
      {
        type = 1.0;
      }
    }

    double mod = STAB * type * critical * randMod;  
    return mod;
  }
 
  public double HitOrMiss(Move attackMove, Pokemon defender) // HitOrMiss calculates to the probability that the Pokemon's attack will hit 
  {
    double probability;
    double moveAccuracy = attackMove.getMoveAccuracy();
    double pokemonAccuracy = getPokemonAccuracy();
    double pokemonEvasion = defender.getPokemonEvasion();
    double chance = .85;
    
    probability = moveAccuracy * (pokemonAccuracy / pokemonEvasion) * chance;
    
    return probability;
  }

  public int checkPriority(Pokemon computer) // This method checks to see which Pokemon will attack first. This returns 0 for the user's Pokemon and 1 for the computer's Pokemon.  
  {
    Move computerMove = computer.getCurrentMove();
    
    if (current.moveSpeed() > computerMove.moveSpeed())
    {
      return 0;
    }
    else if (current.moveSpeed() < computerMove.moveSpeed())
    {
      return 1;
    }

    if (getSpeed() > computer.speed)
    {
      return 0;
    }
    else if (getSpeed() < computer.speed)
    {
      return 1;
    }
    else
    {
      int num = rand.nextInt(12) + 1;
     
      if (num > 6)
      {
        return 0;
      }
      else
      {
        return 1;
      }
    }   
  }
  
  //--------------------------------------------------------------------
  // The following methods sort/search the Pokemon arrays. 
  //--------------------------------------------------------------------
  
  public static int indexOfPokemon(ArrayList<Pokemon> pokemon, String choice) // Searches the pokemon ArrayList for the index of a specific Pokemon
  {
    for (int i = 0; i < pokemon.size(); i++)
    {
      String temp = pokemon.get(i).getName();
      
      if (temp.equals(choice))
      {
        return i; 
      }
    }
    
    return -1;
  }
  
  public static Pokemon[] sortType(Pokemon[] pokemon) // Sorts an array of Pokemon objects by type
  {
    int min; // index of smallest element 
    Pokemon temp; // for swapping
    
    for (int i = 0; i < pokemon.length-1; i++)
    {
      min = i;
      
      for (int z = i+1; z < pokemon.length; z++)
      {
        if (pokemon[z].getType().compareTo(pokemon[min].getType()) < 0)
        {
          min = z;
        }
      }
      
      temp = pokemon[min];
      pokemon[min] = pokemon[i];
      pokemon[i] = temp;
    }
    return pokemon;
  }
  
  public static Pokemon[] sortAlphabet(Pokemon[] pokemon) // Sorts an array of Pokemon objects by alphabet
  {
    int min; // index of smallest element 
    Pokemon temp; // for swapping
    
    for (int i = 0; i < pokemon.length-1; i++)
    {
      min = i;
      
      for (int z = i+1; z < pokemon.length; z++)
      {
        if (pokemon[z].getName().compareTo(pokemon[min].getName()) < 0)
        {
          min = z;
        }
      }
      
      temp = pokemon[min];
      pokemon[min] = pokemon[i];
      pokemon[i] = temp;
    }
    
    return pokemon;
  }
}