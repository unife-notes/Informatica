package N24;

public class Innovazione extends Progetto {

	private int numeroAziende;

	public Innovazione(int codice, String tipo, String titolo, String nome, String organizzazione, double importoTot, int numeroAziende) {
		super(codice, tipo, titolo, nome, organizzazione, importoTot);
		this.numeroAziende = numeroAziende;
	}

	public String toString() {
		return super.toString() + "\t-\t-\t" + numeroAziende + "\t" + super.getImportoTot()*1000;
	}
}
