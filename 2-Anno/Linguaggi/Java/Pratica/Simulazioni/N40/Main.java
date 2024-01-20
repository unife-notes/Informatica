package N40;

import java.io.*;
import java.util.*;

public class Main {

	static List<Veicolo> veicoli = new LinkedList<>();
	static List<Cliente> clienti = new LinkedList<>();
	static Map<Integer, Veicolo> codiceVeicolo_veicolo = new HashMap<>();
	static Map<Integer, Double> codiceVeicolo_importo = new HashMap<>();

	public static void main(String[] args) {
		
		BufferedReader br = null;
		String line = null;
		StringTokenizer tokenizer = null;
		int codice = 0;
		String tipo = null;
		String targa = null;
		String modello = null;
		String marca = null;
		int cilindrata = 0;
		double capienzaBagagliaio = 0.0d;
		String categoria = null;
		int numeroPosti = 0;
		boolean vanoCarico = false;
		double costoGiornaliero = 0.0d;
		Veicolo veicolo = null;
		String nome = null;
		int codiceVeicolo = 0;
		int numeroGiorni = 0;
		Cliente cliente = null;
		double importo = 0.0d;
		

		try {
			br = new BufferedReader(new FileReader("./N40/veicoli.txt"));
			line = br.readLine();

			while (line != null) {
				tokenizer = new StringTokenizer(line);
				codice = Integer.parseInt(tokenizer.nextToken());
				tipo = tokenizer.nextToken();
				targa = tokenizer.nextToken();
				modello = br.readLine();
				marca = br.readLine();
				line = br.readLine();

				if (tipo.equals("auto")) {
					tokenizer = new StringTokenizer(line);
					cilindrata = Integer.parseInt(tokenizer.nextToken());
					capienzaBagagliaio = Double.parseDouble(tokenizer.nextToken());
					line = br.readLine();
					costoGiornaliero = Double.parseDouble(line);

					veicolo = new Auto(codice, tipo, targa, modello, marca, costoGiornaliero, cilindrata, capienzaBagagliaio);
					veicoli.add(veicolo);
				}
				else {
					categoria = line;
					line = br.readLine();
					tokenizer = new StringTokenizer(line);
					numeroPosti = Integer.parseInt(tokenizer.nextToken());
					vanoCarico = Boolean.parseBoolean(tokenizer.nextToken());
					line = br.readLine();
					costoGiornaliero = Double.parseDouble(line);

					veicolo = new Furgone(codice, tipo, targa, modello, marca, costoGiornaliero, categoria, numeroPosti, vanoCarico);
					veicoli.add(veicolo);
				}

				codiceVeicolo_veicolo.put(codice, veicolo);
				codiceVeicolo_importo.put(codice, 0.0d);
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br = new BufferedReader(new FileReader("./N40/clienti.txt"));
			line = br.readLine();

			while (line != null) {
				nome = line;
				line = br.readLine();
				tokenizer = new StringTokenizer(line);

				cliente = new Cliente(nome);
				clienti.add(cliente);

				while (tokenizer.hasMoreTokens()) {
					codiceVeicolo = Integer.parseInt(tokenizer.nextToken());
					numeroGiorni = Integer.parseInt(tokenizer.nextToken());
					importo = codiceVeicolo_veicolo.get(codiceVeicolo).getCosto() * numeroGiorni;

					cliente.addNoleggi(new Noleggio(codiceVeicolo, numeroGiorni));
					codiceVeicolo_importo.put(codiceVeicolo, codiceVeicolo_importo.get(codiceVeicolo) + importo);
				}

				line = br.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("tipo, targa, codice, modello, marca, costo giornaliero, cilindrata, bagagliaio, categoria, numero di posti, vano di carico");

		for (Veicolo v : veicoli) {
			System.out.println(v);
		}

		System.out.println("");

		for (Cliente c : clienti) {
			System.out.println(c);
		}

		System.out.println("\nInserisci il codice di un veicolo:");

		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			codice = Integer.parseInt(br.readLine());

			if (codiceVeicolo_importo.get(codice) == null) {
				System.err.println("Errore: codice non presente nel database");
			}
			else {
				System.out.println(codiceVeicolo_importo.get(codice));
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}