object CollatzConjecture {
  def steps(n: Int) : Option[Int]=  {
    if(n <= 0 ) None
    else if ( n == 1 ) Some(0)
    else if( n % 2 == 0 ) Some(1 + steps( n / 2).getOrElse(0))
    else Some(1 + steps(3 *  n + 1).getOrElse(0))
  }
}