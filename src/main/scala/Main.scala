import java.io.FileReader
import org.apache.commons.csv.CSVFormat

import scala.collection.JavaConverters._
import scala.collection.mutable.ListBuffer
import scala.util.control.Breaks.break

object Main {
  def main(args: Array[String]): Unit = {
    val csvFile = "bus_system.csv"

    val fileReader = new FileReader(csvFile)
    val csvRecords = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader).asScala

    val lista = ListBuffer[LinhaOnibus]()
    for (record <- csvRecords) {

      if (record.get("Número da Linha").nonEmpty) {
        val linha = record.get("Número da Linha").toInt
        val motorista = record.get("Nome do Motorista")
        val origem = record.get("Origem")
        val destino = record.get("Destino")
        val distancia = record.get("Distância (km)").toDouble
        val modelo = record.get("Modelo do Ônibus")
        val linhaOnibus = new LinhaOnibus(linha, motorista, origem, destino, distancia, modelo)
        lista += linhaOnibus // Sobrecarga do operador "+="
      }

    }

    lista.foreach(println)

    val x = lista.toList

    // Testes da função encontraLinha
    println("------------------- Testes da função encontraLinha --------------------------------")
    println(Operacoes.encontraLinha(x,"Salvador","Recife"))
    println(Operacoes.encontraLinha(x,"Belo Horizonte","Vitória"))
    println(Operacoes.encontraLinha(x,"São Paulo","Santa Teresa"))

    // Testes da função calculaTempoPercurso
    println("------------------- Testes da função calculaTempoPercurso -------------------------")
    println(Operacoes.calculaTempoPercurso(x,666))

    // Testes da função buscaLinhasPorMotorista
    println("------------------- Testes da função buscaLinhasPorMotorista ----------------------")
    Operacoes.buscaLinhasPorMotorista(x,"Daniela").foreach(println)

    // Testes da função buscaLinhasPorOrigem
    println("------------------- Testes da função buscaLinhasPorOrigem -------------------------")
    Operacoes.buscaLinhasPorOrigem(x,"Rio de Janeiro").foreach(println)

    fileReader.close()
  }
}
