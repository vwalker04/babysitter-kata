import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class BabysitterTest {

    Babysitter babysitter;

    @Before
    public void setUp() {
        babysitter = new Babysitter();
    }

    @Test
    public void calcNightlyCharge_canStartNoEarlierThan5PM() {
        String startTime = "4:00 PM";

        assertEquals("Invalid Time Entry.", babysitter.calcNightlyCharge(startTime));
    }


}