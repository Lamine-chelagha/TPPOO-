package Noyau;

import java.io.Serializable;
import java.util.*;

public class Systeme implements Serializable{

	    private ArrayList <Bien> listedesBien = new ArrayList<Bien> () ;
	    public ArrayList<Bien> getListedesBien() {
			return listedesBien;
		}
		public void setListedesBien(ArrayList<Bien> listedesBien) {
			this.listedesBien = listedesBien;
		}

		private ArrayList<Bien> listeArchive = new ArrayList<Bien> () ; 
        private ArrayList <String> messageClientel=new ArrayList<String>();
        private ArrayList <String> listCritere= new ArrayList<String>();
     
       
	  public void Afficherprix()
	  {
		  System.out.println("Quel bien souhaitez vous connaitre le prix");
		  int i=0;
	        for (Bien bien : listedesBien) {
	          System.out.println(i +":"+ bien.description +" "+ bien.photo);
	          i++;
	            System.out.println("\n------------------------------------------------\n");
	        } 
	        Scanner ch= new Scanner(System.in);
	        int choix=ch.nextInt();
	        i=0;
	       
	       
	     for(Bien e:listedesBien)
	        {
	        	if(i==choix)
	        	{	 if (e.getNatureTrans()=="vente")
	        	{
	        		System.out.println("le prix de vente du bien choisi : "+e.calculerPrixVente());
	        	}
	        	 if (e.getNatureTrans()=="location")
	        	 {
	        		 System.out.println("le prix de location du bien choisi : "+e.calculerPrixLocation()); 
	        	 }
	        	 if (e.getNatureTrans()=="echange")
	        	 {
	        		 System.out.println("saisir le code de votre wilaya pour savoir le prix d'echange");
	         		 int code=ch.nextInt();
	        		 System.out.println("le prix d'echange du bien choisi : "+e.calculerPrixEchange(code)); 
	        	 }
	        		
	        	}
	        	i++;
	        }
	  }
	   public void afficherSansDetail()
	   {    
               for(Bien e: listedesBien)
               {
			   System.out.println ("description: " +e.description +" lien vers la photo: "+ e.photo +" Date d'ajout: "+e.getDate());
	   }}
        public void  PutSortedInformation()
        {
           for(Bien e:listedesBien)
           {
        	   e.AfficherBien();
           }
        }
	    public void ajouterBien ( Bien objet )
	    {
	        listedesBien.add ( objet ) ;
	    }

	    public void suppBien (Bien ob)
	    {
	       listedesBien.remove(ob) ;
	    }
	    

	    public void modifiBien ()
	    {
	    	int i=0;
	        for (Bien bien : listedesBien) {
	          System.out.println(i +":"+ bien.description + bien.photo);
	          i++;
	            System.out.println("\n------------------------------------------------\n");
	        }
	        
	        System.out.println("choisir le bien que vous voulez modifier");
	        Scanner ch= new Scanner(System.in);
	        int choix=ch.nextInt();
	        
	        i=0;
	        long newprice;
	       for(Bien e:listedesBien)
	        {
	        	if(i==choix)
	        	{	System.out.println("Saisir le nouveau prix du bien");
	        	    newprice=ch.nextLong();
	        		e.setPrix(newprice);
	        	}
	        		
	        	i++;
	        }
	    }

	    public void visualiserBien ( ) 
	    {
	    	int i=0;
	        for (Bien bien : listedesBien) {
	          System.out.println(i +":"+ bien.description +" "+ bien.photo);
	          i++;
	           
	        }
	        System.out.println("\n------------------------------------------------\n");
	        Scanner ch= new Scanner(System.in);
	        int choix=ch.nextInt();
	       
	        i=0;
	      	 for(Bien e:listedesBien)       {
	        	if(i==choix)
	        	{
	        		System.out.println ( " adress exacte : "+e.getAdress_exct()+"   Willaya : "+e.getWillaya()+"\n superfiçie : "+e.getSuperficie()+"\n la nature de transaction : "	+e.getNatureTrans()+"\n prix initial : "+e.getPrix()+"\n negociable : "+e.isNegociable()+"\n description du bien : "+e.getDescription()+"\n Lien vers les photos : "+e.getPhoto() );
	        	}
	        	i++;
	        }
	    }

	    public void archiveBien (Bien obj) 
	    {
	        listeArchive.add(obj);
	        suppBien(obj);
	    }
	    public void affichierArchive ( )
	    {
	        for (Bien bien : listeArchive) {
	            bien.AfficherBien();
	            System.out.println("\n-------------------------------------------------\n");
	        }
	    }
        public void PutForProp(Propritaire prop)
        {
        	prop.AfficherProprietaire();
        }
        
