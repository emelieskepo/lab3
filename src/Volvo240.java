import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Volvo240 extends Car{

    private final static double trimFactor = 1.2;

    public Volvo240(){
        super(4, 100, Color.black, 4.9);
    }

    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }
}