package Noyau;
public class Inhabitable extends Bien {

    private String statueJuridique ;
    private int nbfacade ;

    public String getStatueJuridique() {
		return statueJuridique;
	}

	public void setStatueJuridique(String statueJuridique) {
		this.statueJuridique = statueJuridique;
	}

	public int getNbfacade() {
		return nbfacade;
	}

	public void setNbfacade(int nbfacade) {
		this.nbfacade = nbfacade;
	}
   public Inhabitable() {}
	public Inhabitable ( String statueJuridique , int nbfacade , String adress_exct , double superficie , Propritaire prop , String natureTrans , Boolean negociable , String description , String photo ,long prix , int willaya ) 
    {
        super ( adress_exct , superficie , prop , natureTrans , negociable , description , photo , prix , willaya ) ;
        this.statueJuridique = statueJuridique ; 
        this.nbfacade = nbfacade ;

    } 

    public void afficherBien ( ) { 
        super.AfficherBien();
        System.out.println ( " statue Juridique : "+statueJuridique+"\n nombre de façade : "+nbfacade ); 
    } 

    public double calculerPrixVente (  ) // Le matricule de la willaya
    {
        //Willaya wila = Willaya.
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [willaya] ;

        if ( prix < 5000000 )  // < A 5 millions DA en ajout 3 % du prix 
        {
            if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 3 % du prix 
            {
                price = prix + ( ( prix * 3 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 3.5 % du prix 
            {
                price = prix + ( ( prix * 3.5 ) / 100 ) ;
            }
        }

        if ( prix > 5000000 && prix < 15000000 ) // si le prix entre 5 et 15 millions DA 
        {
            if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 2 % du prix 
            {
                price = prix + ( ( prix * 2 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 2.5 % du prix 
            {
                price = prix + ( ( prix * 2.5 ) / 100 ) ;
            }
        }

        if ( prix > 15000000 ) // le prix est superieur a 15 millions
        {
            if (priceMC < 70000) // le prix de metre carre est un inferieur a 70000 DA alors on ajout 1 % du prix 
            {
                price = prix + ( ( prix * 1 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 2 % du prix 
            {
                price = prix + ( ( prix * 2 ) / 100 ) ;
            }
        }
       
        if ( nbfacade > 1 )
        {
        	price = price + ( ( prix * 0.5 ) / 100 ) ;
        }
        
        return price ;
    }

    public double calculerPrixLocation ( )
    {
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [willaya] ;

        if ( superficie < 60 ) // la superficie est inferieure a 60 metre carre
        {
            if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 1 % du prix 
            {
                price = prix + ( prix / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 1.5 % du prix 
            {
                price = prix + ( ( prix * 1.5 ) / 100 ) ;
            }
        }
        else {
            if ( superficie > 60 && superficie < 150 )// la superficie est inferieure a 150 et superieur a 60 metre carre alors on ajout 1 % au prix 
            {
                if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 2 % du prix 
                {
                    price = prix + ( ( prix * 2 ) / 100 ) ;
                }
                else // le prix de metre carre est un superieur a 50000 DA alors on ajout 2.5 % du prix 
                {
                    price = prix + ( ( prix * 2.5 ) / 100 ) ;
                } 
            }
            else {
                if ( superficie > 150 ) // la superficie est superieur a 150 metre carre
                {
                    if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 3 % du prix 
                    {
                        price = prix + ( ( prix * 3 ) / 100 ) ;
                    }
                    else // le prix de metre carre est un superieur a 50000 DA alors on ajout 3.5 % du prix 
                    {
                        price = prix + ( ( prix * 3.5 ) / 100 ) ;
                    } 
                }
            }
        }

        return price ;
    }

    public double calculerPrixEchange ( int matrWiladeCust )
    {
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [willaya] ;


        if ( prix < 5000000 )  // < A 5 millions DA en ajout 3 % du prix 
        {
            if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 3 % du prix 
            {
                price = prix + ( ( prix * 3 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 3.5 % du prix 
            {
                price = prix + ( ( prix * 3.5 ) / 100 ) ;
            }
        }

        if ( prix > 5000000 && prix < 15000000 ) // si le prix entre 5 et 15 millions DA 
        {
            if (priceMC < 50000) // le prix de metre carre est un inferieur a 50000 DA alors on ajout 2 % du prix 
            {
                price = prix + ( ( prix * 2 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 2.5 % du prix 
            {
                price = prix + ( ( prix * 2.5 ) / 100 ) ;
            }
        }

        if ( prix > 15000000 ) // le prix est superieur a 15 millions
        {
            if (priceMC < 70000) // le prix de metre carre est un inferieur a 70000 DA alors on ajout 1 % du prix 
            {
                price = prix + ( ( prix * 1 ) / 100 ) ;
            }
            else // le prix de metre carre est un superieur a 50000 DA alors on ajout 2 % du prix 
            {
                price = prix + ( ( prix * 2 ) / 100 ) ;
            }
        }
        
        if ( nbfacade > 1 )
        {
        	price = price + ( ( prix * 0.5 ) / 100 ) ;
        }

        if ( matrWiladeCust != willaya )
        {
            price =price +( ( prix * 0.25 ) / 100 ) ;
        }

        return price ;
    }

	

}