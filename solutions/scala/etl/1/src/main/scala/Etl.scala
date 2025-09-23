object Etl {
 def transform(scoreMap: Map[Int, Seq[String]]): Map[String, Int] = 
scoreMap.flatMap { case (score, cars) => 
    cars.map(c => c.toLowerCase -> score)
  }
}
