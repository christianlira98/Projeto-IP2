package promsys.negocio.beans;

public class Servidor extends Usuario {
	
	private static long nextID;
	private long id;
	
	//CONSTRUTOR
	public Servidor(String n, String l, String s){
		super(n, l, s);
		this.id = nextID;
		nextID++;
	}
	
	//GETTERS AND SETTERS
	public long getID(){
		return this.id;
	}
	public static long getNextID(){
		return nextID;
	}
	
	//EQUALS E TOSTRING
	public boolean equals(Object object){
		boolean equal = false;
		if(object instanceof Servidor && ((Servidor) object).getID() == this.id){
			equal = true;
		}
		return equal;
	}
	public String toString(){
		String str = this.getNome() + " - " + this.getLogin();
		return str;
	}
		
}
