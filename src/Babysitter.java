import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Babysitter {

    private long wageBeforeBed = 12;
    private long wageAfterBed = 8;
    private int wagePastMidnight = 16;

    private long total = 0;
    private long amountFromStartToBedTime = 0;
    private long amountFromBedTimeToMidnight = 0;
    private long amountFromMidnightToEndOfJob = 0;

    public String calcNightlyCharge(String startTime, String endTime, String bedTime) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");

        Date time1 = sdf.parse(startTime);
        Date time2 = sdf.parse(endTime);
        Date time3 = sdf.parse(bedTime);

        long startTimeInHours = (time1.getTime() / 3600000) - 5;
        long endTimeInHours = (time2.getTime() / 3600000) - 5;
        long bedTimeInHours = (time3.getTime() / 3600000) - 5;

        if (startTimeInHours < 17) {
            return "Starting time is too early.";
        } else if (endTimeInHours < 17 && endTimeInHours > 4) {
            return "Ending time is too late.";
        }

        // convert 12:00 AM to 24th hour for evaluation
        if (endTimeInHours == 0) {
            endTimeInHours = 24;
        }

        amountFromStartToBedTime = (bedTimeInHours - startTimeInHours) * wageBeforeBed;

        if (endTimeInHours >= 1 && endTimeInHours <= 4) {
            amountFromBedTimeToMidnight = (24 - bedTimeInHours) * wageAfterBed;
        } else if (endTimeInHours < bedTimeInHours) {
            amountFromBedTimeToMidnight = ((endTimeInHours + 12) - bedTimeInHours) * wageAfterBed;
        } else {
            amountFromBedTimeToMidnight = (endTimeInHours - bedTimeInHours) * wageAfterBed;
        }

        if (endTimeInHours >= 1 && endTimeInHours <= 4) {
            amountFromMidnightToEndOfJob = endTimeInHours * wagePastMidnight;
        }

        total = amountFromStartToBedTime + amountFromBedTimeToMidnight + amountFromMidnightToEndOfJob;

        return "$" + Long.toString(total);
    }

}
