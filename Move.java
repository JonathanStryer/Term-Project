/* 
 * Move.java
 * Jonathan Stryer
 * ECS 102 - M002
 * Term Project
 * 
 * This class allows you to create an object for a Pokemon move. 
*/ 

public class Move
{
  private String moveName; // Name of Move 
  private String moveType; // Name of Move type
  private int moveSpeed; // Integer for Move speed
  private double accuracy; // Double for Move accuracy 
  private boolean special; // Boolean special (If true: Move object is specialAtk)
  private int baseDmg; // Integer for the base damage of the Move object
  
  public Move(String initMoveName, String initMoveType, int initMoveSpeed, double initaccuracy, boolean initSpecial, int initBaseDmg) // Constructor for Move object
  {
    // Sets the instance variables based on what is passed through the parameters
    moveName = initMoveName; 
    moveType = initMoveType;
    moveSpeed = initMoveSpeed;
    accuracy = initaccuracy;
    special = initSpecial;
    baseDmg = initBaseDmg;
  }
  
  //-------------------------------------------------------------------//
  // The following methods return instance variables of the Move object.
  //-------------------------------------------------------------------//
  
  public int moveSpeed() // returns moveSpeed
  {
    return moveSpeed;
  }
  
  public double getMoveAccuracy() // returns accuracy
  {
    return accuracy;
  }
  
  public String getMoveName() // returns moveName
  {
    return moveName;
  }
  
  public String getMoveType() // returns moveType
  {
    return moveType;
  }
  
  public boolean isSpecial() // returns true if Move is a Special Attack // returns false if Move is not a Special Attack 
  {
    return special;
  }
  
  public int getBaseDmg() // returns base damage of Move object 
  {
    return baseDmg;
  }
}