class LinhaOnibus(val numero: Int, val motorista: String,
                  val origem: String, val destino: String, val distancia: Double, val modelo : String) {

  override def toString(): String = {
    s"Número da Linha: $numero, Motorista: $motorista, Origem: $origem, Destino: $destino. Distância: $distancia, Modelo: $modelo"
  }
}




