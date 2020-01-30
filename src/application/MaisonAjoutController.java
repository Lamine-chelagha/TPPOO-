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
import Noyau.Maison;
import Noyau.Propritaire;
import Noyau.SuperficieException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class MaisonAjoutController implements Initializable {
	
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
	
	@FXML
	private Label warning ;
	
	ObservableList<String> listeWilaya = FXCollections.observableArrayList("1","2","3","4","5") ; 
	ObservableList<Boolean> listbool = FXCollections.observableArrayList(true,false) ;
	ObservableList<String> transac = FXCollections.observableArrayList("vente","location","echange") ; 
	
	static private Bien house ;
	private String photo ;
	
	public void addBien (ActionEvent event ) throws SuperficieException {
		
		Propritaire prop = new Propritaire("kane" , "Riad" ,"ir_mahrez@esi.dz" , 0673347704 ,"Manchester England");
		
		String adressexct ;
		int wilaya ;
		Double superficie ;
		Double SuperficieHabitable ;
		String typeTrans ;
		long prix ;
		boolean negociable ; 
		String description ;  
		int nbetage ; 
		boolean garage ;
		boolean jardin ;
		boolean picine ; 
		int pieces ;
		boolean meuble ; 
		
		if ( !adress_exct.getText().equals("") ){
			adressexct = adress_exct.getText() ; 
		
			if ( !wilayachek.getValue().equals("") ){
				wilaya = Integer.parseInt(wilayachek.getValue()) ; 
				
				if ( !superficiefield.getText().equals("") ){
					superficie = Double.parseDouble(superficiefield.getText());
					
					if ( !superficiehabitfield.getText().equals("") ){
						SuperficieHabitable = Double.parseDouble(superficiehabitfield.getText());
						if(SuperficieHabitable>superficie) {
							Alert alert = new Alert(Alert.AlertType.WARNING);
				            alert.setTitle("Erreur!");
				            alert.setContentText("Erreur! La superficie habitable ne peut pas etre supériere à la superficie total!");
				            alert.setHeaderText(null);
				            alert.showAndWait();
						}
						
						if ( !typetransfield.getValue().equals("")){
							typeTrans = typetransfield.getValue() ;
							
							if ( !prixfield.getText().equals("") ){
								prix = Long.parseLong(prixfield.getText());
								
								if ( !negofield.getValue().equals("") ){ 
									negociable = negofield.getValue() ; 
									
									if ( !descripfield.getText().equals("") ){
										description = descripfield.getText() ; 
																				
											if (!etagefield.getValue().equals("") ){
												nbetage = Integer.parseInt(etagefield.getValue());
												
												if ( garagefield.getValue() == true || garagefield.getValue() == false ){
													garage = garagefield.getValue();
													
													if ( jardinfield.getValue() == true || jardinfield.getValue() == false ){
														jardin = jardinfield.getValue() ;
														
														if ( picinefield.getValue() == (true) || picinefield.getValue() == (false) ){
															picine = picinefield.getValue() ; 
															
															if ( !piecesfield.getValue().equals("") ) {
																pieces = Integer.parseInt(piecesfield.getValue());
																
																if ( meublfield.getValue() == true || meublfield.getValue() == false ){  
																	meuble = meublfield.getValue();
																
																	house = new Maison(nbetage,garage,jardin,picine,adressexct, superficie ,prop ,typeTrans , negociable ,description , this.photo, pieces, meuble, prix , wilaya,SuperficieHabitable);
																	prop.ajouter_bien(house);
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
																	li.add(house);
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

	public static Bien getHouse() {
		return house;
	}

	
}
