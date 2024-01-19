package N29b;

import java.io.*;
import java.util.*;

public class Main {

	static List<Impiegato> impiegati = new LinkedList<Impiegato>();
	static Map<Integer, Impiegato> codice_impiegato = new HashMap<Integer, Impiegato>();
	static List<Visitatore> visitatori = new LinkedList<Visitatore>();
	static Map<Integer, Integer> codiceImpiegato_numeroServizi = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		
		BufferedReader br = null;
		StringTokenizer tokenizer = null;
		String line = null;
		int codice = 0;
		String tipo = null;
		String nome = null;
		int telefono = 0;
		boolean inglese = false;
		int appuntamenti = 0;
		double costo = 0.0d;
		int ore = 0;
		String specialita = null;
		Impiegato impiegato = null;
		int codiceVisitatore = 0;
		String nomeVisitatore = null;
		int codiceImpiegato = 0;
		double oreServizio = 0.0d;
		Visitatore visitatore = null;


		try {
			br = new BufferedReader(new FileReader("./N29b/impiegati.txt"));
			line = br.readLine();

			while (line != null) {
				tokenizer = new StringTokenizer(line);
				codice = Integer.parseInt(tokenizer.nextToken());
				tipo = tokenizer.nextToken();
				line = br.readLine();
				nome = line;
				line = br.readLine();
				tokenizer = new StringTokenizer(line);

				if (tipo.equals("guida")) {
					telefono = Integer.parseInt(tokenizer.nextToken());
					inglese = Boolean.parseBoolean(tokenizer.nextToken());
					appuntamenti = Integer.parseInt(tokenizer.nextToken());
					costo = Double.parseDouble(tokenizer.nextToken());

					impiegato = new Guida(codice, tipo, nome, costo, telefono, inglese, appuntamenti);
					impiegati.add(impiegato);
				}
				else {
					ore = Integer.parseInt(tokenizer.nextToken());
					costo = Double.parseDouble(tokenizer.nextToken());
					specialita = br.readLine();

					impiegato = new Sommelier(codice, tipo, nome, costo, ore, specialita);
					impiegati.add(impiegato);
				}

				codice_impiegato.put(codice, impiegato);
				codiceImpiegato_numeroServizi.put(codice, 0);
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br = new BufferedReader(new FileReader("./N29b/visitatori.txt"));
			line = br.readLine();

			while (line != null) {
				codiceVisitatore = Integer.parseInt(line);
				nomeVisitatore = br.readLine();
				line = br.readLine();

				visitatore = new Visitatore(codiceVisitatore, nomeVisitatore);
				visitatori.add(visitatore);

				while (line != null && !line.equals("")) {
					tokenizer = new StringTokenizer(line);
					codiceImpiegato = Integer.parseInt(tokenizer.nextToken());
					oreServizio = Double.parseDouble(tokenizer.nextToken());

					nome = codice_impiegato.get(codiceImpiegato).getNome();
					costo = codice_impiegato.get(codiceImpiegato).getCosto();
					visitatore.addServizio(new Servizio(nomeVisitatore, oreServizio, costo));
					codiceImpiegato_numeroServizi.put(codiceImpiegato, codiceImpiegato_numeroServizi.get(codiceImpiegato) + 1);

					line = br.readLine();
				}

				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("nome, codice, tipo, ore settimanali, specialita, telefono, inglese, app. sett., costo orario");

		for(Impiegato i : impiegati){
			System.out.println(i);
		}

		System.out.println();

		for(Visitatore v : visitatori){
			System.out.println(v);
		}

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("\nInserisci il codice di un impiegato: ");
			codice = Integer.parseInt(br.readLine());
			
			if (codiceImpiegato_numeroServizi.get(codice) == null) {
				System.out.println("Codice non esistente!");
			}
			else {
				System.out.println("Numero sevizi per il codice " + codice + ": " + codiceImpiegato_numeroServizi.get(codice));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}
