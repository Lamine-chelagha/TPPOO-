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

public class CreateAccountController {
    @FXML
	private TextField name;
    @FXML
    private TextField lastName;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField confirmpassword;
    @FXML
    private Utilisateur utilisateur=new Utilisateur();
    @FXML
    private Label label;
    
	public void loginOnAction(ActionEvent event) throws IOException{
		lastName.getScene().getWindow().hide();	
		Stage primaryStage= new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);	
	}
	
	public void confirmOnAction() throws IOException{
		if(!name.getText().equals("") && !lastName.getText().equals("") &&!userName.getText().equals("") &&!password.getText().equals("")){
			if(password.getText().equals(confirmpassword.getText())){
				if(!utilisateur.login(userName.getText())){
					
					utilisateur.signUp(name.getText(),lastName.getText() , userName.getText(), password.getText());	
					lastName.getScene().getWindow().hide();
					Parent root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage=new Stage();
					primaryStage.setScene(scene);
					primaryStage.show();
					primaryStage.setResizable(false);
				
				}
				else {
					label.setText("user name existe deja!");
				}
			}
			else{
				label.setText("mot de pass :incorrecte!");
			}
		}
		else {
			label.setText("vous devez remplir les champs indiqués!");
		}
	}
}
