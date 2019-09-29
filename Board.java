import java.util.ArrayList;
import java.util.Random;

public class Board
{
   Random r = new Random();
   ArrayList<String> dice = new ArrayList<String>();
   ArrayList<ArrayList<Tile>> gameboard = new ArrayList<>();
   
   /**
   Constructor creates gameboard with 4 rows each containing a column of 4 tiles
   Constructor runs resetDice method to place random letter in each gameboard space
   **/
   public Board()
   {
      //run resetDice method
      resetDice();
      
      //create board
      //loop for 4 rows
      for(int r=0; r<4; r++)
      {
         //create new row
         ArrayList<Tile> row = new ArrayList<Tile>();
         //run through each element in the row
         for(int c=0; c<4; c++)
         {
            //create tile with row and column indicies and a random letter 
            Tile tile = new Tile(roll(), r, c);
            //add tile to row
            row.add(tile);
         }
         //add row to gameboard
         gameboard.add(row);
      }
   }
   /**
   Method resetDice adds Strings containing letters on dice to each item in ArrayList dice 
   **/
   public void resetDice()
   {
      dice.add("RIFOBX");
      dice.add("IFEHEY");
      dice.add("DENOWS");
      dice.add("UTOKND");
      dice.add("HMSRAO");
      dice.add("LUPETS");
      dice.add("ACITOA");
      dice.add("YLGKUE");
      dice.add("QuBMJOA");
      dice.add("EHISPN");
      dice.add("VETIGN");
      dice.add("BALIYT");
      dice.add("EZAVND");
      dice.add("RALESC");
      dice.add("UWILRG");
      dice.add("PACEMD");   
   }
   /**
   Method chooses random letter from a random die in ArrayList dice
   dice object is removed from ArrayList dice
   repeated until no more dice objects are left in ArrayList dice
   @return String letter
   **/
   public String roll()
   {
      String letter="";
      
      //get random index of remaining dice in ArrayList dice
      int dieIndex = r.nextInt(dice.size());
      //get the String at dieIndex in ArrayList dice
      String die = dice.get(dieIndex);
      //get random index of letter in String die
      int letterIndex = r.nextInt(die.length());
      //if String die length is 7, there must be a Qu in the string
      if (die.length()==7)
      {
         //Q is located at index 0, and u is located at index 1
         //if Q is selected, add u as well
         if (letterIndex==0)
         {
            letter += Character.toString(die.charAt(letterIndex));
            letter += Character.toString(die.charAt(letterIndex+1));
         }
         //if u is selected, add the next letter in the String instead
         else if (letterIndex==1)
         {
            letter += Character.toString(die.charAt(letterIndex+1));
         }
         else
         {
            letter += Character.toString(die.charAt(letterIndex));
         }      
      }
      //If the String does not contain Qu, add letter at index
      else
      {
         letter += Character.toString(die.charAt(letterIndex));
      }
      //remove selected die from ArrayList dice so it cant be chosen twice
      dice.remove(dieIndex);
      return letter;
   }
   /**
   Method overrides toString method
   @return String gameboard
   **/
   @Override
   public String toString()
   {
      String gb = "";
      //go through all rows
      for (int r=0; r<4; r++)
      {
         //in each row, go through every element 
         for (int c=0; c<4; c++)
         {
            //add each letter to String gb
            gb += gameboard.get(r).get(c);
         }
      }
      return gb;
   }
}