import scala.util.Random

trait RobotData {
 def name : String
}

class Robot() extends RobotData{

  private val listOfNames = scala.collection.mutable.Set.empty[String]

  appendName()
  
  def reset() = {
    this.listOfNames.remove(this.name)
  }

  override def name = listOfNames.headOption.getOrElse(randomName(2,3))

  def appendName() = {

   // val currentName = name
    def setNewName(currentName: String): String = {
      while(listOfNames.contains(currentName)){
        setNewName(name)
      }
      currentName
    }

    listOfNames += setNewName(name)
  }

  def randomName(strLength:Int, nbLenght:Int) : String = {
    val start = Math.pow(10,2).toInt
    val end = Math.pow(10,nbLenght).toInt
    val chars =('A' to 'Z')
    val tmpList = List.range(0, strLength)
    Stream.continually()
    val charList = tmpList.map(e => chars(util.Random.nextInt(chars.length)))
    val randomNb = start + Random.nextInt(end - start +1)
    charList.mkString + randomNb.toString
  }

}
