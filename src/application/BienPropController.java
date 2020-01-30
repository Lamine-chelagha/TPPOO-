package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import Noyau.Propritaire;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BienPropController implements Initializable {
   
    @FXML
    private Button Retour;
    @FXML
    private Label size;
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
    
    static int index=0;
    private Propritaire propr= new Propritaire();
    
    public void retourOnAction(ActionEvent event){
    	Retour.getScene().getWindow().hide();
    	
    }
    
    @SuppressWarnings("deprecation")
	public void nextOnAction(ActionEvent event){
    	
    	if(index+1<propr.getListebien().size()){
    		index++;
	    	size.setText("Nombre de biens: "+ new Integer(propr.getListebien().size()).toString());
	    	label9.setText(new Integer(propr.getListebien().get(index).getWillaya()).toString());
	    	label1.setText(propr.getListebien().get(index).getAdress_exct());
	    	label2.setText(new Double(propr.getListebien().get(index).getSuperficie()).toString());
	    	label3.setText(propr.getListebien().get(index).getProp().getPrenom()+" "+propr.getListebien().get(index).getProp().getNom());
		   
		    if(propr.getListebien().get(index).isNegociable()){
		    	label7.setText("oui");
		    }
		    else {
		    	label7.setText("non");
		    }
		    label8.setText(propr.getListebien().get(index).getDate().toString());
		    label5.setText(new Long(propr.getListebien().get(index).getPrix()).toString()+" DA");
		    switch(propr.getListebien().get(index).getNatureTrans()) {
		    	case "vente":
		    		label4.setText("vente");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixVente()).toString()+" DA");
			    	break;
		    	case "location":
		    		label4.setText("location");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixLocation()).toString()+"DA");
			    	break;
		    	case "echange":
		    		label4.setText("echange");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixEchange(2)).toString()+ "DA");
			    	break;
		    		
		    }
		    try {
		    	Image image;
				image = new Image( new FileInputStream(propr.getListebien().get(index).getPhoto()));
				img.setImage(image);
			}
		    catch (FileNotFoundException e1) {	
				e1.printStackTrace();
			}
    	}
    	else {
    		index=0;
    		label9.setText(new Integer(propr.getListebien().get(index).getWillaya()).toString());
	    	label1.setText(propr.getListebien().get(index).getAdress_exct());
	    	label2.setText(new Double(propr.getListebien().get(index).getSuperficie()).toString());
	    	label3.setText(propr.getListebien().get(index).getProp().getPrenom()+" "+propr.getListebien().get(index).getProp().getNom());
		   
		    if(propr.getListebien().get(index).isNegociable()){
		    	label7.setText("oui");
		    }
		    else {
		    	label7.setText("non");
		    }
		    label8.setText(propr.getListebien().get(index).getDate().toString());
		    label5.setText(new Long(propr.getListebien().get(index).getPrix()).toString()+" DA");
		    switch(propr.getListebien().get(index).getNatureTrans()) {
		    	case "vente":
		    		label4.setText("vente");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixVente()).toString()+" DA");
			    	break;
		    	case "location":
		    		label4.setText("location");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixLocation()).toString()+"DA");
			    	break;
		    	case "echange":
		    		label4.setText("echange");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixEchange(2)).toString()+ "DA");
			    	break;	
		    }
		    try {
		    	Image image;
				image = new Image( new FileInputStream(propr.getListebien().get(index).getPhoto()));
				img.setImage(image);
			}
		    catch (FileNotFoundException e1) {	
				e1.printStackTrace();
			}
    	}
    }
    @SuppressWarnings("deprecation")
	public void previousOnAction(ActionEvent event){
    	
    	if(index-1>=0)
    	{
    		index--;
    		size.setText("Nombre de biens:"+new Integer(propr.getListebien().size()).toString());
    		label9.setText(new Integer(propr.getListebien().get(index).getWillaya()).toString());
	    	label1.setText(propr.getListebien().get(index).getAdress_exct());
	    	label2.setText(new Double(propr.getListebien().get(index).getSuperficie()).toString());
	    	label3.setText(propr.getListebien().get(index).getProp().getPrenom()+" "+propr.getListebien().get(index).getProp().getNom());
		   
		    if(propr.getListebien().get(index).isNegociable()){
		    	label7.setText("oui");
		    }
		    else {
		    	label7.setText("non");
		    }
		    label8.setText(propr.getListebien().get(index).getDate().toString());
		    label5.setText(new Long(propr.getListebien().get(index).getPrix()).toString()+" DA");
		    switch(propr.getListebien().get(index).getNatureTrans()) {
		    	case "vente":
		    		label4.setText("vente");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixVente()).toString()+" DA");
			    	break;
		    	case "location":
		    		label4.setText("location");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixLocation()).toString()+"DA");
			    	break;
		    	case "echange":
		    		label4.setText("echange");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixEchange(2)).toString()+ "DA");
			    	break;
		    		
		    }
		    try {
		    	Image image;
				image = new Image( new FileInputStream(propr.getListebien().get(index).getPhoto()));
				img.setImage(image);
			}
		    catch (FileNotFoundException e1) {	
				e1.printStackTrace();
			}
    	}
    	else{
    		index=propr.getListebien().size() -1;
    		label9.setText(new Integer(propr.getListebien().get(index).getWillaya()).toString());
	    	label1.setText(propr.getListebien().get(index).getAdress_exct());
	    	label2.setText(new Double(propr.getListebien().get(index).getSuperficie()).toString());
	    	label3.setText(propr.getListebien().get(index).getProp().getPrenom()+" "+propr.getListebien().get(index).getProp().getNom());
		   
		    if(propr.getListebien().get(index).isNegociable()){
		    	label7.setText("oui");
		    }
		    else {
		    	label7.setText("non");
		    }
		    label8.setText(propr.getListebien().get(index).getDate().toString());
		    label5.setText(new Long(propr.getListebien().get(index).getPrix()).toString()+" DA");
		    switch(propr.getListebien().get(index).getNatureTrans()) {
		    	case "vente":
		    		label4.setText("vente");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixVente()).toString()+" DA");
			    	break;
		    	case "location":
		    		label4.setText("location");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixLocation()).toString()+"DA");
			    	break;
		    	case "echange":
		    		label4.setText("echange");
			    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixEchange(2)).toString()+ "DA");
			    	break;
		    		
		    }
		    try {
		    	Image image;
				image = new Image( new FileInputStream(propr.getListebien().get(index).getPhoto()));
				img.setImage(image);
			}
		    catch (FileNotFoundException e1) {	
				e1.printStackTrace();
			}
    	}
    }
    
	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		String compare=null;
	
		for(Propritaire e:AdminSystemeController.listProp){
			compare = e.getNom()+" "+e.getPrenom()+" "+e.getMail()+" "+e.getAdress();
			if(compare.equals(PropController.names.get(0))){
				propr=e;
			}
		}
		index=0;
		size.setText("Nombre de biens:"+new Integer(propr.getListebien().size()).toString());
		Image image;
		label9.setText(new Integer(propr.getListebien().get(index).getWillaya()).toString());
    	label1.setText(propr.getListebien().get(index).getAdress_exct());
    	label2.setText(new Double(propr.getListebien().get(index).getSuperficie()).toString());
    	label3.setText(propr.getListebien().get(index).getProp().getPrenom()+" "+propr.getListebien().get(index).getProp().getNom());
	   
	    if(propr.getListebien().get(index).isNegociable()){
	    	label7.setText("oui");
	    }
	    else {
	    	label7.setText("non");
	    }
	    label8.setText(propr.getListebien().get(index).getDate().toString());
	    label5.setText(new Long(propr.getListebien().get(index).getPrix()).toString()+" DA");
	    switch(propr.getListebien().get(index).getNatureTrans()) {
	    	case "vente":
	    		label4.setText("vente");
		    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixVente()).toString()+" DA");
		    	break;
	    	case "location":
	    		label4.setText("location");
		    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixLocation()).toString()+"DA");
		    	break;
	    	case "echange":
	    		label4.setText("echange");
		    	label6.setText(new Double(propr.getListebien().get(index).calculerPrixEchange(2)).toString()+ "DA");
		    	break;
	    		
	    }
	    try {
			image = new Image( new FileInputStream(propr.getListebien().get(index).getPhoto()));
			img.setImage(image);
		}
	    catch (FileNotFoundException e1) {	
			e1.printStackTrace();
		}
	}
}

