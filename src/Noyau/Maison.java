package Noyau;


public class Maison extends BienHabitable { 
// la class maison !

    private int nbetage ; 
    public int getNbetage() {
		return nbetage;
	}

	public void setNbetage(int nbetage) {
		this.nbetage = nbetage;
	}

	public boolean isGarage() {
		return garage;
	}

	public void setGarage(boolean garage) {
		this.garage = garage;
	}

	public boolean isJardin() {
		return jardin;
	}

	public void setJardin(boolean jardin) {
		this.jardin = jardin;
	}

	public boolean isPicine() {
		return picine;
	}

	public void setPicine(boolean picine) {
		this.picine = picine;
	}

	private boolean garage ; 
    private boolean jardin ;
    private boolean picine ;
    private double superficieHabitable;
    public Maison()
    {
    	
    }
public Maison(int nbetage,boolean garage,boolean jardin,boolean picine ,String adress_exct , double superficie , Propritaire prop , String natureTrans , Boolean negociable , String description , String photo,int pieces  ,boolean meuble, long prix , int willaya,double superficieHabitable )throws SuperficieException {
        super ( adress_exct , superficie , prop , natureTrans , negociable , description , photo , pieces , meuble , prix , willaya) ;
        this.nbetage = nbetage ;
        this.garage = garage ; 
        this.jardin = jardin ;
        this.picine = picine ; 
        this.superficieHabitable=superficieHabitable;
        if(superficie < superficieHabitable || superficie<0)
        {
        	throw new SuperficieException("Attention la superficie habtiable est superieure a la superficie totale");
        }
    }

    public void AfficherBien() {
        
        super.AfficherBien();

        System.out.println("\n nombre d etage : "+nbetage+"\n avec garage ? : "+garage+"\n jardin ? : "+jardin+"\n picine ? : "+picine);
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

        if ( (jardin) || (picine) || (garage) )
        {
            price = price + ( ( prix * 0.5 ) / 100 ) ;
        }

        return price ;
    }

    public double calculerPrixLocation (  )
    {
        double price = prix ;
        Wilaya tabwilaya = new Wilaya() ;
        long priceMC = tabwilaya.prixmc [ willaya] ;

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

        if ( picine ) // si il y a un picine on ajout au prix 50000 DA 
        {
            price =+ 50000 ;
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

        if ( (jardin == true ) || (picine == true ) || (garage == true ) )
        {
            price = price + ( ( prix * 0.5 ) / 100 ) ;
        }

        if ( matrWiladeCust != willaya )
        {
            price =price+ ( ( prix * 0.25 ) / 100 ) ;
        }

        return price ;
    }

	public double getSuperficieHabitable() {
		return superficieHabitable;
	}

	public void setSuperficieHabitable(double superficieHabitable) {
		this.superficieHabitable = superficieHabitable;
	}

}