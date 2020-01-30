package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ChoisirTypeBienController {
   @FXML
   private Button RetourBtn ;
   

	public void maisonChoice(ActionEvent event) throws Exception{
		Stage primaryStage = new Stage() ;
		Parent root=FXMLLoader.load(getClass().getResource("/application/MaisonAjout.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ajouter une Maison");
		primaryStage.show();
		primaryStage.setResizable(false);
		Stage sauvStage = (Stage) RetourBtn.getScene().getWindow();
		sauvStage.close();
	}
	
	public void appartChoice (ActionEvent event) throws Exception{
		Stage primaryStage = new Stage() ;
		Parent root=FXMLLoader.load(getClass().getResource("/application/AppartAjout.fxml"));
		Scene scene = new Scene(root);
		//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ajouter une Appartemment");
		primaryStage.show();
		primaryStage.setResizable(false);
		Stage sauvStage = (Stage) RetourBtn.getScene().getWindow();
		sauvStage.close();
	}
	
	public void TerrainChoice (ActionEvent event) throws Exception{
		Stage primaryStage = new Stage() ;
		Parent root=FXMLLoader.load(getClass().getResource("/application/InHabitableAjout.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Ajouter une Terrain");
		primaryStage.show();
		primaryStage.setResizable(false);
		Stage sauvStage = (Stage) RetourBtn.getScene().getWindow();
		sauvStage.close();
	}
	
	public void retour (){
		Stage sauvStage = (Stage) RetourBtn.getScene().getWindow();
		sauvStage.close();
	}
	
}
