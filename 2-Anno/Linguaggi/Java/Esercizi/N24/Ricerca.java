package N24;

public class Ricerca extends Progetto{

	private String codiceArgomento;
	private int numeroPartner;

	public Ricerca(int codice, String tipo, String titolo, String nome, String organizzazione, double importoTot, String codiceArgomento, int numeroPartner) {
		super(codice, tipo, titolo, nome, organizzazione, importoTot);
		this.codiceArgomento = codiceArgomento;
		this.numeroPartner = numeroPartner;
	}

	public String toString() {
		return super.toString() + "\t" + codiceArgomento + "\t" + numeroPartner + "\t-\t" + super.getImportoTot()*1000;
	}
}
