package visitor;

import Arbori.Nod;
import FunctiiElementare.Constanta;
import FunctiiElementare.Necunoscuta;
import FunctiiTrigo.Cos;
import FunctiiTrigo.Sin;
import Operatori.Cat;
import Operatori.Minus;
import Operatori.Plus;
import Operatori.Produs;

public class DerivareVisitor extends Visitor{
String derivare;
	
	public DerivareVisitor()
	{
		derivare="";
	}
		
	public String getDerivare() {
		return derivare;
	}

	public void setDerivare(String derivare) {
		this.derivare = derivare;
	}


	public void visit(Plus p) {
		if ( p.getFStang() != null && p . getFDrept() != null )
		{
		visit(p.getFStang()) ;
		String s1=this.derivare;
		visit ( p.getFDrept() ) ;
		String s2=this.derivare ;
		derivare=p.concatTermeni( s1 , s2 ) ;
		}
		
	}


	public void visit(Minus m) {
		if ( m.getFStang() != null && m.getFDrept() != null )
		{
		visit(m.getFStang()) ;
		String s1=this.derivare;
		visit ( m.getFDrept() ) ;
		String s2=this.derivare ;
		derivare=m.concatTermeni( s1 , s2 ) ;
		}
		
	}


	public void visit(Cat c) {
		if ( c.getFStang() != null && c.getFDrept() != null )
		{
		ToStringVisitor v=new ToStringVisitor();
		v.visit(c.getFStang());
		String f=v.getS();
		v.setS("");
		v.visit(c.getFDrept());
		String g=v.getS();
		
		visit(c.getFStang()) ;
		String s1=this.derivare;
		visit ( c.getFDrept() ) ;
		String s2=this.derivare ;

		String aux1=Produs.concatTermens("("+s2+")","("+f+")");
		String aux2=Produs.concatTermens("("+g+")", "("+s1+")");
		String aux3=Plus.concatTermens("("+aux1+")", "("+aux2+")");
		String aux4=Produs.concatTermens("("+g+")","("+ g+")");
		derivare=Cat.concatTermens("("+aux3+")", "("+aux4+")");
		}
		
		
	}


	public void visit(Produs p) {
		if ( p.getFStang() != null && p.getFDrept() != null )
		{
		ToStringVisitor v=new ToStringVisitor();
		v.visit(p.getFStang());
		String f=v.getS();
		v.setS("");
		v.visit(p.getFDrept());
		String g=v.getS();
		
		visit(p.getFStang()) ;
		String s1=this.derivare;
		visit ( p.getFDrept() ) ;
		String s2=this.derivare ;

		String aux1=Produs.concatTermens("("+s2+")", "("+f+")");
		String aux2=Produs.concatTermens("("+g+")", "("+s1+")");
		derivare=Plus.concatTermens(aux1, aux2);
		}
		
	}


	public void visit(Necunoscuta n) {
		derivare="1";
		
	}


	public void visit(Constanta c) {
		derivare="0";
		
	}


	public void visit(Sin s) {
		if ( s.getFStang() != null )
		{
			visit(s.getFStang());
			String s1=derivare;
			ToStringVisitor v=new ToStringVisitor();
			v.visit(s.getFStang());
			String s2=v.getS();
			derivare=Produs.concatTermens(s1,
					Cos.concatTermens(s2));

		}
		
	}


	public void visit(Cos c) {
		if ( c.getFStang() != null )
		{
			visit(c.getFStang());
			String s1=derivare;
			ToStringVisitor v=new ToStringVisitor();
			v.visit(c.getFStang());
			String s2=v.getS();
			derivare=Produs.concatTermens(s1,
					"(-"+Sin.concatTermens(s2)+")");

		}
		
	}

	



	
	public void visit(Nod n) {
		if ( n instanceof Necunoscuta ) this.visit((Necunoscuta)n);
		if ( n instanceof Constanta ) this.visit((Constanta)n);
		if ( n instanceof Plus ) this.visit((Plus)n);
		if ( n instanceof Minus ) this.visit((Minus)n);
		if ( n instanceof Cat ) this.visit((Cat)n);
		if ( n instanceof Produs ) this.visit((Produs)n);
		if ( n instanceof Sin ) this.visit((Sin)n);
		if ( n instanceof Cos ) this.visit((Cos)n);
		
	}

}

