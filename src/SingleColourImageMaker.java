
import java.awt.image.BufferedImage;


public class SingleColourImageMaker {
	
	
	public static BufferedImage makeImageSingleColor(int colorRGB, int width, int height) {
		
		BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_ARGB);
		
		for (int x=0; x<width; x++)
			for (int y=0; y<height; y++)
		       image.setRGB(x,y,colorRGB);
		
		return image;
	}
	
	public static void makeImageSingleColor(int colorRGB, BufferedImage image) {
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		for (int x=0; x<width; x++)
			for (int y=0; y<height; y++)
		       image.setRGB(x,y,colorRGB);
		return;
	}
		
	public static BufferedImage makeImageAllBlack(int width, int height) {
			
		return makeImageSingleColor(Colours.black_rgb, width, height);
	}
	
	public static void makeImageAllBlack(BufferedImage image) {
		
		makeImageSingleColor(Colours.black_rgb,image);
		
		
	}
	

	
	public static BufferedImage makeImageAllWhite(int width, int height) {
		
		return makeImageSingleColor(Colours.white_rgb, width, height);
	}
	
	public static void makeImageAllWhite(BufferedImage image) {
		
		makeImageSingleColor(Colours.white_rgb,image);
		
		
	}
	
	public static void makeImageAllBlue(BufferedImage image) {
		
		makeImageSingleColor(Colours.blue_rgb,image);
		
		
	}
	
	
	public static BufferedImage makeImageAllBlue(int width, int height) {
		
		return makeImageSingleColor(Colours.blue_rgb, width, height);
	}
	
	public static BufferedImage makeImageAllYellow(int width, int height) {
		
		return makeImageSingleColor(Colours.yellow_rgb, width, height);
	}
		
	
	public static BufferedImage makeImageAllRed(int width, int height) {
		
		return makeImageSingleColor(Colours.red_rgb, width, height);
	}
	
	public static BufferedImage makeImageAllGreen(int width, int height) {
		
		return makeImageSingleColor(Colours.green_rgb, width, height);
	}

}
