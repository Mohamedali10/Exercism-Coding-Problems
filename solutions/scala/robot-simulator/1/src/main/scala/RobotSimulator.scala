object Bearing {
sealed trait Directions    
case object South extends Directions
case object North extends Directions
case object East extends Directions
case object West extends Directions
}


final case class Robot(bearing: Bearing.Directions, coordinates: (Int, Int)) {
    def turnRight = bearing match {
        case Bearing.South => this.copy(bearing = Bearing.West)
        case Bearing.North => this.copy(bearing = Bearing.East) 
        case Bearing.East => this.copy(bearing = Bearing.South) 
        case Bearing.West => this.copy(bearing = Bearing.North) 
    }

   def turnLeft = bearing match {
        case Bearing.South => this.copy(bearing = Bearing.East)
        case Bearing.North => this.copy(bearing = Bearing.West) 
        case Bearing.East => this.copy(bearing = Bearing.North) 
        case Bearing.West => this.copy(bearing = Bearing.South) 
    }

   def advance = bearing match {
        case Bearing.South => this.copy(coordinates = (this.coordinates._1, this.coordinates._2 - 1 ))
        case Bearing.North => this.copy(coordinates = (this.coordinates._1, this.coordinates._2 + 1 ))
        case Bearing.East => this.copy(coordinates = (this.coordinates._1 + 1, this.coordinates._2 ))
        case Bearing.West => this.copy(coordinates = (this.coordinates._1 - 1, this.coordinates._2 ))
    }

    def simulate(path: String): Robot = {
        if (path.isEmpty()) this
        else {
            path.head match {
                case 'A' => this.advance.simulate(path.tail)
                case 'L' => this.turnLeft.simulate(path.tail)
                case 'R' => this.turnRight.simulate(path.tail)
                case _: Char => throw new RuntimeException("Invalid character")
            }
        }
    } 
}