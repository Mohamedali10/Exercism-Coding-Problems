final case class WordCount(word: String) {
    val specialChars = "'?[^a-z0-9']'?".r
    def countWords: Map[String, Int] = {
        val lowercaseWord:String = word.toLowerCase()
        val splittedWords = specialChars.replaceAllIn(lowercaseWord, " ").split(" ").filter(_.nonEmpty)
        splittedWords.distinct.map(key => key -> splittedWords.count(_==key)).toMap
    }
}