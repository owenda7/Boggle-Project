import java.util.ArrayList;
public class Word
{
   private String word="";
   private int points;
   private int letters;
   /**
   Constructor tkes input of Array List containing letter selected
   turns ArrayList into String then runs setPoints Method
   **/
   public Word(ArrayList<Tile> tiles)
   {
      //loop through for each ArrayList item
      for(int i=0 ; i<tiles.size(); i++ )
      {
         //Add letter to word
         word+=tiles.get(i);
         //Check if letter is Qu
         if(tiles.get(i).toString().equals("qu"))
            //Add two to counter
            letters+=2;
         //For ever other letter add one to counter
         else
            letters++;
      }
      //run setPoints method
      setPoints();
   }
   /**
   Method setPoints takes String word and sets variable points based on length of word
   **/
   public void setPoints()
   {
      // 1 point for 3 or 4 letter words 
      if(letters==3 || letters==4 )
         points=1;
      //2 points for 5 letter words
      else if(letters==5)
         points=2;
      //3 points for 6 letter words  
      else if(letters==6)
         points=3;
      //5 points for 7 letter words
      else if(letters==7)
         points=5;
      //11 points for 7 letter words or greater
      else if(letters>7)
         points=11;
   }
   /**
   Method returns points
   @return int points
   **/
   public int getPoints()
   {
      return points; 
   }
   /**
   Method overrides toString method
   @return String word
   **/
   @Override
   public String toString()
   {
      return word;
   }
   
}