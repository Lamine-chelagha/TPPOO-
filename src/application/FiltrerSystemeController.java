package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FiltrerSystemeController implements Initializable {
   
    @FXML
    private Button rtr;
    @FXML
    private Label size;
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
    private ImageView img;
    static int index=0;
    
    public void retourOnAction(ActionEvent event)
    {
   	rtr.getScene().getWindow().hide();
    }
    public void nextOnAction(ActionEvent event)
    {
    	index++;
    	if(index<SystemeController.filter.size())
    	{
    	size.setText(new Double(SystemeController.filter.size()).toString()+" biens");
    
    	lbl1.setText(new Integer(SystemeController.filter.get(index).getWillaya()).toString());
    	lbl4.setText(new Double(SystemeController.filter.get(index).getPrix()).toString());
    	if(SystemeController.filter.get(index).isNegociable())
	       {lbl3.setText("oui");}
	    if(!SystemeController.filter.get(index).isNegociable())
	    {lbl3.setText("non");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
	       {lbl3.setText("oui");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
    	 if(SystemeController.filter.get(index).getNatureTrans().equals("vente"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixVente()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("location"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixLocation()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("echange"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixEchange(2)).toString());
		    }
		    try {
				Image image = new Image( new FileInputStream(SystemeController.filter.get(index).getPhoto()));
				img.setImage(image);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
    	}
    	else {
    		index=0;
    	}
    }
    public void previousOnAction(ActionEvent event)
    {
    	index--;
    	if(index>=0)
    	{
    	size.setText(new Double(SystemeController.filter.size()).toString()+" biens");
    	
    	lbl1.setText(new Integer(SystemeController.filter.get(index).getWillaya()).toString());
    	lbl4.setText(new Double(SystemeController.filter.get(index).getPrix()).toString());
    	if(SystemeController.filter.get(index).isNegociable())
	       {lbl3.setText("oui");}
	    if(!SystemeController.filter.get(index).isNegociable())
	    {lbl3.setText("non");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
	       {lbl3.setText("oui");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
    	 if(SystemeController.filter.get(index).getNatureTrans().equals("vente"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixVente()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("location"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixLocation()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("echange"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixEchange(2)).toString());
		    }
		    try {
				Image image = new Image( new FileInputStream(SystemeController.filter.get(index).getPhoto()));
				img.setImage(image);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
    	}
    	else
    	{
    		index=SystemeController.filter.size() -1;
    	}
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		index=0;
		size.setText(new Integer(SystemeController.filter.size()).toString()+" biens");
		Image image;
		lbl1.setText(new Integer(SystemeController.filter.get(index).getWillaya()).toString());
    	lbl4.setText(new Double(SystemeController.filter.get(index).getPrix()).toString());
    	if(SystemeController.filter.get(index).isNegociable())
	       {lbl3.setText("oui");}
	    if(!SystemeController.filter.get(index).isNegociable())
	    {lbl3.setText("non");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
	       {lbl3.setText("oui");}
	    lbl2.setText(SystemeController.filter.get(index).getDate().toString());
    	 if(SystemeController.filter.get(index).getNatureTrans().equals("vente"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixVente()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("location"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixLocation()).toString());
		    }
		    if(SystemeController.filter.get(index).getNatureTrans().equals("echange"))
		    {
		    lbl5.setText(new Double(SystemeController.filter.get(index).calculerPrixEchange(2)).toString());
		    }
		    try {
				image = new Image( new FileInputStream(SystemeController.filter.get(index).getPhoto()));
				img.setImage(image);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
	}
}
