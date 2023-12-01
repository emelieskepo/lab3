import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;
// GLÖM INTE FIXA AVSTÅNDET MELLAN BILARNA
// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // To keep track of a singel cars position
    public ArrayList<Point> vehiclePositions = new ArrayList<>();
    public ArrayList<BufferedImage> vehicleImages = new ArrayList<>();

    public void moveit(int[] x, int[] y) {
        for (int i = 0; i < vehiclePositions.size(); i++) {
            vehiclePositions.get(i).x = x[i];
            vehiclePositions.get(i).y = y[i]+i*100;
        }
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
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg")));
            vehicleImages.add(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

        for(int i = 0; i < vehicleImages.size(); i++) {
            vehiclePositions.add(new Point(0, i * 100));
        }
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < vehicleImages.size(); i++) {
            g.drawImage(vehicleImages.get(i), vehiclePositions.get(i).x, vehiclePositions.get(i).y, null);
        }
    }
}