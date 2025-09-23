object ArmstrongNumbers {
  def isArmstrongNumber(n: Int ): Boolean = {
   val size =  n.toString.size
    val total = n.toString.toList.foldLeft(0.0)((res, cu) => (res  +Math.pow(cu.toString.toInt, size)))
    total == n.toDouble
  }
}