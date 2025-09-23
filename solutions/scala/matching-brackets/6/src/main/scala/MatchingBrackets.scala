object MatchingBrackets {

  val closed = List(']', '}',')')
  val opened = List('[', '{','(')
  val pairs = opened zip closed map{ case (opnd, clsd) => opnd.toString + clsd.toString }

  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: String): Boolean = {
      textWithBr.toList match  {
        case Nil => true
        case br :: Nil => false
        case br :: brs if closed.contains(br) => false
        case text =>
          val  nonEmptyOpenedBr = text.takeWhile(currentBr => !closed.contains(currentBr))
          if (pairs.contains(nonEmptyOpenedBr.last.toString + textWithBr.drop(nonEmptyOpenedBr.size).headOption.getOrElse(""))) {
            val newTextWithBr = nonEmptyOpenedBr.init.mkString + textWithBr.substring(nonEmptyOpenedBr.size + 1)
            loop(newTextWithBr)
          } else false
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)))
  }
}