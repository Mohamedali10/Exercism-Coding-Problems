case class Triangle(firstSide: Double, secondSide: Double, thirdSide: Double) {

  def isTriangle = (firstSide > 0 && secondSide >0 && thirdSide > 0  ) &&
    (firstSide + secondSide >= thirdSide && firstSide + thirdSide >= secondSide && secondSide + thirdSide >= firstSide)
  def equilateral(): Boolean = {
    isTriangle && (firstSide == secondSide && thirdSide == firstSide && secondSide == thirdSide)
  }

  def isosceles(): Boolean = {
    isTriangle && (firstSide == secondSide || firstSide == thirdSide || secondSide == thirdSide)
  }

  def scalene(): Boolean = {
    isTriangle && (firstSide != secondSide && firstSide != thirdSide && secondSide != thirdSide)
  }

}