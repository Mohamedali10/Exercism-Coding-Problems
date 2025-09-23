object MatchingBrackets {

  val closed = List(']', '}',')')
  val opened = List('[', '{','(')
  val pairs = opened zip closed map{ case (opnd, clsd) => opnd.toString + clsd.toString }

  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: String, openedBr: List[Char]): Boolean = {
      textWithBr.toList match  {
        case Nil if openedBr.isEmpty => true
        case Nil if openedBr.nonEmpty => false
        case br :: brs  if opened.contains(br) => loop(brs.mkString, br +: openedBr)
        case br :: brs if closed.contains(br)  => openedBr match {
          case Nil => false
          case op :: Nil if pairs contains(op.toString + br.toString) => true
          case op :: open  if pairs contains(op.toString + br.toString) => loop(brs.mkString, open)
          case _ => false
        }
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)), List.empty)
  }
}