package FunctiiTrigo;
import Functii.*;



public class Sin extends Functie {
	public String concatTermeni(String a){
		String aux;
		int nrP;
		nrP=a.charAt(0)=='(' ? 0 : 2;
		aux="sin";
		if(nrP!=0) aux+="(";
		aux+=a;
		if(nrP!=0) aux+=")";
			return aux;
	}
	
	
	public static String concatTermens(String a){
		String aux;
		int nrP;
		nrP=a.charAt(0)=='(' ? 0:2;
		aux="sin";
		if(nrP!=0) 
			aux+="(";
		aux+=a;
		if(nrP!=0)
			aux+=")";
		return aux;
	}

}
