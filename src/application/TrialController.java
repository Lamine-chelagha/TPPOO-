package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class TrialController 
{
	@FXML
    public ListView<Items> lview;
	
	   
   public void addOnAction()
   { 
	  Button btn = new Button("Visualiser"); 
	  Items ob=new Items("description",btn);  
	   ObservableList<Items> list=FXCollections.observableArrayList(ob);
	   lview.setItems(list);	   
   }
}
