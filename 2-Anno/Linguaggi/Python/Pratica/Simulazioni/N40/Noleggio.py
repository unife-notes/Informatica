class Noleggio:

	def __init__(self, targa, nGiorni, costo) -> None:
		self._targa = targa
		self._nGiorni = nGiorni
		self._costo = costo
	
	def getCosto(self) -> None:
		return self._costo * self._nGiorni
	
	def __str__(self) -> str:
		return "(" + str(self._targa) + "," + str(self._nGiorni) + ")" 