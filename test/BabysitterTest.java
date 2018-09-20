import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.*;

public class BabysitterTest {

    private Babysitter babysitter;
    private String startTime;
    private String endTime;
    private String bedTime;

    @Before
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void calcNightlyCharge_canStartNoEarlierThan5PM() throws ParseException {
        startTime = "4:00 PM";
        endTime = "8:00 PM";
        bedTime = "8:00 PM";

        assertEquals("Starting time is too early.", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }

    @Test
    public void calcNightlyCharge_canEndNoLaterThan4AM() throws ParseException {
        startTime = "5:00 PM";
        endTime = "5:00 AM";
        bedTime = "8:00 PM";

        assertEquals("Ending time is too late.", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }

    @Test
    public void calcNightlyCharge_calculatesPayBetweenStartTimeAndBedTime() throws ParseException {
        startTime = "5:00 PM";
        endTime = "10:00 PM";
        bedTime = "8:00 PM";

        assertEquals("$36", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }
}