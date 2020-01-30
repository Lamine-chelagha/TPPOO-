package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Noyau.Bien;
import Noyau.Systeme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class SousChoixController implements Initializable {
    static int choix;
    @FXML
	private ComboBox<String> combo;
	ObservableList<String> wilaya=FXCollections.observableArrayList();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		for(int i=0;i<48;i++){
			wilaya.add(new Integer(i+1).toString());
		}
		combo.setItems(wilaya);
	}
    public void comboOnAction(ActionEvent event) throws IOException{
    	String type = combo.getValue();
    	choix= Integer.parseInt(type);
    	System.out.println(choix);
    	Systeme sys=new Systeme();
    	  
    	if(SousChoixController.choix<48){
    		sys.setListedesBien(AdminSystemeController.biens);
    		   
	        AdminSystemeController.filter=sys.filtrer(AdminSystemeController.type,choix);
	        for(Bien e:sys.filtrer(AdminSystemeController.type,choix)){
	    	   	System.out.println(e.getDescription());
	    	}
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
	 			 a.setTitle("Erreur!");
	 			 a.setContentText("Erreur! Aucun Bien Correspond à votre recherche!");
	 			 a.setHeaderText(null);
	 			 a.showAndWait();
	 		 }
	   }
   }
    public void retour() {
		Stage sauvStage = (Stage) combo.getScene().getWindow();
		sauvStage.close();
	}
}
