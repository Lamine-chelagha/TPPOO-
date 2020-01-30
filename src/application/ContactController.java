package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

public class ContactController implements Initializable{
    @FXML
    private TextArea message;
    static	ArrayList<String> messagerie=  new ArrayList<String>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void retourOnAction(ActionEvent event){
		message.getScene().getWindow().hide();
	}
	
	public void effacerOnAction(ActionEvent event){
		message.setText("");
	}
	
	public void envoyerOnAction(ActionEvent event){
		InputStream infile; 
		try {
			infile = new FileInputStream("MesssagerieClientel.bin");
			ObjectInputStream fi= new ObjectInputStream(infile);
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Succes!");
            alert.setContentText("Merci! Votre message a été bien eenvoyé!");
            alert.setHeaderText(null);
            alert.showAndWait();
            message.getScene().getWindow().hide();
			while(true){ 
				messagerie.add((String)fi.readObject());
			}
			
			//fi.close();
		} 
		catch (Exception e) {
			
		} 
		
		String newMessage=message.getText();
		messagerie.add(newMessage);
		new File("MesssagerieClientel.bin").delete();
		
		OutputStream outfile;
		try {
			outfile = new FileOutputStream("MesssagerieClientel.bin");
			ObjectOutputStream fi= new ObjectOutputStream(outfile);
			for(String e:messagerie){
				fi.writeObject(e);
			}
			fi.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		messagerie.clear();
		message.setText("");
	}
} 
