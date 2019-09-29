import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.*;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import java.util.Timer;
import java.util.TimerTask;

public class BoggleGUI extends Application
{
   public void start(Stage stage)
   {
      //Give Stage a title
      stage.setTitle("Owen's Boggle Game");
      //Create new game
      Game game = new Game();
      //GridPane for the main board
      GridPane gp = new GridPane();
      gp.setAlignment(Pos.CENTER);
      //VBox for list of corrext words guessed
      VBox left_elements = new VBox();
      left_elements.setPadding(new Insets(15, 12, 15, 12));
      //HBox for all buttons
      HBox button_box = new HBox();
      //BoarderPane to place all game elements in Scene
      BorderPane game_elements = new BorderPane();
      //Create Title
      Text title = new Text("    Owen's Boggle Game"); 
      title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
      HBox title_pane = new HBox(title);
      title_pane.setPadding(new Insets(15, 12, 15, 12));
      title_pane.setAlignment(Pos.CENTER);
      title_pane.setStyle("-fx-background-color: #B1CCF1;");
      
      //Create Word list for correct words guessed
      Text header = new Text("\n\nWords Guessed:");
      header.setFont(Font.font("Arial", FontWeight.BOLD, 18));
      left_elements.getChildren().add(header);
      
      //Create Scoreboard
      Text scoreboard = new Text("\n\n\nScore: "+game.getScore()+"      ");
      scoreboard.setFont(Font.font("Arial", FontWeight.BOLD, 18));
      scoreboard.setTextAlignment(TextAlignment.LEFT);
      
      
      
      //Create Tile objects
      Tile t1 = new Tile(game.board.gameboard.get(0).get(0).toString(),0,0);
      Tile t2 = new Tile(game.board.gameboard.get(0).get(1).toString(),0,1);
      Tile t3 = new Tile(game.board.gameboard.get(0).get(2).toString(),0,2);
      Tile t4 = new Tile(game.board.gameboard.get(0).get(3).toString(),0,3);
      Tile t5 = new Tile(game.board.gameboard.get(1).get(0).toString(),1,0);
      Tile t6 = new Tile(game.board.gameboard.get(1).get(1).toString(),1,1);
      Tile t7 = new Tile(game.board.gameboard.get(1).get(2).toString(),1,2);
      Tile t8 = new Tile(game.board.gameboard.get(1).get(3).toString(),1,3);
      Tile t9 = new Tile(game.board.gameboard.get(2).get(0).toString(),2,0);
      Tile t10 = new Tile(game.board.gameboard.get(2).get(1).toString(),2,1);
      Tile t11 = new Tile(game.board.gameboard.get(2).get(2).toString(),2,2);
      Tile t12 = new Tile(game.board.gameboard.get(2).get(3).toString(),2,3);
      Tile t13 = new Tile(game.board.gameboard.get(3).get(0).toString(),3,0);
      Tile t14 = new Tile(game.board.gameboard.get(3).get(1).toString(),3,1);
      Tile t15 = new Tile(game.board.gameboard.get(3).get(2).toString(),3,2);
      Tile t16 = new Tile(game.board.gameboard.get(3).get(3).toString(),3,3);
      
      
      //Create Tile Pane Objects
      TilePane tp1 = new TilePane(t1,game);
      TilePane tp2 = new TilePane(t2,game);   
      TilePane tp3 = new TilePane(t3,game);
      TilePane tp4 = new TilePane(t4,game);
      TilePane tp5 = new TilePane(t5,game);
      TilePane tp6 = new TilePane(t6,game);   
      TilePane tp7 = new TilePane(t7,game);
      TilePane tp8 = new TilePane(t8,game);
      TilePane tp9 = new TilePane(t9,game);
      TilePane tp10 = new TilePane(t10,game);   
      TilePane tp11 = new TilePane(t11,game);
      TilePane tp12 = new TilePane(t12,game);
      TilePane tp13 = new TilePane(t13,game);
      TilePane tp14 = new TilePane(t14,game);   
      TilePane tp15 = new TilePane(t15,game);
      TilePane tp16 = new TilePane(t16,game);
      
      //Place TilePane Objects on GridPane
      gp.add(tp1,0,0);
      gp.add(tp2,0,1);
      gp.add(tp3,0,2);
      gp.add(tp4,0,3);
      gp.add(tp5,1,0);
      gp.add(tp6,1,1);
      gp.add(tp7,1,2);
      gp.add(tp8,1,3);
      gp.add(tp9,2,0);
      gp.add(tp10,2,1);
      gp.add(tp11,2,2);
      gp.add(tp12,2,3);
      gp.add(tp13,3,0);
      gp.add(tp14,3,1);
      gp.add(tp15,3,2);
      gp.add(tp16,3,3);
      
      
      //END GAME SCENE
      
      
      //**GAME BUTTONS**
       
      // Clear Selection Button: Button deselects all tiles in game
      Button clear = new Button("Clear Selections");
      clear.setOnAction(new EventHandler<ActionEvent>() {
         @Override 
         public void handle(ActionEvent e) 
         {
            //Unselect all tiles
            tp1.setUnselected(game);
            tp2.setUnselected(game);
            tp3.setUnselected(game);
            tp4.setUnselected(game);
            tp5.setUnselected(game);
            tp6.setUnselected(game);
            tp7.setUnselected(game);
            tp8.setUnselected(game);
            tp9.setUnselected(game);
            tp10.setUnselected(game);
            tp11.setUnselected(game);
            tp12.setUnselected(game);
            tp13.setUnselected(game);
            tp14.setUnselected(game);
            tp15.setUnselected(game);
            tp16.setUnselected(game);
         }
      });
      
     //Check Word Button: Checks if word is valid, clears selections, and adds valid words to correct word list
      Button test = new Button("Check Word");
      test.setOnAction(new EventHandler<ActionEvent>() {
         @Override 
         public void handle(ActionEvent e) 
         {   
            boolean valid=false;
            //check of selected is valid 
            valid = game.testSelected(); 
            //unselect all tiles 
            tp1.setUnselected(game);
            tp2.setUnselected(game);
            tp3.setUnselected(game);
            tp4.setUnselected(game);
            tp5.setUnselected(game);
            tp6.setUnselected(game);
            tp7.setUnselected(game);
            tp8.setUnselected(game);
            tp9.setUnselected(game);
            tp10.setUnselected(game);
            tp11.setUnselected(game);
            tp12.setUnselected(game);
            tp13.setUnselected(game);
            tp14.setUnselected(game);
            tp15.setUnselected(game);
            tp16.setUnselected(game);
            
            //if word is valid, do the following
            if(valid==true)
            {
               //add word to correct word list
               Text correct_words = new Text("     "+game.words.get(game.words.size()-1));
               correct_words.setFont(Font.font("Arial", 16));
               left_elements.getChildren().add(correct_words);
               //update score
               Text scoreboard = new Text("\n\n\nScore: "+game.getScore()+"      ");
               scoreboard.setFont(Font.font("Arial", FontWeight.BOLD, 18));
               game_elements.setRight(scoreboard);
            }
         }
      });
      
      // End Game Button: Takes game to end scene
      Button end = new Button("End Game");
      end.setOnAction(new EventHandler<ActionEvent>() {
         @Override 
         public void handle(ActionEvent e) 
         {
            //Create endgame message and format
            Text message = new Text("Game Over!\nFinal Score: "+game.getScore());
            message.setTextAlignment(TextAlignment.CENTER);
            message.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            //create VBox and add message
            VBox end_message = new VBox();
            end_message.setAlignment(Pos.CENTER);
            end_message.getChildren().add(message);
            //create new scene for endpage
            Scene end_page = new Scene(end_message,750,550);
            //show new scene
            stage.setScene(end_page);
         }
      });
      
      //Add buttons to HBox and format
      button_box.getChildren().addAll(test, clear, end);
      button_box.setPadding(new Insets(15, 12, 15, 12));
      button_box.setSpacing(10);
      button_box.setStyle("-fx-background-color: #B1CCF1;");
      button_box.setAlignment(Pos.CENTER);
            
      //Add all elements to BorderPane
      game_elements.setTop(title_pane);
      game_elements.setLeft(left_elements);
      game_elements.setRight(scoreboard);
      game_elements.setCenter(gp);
      game_elements.setBottom(button_box);
      
      //Add BorderPane game_elements to scene
      Scene scene = new Scene(game_elements,750,550);
     
      //add scene to stage
      stage.setScene(scene);
      //show stage
      stage.show();
   }
   
   public static void main(String [] args)
   {
      launch(args);
   }
}