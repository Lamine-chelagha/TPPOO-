package Noyau;
import java.io.Serializable;
import java.util.Date;

public abstract class Bien implements Serializable{ 

    protected String adress_exct ;
    protected double superficie ;
    protected Propritaire prop ;
    protected String natureTrans ;
    protected long prix ;
    protected boolean negociable ; 
    protected String description ;
    protected Date date ; 
    protected String photo ;
    protected int willaya ;
    
   
	public String getAdress_exct() {
		return adress_exct;
	}

	public void setAdress_exct(String adress_exct) {
		this.adress_exct = adress_exct;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Propritaire getProp() {
		return prop;
	}

	public void setProp(Propritaire prop) {
		this.prop = prop;
	}

	public String getNatureTrans() {
		return natureTrans;
	}

	public void setNatureTrans(String natureTrans) {
		this.natureTrans = natureTrans;
	}

	public long getPrix() {
		return prix;
	}

	public void setPrix(long prix) {
		this.prix = prix;
	}

	public boolean isNegociable() {
		return negociable;
	}

	public void setNegociable(boolean negociable) {
		this.negociable = negociable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getWillaya() {
		return willaya;
	}

	public void setWillaya(int willaya) {
		this.willaya = willaya;
	}
    public Bien() {}
	public Bien ( String adress_exct , double superficie , Propritaire prop , String natureTrans , Boolean negociable , String description , String photo , long prix , int willaya ) {
        this.adress_exct = adress_exct ;
        this.superficie = superficie ; 
        this.prop = prop ;
        this.natureTrans = natureTrans ; 
        this.prix = prix ;
        this.negociable = negociable ;
        this.description = description ; 
        date=new Date() ;
        this.photo = photo ;
        this.willaya = willaya ;
    }

    public void AfficherBien ( ) { 
        System.out.println ( " adress exacte : "+adress_exct+"   Willaya : "+willaya+"\n superfiçie : "+superficie+"\n la nature de transaction : "+natureTrans+"\n prix initial : "+prix+"\n negociable : "+negociable+"\n description du bien : "+description+"\n Lien vers les photos : "+ photo );
        System.out.println(" le proprietaire :") ; 
        prop.AfficherProprietaire() ;
    }

  

    public abstract double calculerPrixVente() ;
    public abstract double calculerPrixLocation() ;
    public abstract double calculerPrixEchange (int matrWiladeCust) ;
    
    

}