import Arbori.ArboreFunctional;
import Arbori.Nod;
import FunctiiElementare.Necunoscuta;
import FunctiiTrigo.Cos;
import FunctiiTrigo.Sin;
import Operatori.Cat;


public class Main {
	
	public static void main(String [] args){
		Nod n=new Necunoscuta();
		Nod sin=new Sin();
		Nod cos=new Cos();
		Nod xn=new Necunoscuta();
		Nod cat=new Cat();
		cat.setFStang(n);
		cat.setFDrept(sin);
		cat.setFStang(cos);
		cat.setFStang(xn);
		
		ArboreFunctional a=new ArboreFunctional(cat);
		
		
	}

}
