package Arbori;
import visitor.*;


public class ArboreFunctional {
	protected Nod radacina;
	
	public Nod getRadacina() {
		return radacina;
	}

	public void setRadacina(Nod radacina) {
		this.radacina = radacina;
	}

	public ArboreFunctional(Nod radacina){
		this.radacina=radacina;
	}
	void acceptVisitor(Visitor v){
		v.visit(radacina);
	}
	
	
}
