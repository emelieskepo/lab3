import java.awt.*;

public class Scania extends Truck{

    private double angleLift;

    public Scania(){
        super(2, 500, Color.blue, 25, false);
        this.angleLift = angleLift;
    }

    public double getAngleLift(){
        return this.angleLift;
    }

    public void setAnglePlatform(double angle) {
        if (!isMoving() && angle > 0 && angle <= 70) {
            this.angleLift = angle;
            setIsLiftUp(true);

        }else if (angle == 0 && getCurrentSpeed() == 0){
            setIsLiftUp(false);

        }else
            this.angleLift = 0;

    }

}