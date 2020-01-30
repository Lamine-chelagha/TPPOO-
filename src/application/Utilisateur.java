package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Utilisateur 
{
    public void signUp(String name,String LastName,String username,String password)
    {
    	try {
    		FileWriter fw = new FileWriter("users.txt", true);
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    PrintWriter out = new PrintWriter(bw);
    	    out.println(username+" "+password+" "+name+" "+LastName);
    	    out.close();
    
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

   public boolean login( String usernam,String passwor)
   {
	   String username="";
	   String password="";
	   try {
		   FileInputStream fstream = new FileInputStream("users.txt");
		   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		   String strLine;
		   char c;
		   int i=0;
		   String word="";
		   int cpt=0;
		   //Read File Line By Line
		   while ((strLine = br.readLine()) != null)   
		   {
			  	 cpt=0;
			  	 i=0;
			  	 word="";
			   while(i<strLine.length() && cpt!=2)
			      {
				   c=strLine.charAt(i);
			    	  if(c==' ')
			    	  {  
			    		 cpt++; 
			    		 if(cpt==1)
				    	  {  
				    		 username=word; 
				    	  }

				    	  if(cpt==2)
				    	  {  
				    		  password=word;
				    	  }  
			    		 word="";
			    	  }
			    	  else {
			    		  word=word+c;
			    	  }
			    	  i++;
		   }
		   }   
		   br.close();
	} 
	   catch (Exception e) 
	   {
		e.printStackTrace();
	   }
	   if(usernam.compareTo(username)==0 && passwor.compareTo(password)==0)
			return true; 
	    	else return false;
	   }
   
   
   public boolean login( String usernam)
   {
	   String username="";
	   try {
		   FileInputStream fstream = new FileInputStream("users.txt");
		   BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		   String strLine;
		   char c;
		   int i=0;
		   String word="";
		   int cpt=0;
		   //Read File Line By Line
		   while ((strLine = br.readLine()) != null)   
		   {
			  	 cpt=0;
			  	 i=0;
			  	 word="";
			   while(i<strLine.length() && cpt!=1)
			      {
				   c=strLine.charAt(i);
			    	  if(c==' ')
			    	  {  
			    		 cpt++; 
			    		 if(cpt==1)
				    	  {  
				    		 username=word; 
				    	  }
			    		 word="";
			    	  }
			    	  else {
			    		  word=word+c;
			    	  }
			    	  i++;
		   }
		   }   
		   br.close();
	} 
	   catch (Exception e) 
	   {
		e.printStackTrace();
	   }
	   if(usernam.compareTo(username)==0)
			return true; 
	    	else return false;
	   }   
}

