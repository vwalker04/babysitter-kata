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
    public void calcNightlyCharge_returns12DollarsPerHourBetweenStartTimeAndBedTime() {
        assertEquals(36, babysitter.calcNightlyCharge(5, 8));
    }
}