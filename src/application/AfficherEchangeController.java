package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import Noyau.Bien;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AfficherEchangeController implements Initializable
{
    @FXML
    private Button retour;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private ImageView img;
    
    public void retourOnAction(ActionEvent event){
    	retour.getScene().getWindow().hide();
    }
    public void initialize(URL arg0, ResourceBundle arg1){   
    	Image image;
	           // Bien e=VisualiserfromAdminController.bien;
		Bien e = AdminSystemeController.e;
	    label9.setText(new Integer(e.getWillaya()).toString());
		label1.setText(e.getAdress_exct());
		label2.setText(new Double(e.getSuperficie()).toString());
		label3.setText(e.getProp().getPrenom()+" "+e.getProp().getNom());
			   
		if(e.isNegociable()){
		 	label7.setText("oui");
		}
		else {
			 label7.setText("non");
		}
		label8.setText(e.getDate().toString());
		label5.setText(new Long(e.getPrix()).toString()+" DA");
		label4.setText("echange");
		label6.setText(new Double(e.calculerPrixEchange(VisualiserEchangeController.wilaya)).toString()+"DA");
		try {
			image = new Image( new FileInputStream(e.getPhoto()));
			img.setImage(image);
		}
		catch (FileNotFoundException e1) {			
			e1.printStackTrace();
		}
    }
}