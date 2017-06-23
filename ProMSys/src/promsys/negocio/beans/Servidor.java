package promsys.negocio.beans;

public class Servidor extends Usuario {
	
	private static long nextID;
	
	private long id;
	
	public Servidor(String n, String l, String s){
		super(n, l, s);
		this.id = nextID;
		nextID++;
	}
	
	//getters e setters
	
	public long getID(){
		return this.id;
	}
	
	public static long getNextID(){
		return nextID;
	}
		
}
