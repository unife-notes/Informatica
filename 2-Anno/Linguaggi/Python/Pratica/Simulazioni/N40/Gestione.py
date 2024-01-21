import argparse
from Veicolo import Veicolo
from Auto import Auto
from Cliente import Cliente
from Noleggio import Noleggio
from Furgone import Furgone

class Gestione:
	
	def __init__(self, arg) -> None:
		self.arg = arg
	
	def main(self):
		veicoli = []
		clienti = []
		codice_veicolo = {}
		codice_costo = {}

		try:
			file = open("veicoli.txt", "r")
			line = file.readline().strip()

			while (line != ""):
				tok = line.split()
				codice = int(tok[0])
				tipo = tok[1]
				targa = tok[2]
				modello = file.readline().strip()
				marca = file.readline().strip()
				line = file.readline().strip()

				codice_costo[codice] = 0.0

				if tipo == "auto":
					tok = line.split()
					cilindrata = int(tok[0])
					capienzaBagagliaio = float(tok[1])
					costoGiornaliero = float(file.readline().strip())
					auto = Auto(codice, tipo, targa, modello, marca, costoGiornaliero, cilindrata, capienzaBagagliaio)
					veicoli.append(auto)
					codice_veicolo[codice] = auto
				else :
					categoria = line
					tok = file.readline().strip().split()
					nPosti = int(tok[0])
					vanoCarico = tok[1]
					costoGiornaliero = float(file.readline().strip())
					furgone = Furgone(codice, tipo, targa, modello, marca, costoGiornaliero, categoria, nPosti, vanoCarico)
					veicoli.append(furgone)
					codice_veicolo[codice] = furgone

				line = file.readline().strip()
			file.close()
		
		except IOError as i:
			print(i)
		except Exception as e:
			print(e)

		try:
			file = open("clienti.txt", "r")
			line = file.readline().strip()

			while line != "":
				nome = line
				line = file.readline().strip()
				tok = line.split()

				cliente = Cliente(nome)
				clienti.append(cliente)

				i = 0
				while i < len(tok):
					codice = int(tok[i])
					nGiorni = int(tok[i+1])
					costo = codice_veicolo.get(codice).getCosto() * nGiorni
					
					codice_costo.update({codice: codice_veicolo.get(codice).getCosto() * nGiorni + codice_costo.get(codice)})
					noleggio = Noleggio(codice_veicolo.get(codice).getTarga(), nGiorni, codice_veicolo.get(codice).getCosto())
					cliente.addNoleggio(noleggio)
					
					i += 2

				line = file.readline().strip()

		except IOError as i:
			print(i)
		except Exception as e:
			print(e)

		
		print("tipo, targa, codice, modello, marca, costo giornaliero, cilindrata, bagagliaio, categoria, numero di posti, vano di carico")
		for veicolo in veicoli:
			print(str(veicolo))

		print("\n")
		for cliente in clienti:
			print(str(cliente))

		print("\n")

		self.arg = int(self.arg)
		if codice_veicolo.get(self.arg) == None:
			print("Codice non presente")
		else:
			print(self.arg, codice_costo.get(self.arg))



if __name__ == "__main__":
	parser = argparse.ArgumentParser()
	parser.add_argument("codice", action="store")
	pa = parser.parse_args()
	gestione = Gestione(pa.codice)
	gestione.main()