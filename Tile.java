
public class Tile
{
   private String letter_showing; 
   private int row;
   private int column;
   private boolean selected;
   
   /**
   Constructor sets private variables letter_showing, row, and column
   @param String letter_showing
   @param int row
   @param int column
   **/
   public Tile(String letter_showing, int row, int column)
   {
      //sets class variables to constructor inputs
      this.letter_showing = letter_showing;
      this.row = row;
      this.column = column; 
   }
   /**
   Alternate constructor sets variables letter_showing, row, and column
   @param char letter_showing
   @param int row
   @param int column
   **/
   public Tile(char letter_showing, int row, int column)
   {
      //sets class variables to constructor inputs
      this.letter_showing = Character.toString(letter_showing);
      this.row = row;
      this.column = column; 
   }
   /**
   Method getLetter returns string letter_showing
   @return String letter_showing
   **/
   public String getLetter()
   {
      return letter_showing;
   }
   /**
   Method getLetter returns int row
   @return int row
   **/
   public int getRow()
   {
      return row;
   }
   /**
   Method getLetter returns int column
   @return int column
   **/
   public int getCol()
   {
      return column;
   }  
   /**
   Method converts object name to string letter_showing
   Overrides toString method
   @return String letter_showing
   **/
   @Override
   public String toString()
   {
      return letter_showing;
   } 

   
}