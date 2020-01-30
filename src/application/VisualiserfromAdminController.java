package application;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import Noyau.Bien;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class VisualiserfromAdminController implements Initializable
{     @FXML
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
     
     public void retourOnAction(ActionEvent event){
    	rtr.getScene().getWindow().hide();
     }
     
	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1){    
		Image image;
		Bien e = null;
		String nme=AdminSystemeController.names.get(0);
		 
		for(Bien e1:AdminSystemeController.biens){   
			 if( nme.equals(e1.getDescription())){  
				 e=e1;
			 }
		 }
		
		if(!e.getNatureTrans().equals("echange")){
		   lbl9.setText(new Integer(e.getWillaya()).toString());
		   lbl1.setText(e.getAdress_exct());
		   lbl2.setText(new Double(e.getSuperficie()).toString());
		   lbl3.setText(e.getProp().getPrenom()+" "+e.getProp().getNom());
		  
		   if(e.isNegociable()){
			   lbl7.setText("oui");
		   }
		   else {
			   lbl7.setText("non");
		   }
		   lbl8.setText(e.getDate().toString());
		   lbl5.setText(new Long(e.getPrix()).toString()+" DA");
		   switch(e.getNatureTrans()) {
				case "vente":
					lbl4.setText("vente");
				    lbl6.setText(new Double(e.calculerPrixVente()).toString()+" DA");
				    break;
				case "location":
					lbl4.setText("location");
				    lbl6.setText(new Double(e.calculerPrixLocation()).toString()+"DA");
				    break;
				case "echange":
					lbl4.setText("echange");
				    lbl6.setText(new Double(e.calculerPrixEchange(2)).toString()+ "DA");
		   	}
		   
		   
		    try {
				image = new Image( new FileInputStream(e.getPhoto()));
				img.setImage(image);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
		 }
		
		/* else
		 {   System.out.println(e.getDescription());
			 bien=e;
			 Parent root;
			try {
				root = FXMLLoader.load(getClass().getResource("/application/VisualiserEchange.fxml"));
				Scene scene = new Scene(root,415,639);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				Stage primaryStage = new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
				
		 }*/
		 
	}
     
}
