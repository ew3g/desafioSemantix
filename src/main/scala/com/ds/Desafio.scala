package com.ds
import java.nio.charset.StandardCharsets

import org.apache.spark.sql.SparkSession
object Desafio{

  def main(args: Array[String]): Unit ={

    val spark = SparkSession.builder().appName("Sematinx").getOrCreate()
    //o arquivo NASA_access_log_Aug95 original está foi baixado do link ftp://ita.ee.lbl.gov/traces/NASA_access_log_Jul95.gz,
    //o atual é apenas para demonstração pois não é possível enviá-lo ao github pelo seu tamanho
    val dataset = spark.read.option("encoding", StandardCharsets.US_ASCII.name()).textFile("NASA_access_log_Aug95").rdd
    dataset.cache()

    val hostsUnicos = dataset.map(_.host).distinct().count()
    val erros404 = dataset.map(_.code == 404).count()
    val totalBytes = dataset.map(_.bytes).reduce(_ + _)

    println(s"Host Unicos: " + hostsUnicos)
    println(s"Erros 404: " + erros404)
    println("Total de Bytes retornados: %.2f", totalBytes)

  }
}
