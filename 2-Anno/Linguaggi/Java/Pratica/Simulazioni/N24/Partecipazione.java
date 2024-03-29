package N24;

public class Partecipazione {
	
	private int codiceProgetto;
	private double impegnoOrario;

	public Partecipazione(int codiceProgetto, double impegnoOrario) {
		this.codiceProgetto = codiceProgetto;
		this.impegnoOrario = impegnoOrario;
	}

	public double getImpegnoOrario() {
		return impegnoOrario;
	}

	public int getCodiceProgetto() {
		return codiceProgetto;
	}

	public String toString() {
		return "(" + codiceProgetto + ", " + impegnoOrario + ")";
	}
}
