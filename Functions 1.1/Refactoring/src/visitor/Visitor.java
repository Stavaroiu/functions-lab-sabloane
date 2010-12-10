package visitor;
import Operatori.*;
import FunctiiElementare.*;
import FunctiiTrigo.*;
import Arbori.Nod;

public abstract class Visitor {
	public abstract void visit(Plus p);
	public abstract void visit(Minus m);
	public abstract void visit(Cat m);
	public abstract void visit(Produs p);
	public abstract void visit(Necunoscuta n);
	public abstract void visit(Constanta c);
	public abstract void visit(Sin s);
	public abstract void visit(Cos n);
	public abstract void visit(Nod g);
	
	

}
