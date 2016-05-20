import org.apache.spark.{SparkConf, SparkContext}

object DistinctUsersPerCountryJob {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("Distinct Users Per Country Job")
		val sc = new SparkContext(conf)

		val inputFile = if(args.length>0) args(0) else "location_requests.csv"
		val locReq = sc.textFile(inputFile).map(_.split(","))

		val jobOutput = locReq
			.map(x=>(x(1),x(0))).distinct()
			.map(x=>(x._1,1)).reduceByKey(_+_)


		jobOutput.collect().foreach(println)
	}
}