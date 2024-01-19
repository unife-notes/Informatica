package N29a;

public class Nutrizionista extends Dipendente{

	private long telefono;
	private boolean isMedico;
	private int appuntamentiSettimanali;

	public Nutrizionista(int codice, String nome, String tipo, double costo, long telefono, boolean isMedico, int appuntamentiSettimanali) {
		super(codice, nome, tipo, costo);
		this.telefono = telefono;
		this.isMedico = isMedico;
	}

	public String toString(){
		return super.toString() + "\t-\t-\t" + telefono + "\t" + isMedico + "\t" + appuntamentiSettimanali + "\t" + getCosto();
	}
	
}
