object NthPrime {

  private def isPrime(nb: Int): Boolean = !LazyList(0,1).contains(nb) && (2 until nb).forall(i => nb % i != 0)

  def prime(occurrence: Int) = LazyList.from(1).filter(isPrime).take(occurrence).lastOption

}