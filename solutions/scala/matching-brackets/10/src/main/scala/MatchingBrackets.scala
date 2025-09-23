object MatchingBrackets {

  private val closed = List(']', '}',')')
  private val opened = List('[', '{','(')
  private val pairs = opened zip closed


  def isPaired(string: String) :Boolean = {
    @scala.annotation.tailrec
    def loop(textWithBr: List[Char], openedBr: List[Char]): Boolean = {
      textWithBr match  {
        case Nil if openedBr.isEmpty => true
        case br :: brs  if opened.contains(br) => loop(brs, br +: openedBr)
        case br :: brs if closed.contains(br) && openedBr.nonEmpty && pairs.contains((openedBr.head, br)) =>  loop(brs , openedBr.tail)
        case _ => false
      }
    }
    loop(string.filter(c => (closed ++ opened).contains(c)).toList, List.empty)
  }
}