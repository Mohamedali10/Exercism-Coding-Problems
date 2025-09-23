object PascalsTriangle {
  def rows(numberOfRows: Int): List[List[Int]] = {
    numberOfRows match {
      case 1 => List(List(1))
      case n if n-1 > 0 => rows(n-1) :+ pascalRow(rows(n-1).last)
      case _ => List.empty
    }
  }
  private def pascalRow(previousRowElements: List[Int]): List[Int] = {
    1 +: previousRowElements.zipWithIndex.map{ case (in, i) => previousRowElements.slice(i, i + 2)}.init.map(_.sum) :+ 1
  }
}