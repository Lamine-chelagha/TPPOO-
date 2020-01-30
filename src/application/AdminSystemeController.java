package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

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
import java.util.Optional;
import java.util.ResourceBundle;

import Noyau.Appart;
import Noyau.Bien;
import Noyau.Inhabitable;
import Noyau.Maison;
import Noyau.Propritaire;
import Noyau.SuperficieException;
import Noyau.Systeme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;

public class AdminSystemeController implements Initializable{
	@FXML
	private ListView<String> lview;
	@FXML
	private ComboBox<String> combo;
	@FXML
	private Label lb;
		 
	static ArrayList <Bien> biens = new ArrayList<Bien> () ;
    static String type;
	static ArrayList<Bien> filter= new ArrayList<Bien>();
	static ArrayList<Propritaire> listProp= new ArrayList<Propritaire>();
	static ArrayList<Bien> listArchive= new ArrayList<Bien>();
	static	ArrayList<String> messagerie=  new ArrayList<String>();
	static ObservableList<String> archive=FXCollections.observableArrayList();
	private 	Systeme sys =new Systeme() ;
	
	static ObservableList<String> names=FXCollections.observableArrayList();
		   ObservableList<String> biensView = FXCollections.observableArrayList();
		   ObservableList<String> arg=FXCollections.observableArrayList("Maison","Appartement","Terrains","type transaction:Vente","type transaction:Location","type transaction:Echange","Par wilaya","Inferieur à xxxx Dinars","Superficie minimale","Les biens negociables");
	
	static Bien e;
	static Bien bienTmp;
	static int indexDeBien;
	
	// Event Listener on Button.onAction
	@FXML
	public void visualiserOnAction(ActionEvent event) throws IOException {
		    names=lview.getSelectionModel().getSelectedItems();
		   
		    String nme=names.get(0);
			 e = null;
			 for(Bien e1:AdminSystemeController.biens){   
				 
				 if( nme.equals(e1.getDescription())){  
					 e=e1;
				 }
			 }
			 
			 if(!e.getNatureTrans().equals("echange")){
				 Parent root=FXMLLoader.load(getClass().getResource("/application/VisualiserfromAdmin.fxml"));
				 Scene scene = new Scene(root);
				 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				 Stage primaryStage = new Stage();
				 primaryStage.setScene(scene);
				 primaryStage.show();
				 primaryStage.setResizable(false);
			 }
			 else{
				 Parent root = FXMLLoader.load(getClass().getResource("/application/VisualiserEchange.fxml"));
				 Scene scene = new Scene(root);
				 scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				 Stage primaryStage = new Stage();
				 primaryStage.setScene(scene);
				 primaryStage.show();
				 primaryStage.setResizable(false);
			 }
	}
	public void initialize(URL arg0, ResourceBundle arg1){	//initialiser la liste des bien à partir du fichier
		lb.setText("Bienvenue Admin");
		//AjouterAuFichierBien();
	  	
		sys.setListedesBien(RecupererFromFichier());	// lire à partir du fichier la liste des biens
	  	biens=sys.getListedesBien();
	  	
	  	for(Bien e:biens){
	  		biensView.add(e.getClass().getName()+" "+e.getDescription());
	  	}
	  	
		lview.setItems(biensView);
		combo.setItems(arg);
	}
	
