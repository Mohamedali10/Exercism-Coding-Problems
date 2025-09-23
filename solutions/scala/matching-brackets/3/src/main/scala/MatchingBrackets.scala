object MatchingBrackets {

  val closed = List(']', '}',')')
  val opened = List('[', '{','(')
  val pairs = opened zip closed map{ case (opnd, clsd) => opnd.toString + clsd.toString }

  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: String): Boolean = {
      if(textWithBr.size == 1) false
      else if(textWithBr.isEmpty) true
      else {
        val openedBr = textWithBr.takeWhile(currentBr => !closed.contains(currentBr))
        if (openedBr.isEmpty) return false
        val foundPairBr =  openedBr.last.toString + textWithBr.drop(openedBr.size).headOption.getOrElse("")
        if(pairs.contains(foundPairBr)) {
          val newTextWithBr = openedBr.init.mkString + textWithBr.substring(openedBr.size + 1)
          loop(newTextWithBr)
        } else false
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)))
  }
}