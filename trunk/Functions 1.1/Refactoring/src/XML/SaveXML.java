package XML;
import Arbori.Nod;
import FunctiiElementare.Constanta;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveXML {
	protected FileWriter fstream;
	protected BufferedWriter out;
	
	public SaveXML(Nod a, String fisier) throws IOException{
		fstream=new FileWriter(fisier);
		out=new BufferedWriter(fstream);
		out.write("<?xml version=\"1.0\" encoding=\"ISO-8859-1\" ?>\n");
		save(a,1);
		out.close();		
	}
	public void save(Nod a, int nivel) throws IOException{
		int i;
		for(i=0;i<=nivel; i++)
			out.write(" ");
		int index=(a.getClass().getName()).lastIndexOf('.');
		String fin=a.getClass().getName().substring(index+1);
		if(fin.equals("Constanta"))
			out.write("<"+fin+"id=\""+nivel+"\" val=\""+((Constanta)a).getCt()+"\">\n");
		else
			out.write("<"+fin+" id=\""+nivel+"\">\n");
		if(a.getFStang()!=null)
			save(a.getFStang(),nivel+1);
		if(a.getFDrept()!=null)
			save(a.getFDrept(),nivel+1);
		for(i=1;i<=nivel;i++)
			out.write(" ");
		out.write(" ");
		out.write("</"+fin+">"+"\n");
	}

}
