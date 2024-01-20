package N40;

public class Noleggio {
	
	private int codiceVeicolo;
	private int numeroGiorni;

	public Noleggio(int codiceVeicolo, int numeroGiorni) {
		this.codiceVeicolo = codiceVeicolo;
		this.numeroGiorni = numeroGiorni;
	}

	public double getCosto() {
		return Main.codiceVeicolo_veicolo.get(codiceVeicolo).getCosto() * numeroGiorni;
	}

	public String toString() {
		return "(" + Main.codiceVeicolo_veicolo.get(codiceVeicolo).getTarga() + ", " + numeroGiorni + ")";
	}
}
