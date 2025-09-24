public class CarsAssemble {

    private static int nbCars = 221;
    private static double fourRate = 1;
    private static double eightRate = 0.9;
    private static double nineRate = 0.8;
    private static double tenRate = 0.77;

    public double productionRatePerHour(int speed) {
        if(speed <= 4) {
            return speed * nbCars * fourRate;
        }
        else if (speed <= 8) {
                        return speed * nbCars * eightRate;

        }
            else if (speed == 9) {
                          return  speed * nbCars * nineRate;

            }
            else {
                           return speed * nbCars * tenRate;

            }
            
            
    }

    public int workingItemsPerMinute(int speed) {
        return ((int)Math.round(productionRatePerHour(speed)) / 60);
        
    }
}
