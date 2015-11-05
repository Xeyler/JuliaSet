package me.xeyler;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JuliaMain {
	
	public static void main(String[] args) throws IOException {

		// Custom Complex variable type
		//    the two doubles determine what the picture looks like
		Complex complex = new Complex(0, 0);
		
		// Image that will be rendered
		BufferedImage juliaPic = createJulia(complex);
		
		// Add the image to the JPanel
		ImageIO.write(juliaPic, "PNG", new File("C:/Users/Xeyler/Desktop/Mandelbrot.png"));
		
	}

	private static BufferedImage createJulia(Complex coords) throws IOException {
		
		// f(x)=x^2+Coords
		// x = complex
		
		int w = 1000;
		int h = 1000;
		int maxIterations = 255;

    	double bailout = 2;
		
		BufferedImage image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		WritableRaster raster = image.getRaster();
		
		for(double x = 0; x < w; x++) {
		    for(double y = 0; y < h; y++) {
		    	Complex Z = coords;
		    	for(int iteration = 0; iteration <= maxIterations; iteration++) {
		    		Complex C = new Complex((x - w/2)/(w/4), (y - h/2)/(h/4));
		    		double ZReal = Z.real()*Z.real() - Z.imaginary()*Z.imaginary();
		    		double ZImaginary = 2 * Z.real() * Z.imaginary();
		    		Z = new Complex(ZReal, ZImaginary).add(C);
		    		// First pass
		    		if(Z.norm() > bailout) {
		    			raster.setPixel((int) x, (int) y,
		    					new int[]{Math.min(iteration*iteration*iteration, 255), Math.max(iteration, iteration*iteration - 255), iteration});
		    			break;
		    		} else if(iteration == maxIterations) {
		    			raster.setPixel((int) x, (int) y, new int[]{0, 0, 0});
		    		}
		    	}
		    }
		    System.out.print("Done: ");
		    for(double i = 1; i <= 10; i++) {
		    	if(i/10 <= x/w) {
		    		System.out.print("-");
		    	} else {
		    		System.out.print("*");
		    	}
		    }
		    System.out.println(" " + Math.floor(x/w*100) + "%");
		}

		System.out.println("Done!");
		return image;
	}

}
