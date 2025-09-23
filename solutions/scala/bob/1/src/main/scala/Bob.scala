object Bob {
  def response(statement: String): String = {
    val trimmedStatement = statement.trim
    val filteredByLettersStatement = trimmedStatement.filter(_.isLetter)
    filteredByLettersStatement match {
      case yelling if yelling.nonEmpty && yelling.forall(_.isUpper) && trimmedStatement.endsWith("?") => "Calm down, I know what I'm doing!"
      case yelling if yelling.nonEmpty && yelling.forall(_.isUpper) => "Whoa, chill out!"
      case "" if trimmedStatement.isEmpty => "Fine. Be that way!"
      case _ if trimmedStatement.endsWith("?") => "Sure."
      case _ => "Whatever."
    }
  }
}
