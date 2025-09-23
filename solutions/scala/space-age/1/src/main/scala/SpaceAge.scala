import java.util.Date
object SpaceAge  {


  val orbitalPerPlanet = Map (
    "Earth" -> 1.0,
    "Mercury"-> 0.2408467,
    "Venus"-> 0.61519726,
    "Mars" -> 1.8808158,
    "Jupiter" -> 11.862615,
    "Saturn"-> 29.447498,
    "Uranus"->84.016846,
    "Neptun"->164.79132
  )

  lazy val earthSecond = 31557600

  def onEarth(mill: Double)= {
    mill / earthSecond
  }
  def onMercury(mill: Double) = {
    val mer =  0.2408467 * earthSecond
    mill / mer
  }

  def onVenus(mill: Double) = {
    val mer =  0.61519726 * earthSecond
    mill / mer
  }

  def onMars(mill: Double) = {
    val mer = 1.8808158 * earthSecond
    mill / mer
  }

  def onJupiter(mill: Double) = {
    val mer =  11.862615 * earthSecond
    mill / mer
  }
  def onSaturn(mill: Double) = {
    val mer =  29.447498 * earthSecond
    mill / mer
  }

  def onUranus(mill: Double) = {
    val mer =  84.016846 * earthSecond
    mill / mer
  }

  def onNeptune(mill: Double) = {
    val mer =  164.79132 * earthSecond
    mill / mer
  }
}