package Noyau;


public class Appart extends BienHabitable {

    private int etage ; 
    public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public boolean isAscenseur() {
		return ascenseur;
	}

	public void setAscenseur(boolean ascenseur) {
		this.ascenseur = ascenseur;
	}

	public boolean isSimplexe() {
		return simplexe;
	}

	public void setSimplexe(boolean simplexe) {
		this.simplexe = simplexe;
	}

	private boolean ascenseur ;
    private boolean simplexe ; // si elle est a faux donc duplexe
   public Appart() {}
    public Appart ( int etage , boolean ascenseur , boolean simplexe , String adress_exct , double superficie , Propritaire prop , String natureTrans , Boolean negociable , String description ,String photo , int pieces , boolean meuble , long prix , int Wilaya )
    {
        super ( adress_exct , superficie , prop , natureTrans , negociable , description , photo , pieces , meuble , prix , Wilaya ) ;
        this.etage = etage ; 
        this.ascenseur = ascenseur ;
        this.simplexe = simplexe ;
    }

    public void AfficherBien() {

        super.AfficherBien(); 
        System.out.println("\n Nombre d etage : "+etage+"\n Ascenceur : "+ascenseur);
        if ( simplexe = true )
            System.out.println("\n l appartement est une : simplexe ");
        else
            System.out.println("\n l appartement est une : duplexe ");

    }

    public double calculerPrixVente (  ) // Le matricule de la willaya
    {
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [ willaya ] ;

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

        if ( etage == 0 || etage == 1 || etage == 2  ) 
        {
            price = price + 50000 ;
        }

        return price ;
    }

    public double calculerPrixLocation (  )
    {
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [willaya];

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

        if ( etage == 0 || etage == 1 || etage == 2  ) 
        {
            price = price + 5000 ;
        }

        if ( etage > 6 && (ascenseur == false ) ) // reuction si il n y a pas d'ascenseur
        {
            price = price - ( superficie * 500 ) ;
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
        
        if ( etage == 0 || etage == 1 || etage == 2  ) 
        {
            price = price + 50000 ;
        }

        if ( matrWiladeCust != willaya )
        {
            price =price+ ( ( prix * 0.25 ) / 100 ) ;
        }

        return price ;
    }

}