        public ArrayList <Bien> filtrer ( String critere,int entier)
        {
         
            ArrayList <Bien> listeFiltrer = new ArrayList<Bien> () ; 
            int choix = 0;
            int key = 0 ;
            long bs = 0 , bi = 0 ; 
            double superficiefiltr ;
            Class<?> typeClass ;
            Propritaire prop = new Propritaire("", "", "",0,"");
            Maison mais = new Maison();
            Appart apart = new Appart();
            Inhabitable inh = new Inhabitable();
            
            if(critere.equals("Maison"))
            {
            	choix=1;
            }
            if(critere.equals("Appartement"))
            {
            	choix=2;
            }
            if(critere.equals("Terrains"))
            {
            	choix=3;
            }
            if(critere.equals("type transaction:Vente"))
            {
            	choix=4;
            }
            if(critere.equals("type transaction:Location"))
            {
            	choix=5;
            }
            if(critere.equals("type transaction:Echange"))
            {
            	choix=6;
            }
            if(critere.equals("Par wilaya"))
            {
            	choix=7;
            }
            if(critere.equals("Inferieur à xxxx Dinars"))
            {
            	choix=8;
            }
            if(critere.equals("Superficie minimale"))
            {
            	choix=9;
            }
            if(critere.equals("Les biens negociables"))
            {
            	choix=10;
            }
            

            switch (choix) {
                case 1 :
                    System.out.println("\n filtrer par le type de bien : ");
                    System.out.println("\n choisie le type de Bien : ( 1 : Maison / 2 : Apparetement / 3 : Inhabitable )");
                   
                        typeClass = mais.getClass();
                        System.out.println("\n les maisons : ");
                        for (Bien bien : listedesBien) {
                            if ( bien.getClass() == typeClass )
                            {
                                listeFiltrer.add(bien);
                            }
                        }
                       break;
                       
                case 2:
                    	   
                            typeClass = apart.getClass();
                            System.out.println("\n les Appartements : ");
                            for (Bien bien : listedesBien) {
                            if ( bien.getClass() == typeClass )
                            {
                                listeFiltrer.add(bien);
                            }
                            }
                break;
                
                case 3:
                                typeClass = inh.getClass();
                                System.out.println("\n les Biens inhabitable : ");
                                for (Bien bien : listedesBien) {
                                if ( bien.getClass() == typeClass )
                                {
                                    listeFiltrer.add(bien);
                                }
                                }
                    break;

                    case 4 : 
                        System.out.println("\n filtrage par le Type de transaction : ");
                        System.out.print("\n choisie le type de transaction : ( 1 : vente / 2 : location / 3 : echange ) ");
                     
                        System.out.println("\n par vente ... ");
                        for (Bien bien : listedesBien) {
                            if ( bien.getNatureTrans().compareTo("vente") == 0 )
                            {
                                listeFiltrer.add(bien);
                            }
                        }
                        break;
                        case 5:
                        
                                System.out.println("\n par location ... ");
                                for (Bien bien : listedesBien) {
                                    if ( bien.getNatureTrans().compareTo("location") == 0 )
                                    {
                                        listeFiltrer.add(bien);
                                    }
                                }
                            break;
                            case 6:
                            	
                                typeClass = inh.getClass();
                                for (Bien bien : listedesBien) {
                                    if ( bien.getNatureTrans().compareTo("echange") == 0 )
                                    {
                                        listeFiltrer.add(bien);
                                    }
                                }
                    break ;

                    case 7 :

                        System.out.println("\n filtrage par la willaya souhaitee : ");
                        System.out.print("\n donner la willaya : ");
                                       
                        
                          
                        for (Bien bien : listedesBien) {
                            if ( bien.getWillaya() == entier )  // si l attribut de bien egale a willaya souhaitee dans key alors on ajout dans la liste de filtrage 
                            {
                                listeFiltrer.add(bien);
                            }
                        }

                    break ;

                    case 8 :

                        System.out.println("\n filtrage par prix : ( 1 : prix max seul / 2 : prix min seul / 3 : intervale )");
                         
                          
                          
                        for (Bien bien : listedesBien) {
                            
                            if ( ( bien.getPrix() ) < entier  )
                            {
                                listeFiltrer.add(bien);
                            }

                        }

                    break ;

                    case 9 :
                        System.out.println("\n filtrage par la superficie : ");
                        System.out.println("\n entrer la superficie min pour le filtrage : ");
                        

                        for (Bien bien : listedesBien) {

                            if ( bien.getSuperficie() > entier )
                            {
                                listeFiltrer.add(bien);
                            }
                        }
                        
                    break ;

                    case 10 :
                        System.out.println("\n filtrer les biens negociables seulement : ");

                        for (Bien bien : listedesBien) {
                            if (bien.isNegociable() == true ){

                                listeFiltrer.add(bien) ;

                            }
                        }
                        
                    break ;
                
                default:
                    break;
                }
                    return listeFiltrer ; 
            }
        
        
        public void client(String message)
        {
        	messageClientel.add(message);
        }

        public void AjoutCritere(String nouv)
        {
        	listCritere.add(nouv);
        }
}