from Veicolo import Veicolo

class Furgone(Veicolo):
    
	def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero, categoria, nPosti, vanoCarico) -> None:
		super().__init__(codice, tipo, targa, modello, marca, costoGiornaliero)
		self._categoria = categoria
		self._nPosti = nPosti
		self._vanoCarico = vanoCarico

	def __str__(self) -> str:
		return super().__str__() + "\t-\t-\t" + str(self._categoria) + "\t" + str(self._nPosti) + "\t" + str(self._vanoCarico)
