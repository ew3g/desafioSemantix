# desafioSemantix

1. Qual o objetivo do comando cache em Spark?

R: Armazenar os dados de um dataset em uma memória cache do cluster, para um acesso mais rápido aos dados.

2. O mesmo código implementado em Spark é normalmente mais rápido que a implementação equivalente em MapReduce. Por quê?

R:Pois os dados estão armazenados na memória cache do cluster, assim não se tem o trabalho de percorrer e mapear os dados e efetuar a redução várias vezes como o MapReduce.

3. Qual é a função do SparkContext?

R: É criar e permitir acesso a todo o ambiente do Spark, uma interface que traduz os comandos efetuados para a execução do código Spark.

4. Explique com suas palavras o que é Resilient Distributed Datasets (RDD).

R: É o modo que o stark abstrai os dados numa primeira etapa, onde esses dados ficam distribuídos pelo cluster, podendo ser trabalhados paralelamente.

5. GroupByKey é menos eficiente que reduceByKey em grandes dataset. Por quê?

R: Pois reduceByKey combina os dados requeridos em cada partição do cluster e executa uma única saída para enviá-los. O método grouByKey envia os dados e os mesmo são reduzidos após o envio, podendo causar estouro de memória e disco.

6. Explique o que o código Scala abaixo
faz.
val textFile = sc.textFile("hdfs://...")
val counts = textFile.flatMap(line => line.split("
"))
.map(word => (word, 1))
.reduceByKey(_ + _)
counts.saveAsTextFile("hdfs://...")

R: Conta o número de palavras em um arquivo de texto e reduz a saída por reduceByKey. Após isso a sáida gerada é salva como um arquivo texto.




