public class Lasagna {
    // TODO: define the 'expectedMinutesInOven()' method

    private final static int layerPreparingTime = 2;
     public int expectedMinutesInOven() {
          return 40;
      }
    
    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int actualTime) {
        return 40 - actualTime ;
    }
    // TODO: define the 'preparationTimeInMinutes()' method
       public int preparationTimeInMinutes(int numberOfLayers) {
            return numberOfLayers * layerPreparingTime;
        }
    // TODO: define the 'totalTimeInMinutes()' method

   public int totalTimeInMinutes(int numberOfLayers, int actualTime) {
        return preparationTimeInMinutes(numberOfLayers) + actualTime;
    }
}
