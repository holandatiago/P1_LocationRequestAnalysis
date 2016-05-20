### Location Request Analysis


Os códigos-fonte se encontram em ```/src/main/scala/```.

O arquivo Java se encontra em ```/target/scala-2.11/location-request-analysis_2.11-1.0.jar```.

Para rodar, vá até a pasta do projeto e use:

	$ SPARK_HOME/spark-submit \
		--class CHOSEN_JOB \
		target/scala-2.11/location-request-analysis_2.11-1.0.jar \
		INPUT_PATH

Onde ```SPARK_HOME``` é o local onde o Spark está instalado; ```CHOSEN_JOB``` é a classe que você quer rodar; e ```INPUT_PATH``` é o caminho para o arquivo ```location_requests.csv```(caso não seja especificado, será assumido que se encontra na pasta do projeto).

O programa imprimirá na tela a resposta de cada Job.
