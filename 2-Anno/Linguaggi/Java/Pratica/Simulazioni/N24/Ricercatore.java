package N24;

import java.util.*;

public class Ricercatore {
	
	private String nome;
	private List<Partecipazione> partecipazioni;

	public Ricercatore(String nome) {
		this.nome = nome;
		partecipazioni = new LinkedList<Partecipazione>();
	}

	public void addPartecipazione(Partecipazione partecipazione) {
		partecipazioni.add(partecipazione);
	}

	public double getImpegnoOrarioTotale() {
		double tot = 0.0d;

		for (Partecipazione p : partecipazioni) {
			tot += p.getImpegnoOrario();
		}

		return tot;
	}

	public String toString() {
		return nome + "\t" + getImpegnoOrarioTotale() + "\t" + partecipazioni.size() + "\t" + partecipazioni;
	}
}
