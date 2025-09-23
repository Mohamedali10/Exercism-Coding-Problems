
case class Planet(orbit: Double)

object PlanetOrbits extends Enumeration {
  val earth = Planet(1.0)
  val mercury = Planet(0.2408467)
  val venus = Planet(0.61519726)
  val mars = Planet(1.8808158)
  val jupiter = Planet(11.862615)
  val saturn = Planet(29.447498)
  val uranus = Planet(84.016846)
  val neptun = Planet(164.79132)
}

object SpaceAge {

  lazy val earthSecond = 31557600

  private def computeOrbites(dt: Double, nom: Double): Double = dt / (nom * earthSecond)

  def onEarth(mill: Double): Double = computeOrbites(mill, 1.0)

  def onMercury(mill: Double): Double = computeOrbites(mill, PlanetOrbits.mercury.orbit)

  def onVenus(mill: Double): Double = computeOrbites(mill, PlanetOrbits.venus.orbit)

  def onMars(mill: Double): Double = computeOrbites(mill, PlanetOrbits.mars.orbit)

  def onJupiter(mill: Double): Double = computeOrbites(mill, PlanetOrbits.jupiter.orbit)

  def onSaturn(mill: Double): Double = computeOrbites(mill, PlanetOrbits.saturn.orbit)

  def onUranus(mill: Double): Double = computeOrbites(mill, PlanetOrbits.uranus.orbit)

  def onNeptune(mill: Double): Double = computeOrbites(mill, PlanetOrbits.neptun.orbit)
}