package Noyau;
abstract class BienHabitable extends Bien {

    protected int pieces ;
    protected boolean meuble ;
  
	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public boolean isMeuble() {
		return meuble;
	}

	public void setMeuble(boolean meuble) {
		this.meuble = meuble;
	}
     public BienHabitable() {}
	public BienHabitable ( String adress_exct , double superficie , Propritaire prop , String natureTrans , Boolean negociable , String description , String photo , int pieces , boolean meuble , long prix , int willaya){
        super ( adress_exct , superficie , prop , natureTrans , negociable , description ,photo , prix , willaya ) ;
        this.pieces = pieces ;
        this.meuble = meuble ;
       
    }

    public void AfficherBien() {
        
        super.AfficherBien();
        System.out.println ( " le nombre de pieces : "+pieces+" Meublé : " + meuble ) ;  
    }
}
