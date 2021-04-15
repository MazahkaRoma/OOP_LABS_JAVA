package OOP_Labs;

public class Complex {

    public double re;
    public double im;

    public Complex(double re, double im){
        this.re = re;
        this.im = im;
    }

    public double gerRe(){
        return re;
    }

    public double getIm(){
        return im;
    }

    public double getSqrModule(){
        return re*re + im*im;
    }

    public Complex plus(Complex complex){
        return new Complex(this.re + complex.re, this.im+complex.im);
    }

    public Complex mult(Complex complex){
        return new Complex(this.re * complex.re - this.im * complex.im,
                this.im*complex.re + this.re * complex.im);
    }
}
