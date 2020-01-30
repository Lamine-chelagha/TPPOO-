package application;

import java.io.IOException;

import Noyau.Systeme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SousChoix3Controller {

	@FXML
	private TextField prix;
	
	public void confirmOnAction(ActionEvent event) throws IOException{
		String price=prix.getText();
		int lePrix=Integer.parseInt(price);
		
		Systeme sys=new Systeme();
		
		 sys.setListedesBien(AdminSystemeController.biens);
		   
     	AdminSystemeController.filter=sys.filtrer(AdminSystemeController.type,lePrix);
     	
     	if(AdminSystemeController.filter.size()>0){
	            Parent root=FXMLLoader.load(getClass().getResource("/application/Filtrer.fxml"));
		        Scene scene = new Scene(root);
		        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        Stage primaryStage = new Stage();
		        primaryStage.setScene(scene);
		         primaryStage.show();
		          primaryStage.setResizable(false);
	    	}
	    	else {
	    		Alert a= new Alert(Alert.AlertType.WARNING);
	    		a.setTitle("Erreur");
	    		a.setContentText("Erreur!Aucun Bien Correspond à votre recherche!");
	    		a.setHeaderText(null);
	    		a.showAndWait();
	    	}
	}
	public void retour() {
		Stage sauvStage = (Stage) prix.getScene().getWindow();
		sauvStage.close();
	}

	
}
