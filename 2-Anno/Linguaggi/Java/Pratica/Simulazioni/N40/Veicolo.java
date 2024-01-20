package N40;

public class Veicolo {
	
	private int codice;
	private String tipo;
	private String targa;
	private String modello;
	private String marca;
	private double costoGiornaliero;


	public Veicolo(int codice, String tipo, String targa, String modello, String marca, double costoGiornaliero) {
		this.codice = codice;
		this.tipo = tipo;
		this.targa = targa;
		this.modello = modello;
		this.marca = marca;
		this.costoGiornaliero = costoGiornaliero;
	}

	public String getTarga() {
		return targa;
	}

	public double getCosto() {
		return costoGiornaliero;
	}

	public String toString() {
		if (tipo.equals("auto")) {
			return "automobile" + "\t" + targa + "\t" + codice + "\t" + modello + "\t" + marca + "\t" + costoGiornaliero;
		}

		return "commerciale" + "\t" + targa + "\t" + codice + "\t" + modello + "\t" + marca + "\t" + costoGiornaliero;
	}
}
