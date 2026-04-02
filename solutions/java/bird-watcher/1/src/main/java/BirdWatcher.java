
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] birdsLastWeek = new int[]{0,2,5,3,7,8,4} ;
        return birdsLastWeek;
    }

    public int getToday() {
       int birdsLength = birdsPerDay.length;
        if (birdsLength == 0) {
            return 0;
        } else {
                return birdsPerDay[birdsLength -  1];

        }
    }

    public void incrementTodaysCount() {
        int birdsLength = birdsPerDay.length;
        birdsPerDay[birdsLength - 1] = birdsPerDay[birdsLength - 1] +1;
     
    }

    public boolean hasDayWithoutBirds() {
       boolean hasDay = false;
      for (int nbBird: birdsPerDay) {
            if (nbBird == 0) {
                 hasDay = true;
            }
        }
        return hasDay;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int counter = 0;
        for (int i = 0; i < numberOfDays && i <birdsPerDay.length ; i++ ) {
            counter = birdsPerDay[i] + counter;
        }
        return counter;
    }

    public int getBusyDays() {
        int nbBusyDays = 0;
        for (int nbBird: birdsPerDay) {
            if (nbBird >= 5) {
                nbBusyDays +=1;
            }
        }
        return nbBusyDays;
    }
}
