package N29a;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private int codiceCliente;
	private String nome;
	private List<Servizio> servizi;


	public Cliente(int codiceCliente, String nome){
		this.codiceCliente = codiceCliente;
		this.nome = nome;
		this.servizi = new  LinkedList<Servizio>();
	}

	public Double getTot(){
		double tot = 0.0d;

		for(Servizio servizio : servizi){
			tot += servizio.getCostoServizio();
		}

		return tot;
	}

	public void addServizio(Servizio servizio){
		servizi.add(servizio);
	}
	
	public String toString(){
		return codiceCliente + " " + nome + " " + getTot();
	}
}