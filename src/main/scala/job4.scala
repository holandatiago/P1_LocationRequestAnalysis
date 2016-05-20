import org.apache.spark.{SparkConf, SparkContext}

object AverageHourlyRequestsCountPerCountryJob {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("Average Hourly Requests Count Per Country Job")
		val sc = new SparkContext(conf)

		val inputFile = if(args.length>0) args(0) else "location_requests.csv"
		val locReq = sc.textFile(inputFile).map(_.split(","))

		val jobOutput = locReq
			.map(x=>((x(1),x(4).replaceAll(":[0-9][0-9]",":xx")),1)).reduceByKey(_+_)
			.map(x=>(x._1._1,(x._2,1))).reduceByKey((x,y)=>(x._1+y._1,x._2+y._2))
			.map(x=>(x._1,x._2._1.toFloat/x._2._2))

		jobOutput.collect().foreach(println)
	}
}