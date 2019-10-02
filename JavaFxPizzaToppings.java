/* JavaFXPizzaToppings
   Create a GUI with checkboxes and checkbox controls in a VBox, show in a scene and
   add totals of the the selected checboxes.
*/

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class JavaFxPizzaToppings extends Application
{
   //Fields
   CheckBox cheeseCheckBox;
   CheckBox anchoviesCheckBox;
   CheckBox jalepenoCheckBox;
   CheckBox pepperoniCheckBox;
   CheckBox sausageCheckBox;
   Label totalLabel;
   
   public static void main(String[] args)
   {
      launch(args);
   } //end main()
   
   @Override
   public void start(Stage pStage)
   {
      // create check box controls
      cheeseCheckBox = new CheckBox("Cheese $2.00");
      anchoviesCheckBox = new CheckBox("Anchovies $1.00");
      jalepenoCheckBox = new CheckBox("jalepenos $4.00");
      pepperoniCheckBox = new CheckBox("pepperoni $2.00");
      sausageCheckBox = new CheckBox("sausage $2.00");
      
      //Create a button control
      Button totalButton = new Button("Get Total");
      //Register the even handler with the button
      totalButton.setOnAction(new TotalButtonHandler());
      //Create a label for total
      totalLabel = new Label("$0.00");
      
      // Put the boxes in a VBox
      VBox checkBoxVBox = new VBox(10, cheeseCheckBox, anchoviesCheckBox, jalepenoCheckBox, pepperoniCheckBox, sausageCheckBox);
      // VBox for the root
      VBox mainVBox = new VBox(10, checkBoxVBox, totalButton, totalLabel);
      //Alignment and padding for mainVBox
      mainVBox.setAlignment(Pos.CENTER);
      mainVBox.setPadding(new Insets(10));
      //Create the scene and show it
      Scene scene = new Scene(mainVBox);
      pStage.setScene(scene);
      pStage.setTitle("Check box in JavaFX");
      pStage.show();
   } //end start()
   
   // Event handler
   class TotalButtonHandler implements EventHandler<ActionEvent>
   {
      @Override
      public void handle(ActionEvent event)
      {
         //Local variable for result
         double result=0;
         //Add toppings
         if (cheeseCheckBox.isSelected())
            result += 2.00;
         if (anchoviesCheckBox.isSelected())
            result += 1.00;
         if (jalepenoCheckBox.isSelected())
            result += 4.00;
         if (pepperoniCheckBox.isSelected())
            result += 2.00;
         if (sausageCheckBox.isSelected())
            result += 2.00;
                  
                  // displat the results
                  totalLabel.setText(String.format("$%,.2f", result));
      } //end handler
   } //end inner class
} //end class