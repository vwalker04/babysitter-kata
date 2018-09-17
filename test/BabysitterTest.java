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
        assertEquals(12, babysitter.calcNightlyCharge(6, 7, 7));
        assertEquals(36, babysitter.calcNightlyCharge(5, 8, 8));
    }

    @Test
    public void calcNightlyCharge_returnsCorrectRateBeforeAndAfterBedTime() {
        assertEquals(32, babysitter.calcNightlyCharge(6, 9, 8));
        assertEquals(76, babysitter.calcNightlyCharge(5, 12, 10));
        assertEquals(24, babysitter.calcNightlyCharge(8, 11, 7));
    }
}