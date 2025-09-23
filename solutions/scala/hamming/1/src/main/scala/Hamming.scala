object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = 
if (dnaStrandOne.length != dnaStrandTwo.length) None
else if ( dnaStrandOne.headOption == dnaStrandTwo.headOption && dnaStrandOne.headOption.nonEmpty)
distance(dnaStrandOne.tail, dnaStrandTwo.tail) 
else if ( dnaStrandOne.headOption != dnaStrandTwo.headOption)
distance(dnaStrandOne.tail, dnaStrandTwo.tail) map ( _ + 1)
else Some(0)
}
