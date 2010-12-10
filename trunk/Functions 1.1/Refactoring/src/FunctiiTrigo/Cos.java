package FunctiiTrigo;
import Functii.*;

public final class Cos extends Functie {
	public String concatTermeni(String a){
		String aux;
		int nrP;
		
		nrP=a.charAt(0)=='(' ? 0:2;
		
		aux="cos";
		if(nrP!=0) 
			aux+="(";
		aux+=a;
		if(nrP!=0)
			aux+=")";
		return aux;
	}
	
	
	public static String concatTermens(String a){
		String aux;
		int nrP;
		
		nrP=a.charAt(0)=='(' ? 0:2;
		
		aux="cos";
		if(nrP!=0) 
			aux+="(";
		aux+=a;
		if(nrP!=0)
			aux+=")";
		return aux;
	}

}
