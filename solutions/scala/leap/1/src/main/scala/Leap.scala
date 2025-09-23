object Leap {
  def leapYear(year: Int): Boolean = isDivisbleBy400(year) || (!isDivisbleBy100(year) && isDivisbleBy4(year))

  private def isDivisbleBy4 (year: Int): Boolean = year % 4 == 0
  private def isDivisbleBy100(year: Int): Boolean = year % 100 == 0
  private def isDivisbleBy400(year: Int): Boolean = year % 400 == 0
}
