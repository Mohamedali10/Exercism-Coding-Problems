

final case class Clock(hour: Int, minutes: Int) {

  def +(clock: Clock): Clock = Clock(clock.hour + hour, clock.minutes + minutes)

  def -(clock: Clock): Clock = Clock(hour - clock.hour, minutes - clock.minutes)

  def ==(clock: Clock): Boolean = Clock(hour, minutes).equals(Clock(clock.hour, clock.minutes))

  def equals(obj: Clock): Boolean = obj.hour == this.hour && obj.minutes == this.minutes
}

object Clock {
  def apply(minute: Int): Clock = apply(0, minute)

  def apply(hour: Int, minutes: Int): Clock = {
    val newClk = new Clock(hour, minutes)
    newClk.copy(hour = setHour(newClk), minutes = setMinutes(nbOfMinutes(newClk.minutes)))
  }

  private def nbOfHours(min: Int): Int = min / 60

  private def nbOfMinutes(min: Int): Int = min % 60

  private def hourCalculator(h: Int): Int = if (Math.abs(h) >= 24) hourCalculator(h % 24) else h

  private def setMinutes(mi: Int): Int = if (mi < 0) 60 + mi else mi

  def setHour(clk: Clock): Int = {
    val numberOfHoursInMinutes = nbOfHours(clk.minutes)
    val totalHoursOfMinutes = hourCalculator(numberOfHoursInMinutes)
    val totalHoursOfHours = hourCalculator(clk.hour)
    val removeOneHourFromTotal = if (clk.minutes < 0) (totalHoursOfHours - 1) + totalHoursOfMinutes else totalHoursOfHours + totalHoursOfMinutes
    removeOneHourFromTotal match {
      case 24 => 0
      case nb if nb > 24 => 24 - removeOneHourFromTotal
      case nb if nb < 0 => 24 + removeOneHourFromTotal
      case _ => removeOneHourFromTotal
    }
  }
}