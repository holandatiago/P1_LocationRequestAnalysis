import org.apache.spark.{SparkConf, SparkContext}

object MostActiveUserPerCountryJob {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("Most Active User Per Country Job")
		val sc = new SparkContext(conf)

		val inputFile = if(args.length>0) args(0) else "location_requests.csv"
		val locReq = sc.textFile(inputFile).map(_.split(","))

		val jobOutput = locReq
			.map(x=>((x(1),x(0)),1)).reduceByKey(_+_)
			.map(x=>(x._1._1,(x._1._2,x._2))).reduceByKey((x,y)=> if(x._2>y._2) x else y)
			.map(x=>(x._1,x._2._1))

		jobOutput.collect().foreach(println)
	}
}