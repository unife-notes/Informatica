package N40;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private String nome;
	private List<Noleggio> noleggi;

	public Cliente(String nome) {
		this.nome = nome;
		noleggi = new LinkedList<>();
	}

	public void addNoleggi(Noleggio noleggio) {
		noleggi.add(noleggio);
	}

	public double getCostoTotale() {
		double tot = 0.0d;

		for (Noleggio n : noleggi) {
			tot += n.getCosto();
		}

		return tot;
	}

	public String toString() {
		return nome + "\t" + getCostoTotale() + "\t" + noleggi;
	}
}
