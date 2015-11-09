package org.test.spark

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

/**
 * @author JungHaGwon
 */
object WordCount {
  
  def main(args: Array[String]) = {
  val conf = new SparkConf()
    .setAppName("WordCount")
    .setMaster("local")
  val sc = new SparkContext(conf)
  
  val test = sc.textFile("foo.txt")
  
  test.flatMap { line => 
    line.split(" ") 
    }
  .map { word =>
    (word,1)
  }
  .reduceByKey(_ + _)
  .saveAsTextFile("foo.count.txt") 
  }
  
}