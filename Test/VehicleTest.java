import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.*;

public class VehicleTest {

    private Saab95 saab = new Saab95();


    @Test
    public void saabTurnLeft() {
        saab.turnLeft();
        assertEquals("NORTH", saab.getDirection());
        saab.turnLeft();
        assertEquals("WEST", saab.getDirection());
        saab.turnLeft();
        assertEquals("SOUTH", saab.getDirection());
        saab.turnLeft();
        assertEquals("EAST", saab.getDirection());
    }

    @Test
    public void saabTurnRight() {
        saab.turnRight();
        assertEquals("SOUTH", saab.getDirection());
        saab.turnRight();
        assertEquals("WEST", saab.getDirection());
        saab.turnRight();
        assertEquals("NORTH", saab.getDirection());
        saab.turnRight();
        assertEquals("EAST", saab.getDirection());
    }

    @Test
    public void saabTurnLeftAndMoveForward() {
        saab.turnLeft();
        saab.move();
        assertEquals(saab.getCurrentSpeed(), saab.getXPos(), 0.0001);

        saab.turnLeft();
        saab.move();
        assertEquals(saab.getCurrentSpeed(), -(saab.getYPos()), 0.0001);

        saab.turnLeft();
        saab.move();
        assertEquals(saab.getCurrentSpeed(), -(saab.getXPos()), 0.0001);

        saab.turnLeft();
        saab.move();
        assertEquals(saab.getCurrentSpeed(), saab.getYPos(), 0.0001);


    }

    @Test
    public void saabNumberOfDoors() {
        assertEquals(2, saab.getNrDoors());
    }

    @Test
    public void setTurboOnSaab() {
        saab.setTurboOn();
        assertTrue(saab.isTurboOn());
    }

    @Test
    public void saabEnginePower() {
        assertEquals(125, saab.getEnginePower(), 0.0001);
    }

    @Test
    public void saabSetCurrentSpeedWithinInterval() {
        saab.setCurrentSpeed(10);
        assertEquals(10, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saabGetColor() {
        assertEquals(Color.red, saab.getColor());
    }

    @Test
    public void saabSetColor() {
        saab.setColor(Color.black);
        assertEquals(Color.black, saab.getColor());
    }

    @Test
    public void saabStartEngine() {
        saab.startEngine();
        assertEquals(0.1, saab.getCurrentSpeed(), 0.0001);
    }

    @Test
    public void saabGasWithinInterval() {
        double initialSpeed = saab.getCurrentSpeed();
        saab.brake(0.1);
        assertTrue(saab.getCurrentSpeed() <= initialSpeed);
    }

    @Test
    public void saabBrakeOutsideInterval() {
        double initialSpeed = saab.getCurrentSpeed();
        saab.brake(2.0);
        assertTrue(saab.getCurrentSpeed() == initialSpeed);}


    @Test
    public void saabGasWhenAmountWithinInterval(){
        double initialSpeed = saab.getCurrentSpeed();
        saab.gas(0.1);
        assertTrue(saab.getCurrentSpeed() >= initialSpeed);
    }

    @Test
    public void saabGasWhenAmountOutsideInterval() {
        double initialSpeed = saab.getCurrentSpeed();
        saab.gas(-1.0);
        assertTrue(saab.getCurrentSpeed() == initialSpeed);
    }

    @Test
    public void isCurrentSpeedOutsideInterval() {
        double initialSpeed = saab.getCurrentSpeed();
        saab.setCurrentSpeed(140);
        assertTrue(saab.getCurrentSpeed() == initialSpeed);

    }

    @Test
    public void setAndGetPositions() {
        saab.setPosition(1.0, 1.0, "SOUTH");
        assertEquals(1.0, saab.getXPos(), 0.001);
        assertEquals(1.0, saab.getXPos(), 0.001);
        assertEquals("SOUTH", saab.getDirection());
    }

    @Test
    public void getSize(){
        assertEquals(4.8, saab.getSize(), 0.001);
    }
}