package N29b;

public class Impiegato {
	
	private int codice;
	private String tipo;
	private String nome;
	private double costo;

	public Impiegato(int codice, String tipo, String nome, double costo){
		this.codice = codice;
		this.tipo = tipo;
		this.nome = nome;
		this.costo = costo;
	}

	public String getNome(){
		return nome;
	}

	public double getCosto(){
		return costo;
	}

	public String toString(){
		return nome + "\t" + codice + "\t" + tipo; 
	}
}
