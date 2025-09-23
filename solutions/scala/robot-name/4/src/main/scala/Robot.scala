import Robots.robotsName

import scala.util.Random

trait RobotData {
 def name : String
}

class Robot() extends RobotData {
  val rangeString = 'A' to 'Z'
  val rangeNumber = 0 to 9
  val maxNb = 3
  val maxCh = 2
  def reset() = {
    Robots.robotsName.remove(this.name)
  }

  override def name = {
    if (allowedUniqueNames(maxCh, maxNb)) randomName(maxCh,maxNb)
    else randomName(maxCh + 1,maxNb + 1)
  }

  def allowedUniqueNames(strLength:Int, nbLenght:Int) = {
  (max(rangeNumber.size, nbLenght) + max(rangeString.size, strLength)) > (Robots.robotsName.size)
}

  val  max = (rng: Int, po: Int) =>  fact(rng) /  (fact(po) * fact(rng - fact(po)))
  def fact(nb: Int) : Int = {
    def loop(acc: Int, nb1: Int): Int = {
      if(nb1 == 0 ) 1
      else loop(acc*nb1, nb1 - 1)
    }
    loop(1, nb)
  }
  def randomName(strLength:Int, nbLenght:Int) : String = {

   var newName =  (1 to strLength).foldLeft(""){(em, i ) => em + rangeString(Random.nextInt(9))} +
       (1 to nbLenght).foldLeft(""){(em, i) => em + rangeNumber(Random.nextInt(9)).toString}

   while (robotsName.contains(newName)) {
     newName =  (1 to strLength).foldLeft(""){(em, i ) => em + rangeString(Random.nextInt(9))} +
       (1 to nbLenght).foldLeft(""){(em, i) => em + rangeNumber(Random.nextInt(9)).toString}
   }
    robotsName.add(newName)
    newName
  }
}
object Robots {
  val robotsName = scala.collection.mutable.Set.empty[String]
}