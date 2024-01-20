package N40;

public class Auto extends Veicolo {

	private int cilindrata;
	private double capienzaBagagliaio;

	public Auto(int codice, String tipo, String targa, String modello, String marca, double costoGiornaliero, int cilindrata, double capienzaBagagliaio) {
		super(codice, tipo, targa, modello, marca, costoGiornaliero);
		this.cilindrata = cilindrata;
		this.capienzaBagagliaio = capienzaBagagliaio;
	}

	public String toString() {
		return super.toString() + "\t" + cilindrata + "\t" + capienzaBagagliaio + "\t-\t-\t-\t";
	}
}
