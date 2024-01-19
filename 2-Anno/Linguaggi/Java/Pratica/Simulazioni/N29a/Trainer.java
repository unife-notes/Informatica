package N29a;

public class Trainer extends Dipendente{
	
	private int oreSettimanali;
	private String specialita;

	
	public Trainer(int codice, String nome, String tipo, double costo, int oreSettimanali, String specialita) {
		super(codice, nome, tipo, costo);
		this.oreSettimanali = oreSettimanali;
		this.specialita = specialita;
	}

	public String toString(){
		return super.toString() + "\t" + oreSettimanali + "\t" + specialita + "\t-\t-\t-\t" + getCosto();
	}
	
}
