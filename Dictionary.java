import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary
{
   private ArrayList<String> dictionary = new ArrayList<>();;
   Scanner dict;
   /**
   Constructor takes string containing file address containing dictionary
   each word in text file is then placed in 
   **/
   public Dictionary(String file)
   {
      //try to open file 
      try
      { 
         File infile = new File(file);
         dict = new Scanner(infile);
      }
      //catch if file not available (do nothing)
      catch(IOException exception) 
      {
      }
      //for every word in text file, add word to ArrayList dictionary
      while(dict.hasNext())
      {
         dictionary.add(dict.nextLine());  
      }
   }
   /**
   Method checks if word guessed is in Array dictionary
   @param ArrayList tiles
   @return boolean  
   **/
   public boolean isValidWord(ArrayList<Tile> tiles)
   {
      String guess="";
      //get the word guessed
      for(int i=0 ; i<tiles.size(); i++ )
      {
         guess+=tiles.get(i);
      }
      //check if word is in Arraylist dictionary
      for (int i=0; i<dictionary.size(); i++)
      {
         if(guess.equalsIgnoreCase(dictionary.get(i)))
            return true;
      }
      return false;
   }
   
}