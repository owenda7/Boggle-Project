import java.util.ArrayList;
public class Game extends Board
{
   Board board;
   Dictionary dict = new Dictionary("dictionary.txt");
   ArrayList<Tile> selectedTiles = new ArrayList<Tile>();
   ArrayList<String> words = new ArrayList<String>(); 
   int points=0;
   
   /**
   Constructor game creates new Board from Board Class
   Saves to class variable board
   */
   public Game()
   {
      board = new Board();
   }
   /**
   Method isValid Selection checks if int r and int c exist in index of ArrayList gameboard
   @param int r 
   @param int c
   */
   public boolean isValidSelection(int r, int c)
   {
      
      if (r<board.gameboard.size())
         if(c<board.gameboard.size())
            if(selectedTiles.isEmpty())
               return true;
            if(selectedTiles.get((selectedTiles.size()-1)).getRow() == r+1)
            {
               if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c+1)
                  return true;
               else if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c)
                  return true;
               else if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c-1)
                  return true;
            }
            if(selectedTiles.get((selectedTiles.size()-1)).getRow() == r)
            {
               if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c+1)
                  return true;
               else if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c-1)
                  return true;
            }
            if(selectedTiles.get((selectedTiles.size()-1)).getRow() == r-1)
            {
               if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c+1)
                  return true;
               else if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c)
                  return true;
               else if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c-1)
                  return true;
            }
      return false;
   }
   public boolean isValidDeselection(int r, int c)
   {
      if(selectedTiles.get((selectedTiles.size()-1)).getRow() == r)  
      {
         if(selectedTiles.get((selectedTiles.size()-1)).getCol() == c)
            return true;
      }
      return false;
         
   }
   /**
   Method addToSelected takes Tile at row r and column c and adds it to ArrayList selectedTiles
   @param int r 
   @param int c
   */
   public void addToSelected(int r, int c)
   {
      selectedTiles.add(board.gameboard.get(r).get(c));
   }
   /**
   Method getSelectedTiles returns ArrayList selectedTiles
   @return ArrayList selectedTiles
   */
   public ArrayList<Tile> getSelectedTiles()
   {
      return selectedTiles;
   }
   /**
   Method removeFromSelected takes Tile at row r and column c and removes it from ArrayList selectedTiles
   @param int r 
   @param int c
   */
   public void removeFromSelected(int r, int c)
   {
      selectedTiles.remove(board.gameboard.get(r).get(c));
   }
   /**
   Method testSelected checks if word in ArrayList selectedTiles is also in dictionary.txt
   */
   public boolean testSelected()
   {
      Word w = new Word(selectedTiles);
      
      for (int i=0; i<words.size(); i++)
      {
         if(w.toString().equals(words.get(i)))
            return false;
      }
      if (dict.isValidWord(selectedTiles))
      {
         words.add(w.toString());     
         points+=w.getPoints();
         selectedTiles.clear();
         return true;
      }
      selectedTiles.clear();
      return false;
      
            
   }
   /**
   Method getTile returns tile at index row r and column c
   @param int r 
   @param int c
   */
   public Tile getTile(int r, int c)
   {
      return board.gameboard.get(r).get(c);
   }
   /**
   Method removes all tiles from ArrayList selectedTiles
   */
   public void clearSelected()
   {
      selectedTiles.clear(); 
   }
   /**
   Method toString returns the gameboard as a sting in 4x4 format
   @Return String s
   */
   public String toString()
   {
      String s="";
      for (int r=0; r<4; r++)
      {
         //in each row, go through every element 
         for (int c=0; c<4; c++)
         {
            //add each letter to String gb
            s += board.gameboard.get(r).get(c);
         }
      }
      return s;  
   }
   public int getScore()
   {
      return points;
   }
}