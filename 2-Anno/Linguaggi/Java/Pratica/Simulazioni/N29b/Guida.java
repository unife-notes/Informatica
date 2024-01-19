package N29b;

public class Guida extends Impiegato{

    private int telefono;
    private boolean inglese;
    private int appuntamenti;

    public Guida(int codice, String tipo, String nome, double costo, int telefono, boolean inglese, int appuntamenti) {
        super(codice, tipo, nome, costo);
        this.telefono = telefono;
        this.inglese = inglese;
        this.appuntamenti = appuntamenti;
    }

    public String toString(){
        return super.toString() + "\t-\t-\t" + telefono + "\t" + inglese + "\t" + appuntamenti + super.getCosto();
    }
    
}
