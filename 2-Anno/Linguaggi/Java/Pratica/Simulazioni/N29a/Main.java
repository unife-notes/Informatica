package N29a;

import java.io.*;
import java.util.*;

public class Main {

	static List<Dipendente> dipendenti = new LinkedList<Dipendente>();
	static List<Cliente> clienti = new LinkedList<Cliente>();
	static Map<Integer, Dipendente> codice_dipendente = new HashMap<Integer, Dipendente>();
	static Map<Integer, Integer> codice_numeroServizi = new HashMap<Integer, Integer>();

	public static void main(String[] args) {

		BufferedReader br = null;
		String line = null;
		StringTokenizer tokenizer = null;
		int codice = 0;
		String tipo = null;
		String nome = null;
		int oreSettimanali = 0;
		double costoOrario = 0.0d;
		String specialita = null;
		long telefono = 0;
		boolean isMedico = false;
		int appuntamentiSettimanali = 0;
		int codiceCliente = 0;
		String nomeCliente = null;
		int codiceDipendente = 0;
		double ore = 0.0d;
		Dipendente dipendente = null;
		Servizio servizio = null;
		Cliente cliente = null;
		int max = 0;
		
		/*
		 * Lettura del primo file 
		 */
		try {
			br = new BufferedReader(new FileReader("./N29a/dipendenti.txt"));
			line = br.readLine();

			while (line != null) {
				tokenizer = new StringTokenizer(line);
				codice = Integer.parseInt(tokenizer.nextToken());
				tipo = tokenizer.nextToken();
				line = br.readLine();
				nome = line;
				line = br.readLine();
				tokenizer = new StringTokenizer(line);

				if(tipo.equals("trainer")){
					oreSettimanali = Integer.parseInt(tokenizer.nextToken());
					costoOrario = Double.parseDouble(tokenizer.nextToken());
					line = br.readLine();
					specialita = line;

					dipendente = new Trainer(codice, nome, tipo, costoOrario, oreSettimanali, specialita);
					dipendenti.add(dipendente);
				}
				else {
					telefono = Long.parseLong(tokenizer.nextToken());
					isMedico = Boolean.parseBoolean(tokenizer.nextToken());
					appuntamentiSettimanali = Integer.parseInt(tokenizer.nextToken());
					costoOrario = Double.parseDouble(tokenizer.nextToken());

					dipendente = new Nutrizionista(codice, nome, tipo, costoOrario, telefono, isMedico, appuntamentiSettimanali);
					dipendenti.add(dipendente);
				}

				codice_dipendente.put(codice, dipendente);
				codice_numeroServizi.put(codice, 0);
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * Lettura del secondo file
		 */
		try {
			br = new BufferedReader(new FileReader("./N29a/clienti.txt"));
			line = br.readLine();

			while (line != null) {
				codiceCliente = Integer.parseInt(line);
				line = br.readLine();
				nomeCliente = line;

				cliente = new Cliente(codiceCliente, nomeCliente);
				clienti.add(cliente);

				line = br.readLine();

				while (line != null && !line.equals("")) {
					tokenizer = new StringTokenizer(line);
					codiceDipendente = Integer.parseInt(tokenizer.nextToken());
					ore = Double.parseDouble(tokenizer.nextToken());

					servizio = new Servizio(codice_dipendente.get(codiceDipendente), ore);
					cliente.addServizio(servizio);
					codice_numeroServizi.put(codiceDipendente, codice_numeroServizi.get(codiceDipendente) + 1);

					line = br.readLine();
				}
				line = br.readLine();
			}
			br.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("nome, codice, tipo, ore settimanali, specialità, telefono, medico, app.sett., costo orario");
		
		for(Dipendente d : dipendenti){
			System.out.println(d);
		}

		System.out.println("");

		for(Cliente c : clienti){
			System.out.println(c);
		}

		System.out.println("");

		for(Dipendente d : dipendenti){
			if(codice_numeroServizi.get(d.getCodice()) > max){
				max = codice_numeroServizi.get(d.getCodice());
				nome = d.getNome();
			}
		}

		System.out.println(nome + ": " + max);

	}
}