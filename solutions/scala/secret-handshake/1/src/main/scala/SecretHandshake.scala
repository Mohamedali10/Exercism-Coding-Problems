object SecretHandshake {

  private val ActionsById : Map[Int, String] = Map(
    0 -> "reverse",
    1 -> "jump",
    2 -> "close your eyes",
    3 -> "double blink",
    4 -> "wink"
  )

private def toBinaryPresentation(code: Int): Array[Char] = String.format("%5s",code
    .toBinaryString).replace(" ", "0").toArray
  
  private def mapToActions(binary: Array[Char]): List[String] = {
    val indexes = binary.zipWithIndex.filter(_._1 == '1').map(_._2)
    if (indexes.contains(0)) indexes.flatMap(ActionsById.get).tail.toList
    else indexes.flatMap(ActionsById.get).reverse.toList
  }

  def commands(code: Int): List[String] = mapToActions(toBinaryPresentation(code))

}