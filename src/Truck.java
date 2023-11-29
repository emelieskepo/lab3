import java.awt.*;

public abstract class Truck extends Vehicle{

    private boolean isLiftUp;


    public Truck(int nrDoors, double enginePower, Color color, double size, boolean isLiftUp) { //Konstruktor
        super(nrDoors, enginePower, color, size);
        this.isLiftUp = false;
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }


    @Override
    public void setCurrentSpeed(double currentSpeed){
        if (!this.isLiftUp){
            super.setCurrentSpeed(currentSpeed);
        }
    }

    @Override
    public void gas(double amount) {
        if (!isLiftUp && amount >= 0 && amount <= 1) {
            super.gas(amount);
        }
    }

    @Override
    public void brake(double amount) {
        if (!isLiftUp && amount >= 0 && amount <= 1) {
            super.brake(amount);
        }
    }

    public boolean isMoving() {
        return getCurrentSpeed() > 0;
    }


    public boolean getIsLiftUp() {
        return this.isLiftUp;
    }

    public void setIsLiftUp(boolean isLiftUp) {
        if (!isMoving()){
            this.isLiftUp = isLiftUp;
        }
    }
}