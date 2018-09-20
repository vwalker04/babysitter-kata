import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Babysitter {

    private long wageBeforeBed = 12;
    private int wageAfterBed = 8;
    private int wagePastMidnight = 16;
    private int total;

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

        long difference = (bedTimeInHours - startTimeInHours) * wageBeforeBed;
        String strDifference = "$" + Long.toString(difference);
        return strDifference;
    }

}
