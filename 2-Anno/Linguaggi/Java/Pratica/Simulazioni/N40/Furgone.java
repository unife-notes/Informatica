package N40;

public class Furgone extends Veicolo{
	
	private String categoria;
	private int numeroPosti;
	private boolean vanoCarico;

	public Furgone(int codice, String tipo, String targa, String modello, String marca, double costoGiornaliero, String categoria, int numeroPosti, boolean vanoCarico) {
		super(codice, tipo, targa, modello, marca, costoGiornaliero);
		this.categoria = categoria;
		this.numeroPosti = numeroPosti;
		this.vanoCarico = vanoCarico;
	}

	public String toString() {
		return super.toString() + "\t-\t-\t" + categoria + "\t" + numeroPosti + "\t" + vanoCarico;
	}
}
