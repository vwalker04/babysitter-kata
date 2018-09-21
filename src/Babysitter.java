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

        if (endTimeInHours <= 24 && endTimeInHours > bedTimeInHours) {
             amountFromBedTimeToMidnight = (endTimeInHours - bedTimeInHours) * wageAfterBed;
        }

        amountFromStartToBedTime = (bedTimeInHours - startTimeInHours) * wageBeforeBed;

        total = amountFromStartToBedTime + amountFromBedTimeToMidnight;

        return "$" + Long.toString(total);
    }

}
