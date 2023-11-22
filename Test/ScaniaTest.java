import org.junit.Test;
import static org.junit.Assert.*;

public class ScaniaTest {
    private Scania scania = new Scania();

    @Test
    public void scaniaSetAnglePlatform() {
        scania.setAnglePlatform(10.0);
        assertEquals(10.0, scania.getAngleLift(), 0.0001);
    }
    @Test
    public void scaniaSetAnglePlatformWhenAngleIsNotAllowed() {
        scania.setAnglePlatform(90.0);
        assertEquals(0, scania.getAngleLift(), 0.0001);
    }
}