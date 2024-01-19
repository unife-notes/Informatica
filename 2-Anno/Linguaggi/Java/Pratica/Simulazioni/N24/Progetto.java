package N24;

public class Progetto {
	
	private int codice;
	private String tipo;
	private String titolo;
	private String nome;
	private String organizzazione;
	private double importoTot;

	public Progetto(int codice, String tipo, String titolo, String nome, String organizzazione, double importoTot) {
		this.codice = codice;
		this.tipo = tipo;
		this.titolo = titolo;
		this.nome = nome;
		this.organizzazione = organizzazione;
		this.importoTot = importoTot;
	}

	public double getImportoTot(){
		return importoTot;
	}

	public String toString() {
		return tipo + "\t" + titolo + "\t" + codice + "\t" + nome + "\t" + organizzazione; 
	}
}