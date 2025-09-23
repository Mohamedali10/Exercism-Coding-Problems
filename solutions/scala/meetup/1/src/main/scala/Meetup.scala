import java.time.{DayOfWeek, LocalDate}
import Schedule.Schedule

import java.time.temporal.{ChronoField, TemporalField}
import java.util.Calendar
import scala.collection.BitSet.empty.to

case class Meetup(month: Int, year: Int) {

  def day(dayOfWeek: Int, schedule: Schedule): LocalDate = {
    val monthBegins = LocalDate.of(year, month, 1)
    val monthEnds = LocalDate.of(year, month, monthBegins.lengthOfMonth())

    def loop(currentDate: LocalDate, acc: List[LocalDate]): List[LocalDate] = {
      if(currentDate.isBefore(monthEnds.plusDays(1))) {
        if(currentDate.get(ChronoField.DAY_OF_WEEK) == dayOfWeek) loop(currentDate.plusDays(1), acc :+ currentDate)
        else loop(currentDate.plusDays(1), acc)
      } else {
        acc
      }
    }
    val listOfDays = loop(monthBegins, List.empty)
     schedule match {
       case Schedule.First => listOfDays.head
       case Schedule.Second => listOfDays.take(2).last
       case Schedule.Third => listOfDays.take(3).last
       case Schedule.Fourth => listOfDays.take(4).last
       case Schedule.Last => listOfDays.last
       case Schedule.Teenth => listOfDays.filter(ld => ld.getDayOfMonth > 10 && ld.getDayOfMonth < 20).sortWith(_ isAfter (_)).head
     }

  }
}

object Schedule extends Enumeration {
  type Schedule = Value
  val Teenth, First, Second, Third, Fourth, Last = Value
}

object Meetup {
  val Mon = DayOfWeek.MONDAY.getValue
  val Tue = DayOfWeek.TUESDAY.getValue
  val Wed = DayOfWeek.WEDNESDAY.getValue
  val Thu = DayOfWeek.THURSDAY.getValue
  val Fri = DayOfWeek.FRIDAY.getValue
  val Sat = DayOfWeek.SATURDAY.getValue
  val Sun = DayOfWeek.SUNDAY.getValue
}
