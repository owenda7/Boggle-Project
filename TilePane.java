import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class TilePane extends HBox
{
   Tile t;
   boolean selected = false;
   Rectangle tile;
   Text letter; 
   StackPane tilepane;
   
   public TilePane(Tile t, Game g)
   {
      this.t = t;
      tile = new Rectangle();
      tile.setWidth(100);
      tile.setHeight(100);
      tile.setFill(Color.TRANSPARENT);
      tile.setStroke(Color.BLACK);
      letter = new Text(t.toString());
      letter.setFont(new Font(25));
      
      tile.addEventHandler(MouseEvent.MOUSE_PRESSED,
        new EventHandler<MouseEvent>() {
          public void handle(MouseEvent m) {
            if(selected==false)
            {
               if (g.isValidSelection(t.getRow(), t.getCol()))
               {
                 setSelected(g);
               }
               
            }
            else
            {
               if (g.isValidDeselection(t.getRow(), t.getCol()))
               {
                  setUnselected(g);
               }
            }
               
          }
        });
           
      tilepane = new StackPane(tile, letter);
      this.getChildren().add(tilepane);
      
   }
   
   public void setSelected(Game g)
   {
      g.addToSelected(t.getRow(), t.getCol());
      tile.setFill(Color.web("B1CCF1"));
      selected = true;
   }
   
   public void setUnselected(Game g)
   {
      g.removeFromSelected(t.getRow(), t.getCol());
      tile.setFill(Color.TRANSPARENT);
      selected = false; 
   }
   public boolean isSelected()
   {
      return selected;
   }
   
   
}