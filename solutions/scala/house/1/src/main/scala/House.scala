object House {
  val seqOfString = List("",
    "the malt that lay in ", "the rat that ate ",
    "the cat that killed ", "the dog that worried ",
    "the cow with the crumpled horn that tossed ",
    "he maiden all forlorn that milked ",
    "the man all tattered and torn that kissed ",
    "the priest all shaven and shorn that married ",
    "the rooster that crowed in the morn that woke ",
    "the farmer sowing his corn that kept ",
    "the horse and the hound and the hornthat belong ")


  def jackRhyme(str: List[String], originStr: String, tailStr: String): String = {
    if (str.isEmpty) {
      return  originStr.concat(tailStr)
    } else {
      val newTail = str.head.concat(tailStr)
      jackRhyme(str.tail, originStr, newTail)
    }
  }

  def recite(startElement: Int, endElement: Int): String = {
    var str =""
    val startOfRhyme = " This is "
    val endOfRhyme = "the house that Jack built."
    for (i<- startElement to endElement) {
      str +=jackRhyme(seqOfString.take(i),startOfRhyme, endOfRhyme)+ "\n"
    }
    str
  }

}
