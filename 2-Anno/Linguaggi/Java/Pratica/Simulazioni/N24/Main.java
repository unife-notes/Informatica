package N24;

import java.io.*;
import java.util.*;

public class Main {

	static List<Progetto> progetti = new LinkedList<Progetto>();
	static List<Ricercatore> ricercatori = new LinkedList<Ricercatore>();
	static Map<Ricercatore, Double> ricercatore_maxImpegnoOrario = new HashMap<Ricercatore, Double>();
	static Map<String, Progetto> nomeRicercatore_progetto = new HashMap<String, Progetto>();

	public static void main(String[] args) {
		
		BufferedReader br = null;
		StringTokenizer tokenizer = null;
		String line = null;
		int codice = 0;
		String tipo = null;
		String titolo = null;
		String nomeCoordinatore = null;
		String organizzazione = null;
		String codiceArgomento = null;
		int numeroPartner = 0;
		double importoTot = 0.0d;
		int numeroAziende = 0;
		Progetto progetto = null;
		String nomeRicercatore = null;
		int codiceProgetto = 0;
		double impegnoOrario = 0.0d;
		Ricercatore ricercatore = null;
		String cognome = null;
		double max = 0.0d;


		try {
			br = new BufferedReader(new FileReader("./N24/progetti.txt"));
			line = br.readLine();

			while (line != null) {
				tokenizer = new StringTokenizer(line);
				codice = Integer.parseInt(tokenizer.nextToken());
				tipo = tokenizer.nextToken();
				titolo = br.readLine();
				nomeCoordinatore = br.readLine();
				organizzazione = br.readLine();
				line = br.readLine();
				tokenizer = new StringTokenizer(line);

				if (tipo.equals("ricerca")) {
					codiceArgomento = tokenizer.nextToken();
					numeroPartner = Integer.parseInt(tokenizer.nextToken());
					importoTot = Double.parseDouble(br.readLine());

					progetto = new Ricerca(codice, tipo, titolo, nomeCoordinatore, organizzazione, importoTot, codiceArgomento, numeroPartner);
				}
				else {
					numeroAziende = Integer.parseInt(tokenizer.nextToken());
					importoTot = Double.parseDouble(tokenizer.nextToken());

					progetto = new Innovazione(codice, tipo, titolo, nomeCoordinatore, organizzazione, importoTot, numeroAziende);
				}

				progetti.add(progetto);
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br = new BufferedReader(new FileReader("./N24/ricercatori.txt"));
			line = br.readLine();

			while (line != null) {
				nomeRicercatore = line;
				nomeRicercatore += " " + br.readLine();
				line = br.readLine();

				ricercatore = new Ricercatore(nomeRicercatore);
				ricercatori.add(ricercatore);
				max = 0.0d;

				while (line != null && !line.equals("")) {
					tokenizer = new StringTokenizer(line);
					codiceProgetto = Integer.parseInt(tokenizer.nextToken());
					impegnoOrario = Double.parseDouble(tokenizer.nextToken());
					line = br.readLine();

					if (impegnoOrario > max){
						max = impegnoOrario;
					}

					ricercatore.addPartecipazione(new Partecipazione(codiceProgetto, impegnoOrario));
					for (Progetto p : progetti) {
						if (codiceProgetto == p.getCodice()) {
							nomeRicercatore_progetto.put(nomeRicercatore, p);
						}
					}
				}
				ricercatore_maxImpegnoOrario.put(ricercatore, max);
				
				line = br.readLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\ntipo, titolo, codice, coordinatore, organizzazione, argomento, partner, aziende, importo totale in migliaia di euro\n");
		for (Progetto p : progetti) {
			System.out.println(p);
		}

		System.out.println("\n");
		for (Ricercatore r : ricercatori) {
			System.out.println(r);
		}

		System.out.println("\nInserisci il cognome:");
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			cognome = br.readLine();

			for (Ricercatore r : ricercatori){
				if (r.getNome().contains(cognome)) {
					System.out.print(r.getNome() + " " + ricercatore_maxImpegnoOrario.get(r) + " ");
					System.out.println(nomeRicercatore_progetto.get(r.getNome()).getTitolo());
				}
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}