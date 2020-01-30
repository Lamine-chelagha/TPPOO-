package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController
{
	@FXML
	private TextField userName ;
	@FXML
	private PasswordField password;
	@FXML
	private Label label;
	@FXML
	private Administrateur admin=new Administrateur();
	public void registerOnAction(ActionEvent event) throws IOException{
		if(admin.login(userName.getText(), password.getText())){
		password.getScene().getWindow().hide();
		Parent root=FXMLLoader.load(getClass().getResource("/application/AdminSysteme.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		}
		else{
			userName.setText("");
			password.setText("");
			label.setText("Admin name/Mot de pass :incorrecte!");	
		}
	}

}
	
