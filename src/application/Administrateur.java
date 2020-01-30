package application;


public class Administrateur 
{  
	public boolean login (String usernam, String passwor ) {
    	if(usernam.compareTo("admin")==0 && passwor.compareTo("admin")==0)
    		return true; 
    	else { 
    		return false;
    
    	}
    }
}
