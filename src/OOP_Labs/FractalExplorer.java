package OOP_Labs;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileFilter;

public class FractalExplorer{
    private int size;
    private JImageDisplay display;
    private FracctalGenerator fractalGenerator;
    private Rectangle2D.Double range;

    public FractalExplorer(int size){
        this.size = size;
        this.range = new Rectangle2D.Double();
        this.fractalGenerator = new Mandelbrot();
        this.display = new JImageDisplay(size, size);
    }

    public void createAndShowGUI(){
        JFrame frame = new JFrame("Fractal Explorer");
        Button buttonReset = new Button("Reset Display");

        JPanel jpanel = new JPanel();
        JPanel jpanelBoth = new JPanel();
        Button buttonSave = new Button("Save Image");
        jpanelBoth.add(buttonSave);
        jpanelBoth.add(buttonReset);

        JLabel jLabel = new JLabel("Fractal: ");
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Mandelbrot");
        comboBox.addItem("Tricorn");
        comboBox.addItem("BurningShip");

        jpanel.add(jLabel);
        jpanel.add(comboBox);

        ActionListener actionListener = new buttonResetClick();
        ActionListener saveAction = new buttonSaveClick();
        MouseListener mouseListener = new displayMouseClick();
        buttonReset.addActionListener(actionListener);
        buttonSave.addActionListener(saveAction);
        comboBox.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameFractal = (String) comboBox.getSelectedItem();
                if (nameFractal.equals("Mandelbrot")){
                    fractalGenerator = new Mandelbrot();
                    fractalGenerator.getInitialRange(range);
                    drawFractal();
                }
                if (nameFractal.equals("Tricorn")){
                    fractalGenerator = new Tricorn();
                    fractalGenerator.getInitialRange(range);
                    drawFractal();
                }
                if (nameFractal.equals("BurningShip")){
                    fractalGenerator = new BurningShip();
                    fractalGenerator.getInitialRange(range);
                    drawFractal();
                }
            }
        });

        frame.addMouseListener(mouseListener);

        frame.getContentPane().add(display, BorderLayout.CENTER);
        frame.getContentPane().add(jpanelBoth, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(jpanel, BorderLayout.NORTH);

        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void drawFractal(){
        double xCoord, yCoord;
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
            {
                xCoord = FracctalGenerator.getCoord(range.x, range.x + range.width, size, x);
                yCoord = FracctalGenerator.getCoord(range.y, range.y + range.height, size, y);

                int iterations = fractalGenerator.numIterations(xCoord, yCoord);
                int rgbColor;

                if (iterations == -1)
                {
                    rgbColor = 0;
                }
                else
                    {
                    float hue = 0.7f + (float) iterations / 200f;
                    rgbColor = Color.HSBtoRGB(hue, 1f, 1f);
                }
                display.drawPixel(x, y, rgbColor);
            }
            display.repaint();
        }
        display.repaint();
    }


    private class buttonResetClick implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            fractalGenerator.getInitialRange(range);
            drawFractal();
        }
    }

    private class buttonSaveClick implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            JFileChooser jFileChooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("PNG Images", "png");
            jFileChooser.setFileFilter(filter);
            jFileChooser.setAcceptAllFileFilterUsed(false);
            if (jFileChooser.showSaveDialog(display) == JFileChooser.APPROVE_OPTION)
            {
                File file = jFileChooser.getSelectedFile();
                try
                {
                    ImageIO.write(display.bufferedImage, "png", file);
                }
                catch (IOException exception)
                {
                    JOptionPane.showMessageDialog(display, exception.getMessage(),
                            "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                }
                catch (NullPointerException exception)
                {
                    JOptionPane.showMessageDialog(display, "Save error",
                            "Cannot Save Image", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }

    private class displayMouseClick implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e)
        {
            double xCoord = FracctalGenerator.getCoord(range.x, range.x + range.width, size, e.getX());
            double yCoord = FracctalGenerator.getCoord(range.y, range.y + range.height, size, e.getY());
            fractalGenerator.recenterAndZoomRange(range, xCoord, yCoord,0.5);
            drawFractal();
        }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }

    public static void main(String[] args)
    {
        FractalExplorer fractalExplorer = new FractalExplorer(800);
        fractalExplorer.createAndShowGUI();
        fractalExplorer.fractalGenerator.getInitialRange(fractalExplorer.range);
        fractalExplorer.drawFractal();
    }

}