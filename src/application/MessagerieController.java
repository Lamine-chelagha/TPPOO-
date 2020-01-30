package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class MessagerieController implements Initializable
{
   @FXML
   private TextArea msg;
   static int index=0;
@Override
public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	
	msg.setText(AdminSystemeController.messagerie.get(index));
}
public void retourOnAction(ActionEvent event)
{
	msg.getScene().getWindow().hide();
}
   public void suivantOnAction(ActionEvent event)
   {
	  
	   if(index+1<AdminSystemeController.messagerie.size())
	   {
		   index++;
	   msg.setText(AdminSystemeController.messagerie.get(index));
	   }
	   else
	   {
		   index=0;
		   msg.setText(AdminSystemeController.messagerie.get(index));
		   
	   }
	   }
   public void precedentOnAction(ActionEvent event)
   {
	  
	   if(index-1>=0)
	   {
	    index--;
	   msg.setText(AdminSystemeController.messagerie.get(index));
	   }
	   else
	   {
		   index=AdminSystemeController.messagerie.size()-1;
		   msg.setText(AdminSystemeController.messagerie.get(index));
	   }
   }
}	
