object MatchingBrackets{

  val closed = List(']', '}',')')
  val opened = List('{','(','[')
  val allPattern = List("{}","()","[]")

  def isPaired(string: String) :Boolean = {
    removeTail(string.filter(c => (closed ++ opened).contains(c)))
  }
  private def removeTail(string: String): Boolean = {
    def loop(acc: String):Boolean = {
      if(acc.size == 1) false
      else if(acc.isEmpty) true
      else {
        val firstEle = acc.zipWithIndex.takeWhile(c => !closed.contains(c._1))
        if (firstEle.size == 0) return false
        val cop =  firstEle.last._1.toString +  acc.drop(firstEle.size).headOption.getOrElse("")
        if(allPattern.contains(cop)) {
          val news = firstEle.init.map(_._1).mkString + acc.substring(firstEle.last._2 + 2)
          loop(news) && true
        } else false
      }
    }
    loop(string)
  }
}