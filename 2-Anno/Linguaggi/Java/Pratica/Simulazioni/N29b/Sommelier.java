package N29b;

public class Sommelier extends Impiegato {

	private int oreSettimanali;
	private String specialita;

	public Sommelier(int codice, String tipo, String nome, double costo, int oreSettimanali, String specialita) {
		super(codice, tipo, nome, costo);
		this.oreSettimanali = oreSettimanali;
		this.specialita = specialita;
	}

	public String toString(){
		return super.toString() + "\t" + oreSettimanali + "\t" + specialita + "\t-\t-\t-\t" + super.getCosto();
	}
	
}
