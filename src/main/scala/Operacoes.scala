object Operacoes {

  def encontraLinha(listaLinhas: Seq[LinhaOnibus],origem: String, destino: String): String = {
    listaLinhas.find(linha => linha.origem == origem && linha.destino == destino) match {
      case Some(linha) => linha.numero.toString
      case None => "Linha não encontrada"
    }
  }

  def calculaTempoPercurso(listaLinhas: Seq[LinhaOnibus],numeroLinha: Int): String = {
    listaLinhas.find(linha => linha.numero == numeroLinha) match {
      case Some(linha) => linha.modelo match {
        case "Mercedes" => f"Tempo de percurso: ${(linha.distancia / 90)}%.2f h"
        case "Agrale" => f"Tempo de percurso: ${(linha.distancia / 92)}%.2f h"
        case "Iveco" => f"Tempo de percurso: ${(linha.distancia / 95)}%.2f h"
        case "Volvo" => f"Tempo de percurso: ${(linha.distancia / 100)}%.2f h"
      }
      case None => "Linha inválida"
    }
  }

  def buscaLinhasPorMotorista(listaLinhas: Seq[LinhaOnibus], nomeMotorista: String): Seq[Int] = {
    listaLinhas.collect { case linha if linha.motorista == nomeMotorista => linha.numero }

  }

  def buscaLinhasPorOrigem(listaLinhas: Seq[LinhaOnibus],origem: String): Seq[LinhaOnibus] = {
    listaLinhas.filter(_.origem == origem)
  }


}
