from Veicolo import Veicolo

class Auto(Veicolo):

	def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero, cilindrata, capienzaBagagliaio) -> None:
		super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
		self._cilindrata = cilindrata
		self._capienzaBagagliaio = capienzaBagagliaio

	def __str__(self) -> str:
		return super().__str__() + "\t" + str(self._cilindrata) + "\t" + str(self._capienzaBagagliaio) + "\t-\t-\t-"
