public class Babysitter {

    private int wageBeforeBed = 12;
    private int wageAfterBed = 8;
    private int wagePastMidnight = 16;
    private int total;

    public int calcNightlyCharge(int startTime, int endTime, int bedTime) {
        if (bedTime <= startTime) {
            total = (endTime - startTime) * wageAfterBed;
        }
        if (bedTime > startTime) {
            total = (bedTime - startTime) * wageBeforeBed;
            total += (endTime - bedTime) * wageAfterBed;
        }
        return total;
    }
}
