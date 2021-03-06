package OOP_Labs;

import java.awt.geom.Rectangle2D;

class Mandelbrot extends FracctalGenerator{


    private static final int MAX_ITERATIONS = 2000;

    @Override
    public void getInitialRange(Rectangle2D.Double range) {
        range.x = -2;
        range.y = -1.5;
        range.width = 3;
        range.height = 3;
    }

    @Override
    public int numIterations(double x, double y) {
        Complex c = new Complex(x, y);
        Complex z = new Complex(0,0);
        int counter = 0;

        while (z.getSqrModule() < 4 && counter < MAX_ITERATIONS){
            z = z.mult(z);
            z = z.plus(c);
            counter++;
        }

        if (counter == MAX_ITERATIONS)
            return -1;
        return counter;
    }
}