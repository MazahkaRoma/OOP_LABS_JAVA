package OOP_Labs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class FractalExplorer
{
    private int width;
    private int height;
    private JImageDisplay display;
    private FracctalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    public FractalExplorer(int width, int height)
    {
        this.width = width;
        this.height = height;
        range = new Rectangle2D.Double();
        fractalGenerator = new Mandelbrot();
        fractalGenerator.getInitialRange(range);
    }

    public void createAndShowGUI()
    {

        JFrame frame = new JFrame("Fractal Explorer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        display = new JImageDisplay(width,height);
        display.addMouseListener(new MouseButtonClicked());
        frame.add(display, BorderLayout.CENTER);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ButtonResetEventListener());
        frame.add(btnReset, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal()
    {
        for (int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y ++)
            {
                double xCoord = FracctalGenerator.getCoord(range.x, range.x+range.width, width, x);
                double yCoord = FracctalGenerator.getCoord(range.y, range.y+range.height, height, y);


                int numIters = fractalGenerator.numIterations(xCoord, yCoord);

                if (numIters == -1)
                {
                    display.drawPixel(x, y, Color.BLACK.getRGB());
                }

                else {
                    float hue = 0.7f + (float)numIters / 200f;
                    int rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                    display.drawPixel(x, y, rgbColor);
                }
                display.repaint();
            }
        }
    }

    class ButtonResetEventListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }

    class MouseButtonClicked implements MouseListener
    {
        public void mouseClicked(MouseEvent e)
        {
            double xCoord = FracctalGenerator.getCoord(range.x, range.x+range.width, width, e.getX());
            double yCoord = FracctalGenerator.getCoord(range.y, range.y+range.height, height, e.getY());
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord, 0.5);
            drawFractal();
        }
        public void mousePressed(MouseEvent e){};

        public void mouseReleased(MouseEvent e){};

        public void mouseEntered(MouseEvent e){};

        public void mouseExited(MouseEvent e){};
    }

    public static void main(String[] args)
    {

        FractalExplorer fractalExplorer = new FractalExplorer(1920, 1080);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.drawFractal();
    }

}
