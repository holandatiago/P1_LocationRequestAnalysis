### Location Request Analysis


Os c�digos-fonte se encontram em:
	/src/main/scala/

O arquivo Java se encontra em:
	/target/scala-2.11/location-request-analysis_2.11-1.0.jar


Para rodar, v� at� a pasta do projeto e use:

	$ SPARK_HOME/spark-submit \
		--class CHOSEN_JOB \
		target/scala-2.11/location-request-analysis_2.11-1.0.jar \
		INPUT_PATH

Onde:
```SPARK_HOME``` -> Local onde o Spark est� instalado.
```CHOSEN_JOB``` -> Classe que voc� queira rodar.
```INPUT_PATH``` -> Caminho para o arquivo ```location_requests.csv```. Caso n�o seja especificado, ser� assumido que se encontra na pasta do projeto.

O programa imprimir� na tela a resposta de cada Job.