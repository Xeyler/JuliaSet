package me.xeyler;

public class Complex {

	private final double real;
	private final double imaginary;
	
	public Complex(double r, double i) {
		real = r;
		imaginary = i;
	}
	
	public Complex add(Complex complex2) {
		Complex complex1 = this;
		double real = complex1.real + complex2.real;
		double imaginary = complex1.imaginary + complex2.imaginary;
		return new Complex(real, imaginary);
	}
	
	public Complex subtract(Complex complex2) {
		Complex complex1 = this;
		double real = complex1.real - complex2.real;
		double imaginary = complex1.imaginary - complex2.imaginary;
		return new Complex(real, imaginary);
	}
	
	public Complex multiply(Complex complex2) {
		Complex complex1 = this;
		double real = (complex1.real * complex2.real) - (complex1.imaginary * complex2.imaginary);
		double imaginary = (complex1.real * complex2.imaginary) + (complex1.imaginary * complex2.real);
		return new Complex(real, imaginary);
	}
	
	public double real() {
		return real;
	}
	
	public double imaginary() {
		return imaginary;
	}

	public double norm() {
		Complex complex = this;
		double real = complex.real * complex.real;
		double imaginary = complex.imaginary * complex.imaginary;
		double norm = Math.sqrt(real + imaginary);
		return norm;
	}
	
	public String toString() {
		if(imaginary == 0) return real + "";
		if(real == 0) return imaginary + "i";
		if(imaginary < 0) return real + " - " + (-imaginary) + "i";
		return real + " + " + imaginary + "i";
	}
	
}
