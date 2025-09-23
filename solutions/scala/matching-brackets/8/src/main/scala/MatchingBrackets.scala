object MatchingBrackets {

  val closed = List(']', '}',')')
  val opened = List('[', '{','(')
  val pairs = opened zip closed map{ case (opnd, clsd) => opnd.toString + clsd.toString }
  val unzipPairs = pairs.map (pair => (pair.head, pair.last))

  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: List[Char], openedBr: List[Char]): Boolean = {
      textWithBr match  {
        case Nil if openedBr.isEmpty => true
        case Nil if openedBr.nonEmpty => false
        case br :: brs  if opened.contains(br) => loop(brs, br +: openedBr)
        case br :: brs if closed.contains(br) && openedBr.isEmpty => false
        case br :: brs if closed.contains(br) && openedBr.size == 1 && unzipPairs.contains((openedBr.head, br)) => true
        case br :: brs if closed.contains(br) && openedBr.nonEmpty && unzipPairs.contains((openedBr.head, br)) =>  loop(brs , openedBr.tail)
        case _ => false
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)).toList, List.empty)
  }
}