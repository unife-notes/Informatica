class Cliente:
    
	def __init__(self, nome) -> None:
		self._nome = nome
		self._noleggi = []

	def addNoleggio(self, noleggio) -> None:
		self._noleggi.append(noleggio)

	def getCostoTot(self) -> float:
		tot = 0.0
		
		for noleggio in self._noleggi:
			#print(str(noleggio.getCosto()))
			tot += noleggio.getCosto()

		return tot

	def __str__(self) -> str:
		return self._nome + "\t" + str(self.getCostoTot()) + "\t" + str(len(self._noleggi)) + "\t" + ' '.join([str(i) for i in self._noleggi])
		
		