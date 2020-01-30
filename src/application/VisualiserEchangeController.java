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

public class VisualiserEchangeController
{
	@FXML
	private TextField prix;
	static int wilaya;
	public void confirmOnAction(ActionEvent event) throws IOException
	{
		String wil=prix.getText();
	    wilaya=Integer.parseInt(wil);
	   
	     Parent  root = FXMLLoader.load(getClass().getResource("/application/AfficherEchange.fxml"));
		Scene scene = new Scene(root,415,639);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);

	}
}
