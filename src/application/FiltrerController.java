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

public class FiltrerController implements Initializable {
   
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
    private Label lbl6;
    @FXML
    private Label lbl7;
    @FXML
    private Label lbl8;
    @FXML
    private Label lbl9;
    @FXML
    private ImageView img;
    static int index=0;
    
    public void retourOnAction(ActionEvent event)
    {
   	rtr.getScene().getWindow().hide();
    }
    @SuppressWarnings("deprecation")
	public void nextOnAction(ActionEvent event){
    	
    	if(index+1<AdminSystemeController.filter.size()){
    		index++;
	    	size.setText("Nombre de biens: "+new Integer(AdminSystemeController.filter.size()).toString());
	    	lbl9.setText(new Integer(AdminSystemeController.filter.get(index).getWillaya()).toString());
		    lbl1.setText(AdminSystemeController.filter.get(index).getAdress_exct());
		    lbl2.setText(new Double(AdminSystemeController.filter.get(index).getSuperficie()).toString());
		    lbl3.setText(AdminSystemeController.filter.get(index).getProp().getPrenom()+" "+AdminSystemeController.filter.get(index).getProp().getNom());
		   
		    if(AdminSystemeController.filter.get(index).isNegociable())
		       {lbl7.setText("oui");}
		    if(!AdminSystemeController.filter.get(index).isNegociable())
		    {lbl7.setText("non");}
		    lbl8.setText(AdminSystemeController.filter.get(index).getDate().toString());
		    lbl5.setText(new Long(AdminSystemeController.filter.get(index).getPrix()).toString()+" DA");
		    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("vente"))
		    {
		    	lbl4.setText("vente");
		    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixVente()).toString()+" DA");
		    }
		    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("location"))
		    {
		    	lbl4.setText("location");
		    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixLocation()).toString()+"DA");
		    }
		    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("echange"))
		    {
		    	lbl4.setText("echange");
		    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixEchange(2)).toString()+ "DA");
		    }
		    try {
		    	Image image;
				image = new Image( new FileInputStream(AdminSystemeController.filter.get(index).getPhoto()));
				img.setImage(image);
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
    	
    	}
    	else {
    		index=0;
    		size.setText("Nombre de biens: "+new Integer(AdminSystemeController.filter.size()).toString());
        	lbl9.setText(new Integer(AdminSystemeController.filter.get(index).getWillaya()).toString());
    	    lbl1.setText(AdminSystemeController.filter.get(index).getAdress_exct());
    	    lbl2.setText(new Double(AdminSystemeController.filter.get(index).getSuperficie()).toString());
    	    lbl3.setText(AdminSystemeController.filter.get(index).getProp().getPrenom()+" "+AdminSystemeController.filter.get(index).getProp().getNom());
    	   
    	    if(AdminSystemeController.filter.get(index).isNegociable())
    	       {lbl7.setText("oui");}
    	    if(!AdminSystemeController.filter.get(index).isNegociable())
    	    {lbl7.setText("non");}
    	    lbl8.setText(AdminSystemeController.filter.get(index).getDate().toString());
    	    lbl5.setText(new Long(AdminSystemeController.filter.get(index).getPrix()).toString()+" DA");
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("vente"))
    	    {
    	    	lbl4.setText("vente");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixVente()).toString()+" DA");
    	    }
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("location"))
    	    {
    	    	lbl4.setText("location");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixLocation()).toString()+"DA");
    	    }
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("echange"))
    	    {
    	    	lbl4.setText("echange");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixEchange(2)).toString()+ "DA");
    	    }
    	    try {
    	    	Image image;
    			image = new Image( new FileInputStream(AdminSystemeController.filter.get(index).getPhoto()));
    			img.setImage(image);
    		} catch (FileNotFoundException e1) {
    			
    			e1.printStackTrace();
    		}
    	}
    }
    @SuppressWarnings("deprecation")
	public void previousOnAction(ActionEvent event)
    {
    	
    	if(index-1>=0)
    	{
    		index--;
    	size.setText("Nombre de biens: "+new Integer(AdminSystemeController.filter.size()).toString());
    	lbl9.setText(new Integer(AdminSystemeController.filter.get(index).getWillaya()).toString());
	    lbl1.setText(AdminSystemeController.filter.get(index).getAdress_exct());
	    lbl2.setText(new Double(AdminSystemeController.filter.get(index).getSuperficie()).toString());
	    lbl3.setText(AdminSystemeController.filter.get(index).getProp().getPrenom()+" "+AdminSystemeController.filter.get(index).getProp().getNom());
	   
	    if(AdminSystemeController.filter.get(index).isNegociable())
	       {lbl7.setText("oui");}
	    if(!AdminSystemeController.filter.get(index).isNegociable())
	    {lbl7.setText("non");}
	    lbl8.setText(AdminSystemeController.filter.get(index).getDate().toString());
	    lbl5.setText(new Long(AdminSystemeController.filter.get(index).getPrix()).toString()+" DA");
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("vente"))
	    {
	    	lbl4.setText("vente");
	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixVente()).toString()+" DA");
	    }
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("location"))
	    {
	    	lbl4.setText("location");
	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixLocation()).toString()+"DA");
	    }
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("echange"))
	    {
	    	lbl4.setText("echange");
	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixEchange(2)).toString()+ "DA");
	    }
	    try {
	    	Image image;
			image = new Image( new FileInputStream(AdminSystemeController.filter.get(index).getPhoto()));
			img.setImage(image);
		} catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
    	
    	}
    	else
    	{
    		index=AdminSystemeController.filter.size() -1;
    		size.setText("Nombre de biens: "+new Integer(AdminSystemeController.filter.size()).toString());
        	lbl9.setText(new Integer(AdminSystemeController.filter.get(index).getWillaya()).toString());
    	    lbl1.setText(AdminSystemeController.filter.get(index).getAdress_exct());
    	    lbl2.setText(new Double(AdminSystemeController.filter.get(index).getSuperficie()).toString());
    	    lbl3.setText(AdminSystemeController.filter.get(index).getProp().getPrenom()+" "+AdminSystemeController.filter.get(index).getProp().getNom());
    	   
    	    if(AdminSystemeController.filter.get(index).isNegociable())
    	       {lbl7.setText("oui");}
    	    if(!AdminSystemeController.filter.get(index).isNegociable())
    	    {lbl7.setText("non");}
    	    lbl8.setText(AdminSystemeController.filter.get(index).getDate().toString());
    	    lbl5.setText(new Long(AdminSystemeController.filter.get(index).getPrix()).toString()+" DA");
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("vente"))
    	    {
    	    	lbl4.setText("vente");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixVente()).toString()+" DA");
    	    }
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("location"))
    	    {
    	    	lbl4.setText("location");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixLocation()).toString()+"DA");
    	    }
    	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("echange"))
    	    {
    	    	lbl4.setText("echange");
    	    lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixEchange(2)).toString()+ "DA");
    	    }
    	    try {
    	    	Image image;
    			image = new Image( new FileInputStream(AdminSystemeController.filter.get(index).getPhoto()));
    			img.setImage(image);
    		} catch (FileNotFoundException e1) {
    			
    			e1.printStackTrace();
    		}
    	}
    }
	@SuppressWarnings("deprecation")
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		index=0;
		size.setText("Nombre de biens: "+new Integer(AdminSystemeController.filter.size()).toString());
    	lbl9.setText(new Integer(AdminSystemeController.filter.get(index).getWillaya()).toString());
	    lbl1.setText(AdminSystemeController.filter.get(index).getAdress_exct());
	    lbl2.setText(new Double(AdminSystemeController.filter.get(index).getSuperficie()).toString());
	    lbl3.setText(AdminSystemeController.filter.get(index).getProp().getPrenom()+" "+AdminSystemeController.filter.get(index).getProp().getNom());
	   
	    if(AdminSystemeController.filter.get(index).isNegociable())
	       {lbl7.setText("oui");}
	    if(!AdminSystemeController.filter.get(index).isNegociable())
	    {lbl7.setText("non");}
	    lbl8.setText(AdminSystemeController.filter.get(index).getDate().toString());
	    lbl5.setText(new Long(AdminSystemeController.filter.get(index).getPrix()).toString()+" DA");
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("vente")){
	    	lbl4.setText("vente");
	    	lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixVente()).toString()+" DA");
	    }
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("location")){
	    	lbl4.setText("location");
	    	lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixLocation()).toString()+"DA");
	    }
	    if(AdminSystemeController.filter.get(index).getNatureTrans().equals("echange")){
	    	lbl4.setText("echange");
	    	lbl6.setText(new Double(AdminSystemeController.filter.get(index).calculerPrixEchange(2)).toString()+ "DA");
	    }
	    
	    try {
	    	Image image;
			image = new Image( new FileInputStream(AdminSystemeController.filter.get(index).getPhoto()));
			img.setImage(image);
		} 
	    catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
		}
	}
}
