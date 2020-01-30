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

import Noyau.Bien;
import Noyau.Inhabitable;
import Noyau.Propritaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class InHabitableAjoutController implements Initializable {
	
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
	
	@FXML
	private Label warning ;
	
	ObservableList<String> listeWilaya = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20") ; 
	ObservableList<Boolean> listbool = FXCollections.observableArrayList(true,false) ;
	ObservableList<String> transac = FXCollections.observableArrayList("vente","location","echange") ; 
	
	private Bien terrain ;
	private String photo=null ;
	
	public void addBien ( ActionEvent event ) {
		Propritaire prop = new Propritaire("Nom1" , "Prenom1" ,"nom1.Prenom1@gmail.com" , 0600000704 ,"Adresse Proprietaire");
		
		String adressexct ;
		int wilaya ;
		Double superficie ;
		String typeTrans ;
		long prix ;
		boolean negociable ; 
		String description ; 
		String statuejuridique ;
		int nbfacade ;
	
		
		if ( !adress_exct.getText().equals("") ){
			adressexct = adress_exct.getText() ; 
			if ( !wilayachek.getValue().equals("") ){
				wilaya = Integer.parseInt(wilayachek.getValue()) ; 
				if ( !superficiefield.getText().equals("") ){
					superficie = Double.parseDouble(superficiefield.getText());	
					if ( !typetransfield.getValue().equals("")){
						typeTrans = typetransfield.getValue() ;
						if ( !prixfield.getText().equals("") ){
							prix = Long.parseLong(prixfield.getText());
							if ( negofield.getValue()==true || negofield.getValue()==false ){
								negociable = negofield.getValue() ; 	
								if ( !descripfield.getText().equals("") ){
									description = descripfield.getText() ; 
									if ( !statjuridiquefield.getText().equals("") ){
										statuejuridique = statjuridiquefield.getText();
										if ( ! nbfacadefield.getValue().equals("") ){
											nbfacade = Integer.parseInt(nbfacadefield.getValue());
											terrain = new Inhabitable(statuejuridique, nbfacade, adressexct, superficie, prop, typeTrans, negociable, description, this.photo, prix, wilaya);									
											prop.ajouter_bien(terrain);
											ArrayList<Bien> li=  new ArrayList<Bien>();
											li.clear();
											InputStream infile; 
											try {
												infile = new FileInputStream("Bien.bin");
												ObjectInputStream fi= new ObjectInputStream(infile);
												while(true){
													li.add((Bien)fi.readObject());
												}
											} 
											catch (Exception e) {
											
											} 
											li.add(terrain);
											new File("Bien.bin").delete();
											OutputStream outfile;
											try {
												outfile = new FileOutputStream("Bien.bin");
												ObjectOutputStream fi= new ObjectOutputStream(outfile);
												for(Bien e:li){
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
											
										}	
									}			
								}
							}
						}
					}
				}
			}
			Stage sauvStage = (Stage) warning.getScene().getWindow();
			sauvStage.close();
		}
		else {
			warning.setText("Veuillez completer les champs indiqués !");
		}
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		ObservableList<String> liste = FXCollections.observableArrayList("1","2","3","4") ; 
		nbfacadefield.setItems(liste);
		
		for (int i = 0 ; i < 48 ; i++ ){
			listeWilaya.add(new Integer(i+1).toString());
		}
		
		wilayachek.setItems(listeWilaya);
		typetransfield.setItems(transac);
		negofield.setItems(listbool);
	}
	
	public void filechooser(ActionEvent event){
		
		FileChooser filestage = new FileChooser() ;
		filestage.setTitle("Attacher une photo du Bien");
		Stage stage = (Stage) prixfield.getScene().getWindow();
		
		File photolink = filestage.showOpenDialog(stage);
		this.photo = photolink.getPath() ; 
		
	}
	
	public void retour(ActionEvent event){
		warning.getScene().getWindow().hide();
	}

}
