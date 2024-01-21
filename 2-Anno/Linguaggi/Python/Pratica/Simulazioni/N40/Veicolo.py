class Veicolo:
	
	def __init__(self, codice, tipo, targa, modello, marca, costoGiornaliero) -> None:
		self._codice = codice
		self._tipo = tipo
		self._targa = targa
		self._modello = modello
		self._marca = marca
		self._costoGiornaliero = costoGiornaliero

	def getTarga(self) -> str:
		return self._targa

	def getCosto(self) -> float:
		return self._costoGiornaliero

	def __str__(self) -> str:
		
		if self._tipo == "auto":
			return "automobile" + "\t" + str(self._targa) + "\t" + str(self._codice) + "\t" + str(self._modello) + "\t" + str(self._marca) + "\t" + str(self._costoGiornaliero)
		
		return "commerciale" + "\t" + str(self._targa) + "\t" + str(self._codice) + "\t" + str(self._modello) + "\t" + str(self._marca) + "\t" + str(self._costoGiornaliero)