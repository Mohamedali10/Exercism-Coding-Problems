object BeerSong {

  def recite(numberOfBottle: Int, numberOfRecite: Int): String = {

      var outputrecite: String = " "
        
        for(i<- 0 to numberOfRecite -1 ){
            (numberOfBottle-i) match {
                case 0 => outputrecite ="No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n"
                case 1 => outputrecite = "1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall."
                case _ => {outputrecite = (numberOfBottle - i).toString() +" bottles of beer on the wall, "+
                (numberOfBottle - i) + " bottles of beer."+ "\nTake one down and pass it around, " +(numberOfBottle - (i+1)).toString()
                           
                           if((numberOfBottle-(i+1)) == 1 ){
                  							outputrecite = outputrecite + "bottle of beer on the wall.\n"
                           }else{
                             outputrecite = outputrecite + " bottles of beer on the wall.\n"
                           }
                          }
            }
        return outputrecite

        }
    outputrecite
    }


}