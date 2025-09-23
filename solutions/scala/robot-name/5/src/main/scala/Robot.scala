import Robots.robotsName

import scala.collection.mutable
import scala.util.Random

trait RobotData {
 def name : String
}

class Robot() extends RobotData {
  val rangeString = 'A' to 'Z'
  val rangeNumber = 0 to 9
  private var maxNb = 3
  private var maxCh = 2
  private var myName : String = ""
  lazy val extendNbChars : Boolean = allowedUniqueNames(maxCh, maxNb)
  def reset() = myName = ""


  override def name = {
    if (myName.isEmpty) setName
    myName
  }

  private def setName: Unit = {
    if (extendNbChars) randomName(maxCh,maxNb)
    else randomName(maxCh + 1, maxNb + 1 )
  }

  def allowedUniqueNames(strLength:Int, nbLenght:Int) = {
    (max(rangeNumber.size, nbLenght) + max(rangeString.size, strLength)) > (Robots.robotsName.size)
  }

    def fact(nb: Long) : Long = {
    def loop(acc: Long, nb1: Long): Long = {
      if(nb1 <= 1 ) acc
      else loop(acc*nb1, nb1 - 1)
    }
    loop(1, nb)
  }
  val  max: (Long, Long) => Long = (rng: Long, po: Long) => fact(rng) / (fact(po) * fact(rng - fact(po)))

  def randomName(strLength:Int, nbLenght:Int)  = {
    def createNewName(newName: String): String = {
      newName match {
        case name: String if name.isEmpty || robotsName.contains(name) => createNewName( (1 to strLength).foldLeft(""){(em, i ) => em + rangeString(Random.nextInt(9))} +
          (1 to nbLenght).foldLeft(""){(em, i) => em + rangeNumber(Random.nextInt(9)).toString})
        case aName : String => aName
      }
    }
    myName = createNewName("")
    robotsName += myName
  }
}
object Robots {
  val robotsName = mutable.HashSet.empty[String]
}