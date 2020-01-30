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
import java.util.Date;
import java.util.ResourceBundle;

import Noyau.Bien;
import Noyau.Inhabitable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ModifierInhabitableController implements Initializable {
	
	@FXML
	private TextField adress_exct ;
	
	@FXML
	private ComboBox<String> wilayachek ;
	
	@FXML
	private TextField superficiefield ;

	@FXML
	private ComboBox<String> typetransfield ;
	
	@FXML
	private TextField prixfield ;
	
	@FXML
	private ComboBox<Boolean> negofield ;
	
	@FXML
	private TextField statjuridiquefield ;
	
	@FXML
	private TextArea descripfield ; 
	
	@FXML
	private ComboBox<String> nbfacadefield ;
	
	ObservableList<String> listeWilaya = FXCollections.observableArrayList("1","2","3","4","5") ; 
	ObservableList<Boolean> listbool = FXCollections.observableArrayList(true,false) ;
	ObservableList<String> transac = FXCollections.observableArrayList("vente","location","echange") ; 
	
	private Inhabitable bienPourInial ;
	
	
	public void Modifier ( ActionEvent event ) 
	{
		bienPourInial = (Inhabitable) AdminSystemeController.bienTmp ; 
		
		if ( !adress_exct.getText().equals("") ) // si le champs n est pas vide (donc il est modifier)
		{
			bienPourInial.setAdress_exct(adress_exct.getText());
		}
		

		if ( !wilayachek.getValue().equals("") )
		{		
			bienPourInial.setWillaya(Integer.parseInt( wilayachek.getValue()) );
		}
		
		
		if ( !superficiefield.getText().equals("") )
		{
			bienPourInial.setSuperficie(Double.parseDouble( superficiefield.getText() ));
		}
		
		
		if (! typetransfield.getValue().equals("") )
		{
			bienPourInial.setNatureTrans(typetransfield.getValue());
		}
		
		
		if ( !prixfield.getText().equals("") )
		{
			bienPourInial.setPrix(Long.parseLong(prixfield.getText()));
		}
		
		
		if ( negofield.getValue() != bienPourInial.isNegociable() )
		{
			bienPourInial.setNegociable(negofield.getValue());		
		}
		
		if ( !descripfield.getText().equals("") )
		{
			bienPourInial.setDescription(descripfield.getText());
		}
		
		if ( !nbfacadefield.getValue().equals("") )
		{
			bienPourInial.setNbfacade(Integer.parseInt(nbfacadefield.getValue()));
		}

		
		//modification de la date d'ajout a la date de dernier modification
				Date date = new Date ( ) ; 
				bienPourInial.setDate(date);
				
//la Supprission de l ancien bien
				
				ArrayList<Bien> li=  new ArrayList<Bien>();
				li.clear();
				InputStream infile; 
				try {
					infile = new FileInputStream("Bien.bin");
					ObjectInputStream fi= new ObjectInputStream(infile);
					while(true)
					{
				    li.add((Bien)fi.readObject());
					}
				  //fi.close();
				} catch (Exception e) {
				
				} 
				li.remove(AdminSystemeController.indexDeBien);
				
				//l ajout du bien modifier
				
				li.add(bienPourInial);
				for(Bien e:li)
				{
					System.out.println(e.getDescription());
				}
				 new File("Bien.bin").delete();
				OutputStream outfile;
				try {
					outfile = new FileOutputStream("Bien.bin");
					ObjectOutputStream fi= new ObjectOutputStream(outfile);
					for(Bien e:li)
					{
					fi.writeObject(e);
					}
					fi.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		this.bienPourInial = (Inhabitable) AdminSystemeController.bienTmp ; 
		
		adress_exct.setPromptText(bienPourInial.getAdress_exct());
		superficiefield.setPromptText(new Double(bienPourInial.getSuperficie()).toString() );
		prixfield.setPromptText( new Long( bienPourInial.getPrix()).toString() );
		wilayachek.setPromptText(new Integer(bienPourInial.getWillaya()).toString());
		typetransfield.setPromptText(bienPourInial.getNatureTrans()); 
		negofield.setPromptText(new Boolean(bienPourInial.isNegociable()).toString());
		descripfield.setPromptText(bienPourInial.getDescription());
		nbfacadefield.setPromptText(new Integer(bienPourInial.getNbfacade()).toString());
		statjuridiquefield.setPromptText(bienPourInial.getStatueJuridique());
		
		//initialisation des listes 
		
		ObservableList<String> liste = FXCollections.observableArrayList("1","2","3","4","5") ; 
		
		for (int i = 0 ; i < 58 ; i++ )
		{
			listeWilaya.add(new Integer(i+1).toString());
		}
		
		wilayachek.setItems(listeWilaya);
		typetransfield.setItems(transac);
		negofield.setItems(listbool);
		nbfacadefield.setItems(liste);
		
		wilayachek.setValue("");
		negofield.setValue(bienPourInial.isNegociable());
		typetransfield.setValue("");
		nbfacadefield.setValue("");
		
	    }
	

}
