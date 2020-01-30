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

import Noyau.Appart;
import Noyau.Bien;
import Noyau.Propritaire;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AppartAjoutController implements Initializable {
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
	private TextArea descripfield ; 
	
	@FXML
	private Button linkfield ;
	
	@FXML
	private ComboBox<Boolean> ascenseurfield ;
	
	@FXML
	private ComboBox<String> suplexefield ;
	
	@FXML
	private ComboBox<Boolean> meublefield ;
	
	@FXML
	private ComboBox<String> etagefield ;
	
	@FXML
	private ComboBox<String> piecesfield ;
	
	@FXML
	private Label warning ;
	
	ObservableList<String> listeWilaya = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20") ; 
	ObservableList<Boolean> listebool = FXCollections.observableArrayList(true,false) ;
	ObservableList<String>	listeDuplixite = FXCollections.observableArrayList("Simple","Dupleexe") ;
	ObservableList<String> transac = FXCollections.observableArrayList("vente","location","echange") ; 
	
	private Appart apparttement ;
	private String photo ;
	
	public void addBien (ActionEvent event  ) {
		
		Propritaire prop = new Propritaire("Nom1" , "Prenom1" ,"nom1.Prenom1@gmail.dz" , 0673347704 ,"Manchester England");
		
		String adressexct ;
		int wilaya ;
		Double superficie ;
		boolean simplexe ;
		String typeTrans ;
		long prix ;
		boolean negociable ; 
		String description ;  
		int nbetage ; 
		boolean ascenseur ; 
		boolean meuble ;
		int pieces ; 
		
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
									if (!etagefield.getValue().equals("") ){
										nbetage = Integer.parseInt(etagefield.getValue());
										if ( ascenseurfield.getValue() == true || ascenseurfield.getValue() == false ){
												ascenseur = ascenseurfield.getValue() ; 
												if ( suplexefield.getValue() == "Duplexe" || suplexefield.getValue() == "Simple" ){
													if (suplexefield.getValue() == "Duplexe") {
														simplexe =  false;
													}
													else {
														simplexe =  true;
													}
													
													if ( meublefield.getValue() == true || meublefield.getValue() == false ){
														meuble = meublefield.getValue() ;
														if ( ! piecesfield.getValue().equals("") ){
															pieces = Integer.parseInt( piecesfield.getValue() ) ;
															apparttement = new Appart(nbetage, ascenseur, simplexe, adressexct, superficie, prop, typeTrans, negociable, description, this.photo, pieces, meuble, prix, wilaya);
															prop.ajouter_bien(apparttement);
															ArrayList<Bien> li=  new ArrayList<Bien>();
															li.clear();
															InputStream infile; 
															try {
																infile = new FileInputStream("Bien.bin");
																ObjectInputStream fi= new ObjectInputStream(infile);
																while(true){
																	li.add((Bien)fi.readObject());
																}
															  //fi.close();
															} 
															catch (Exception e) {
															
															} 
															li.add(apparttement);
															/*for(Bien e:li){
																System.out.println(e.getDescription());
															}*/
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
		
		ObservableList<String> liste = FXCollections.observableArrayList("1","2","3","4","5") ; 
		etagefield.setItems(liste);
		piecesfield.setItems(liste);
		
		for (int i = 0 ; i < 58 ; i++ ){
			listeWilaya.add(new Integer(i+1).toString());
		}
		
		wilayachek.setItems(listeWilaya);
		typetransfield.setItems(transac);
		negofield.setItems(listebool);
		suplexefield.setItems(listeDuplixite);
		ascenseurfield.setItems(listebool);
		meublefield.setItems(listebool);
	}
	
	
	public void filechooser(ActionEvent event){
			
		FileChooser filestage = new FileChooser() ;
		filestage.setTitle("Attacher une photo du Bien");
		Stage stage = (Stage) linkfield.getScene().getWindow();	
		File photolink = filestage.showOpenDialog(stage);
		this.photo = photolink.getPath() ; 
			
	}
	
	
	public void retoure (ActionEvent event){
		warning.getScene().getWindow().hide();
	}

}
