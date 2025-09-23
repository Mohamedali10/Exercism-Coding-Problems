object SumOfMultiples {
  def main(args: Array[String]) ={
  val res = sum(Set(4,6),20)
    println(s"res--->  $res")

  }

  def sum(factors: Set[Int], limit: Int): Int = {
    var multipiers = Set[Int]()
    factors.foreach(factor=>{
      for( i <- factor to limit-1) {
        if(i % factor == 0){
          multipiers = multipiers.+(i)
          println(multipiers)
        }
      }
    })
    println(s"multipliers  $multipiers")
    val sum2 = multipiers.sum
    println(s"sum2  $sum2")
  sum2
  }
}

