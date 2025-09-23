object MatchingBrackets {

  val closed = List(']', '}',')')
  val opened = List('[', '{','(')
  val pairs = opened zip closed map{ case (opnd, clsd) => opnd.toString + clsd.toString }

  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: String): Boolean = {
      textWithBr match  {
        case text : String if text.isEmpty => true
        case text if text.size == 1 => false
        case text  =>  text.takeWhile(currentBr => !closed.contains(currentBr)) match {
          case openedBr if openedBr.isEmpty => false
          case nonEmptyOpenedBr if pairs.contains(nonEmptyOpenedBr.last.toString + textWithBr.drop(nonEmptyOpenedBr.size).headOption.getOrElse("")) => {
            val newTextWithBr = nonEmptyOpenedBr.init.mkString + textWithBr.substring(nonEmptyOpenedBr.size + 1)
            loop(newTextWithBr)
          }
          case _ => false
        }
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)))
  }
}