package N29b;

class Servizio {
	
	private String nome;
	private double durata;
	private double costo;

	public Servizio(String nome, double durata, double costo) {
		this.nome = nome;
		this.durata = durata;
		this.costo = costo;
	}

	public double getCostoTot() {
		return costo * durata;
	}

	public String toString() {
		return nome + "\t" + durata + "\t" + getCostoTot();
	}

}