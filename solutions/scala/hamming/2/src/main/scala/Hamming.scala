object Hamming {
  def distance(dnaStrandOne: String, dnaStrandTwo: String): Option[Int] = 
Option.when(dnaStrandOne.length == dnaStrandTwo.length){
  dnaStrandOne.zip(dnaStrandTwo).count{ case (left, right) => left != right}
}
}
