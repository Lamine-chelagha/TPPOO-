package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Noyau.Bien;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ListArchiveController implements Initializable {
   
    @FXML
    private Button retour;
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
    ArrayList<Bien> larch=  new ArrayList<Bien>();
    
    public void retourOnAction(ActionEvent event){
   		retour.getScene().getWindow().hide();
    }
    
    @SuppressWarnings("deprecation")
	public void nextOnAction(ActionEvent event){
    	if(index+1<larch.size()){
    		index++;
    		size.setText("Nombre de biens: "+new Integer(larch.size()).toString());
    		label9.setText(new Integer(larch.get(index).getWillaya()).toString());
    		label1.setText(larch.get(index).getAdress_exct());
    		label2.setText(new Double(larch.get(index).getSuperficie()).toString());
    		label3.setText(larch.get(index).getProp().getPrenom()+" "+larch.get(index).getProp().getNom());
	   
    		if(larch.get(index).isNegociable()){
    			label7.setText("oui");
    		}
    		else {
    			label7.setText("non");
    		}
    		label8.setText(larch.get(index).getDate().toString());
    		label5.setText(new Long(larch.get(index).getPrix()).toString()+" DA");
    		
    		switch(larch.get(index).getNatureTrans()) {
    			case "vente":
    				label4.setText("vente");
    			    label6.setText(new Double(larch.get(index).calculerPrixVente()).toString()+" DA");
    			    break;
    			case "location":
    				label4.setText("location");
    			    label6.setText(new Double(larch.get(index).calculerPrixLocation()).toString()+"DA");
    			    break;
    			case "echange":
    				label4.setText("echange");
    			    label6.setText(new Double(larch.get(index).calculerPrixEchange(2)).toString()+ "DA");
    		}
    	
	   	    try {
	   	    	Image image;
	   	    	image = new Image( new FileInputStream(larch.get(index).getPhoto()));
	   	    	img.setImage(image);
	   	    }
	   	    catch (FileNotFoundException e1) {
	   	    	e1.printStackTrace();
	   	    }

    	}
    	else {
    		index=0;
    		size.setText("Nombre de biens: "+new Integer(larch.size()).toString());
    		label9.setText(new Integer(larch.get(index).getWillaya()).toString());
    		label1.setText(larch.get(index).getAdress_exct());
    		label2.setText(new Double(larch.get(index).getSuperficie()).toString());
    		label3.setText(larch.get(index).getProp().getPrenom()+" "+larch.get(index).getProp().getNom());
	   
    		if(larch.get(index).isNegociable()){
    			label7.setText("oui");
    		}
    		else {
    			label7.setText("non");
    		}
    		label8.setText(larch.get(index).getDate().toString());
    		label5.setText(new Long(larch.get(index).getPrix()).toString()+" DA");
    		
    		switch(larch.get(index).getNatureTrans()) {
    			case "vente":
    				label4.setText("vente");
    			    label6.setText(new Double(larch.get(index).calculerPrixVente()).toString()+" DA");
    			    break;
    			case "location":
    				label4.setText("location");
    			    label6.setText(new Double(larch.get(index).calculerPrixLocation()).toString()+"DA");
    			    break;
    			case "echange":
    				label4.setText("echange");
    			    label6.setText(new Double(larch.get(index).calculerPrixEchange(2)).toString()+ "DA");
    		}
    	
	   	    try {
	   	    	Image image;
	   	    	image = new Image( new FileInputStream(larch.get(index).getPhoto()));
	   	    	img.setImage(image);
	   	    }
	   	    catch (FileNotFoundException e1) {
	   	    	e1.printStackTrace();
	   	    }

    	}
    }
    @SuppressWarnings("deprecation")
	public void previousOnAction(ActionEvent event){
    	if(index-1>=0){
    		index--;
    		size.setText("Nombre de biens: "+new Integer(larch.size()).toString());
    	
    		label9.setText(new Integer(larch.get(index).getWillaya()).toString());
    		label1.setText(larch.get(index).getAdress_exct());
    		label2.setText(new Double(larch.get(index).getSuperficie()).toString());
    		label3.setText(larch.get(index).getProp().getPrenom()+" "+larch.get(index).getProp().getNom());
	   
    		if(larch.get(index).isNegociable()){
    			label7.setText("oui");
    		}
    		else {
    			label7.setText("non");
    		}
    		label8.setText(larch.get(index).getDate().toString());
    		label5.setText(new Long(larch.get(index).getPrix()).toString()+" DA");
    		
    		switch(larch.get(index).getNatureTrans()) {
    			case "vente":
    				label4.setText("vente");
    			    label6.setText(new Double(larch.get(index).calculerPrixVente()).toString()+" DA");
    			    break;
    			case "location":
    				label4.setText("location");
    			    label6.setText(new Double(larch.get(index).calculerPrixLocation()).toString()+"DA");
    			    break;
    			case "echange":
    				label4.setText("echange");
    			    label6.setText(new Double(larch.get(index).calculerPrixEchange(2)).toString()+ "DA");
    		}
	   	    try {
	   	    	Image image;
	   	    	image = new Image( new FileInputStream(larch.get(index).getPhoto()));
	   	    	img.setImage(image);
	   	    }
	   	    catch (FileNotFoundException e1) {
	   	    	e1.printStackTrace();
	   	    }
    	}
    	else{
    		index=larch.size() -1;
    		size.setText("Nombre de biens: "+new Integer(larch.size()).toString());
    		label9.setText(new Integer(larch.get(index).getWillaya()).toString());
    		label1.setText(larch.get(index).getAdress_exct());
    		label2.setText(new Double(larch.get(index).getSuperficie()).toString());
    		label3.setText(larch.get(index).getProp().getPrenom()+" "+larch.get(index).getProp().getNom());
	   
    		if(larch.get(index).isNegociable()){
    			label7.setText("oui");
    		}
    		else {
    			label7.setText("non");
    		}
    		label8.setText(larch.get(index).getDate().toString());
    		label5.setText(new Long(larch.get(index).getPrix()).toString()+" DA");
    		
    		switch(larch.get(index).getNatureTrans()) {
    			case "vente":
    				label4.setText("vente");
    			    label6.setText(new Double(larch.get(index).calculerPrixVente()).toString()+" DA");
    			    break;
    			case "location":
    				label4.setText("location");
    			    label6.setText(new Double(larch.get(index).calculerPrixLocation()).toString()+"DA");
    			    break;
    			case "echange":
    				label4.setText("echange");
    			    label6.setText(new Double(larch.get(index).calculerPrixEchange(2)).toString()+ "DA");
    		}
    	
	   	    try {
	   	    	Image image;
	   	    	image = new Image( new FileInputStream(larch.get(index).getPhoto()));
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
		index=0;
		larch=RecupererFromFichier();
		if(larch.size()>0){
		size.setText("Nombre de biens: "+new Integer(larch.size()).toString());
		label9.setText(new Integer(larch.get(index).getWillaya()).toString());
		label1.setText(larch.get(index).getAdress_exct());
		label2.setText(new Double(larch.get(index).getSuperficie()).toString());
		label3.setText(larch.get(index).getProp().getPrenom()+" "+larch.get(index).getProp().getNom());
   
		if(larch.get(index).isNegociable()){
			label7.setText("oui");
		}
		else {
			label7.setText("non");
		}
		label8.setText(larch.get(index).getDate().toString());
		label5.setText(new Long(larch.get(index).getPrix()).toString()+" DA");
		
		switch(larch.get(index).getNatureTrans()) {
			case "vente":
				label4.setText("vente");
			    label6.setText(new Double(larch.get(index).calculerPrixVente()).toString()+" DA");
			    break;
			case "location":
				label4.setText("location");
			    label6.setText(new Double(larch.get(index).calculerPrixLocation()).toString()+"DA");
			    break;
			case "echange":
				label4.setText("echange");
			    label6.setText(new Double(larch.get(index).calculerPrixEchange(2)).toString()+ "DA");
		}
	
   	    try {
   	    	Image image;
   	    	image = new Image( new FileInputStream(larch.get(index).getPhoto()));
   	    	img.setImage(image);
   	    }
   	    catch (FileNotFoundException e1) {
   	    	e1.printStackTrace();
   	    }

		}
	}
	public ArrayList<Bien> RecupererFromFichier() {  
		ArrayList<Bien> li=  new ArrayList<Bien>();
		InputStream infile; 
		try {
			infile = new FileInputStream("Archives.bin");
			ObjectInputStream fi = new ObjectInputStream(infile);
			while(true){
				li.add((Bien)fi.readObject());
			}
	  
		} 
		catch (Exception e) {
	
		} 
		return li;
	}
	
}
