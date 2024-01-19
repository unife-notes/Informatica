package N29a;

public class Dipendente {
	
	private int codice;
	private String nome;
	private String tipo;
	private double costo;


	public Dipendente(int codice, String nome, String tipo, double costo){
		this.codice = codice;
		this.nome = nome;
		this.tipo = tipo;
		this.costo = costo;
	}

	public double getCosto(){
		return costo;
	}

	public int getCodice(){
		return codice;
	}

	public String getNome(){
		return nome;
	}

	public String toString(){
		return nome + "\t" + codice + "\t" + tipo + "\t"; 
	}

}
