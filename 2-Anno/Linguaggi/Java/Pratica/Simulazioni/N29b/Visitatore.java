package N29b;

import java.util.*;

public class Visitatore {
	
	private int codiceVisitatore;
	private String nome;
	private List<Servizio> servizi;

	public Visitatore(int codiceVisitatore, String nome){
		this.codiceVisitatore = codiceVisitatore;
		this.nome = nome;
		this.servizi = new LinkedList<Servizio>();
	}

	public void addServizio(Servizio servizio){
		servizi.add(servizio);
	}

	public String toString() {
		return codiceVisitatore + "\t" + nome + "\t" + servizi;
	}

}
