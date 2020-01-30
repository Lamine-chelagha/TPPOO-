package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

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
import Noyau.Maison;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;

import javafx.scene.control.TextArea;

public class ModifierMaisonController implements Initializable {
	@FXML
	private TextField adress_exct ;
	
	@FXML
	private ComboBox<String> wilayachek ;
	
	@FXML
	private TextField superficiefield ;
	
	@FXML
	private TextField superficiehabitfield ;
	
	@FXML
	private ComboBox<String> typetransfield ;
	
	@FXML
	private TextField prixfield ;
	
	@FXML
	private ComboBox<Boolean> negofield ;
	
	@FXML
	private TextArea descripfield ; 
	
	@FXML
	private TextField linkfield ;
	
	@FXML
	private ComboBox<String> etagefield ;
	
	@FXML
	private ComboBox<Boolean> garagefield ;
	
	@FXML
	private ComboBox<Boolean> jardinfield ;
	
	@FXML
	private ComboBox<Boolean> picinefield ;
	
	@FXML
	private ComboBox<String> piecesfield ;
	
	@FXML
	private ComboBox<Boolean> meublfield ;
	
	static Maison bienPourInial ;
	
	ObservableList<String> listeWilaya = FXCollections.observableArrayList("1","2","3","4","5") ; 
	ObservableList<Boolean> listbool = FXCollections.observableArrayList(true,false) ;
	ObservableList<String> transac = FXCollections.observableArrayList("vente","location","echange") ; 

	public void confirmeModification(ActionEvent event) 
	{
		this.bienPourInial = (Maison) AdminSystemeController.bienTmp ; 
		
		
		if ( !adress_exct.getText().equals("") ) // si le champs n est pas vide (donc il est modifier)
		{
			bienPourInial.setAdress_exct(adress_exct.getText());
		}
		

		if ( !wilayachek.getValue().equals("") )
		{		
			bienPourInial.setWillaya(Integer.parseInt( wilayachek.getValue()) );
		}

		
		if ( !superficiehabitfield.getText().equals("") )
		{
			bienPourInial.setSuperficieHabitable(Double.parseDouble( superficiehabitfield.getText() ));
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
		
		
		if ( !etagefield.getValue().equals("") )
		{
			bienPourInial.setNbetage( Integer.parseInt( etagefield.getValue() ) ) ;
		}
		
		
		if ( garagefield.getValue() != bienPourInial.isGarage() ) 
		{
			bienPourInial.setGarage(garagefield.getValue());	
		}
		
		
		if ( jardinfield.getValue() != bienPourInial.isJardin() )
		{
			bienPourInial.setJardin(jardinfield.getValue());	
		}
		
		
		if ( picinefield.getValue() != bienPourInial.isPicine() )
		{
			bienPourInial.setPicine(picinefield.getValue());	
		}
		
		
		if ( !piecesfield.getValue().equals("") )
		{
			bienPourInial.setPieces(Integer.parseInt( piecesfield.getValue() ) );	
		}
		
		
		if ( meublfield.getValue() != bienPourInial.isMeuble() )
		{
			bienPourInial.setMeuble(meublfield.getValue());
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
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		this.bienPourInial = (Maison) AdminSystemeController.bienTmp ; 
		
		adress_exct.setPromptText(bienPourInial.getAdress_exct());
		superficiefield.setPromptText(new Double(bienPourInial.getSuperficie()).toString() );
		prixfield.setPromptText( new Long( bienPourInial.getPrix()).toString() );
		wilayachek.setPromptText(new Integer(bienPourInial.getWillaya()).toString());
		typetransfield.setPromptText(bienPourInial.getNatureTrans()); 
		etagefield.setPromptText(new Integer(bienPourInial.getNbetage()).toString());
		garagefield.setPromptText(new Boolean(bienPourInial.isGarage()).toString());
		jardinfield.setPromptText(new Boolean( bienPourInial.isJardin()).toString());
	    picinefield.setPromptText(new Boolean( bienPourInial.isPicine()).toString());
		superficiehabitfield.setPromptText(new Double(bienPourInial.getSuperficieHabitable()).toString() );
		negofield.setPromptText(new Boolean(bienPourInial.isNegociable()).toString());
		piecesfield.setPromptText(new Integer(bienPourInial.getNbetage()).toString());
		meublfield.setPromptText(new Boolean( bienPourInial.isMeuble()).toString());
		descripfield.setPromptText(bienPourInial.getDescription());
		
		//initialisation des listes 
		
		ObservableList<String> liste = FXCollections.observableArrayList("1","2","3","4","5") ; 
		etagefield.setItems(liste);
		piecesfield.setItems(liste);
		
		for (int i = 0 ; i < 58 ; i++ )
		{
			listeWilaya.add(new Integer(i+1).toString());
		}
		
		wilayachek.setItems(listeWilaya);
		typetransfield.setItems(transac);
		negofield.setItems(listbool);
		garagefield.setItems(listbool);
		picinefield.setItems(listbool);
		meublfield.setItems(listbool);	
		jardinfield.setItems(listbool);
		
		wilayachek.setValue("");
		negofield.setValue(bienPourInial.isNegociable());
		garagefield.setValue(bienPourInial.isGarage());
		jardinfield.setValue(bienPourInial.isJardin());
		picinefield.setValue(bienPourInial.isPicine());
		meublfield.setValue(bienPourInial.isMeuble());
		typetransfield.setValue("");
		piecesfield.setValue("");
		etagefield.setValue("");
		
	}

	// Event Listener on Button.onAction
	@FXML
	public void filechooser(ActionEvent event) {
	}

	// Event Listener on Button.onAction
	@FXML
	public void retoure(ActionEvent event) {
		meublfield.getScene().getWindow().hide();
	}
	
}
