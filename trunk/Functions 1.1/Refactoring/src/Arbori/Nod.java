package Arbori;

import visitor.Visitor;

public class Nod {
	protected Nod fStang;
	protected Nod fDrept;
	protected double x;
	public Nod getFStang() {
		return fStang;
	}
	public void setFStang(Nod stang) {
		fStang = stang;
	}
	public Nod getFDrept() {
		return fDrept;
	}
	public void setFDrept(Nod drept) {
		fDrept = drept;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void acceptVisitor(Visitor v){
		v.visit(this);
	}
}
