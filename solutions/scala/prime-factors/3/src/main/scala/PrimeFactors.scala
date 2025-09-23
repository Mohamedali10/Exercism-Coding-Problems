object PrimeFactors {

  private def isPrime(number: Long): Boolean = !(2L until number).exists(i => number % i == 0)

  def factors(number: Long): List[Long] = {
    @scala.annotation.tailrec
    def loop(currentValue: Long, lastDivisor: Long, acc: List[Long]): List[Long] = {
      if (currentValue == 1L || lastDivisor > number) acc
      else if(currentValue % lastDivisor == 0) {
         loop(currentValue / lastDivisor, lastDivisor,  acc :+ lastDivisor)
      } else loop(currentValue, lastDivisor + 1L,  acc)
    }
    loop(number, 2L, List.empty)
  }
}