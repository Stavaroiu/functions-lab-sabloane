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

public class CalculVisitor extends Visitor{
	double value;
	double startValue;
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
		
	}

	public void visit(Plus p) {
		if ( p.getFStang() != null && p . getFDrept() != null )
		{
		visit(p.getFStang()) ;
		double x1=getValue();
		visit ( p.getFDrept() ) ;
		double x2=getValue();
		value=x1+x2;
		}
		
	}

	public CalculVisitor() {
		super();
		value=0;
	}

	public CalculVisitor(double d) {
		super();
		this.startValue=d;
	}

	public void visit(Minus m) {
		if ( m.getFStang() != null && m.getFDrept() != null )
		{
		visit(m.getFStang()) ;
		double x1=getValue();
		visit ( m.getFDrept() ) ;
		double x2=getValue();
		value=x1-x2;
		}
		
	}

	public void visit(Cat c) {
		if ( c.getFStang() != null && c.getFDrept() != null )
		{
		visit(c.getFStang()) ;
		double x1=getValue();
		visit ( c.getFDrept() ) ;
		double x2=getValue();
		if (x1!=0.0)
		value=x2/x1;
		}
		
	}

	public void visit(Produs p) {
		if ( p.getFStang() != null && p . getFDrept() != null )
		{
		visit(p.getFStang()) ;
		double x1=getValue();
		visit ( p.getFDrept() ) ;
		double x2=getValue();
		value=x1*x2;
		}
		
	}

	public void visit(Necunoscuta n) {
		this.value=n.getX();
		
	}

	public void visit(Constanta c) {
		this.value=c.getCt();
		
	}


	public void visit(Sin s) {
		if ( s.getFStang() != null )
		{
			visit(s.getFStang());
			double d=Math.sin(value);
			value=d;
		}
		
	}

	public void visit(Cos c) {
		if ( c.getFStang() != null )
		{
			visit(c.getFStang());
			double d=Math.cos(value);
			value=d;
		}	
	}

	public void visit(Nod n) {
		n.setX(startValue);
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
