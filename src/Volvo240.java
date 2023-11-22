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

    public static class DrawPanel extends JPanel {

        // Just a single image, TODO: Generalize
        BufferedImage volvoImage;
        // To keep track of a singel cars position
        Point volvoPoint = new Point();

        // TODO: Make this genereal for all cars
        void moveit(int x, int y){
            volvoPoint.x = x;
            volvoPoint.y = y;
        }

        // Initializes the panel and reads the images
        public DrawPanel(int x, int y) {
            this.setDoubleBuffered(true);
            this.setPreferredSize(new Dimension(x, y));
            this.setBackground(Color.green);
            // Print an error message in case file is not found with a try/catch block
            try {
                // You can remove the "pics" part if running outside of IntelliJ and
                // everything is in the same main folder.
                // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

                // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
                // if you are starting in IntelliJ.
                volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }

        // This method is called each time the panel updates/refreshes/repaints itself
        // TODO: Change to suit your needs.
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        }
    }
}