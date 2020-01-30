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

public class VisualiserController implements Initializable{
	@FXML
     private Button rtr;
     @FXML
     private Label lbl1;
     @FXML
     private Label lbl2;
     @FXML
     private Label lbl3;
     @FXML
     private Label lbl4;
     @FXML
     private Label lbl5;
     @FXML
     private Label lbl6;
     @FXML
     private Label lbl7;
     @FXML
     private Label lbl8;
     @FXML
     private Label lbl9;
     @FXML
     private ImageView img;
     
     public void retourOnAction(ActionEvent event)
     {
    	rtr.getScene().getWindow().hide();
     }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1)
	{    Image image;
	
		 String nme=SystemeController.names.get(0);
		 for(Bien e:SystemeController.biens)
		 {   
			 
			 if( nme.equals(e.getDescription()))
			 {
				 lbl9.setText(new Integer(e.getWillaya()).toString());
				    lbl1.setText(e.getAdress_exct());
				    lbl2.setText(new Double(e.getSuperficie()).toString());
				    lbl3.setText(e.getProp().getPrenom()+" "+e.getProp().getNom());
				   
				    if(e.isNegociable())
				       {lbl7.setText("oui");}
				    if(!e.isNegociable())
				    {lbl7.setText("non");}
				    lbl8.setText(e.getDate().toString());
				    lbl5.setText(new Long(e.getPrix()).toString()+" DA");
				    if(e.getNatureTrans().equals("vente"))
				    {
				    	lbl4.setText("vente");
				    lbl6.setText(new Double(e.calculerPrixVente()).toString()+" DA");
				    }
				    if(e.getNatureTrans().equals("location"))
				    {
				    	lbl4.setText("location");
				    lbl6.setText(new Double(e.calculerPrixLocation()).toString()+"DA");
				    }
				    try {
						image = new Image( new FileInputStream(e.getPhoto()));
						img.setImage(image);
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
			 }
		 }
	}
     
}
