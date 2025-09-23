import com.github.blemale.scaffeine._

import scala.util.Random

class Robot() {

  var name :String = ""
  var listOfNames = scala.collection.immutable.Stream[String]()
  appendName()
  
  def reset()= {//do not do anything
     }

  def appendName()= {

    this.name = randomName(2,3)
    while(listOfNames.contains(this.name)){
      this.name = randomName(2,3)
    }
    listOfNames = this.name #:: listOfNames
  }

  def randomName(strLength:Int, nbLenght:Int) : String = {
    val start = Math.pow(10,2).toInt
    val end = Math.pow(10,nbLenght).toInt
    println(start)
    val chars =('A' to 'Z')
    println(chars)
    var st = ""
    val tmpList = List.range(0, strLength)
    println(tmpList)
    val charList = tmpList.map(e => chars(util.Random.nextInt(chars.length)))
    val randomNb = start + Random.nextInt(end - start +1)
    println(randomNb)
    println(charList)
    charList.mkString + randomNb.toString
  }

}
