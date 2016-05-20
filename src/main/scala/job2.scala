import org.apache.spark.{SparkConf, SparkContext}

object PeakHourOfDayJob {
	def main(args: Array[String]) {
		val conf = new SparkConf().setAppName("Peak Hour Of Day Job")
		val sc = new SparkContext(conf)

		val inputFile = if(args.length>0) args(0) else "location_requests.csv"
		val locReq = sc.textFile(inputFile).map(_.split(","))

		val jobOutput = locReq
			.map(x=>(x(4).substring(11,13),1)).reduceByKey(_+_)
			.map(x=>(1,(x._1,x._2))).reduceByKey((x,y)=> if(x._2>y._2) x else y)
			.map(_._2._1)

		jobOutput.collect().foreach(println)
	}
}