package Operatori;
import Arbori.Nod;

public final class Produs extends Operator {
		
	public String concatTermeni(String a,String b){
		String aux;
		if(a.compareTo("0")==0 || b.compareTo("0")==0)
			aux=a;
		else
			if(a.compareTo("0")==0)
				aux=b;
			else 
				if(b.compareTo("0")==0)
					aux=a;
				else
					aux=a+"*"+b;
		return aux;
	}
	
	public static String concatTermens(String a,String b){
		String aux;
		if(a.compareTo("0")==0 || b.compareTo("0")==0)
			aux=a;
		else
			if(a.compareTo("0")==0)
				aux=b;
			else 
				if(b.compareTo("0")==0)
					aux=a;
				else
					aux=a+"*"+b;
		return aux;
	}

}
