package visitor;

import Arbori.Nod;
import Operatori.*;
import Functii.Functie;
import FunctiiElementare.*;
import FunctiiTrigo.Cos;
import FunctiiTrigo.Sin;

public class ToStringVisitor extends Visitor {
	protected String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
	public ToStringVisitor(String s){
		this.s=s;
	}
	public ToStringVisitor(){
		super();
	}
	public void visit(Plus p){
		if(p.getFStang()!=null&&p.getFDrept()!=null)
		{visit(p.getFStang());
		String s1=this.s;
		visit(p.getFDrept());
		String s2=this.s;
		s=p.concatTermeni(s1,s2);
		}
	}
	public void visit(Minus p){
		if(p.getFStang()!=null&&p.getFDrept()!=null)
		{visit(p.getFStang());
		String s1=this.s;
		visit(p.getFDrept());
		String s2=this.s;
		s=p.concatTermeni(s1,s2);
		}
	}
	public void visit(Cat p){
		if(p.getFStang()!=null&&p.getFDrept()!=null)
		{visit(p.getFStang());
		String s1=this.s;
		visit(p.getFDrept());
		String s2=this.s;
		s=p.concatTermeni(s1,s2);
		}
	}
	public void visit(Produs p){
		if(p.getFStang()!=null&&p.getFDrept()!=null)
		{visit(p.getFStang());
		String s1=this.s;
		visit(p.getFDrept());
		String s2=this.s;
		s=p.concatTermeni(s1,s2);
		}
	}
	public void visit(Necunoscuta n){
		this.s="x";
	}
	public void visit(Constanta c){
		this.s=Double.toString(c.getCt());
	}


	public void visit(Cos c){
		vizitare(c);
	}
	
	public void visit(Sin s){
		vizitare(s);
	}


	public void visit(Nod n){
		if(n.getClass().equals("Plus"))
			visit((Plus)n);
		else
			if(n.getClass().equals("Minus"))
				visit((Minus)n);
			else
				if(n.getClass().equals("Produs"))
					visit((Produs)n);
				else 
					if(n.getClass().equals("Cat"))
						visit((Cat)n);
					else
						if(n.getClass().equals("Constanta"))
							visit((Constanta)n);
						else
							if(n.getClass().equals("Necunoscuta"))
								visit((Necunoscuta)n);
							else
								if(n.getClass().equals("Cos"))
									visit((Cos)n);
								else
									if(n.getClass().equals("Sin"))
										visit((Sin)n);
	}
	public void vizitare(Operator o){
		if(o.getFStang()!=null && o.getFDrept()!=null)
		{
			visit(o.getFStang());
			String s1=this.s;
			visit(o.getFDrept());
			String s2=this.s;
			s=o.concatTermeni(s1, s2);
		}
	}
	
	public void vizitare(Functie f){
		if(f.getFStang()!=null)
		{
			visit(f.getFStang());
			String s1=this.s;
			s=f.concatTermeni(s1);
		}
	}
	
}
