package Noyau;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Propritaire implements Serializable{

    private String nom ;
    private String prenom ;
    private String mail ;
    private int tele ;
    private String adress ;
    public String getNom() {
		return nom;
	}
 
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getTele() {
		return tele;
	}

	public void setTele(int tele) {
		this.tele = tele;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public ArrayList<Bien> getListebien() {
		return listebien;
	}

	public void setListebien(ArrayList<Bien> listebien) {
		this.listebien = listebien;
	}

	private ArrayList<Bien> listebien=new ArrayList<Bien>();
     public Propritaire() {}
    public Propritaire(String nom , String prenom , String mail , int tele , String adress )
    {
        this.nom = nom ;
        this.prenom = prenom ; 
        this.mail = mail ;
        this.tele = tele ;
        this.adress = adress ;
    }

    public void ajouter_bien ( Bien ob )
    {
        listebien.add(ob) ;
    }

    public void AfficherProprietaire ()
    {
        System.out.println("Nom : "+nom+"   prenom : "+prenom+"   mail : "+mail+"  tele : "+tele+"   adress : "+adress);
        for(Bien e:listebien)
        {   
        	System.out.println ( " adress exacte : "+e.getAdress_exct()+"   Willaya : "+e.getWillaya()+"\n superfiçie : "+e.getSuperficie()+"\n la nature de transaction : "	+e.getNatureTrans()+"\n prix initial : "+e.getPrix()+"\n negociable : "+e.isNegociable()+"\n description du bien : "+e.getDescription()+"\n Lien vers les photos : "+ e.getPhoto() );
            System.out.println("----------------------");
        }
    }
        
}
