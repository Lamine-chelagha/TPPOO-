package Noyau;

public class Administrateur {
    private String name;
    private String prenom;
    private String motDePass;
    private String User;
    
	public Administrateur(String nom,String pnom,String password,String username) {
		// TODO Auto-generated constructor stub
		name=nom;
		prenom=pnom;
		motDePass=password;
		User=username;
	}
 public boolean login(String us,String pass)
 {

 	if(us.compareTo(User)==0 && pass.compareTo(motDePass)==0)
		return true; 
 	else return false;
 }
}
