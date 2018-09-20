import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import static org.junit.Assert.*;

public class BabysitterTest {

    Babysitter babysitter;

    @Before
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void calcNightlyCharge_canStartNoEarlierThan5PM() throws ParseException {
        String startTime = "4:00 PM";
        String endTime = "8:00 PM";
        String bedTime = "8:00 PM";

        assertEquals("Starting time is too early.", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }

    @Test
    public void calcNightlyCharge_canEndNoLaterThan4AM() throws ParseException {
        String startTime = "5:00 PM";
        String endTime = "5:00 AM";
        String bedTime = "8:00 PM";

        assertEquals("Ending time is too late.", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }

    @Test
    public void calcNightlyCharge_calculatesPayBetweenStartTimeAndBedTime() throws ParseException {
        String startTime = "5:00 PM";
        String endTime = "10:00 PM";
        String bedTime = "8:00 PM";

        assertEquals("$36", babysitter.calcNightlyCharge(startTime, endTime, bedTime));
    }
}