	public  void AjouterAuFichierBien()	{
		Propritaire prop0 = new Propritaire("Nom1" , "Prenom1" ,"Nom1.Prenom1@gmail.com" , 0673347704 ,"Manchester England");
	  	Propritaire prop1 = new Propritaire("Nom2" , "Prenom2" ,"Nom2.Prenom2@gmail.com" , 0673347705 ,"Barcelone Spain");
	  	Propritaire prop2 = new Propritaire("Nom3" , "Prenom3" ,"Nom3.Prenom3@gmail.com" , 0673347706 ,"Turin Italie");
	  	Propritaire prop3 = new Propritaire("Nom4" , "Prenom4" ,"Nom4.Prenom4@gmail.com" , 0673347707 ,"Doha Qatar");
	  	
	  	
	    Bien bien1= new Appart(1 , false,true , "Oued Smar" ,120 ,prop1 ,"vente" , true , "Tres vaste","C:\\Users\\Slash\\eclipse-workspace\\TpTrial\\src\\icons\\th (6).jpg",4, true ,10000000 , 2 );
	    prop1.ajouter_bien(bien1);
	    sys.ajouterBien(bien1);
	  	Bien bien2=null;
		
	  	try {
	  		bien2 = new Maison( 1 , false , true ,false ,"alger centre",200,prop0 ,"vente",false,"magnifique","C:\\Users\\Slash\\eclipse-workspace\\TpTrial\\src\\icons\\th (6).jpg",4,true, 10000000,3,150);
		}
	  	
	  	catch (SuperficieException e1) {
			e1.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur!");
            alert.setContentText("Erreur! La superficie Habitable ne peut pas etre superieure à la superficie total!");
            alert.setHeaderText(null);
            alert.showAndWait();
		}
		
	  	if(bien2!=null){
	  		prop0.ajouter_bien(bien2);
	  		sys.ajouterBien(bien2);
		}
	  	
	  	Bien bien3= new Inhabitable("legale",3,"blida" ,500,prop0 ,"vente",true,"propre","C:\\Users\\Slash\\eclipse-workspace\\TpTrial\\src\\icons\\th (6).jpg" ,20000000,1);
	  	prop0.ajouter_bien(bien3);
	  	sys.ajouterBien(bien3);
	  	Bien bien4= new Appart(1,true,true,"tipaza",160 ,prop2 ,"location",true, "calme" ,"C:\\Users\\Slash\\Downloads\\icones\\th (6).jpg",3 , true, 40000,3 );
	  	prop2.ajouter_bien(bien4);
	  	sys.ajouterBien(bien4);
	  	Bien bien5=null;
		
	  	try {
			bien5 = new Maison(2 ,false ,false ,true ,"chlef",160 , prop2 ,"location",true ,"neuf" ,"C:\\Users\\Slash\\Downloads\\icones\\th (6).jpg",4,true, 150000,2,120);
		}
	  	catch (SuperficieException e1) {
			e1.printStackTrace();
		}
	  	
		if(bien5!=null){
			prop2.ajouter_bien(bien5);
			sys.ajouterBien(bien5);
		}
	  	
		Bien bien6= new Appart(6 ,false ,true ,"oran" ,50, prop1 , "location" ,false ,"small" ,"C:\\Users\\Slash\\Downloads\\icones\\th (6).jpg" ,0 ,false , 600000 , 3 );
	  	prop1.ajouter_bien(bien6);
	  	sys.ajouterBien(bien6);
	  	Bien bien7= new Inhabitable( "legale" , 1 , "blida" , 650 , prop0 , "echange" , true ,"Good" ,"C:\\Users\\Slash\\Downloads\\icones\\th (6).jpg",18000000 , 1);
	  	prop0.ajouter_bien(bien7);
	  	sys.ajouterBien(bien7);
	  	Bien bien8=null;
		
	  	try {
			bien8 = new Maison(3, true , false , false ,"adrar" , 200 , prop1 ,"echange" , false , "calme" , "C:\\Users\\Slash\\Downloads\\icones\\th (6).jpg", 3 , true , 14000000 , 2,130);
		} 
	  	catch (SuperficieException e1) {
			e1.printStackTrace();
		}
		
	  	if(bien8!=null){
	  		prop1.ajouter_bien(bien8);
	  		sys.ajouterBien(bien8);
		}
	
	  	OutputStream outfile;
		
	  	try {
			outfile = new FileOutputStream("Bien.bin");
			ObjectOutputStream fi= new ObjectOutputStream(outfile);
			
			for(Bien e:sys.getListedesBien()){
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
	public ArrayList<Bien> RecupererFromFichier(){  
		ArrayList<Bien> li=  new ArrayList<Bien>();
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
		return li;
	}
	
	public void AjouterBien(ActionEvent event) throws IOException{
		
		Parent root=FXMLLoader.load(getClass().getResource("/application/ChoisirTypeBien.fxml"));
		Scene scene = new Scene(root);
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	   
	}
	
	public void suppimerBien(ActionEvent event){
		
		 names=lview.getSelectionModel().getSelectedItems();
		 Alert a= new Alert(Alert.AlertType.CONFIRMATION);
		 a.setTitle("Confirmation");
 		 a.setContentText("Etes vous sur de vouloir supprimer ce bien !");
 		 a.setHeaderText(null);
 		 Optional <ButtonType> result=a.showAndWait();
 		 
 		 if(result.get()==ButtonType.OK){
 			 Bien e1 = null;
 			 for(Bien e:sys.getListedesBien()){
 				 if(e.getDescription().equals(names.get(0))){
 					 e1=e;
 				 }
 			 }
 			 e1.getProp().getListebien().remove(e1);
 			 sys.getListedesBien().remove(e1);
		 
 			 //mise a jour du fichier
 			 new File("Bien.bin").delete();
 			 OutputStream outfile;
 			 
 			 try {
 				 outfile = new FileOutputStream("Bien.bin");
 				 ObjectOutputStream fi= new ObjectOutputStream(outfile);
 				 for(Bien e:sys.getListedesBien()){
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
 			 lview.getItems().clear();
 			 biens=sys.getListedesBien();
		  		biensView.clear();
		  	for(Bien e:biens){
		  		biensView.add(e.getDescription());
		  	}
			
		  	lview.setItems(biensView);
 		}
	}
	
	public void recupererChoixOnAction(ActionEvent event) throws IOException{
		 type = combo.getValue();
		
		if(type.equals("Par wilaya")){
			Parent root1=FXMLLoader.load(getClass().getResource("/application/SousChoix.fxml"));
	        Scene scene1 = new Scene(root1);
	        Stage primaryStage1 = new Stage();
	        primaryStage1.setScene(scene1);
	        primaryStage1.show();
	        primaryStage1.setResizable(false);
	         
	         //AdminSystemeController.filter=sys.filtrer(type,SousChoixController.choix);
		}
		
		if(type.equals("Inferieur à xxxx Dinars")){
			Parent root1=FXMLLoader.load(getClass().getResource("/application/SousChoix2.fxml"));
	        Scene scene1 = new Scene(root1);
	        Stage primaryStage1 = new Stage();
	        primaryStage1.setScene(scene1);
	         primaryStage1.show();
	         primaryStage1.setResizable(false);
		}
		
		if(type.equals("Superficie minimale")){
			Parent root=FXMLLoader.load(getClass().getResource("/application/SousChoix3.fxml"));
	        Scene scene = new Scene(root);
	        Stage primaryStage = new Stage();
	        primaryStage.setScene(scene);
	         primaryStage.show();
	         primaryStage.setResizable(false);
		}
		if(!type.equals("Superficie minimale") && !type.equals("Inferieur à xxxx Dinars")&& !type.equals("Par wilaya")){
			filter=sys.filtrer(type,-1);
			if(filter.size()>0){
				Parent root=FXMLLoader.load(getClass().getResource("/application/Filtrer.fxml"));
				Scene scene = new Scene(root);
				Stage primaryStage = new Stage();
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setResizable(false);
			}
			else {
	    		Alert a= new Alert(Alert.AlertType.INFORMATION);
	    		a.setTitle("Information");
	    		a.setContentText("Aucun Bien Correspond à votre recherche");
	    		a.setHeaderText(null);
	    		a.showAndWait();
	    	}
		}
	}
	
	public void voirMessageOnAction(ActionEvent event) throws IOException{
		InputStream infile; 
		try {
			infile = new FileInputStream("MesssagerieClientel.bin");
			ObjectInputStream fi= new ObjectInputStream(infile);
			messagerie.clear();
			while(true){ 
				messagerie.add((String)fi.readObject());
			}
			//fi.close();
		} 
		catch (Exception e) {	
		
		} 
		
		Parent root=FXMLLoader.load(getClass().getResource("/application/Messagerie.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage primaryStage = new Stage();
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public void deconnecterOnAction(ActionEvent event) throws IOException{
		combo.getScene().getWindow().hide();
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
	
	public void archiverOnAction(ActionEvent event){
		listArchive.clear();
		InputStream infile; 
		try {
			infile = new FileInputStream("Archives.bin");
			ObjectInputStream fi= new ObjectInputStream(infile);
			while(true){ 
				listArchive.add((Bien)fi.readObject());
			}
			//fi.close();
		} 
		catch (Exception e) {
			
		} 
		
		archive=lview.getSelectionModel().getSelectedItems();
		Bien e1 = null;
		
		for(Bien e:sys.getListedesBien()){ 
			 if(e.getDescription().equals(archive.get(0))){
				listArchive.add(e);
		        e1=e;
			 }
		 }
		
		e1.getProp().getListebien().remove(e1);
		sys.getListedesBien().remove(e1);
		
		//mise a jour du fichier
		new File("Bien.bin").delete();
		OutputStream outfile;
		try {
			outfile = new FileOutputStream("Bien.bin");
			ObjectOutputStream fi= new ObjectOutputStream(outfile);
			for(Bien e:sys.getListedesBien()){
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
		
		lview.getItems().clear();
	  	biens=sys.getListedesBien();
	  	biensView.clear();
	  	
	  	for(Bien e:biens){
		  	biensView.add(e.getDescription());
		}
		lview.setItems(biensView);
		
		new File("Archives.bin").delete();
		OutputStream outfile1;
		try {
			outfile1 = new FileOutputStream("Archives.bin");
			ObjectOutputStream fi1= new ObjectOutputStream(outfile1);
			for(Bien e:listArchive){
				fi1.writeObject(e);
			}
			fi1.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void listArchiveOnAction(ActionEvent event) throws IOException{
		Stage primaryStage=new Stage();
		/*URL url  = new File("/application/ListArchive.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
		/*/Parent root=FXMLLoader.load(getClass().getResource("/application/BienArchives.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
		
	}
	
	public void listProprietaire(ActionEvent event) throws IOException{
		listProp.clear();
		for (Bien e: sys.getListedesBien()){
			if(!listProp.contains(e.getProp())){
				listProp.add(e.getProp());
			}
		}
		Stage primaryStage=new Stage();
		Parent root=FXMLLoader.load(getClass().getResource("/application/Prop.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public void modifierBien ( ActionEvent event ) throws IOException{
		names = lview.getSelectionModel().getSelectedItems();
		bienTmp = null; 
		int i=0 ; 
		for(Bien e:sys.getListedesBien()){
			if(e.getDescription().equals(names.get(0))){
				bienTmp = e ;
				indexDeBien = i ;
			}
			i++ ;
		}
	 
		if ( bienTmp.getClass().toString().equals("class Noyau.Maison") ){
			Stage primaryStage = new Stage() ;
			Parent root=FXMLLoader.load(getClass().getResource("/application/ModifierMaison.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Modifier une Maison");
			primaryStage.show();
			primaryStage.setResizable(false);
		}	
	 
		if ( bienTmp.getClass().toString().equals("class Noyau.Appart") ){
			Stage primaryStage = new Stage() ;
			Parent root=FXMLLoader.load(getClass().getResource("/application/ModifierAppart.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Modifier une Appartemment");
			primaryStage.show();
			primaryStage.setResizable(false);
		}
	 
		if ( bienTmp.getClass().toString().equals("class Noyau.Inhabitable") ){
			Stage primaryStage = new Stage() ;
			Parent root=FXMLLoader.load(getClass().getResource("/application/ModifierInhabitable.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Modifier une Terrain");
			primaryStage.show();
			primaryStage.setResizable(false);
		} 
	}
	
	public void refreshOnAction(ActionEvent event){
		lview.getItems().clear();
		sys.setListedesBien(RecupererFromFichier());
	  	biens=sys.getListedesBien();
	  	for(Bien e:biens){
	  		biensView.add(e.getDescription());
	  	}
	  	
		lview.setItems(biensView);
		combo.setItems(arg);
	}
}