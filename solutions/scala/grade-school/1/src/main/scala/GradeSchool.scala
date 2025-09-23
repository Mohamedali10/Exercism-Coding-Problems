class School {
  type DB = Map[Int, Seq[String]]
  private var schoolRestore =  Map.empty[Int, Seq[String]]
  def add(name: String, g: Int) = {
    val maybeExist = schoolRestore.get(g)
    maybeExist.fold(schoolRestore += (g -> Seq(name)))(already => schoolRestore += (g -> (already :+ name)))
  }

  def db: DB = schoolRestore

  def grade(g: Int): Seq[String] = schoolRestore.getOrElse(g, Seq.empty)

  def sorted: DB = {
    schoolRestore.toList.sortBy(_._1).map { case (g, sts) => (g -> sts.sorted)}.toMap
  }
}

