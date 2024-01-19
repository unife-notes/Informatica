package N29a;

public class Servizio {
	
	private Dipendente dipendente;
	private double ore;


	public Servizio(Dipendente dipendente, double ore){
		this.dipendente = dipendente;
		this.ore = ore;
	}

	public double getCostoServizio(){
		return dipendente.getCosto() * ore;
	}
}
