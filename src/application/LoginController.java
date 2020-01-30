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

public class LoginController {
    @FXML
    private PasswordField password;
    @FXML
    private TextField userName;
    @FXML
    private Label message;
    @FXML
    private static String utilisateur;
	
    public static String getUtilisa() {
		return utilisateur;
	}
	private Utilisateur use =new Utilisateur();
	
	public void loginOnAction(ActionEvent event) throws IOException {
		if(!userName.getText().equals("") && !password.getText().equals("")){
			if(use.login(userName.getText(), password.getText())){
				utilisateur = userName.getText();	
				userName.getScene().getWindow().hide();	
				Parent root=FXMLLoader.load(getClass().getResource("/application/Systeme.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage=new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
			}
			else{
				userName.setText("");
				password.setText("");
				message.setText("user name/mot de pass: incorrecte!");
			}
		}
		else {
			message.setText("Entrer le user name/mot de pass!!!");
		}
	}
	
	public void registerOnAction(ActionEvent event) throws IOException{
		userName.getScene().getWindow().hide();	
		Parent root=FXMLLoader.load(getClass().getResource("/application/CreationCompte.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
	}
	public void AdminOnAction(ActionEvent event) throws IOException{
		userName.getScene().getWindow().hide();	
		Parent root=FXMLLoader.load(getClass().getResource("/application/Admin.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage=new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public void Quiter(ActionEvent event) {
		Stage sauvStage = (Stage) message.getScene().getWindow();
		sauvStage.close();
	}

}
