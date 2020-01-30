package application;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Noyau.Bien;
import Noyau.Systeme;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class SystemeController implements Initializable{
	@FXML
	private ListView<String> lview;
	
	@FXML
	private Label lb;
	
	@FXML
	private ComboBox<String> combo;
	
	static ArrayList <Bien> biens = new ArrayList<Bien> () ;
	static ArrayList <Bien> filter = new ArrayList<Bien> () ;
	static ObservableList<String> names=FXCollections.observableArrayList();
	ObservableList<String> biensView = FXCollections.observableArrayList();
	ObservableList<String> arg=FXCollections.observableArrayList("Maison","Appartement","Terrains","type transaction:Vente","type transaction:Location","type transaction:Echange","Par wilaya","Inferieur à xxxx Dinars","Superficie minimale","Les biens negociables");
	private Systeme sys =new Systeme() ;
   
   
	public void visualiserOnAction(ActionEvent event) throws IOException{  
		    names=lview.getSelectionModel().getSelectedItems();
		    Parent root=FXMLLoader.load(getClass().getResource("/application/Visualiser.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);	
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		lb.setText("Bienvenue "+LoginController.getUtilisa());
		sys.setListedesBien(listBien());
		biens=listBien();
		
		for(Bien e:biens){
			biensView.add(e.getDescription());
		}
		
		lview.setItems(biensView);
		combo.setItems(arg);
	}
	
	public ArrayList<Bien> listBien(){
		ArrayList<Bien> li=  new ArrayList<Bien>();
		InputStream infile; 
		try {
			infile = new FileInputStream("Bien.bin");
			ObjectInputStream fi= new ObjectInputStream(infile);
			while(true){
		    li.add((Bien)fi.readObject());
			}
		//  fi.close();
		} 
		catch (Exception e) {
		
		} 
		return li;
	}
	
	public void recupererChoixOnAction(ActionEvent event) throws IOException{
	     
		String type = combo.getValue();
		int choix=0;
		filter=sys.filtrer(type,choix);
		if(filter!=null){
		    Parent root=FXMLLoader.load(getClass().getResource("/application/FiltrerSysteme.fxml"));
			Scene scene = new Scene(root);
			Stage primaryStage = new Stage();
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		    }
	}
	
	public void contactOnAction(ActionEvent event) throws IOException{
		    Parent root=FXMLLoader.load(getClass().getResource("/application/Contact.fxml"));
			Scene scene = new Scene(root);
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
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}
}
