object PrimeFactors {

  private def isPrime(n: Long): Boolean = !(2L until n).exists(i => n % i == 0)

  def factors(number: Long): List[Long] = {
    //lazy val primeNumbersList = (2L to number).filter(isPrime)
    def loop(currentValue: Long, lastInt: Long): List[Long] = {
      if (currentValue == 1L) List.empty
      else if(isPrime(lastInt) && currentValue % lastInt == 0) {
        lastInt +: loop(currentValue / lastInt, lastInt)
      }
      else
      (2L to currentValue).find(nb => (isPrime(nb) &&  currentValue % nb == 0)).map(nbp => nbp +: loop(currentValue / nbp, nbp)).getOrElse(List.empty)
    }
    loop(number, 2L)
  }
}