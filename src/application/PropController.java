package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Noyau.Propritaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class PropController implements Initializable {
     @FXML
     private ListView<String> lview;
     static ObservableList<String> names=FXCollections.observableArrayList();
     ObservableList<String> li=FXCollections.observableArrayList();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		for(Propritaire e:AdminSystemeController.listProp)
		{
			li.add(e.getNom()+" "+e.getPrenom()+" "+e.getMail()+" "+e.getAdress());
		}
		
		lview.setItems(li);
	}
	 public void retourOnAction(ActionEvent event)
     {
    	lview.getScene().getWindow().hide();
     }
	 public void voirOnAction(ActionEvent event) throws IOException
	 {
		 names=lview.getSelectionModel().getSelectedItems();
		     Parent root=FXMLLoader.load(getClass().getResource("/application/BienProp.fxml"));
			Scene scene = new Scene(root,481,661);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
	 }
}
