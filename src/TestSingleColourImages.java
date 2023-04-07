import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;
public class TestSingleColourImages {
	
	static int ENCRYPTION_KEY = 1234;
	
	
	public static void TestImageAllBlack() {
		
		System.out.println("\nMaking an all black image and signing with key "+ ENCRYPTION_KEY);
		
		BufferedImage image = SingleColourImageMaker.makeImageAllBlack(400, 600);
		ImageWindow.imageDisplay(image, "AllBlack");
		
		ImagesToFromFiles.writeImageToFile(image, "AllBlack");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		
		ImageWindow.imageDisplay(image, "AllBlack-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllBlack-Signed");
		
		System.out.println("Checking for signature of black image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of black image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
	};
	
	public static void TestImageAllWhite() {
		
		System.out.println("\nMaking an all white image and signing with key "+ ENCRYPTION_KEY);
		
		
		BufferedImage image = SingleColourImageMaker.makeImageAllWhite(600, 400);
		ImageWindow.imageDisplay(image, "AllWhite");
		ImagesToFromFiles.writeImageToFile(image, "AllWhite");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		ImageWindow.imageDisplay(image, "AllWhite-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllWhite-Signed");
		
		System.out.println("Checking for signature of white image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of white image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
	};
	
	public static void TestImageAllBlue() {
		
		System.out.println("\nMaking an all blue image and signing with key "+ ENCRYPTION_KEY);
		
		
		BufferedImage image = SingleColourImageMaker.makeImageAllBlue(300, 300);
		ImageWindow.imageDisplay(image, "All Blue");
		ImagesToFromFiles.writeImageToFile(image, "AllBlue");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		ImageWindow.imageDisplay(image, "AllBlue-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllBlue-Signed");
		
		System.out.println("Checking for signature of blue image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of blue image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
	};
	
	
	public static void TestImageAllYellow() {
		
		System.out.println("\nMaking an all yellow image and signing with key "+ ENCRYPTION_KEY);
		
		
		BufferedImage image = SingleColourImageMaker.makeImageAllYellow(100, 200);
		ImageWindow.imageDisplay(image, "All Yellow");
		ImagesToFromFiles.writeImageToFile(image, "AllYellow");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		ImageWindow.imageDisplay(image, "AllYellow-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllYellow-Signed");
		
		System.out.println("Checking for signature of yellow image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of yellow image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
	};
	
	public static void TestImageAllRed() {
		
		System.out.println("\nMaking an all red image and signing with key "+ ENCRYPTION_KEY);
		
		
		BufferedImage image = SingleColourImageMaker.makeImageAllRed(50, 1000);
		ImageWindow.imageDisplay(image, "All Red");
		ImagesToFromFiles.writeImageToFile(image, "AllRed");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		ImageWindow.imageDisplay(image, "AllRed-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllRed-Signed");
		
		System.out.println("Checking for signature of red image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of red image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
	};
	
	public static void TestImageAllGreen() {
		
		System.out.println("\nMaking an all green image and signing with key "+ ENCRYPTION_KEY);
		
		
		BufferedImage image = SingleColourImageMaker.makeImageAllGreen(1000, 50);
		ImageWindow.imageDisplay(image, "All Green");
		ImagesToFromFiles.writeImageToFile(image, "AllGreen");
		
		SignAndVerifyImageSignature.signImage(ENCRYPTION_KEY, image);
		ImageWindow.imageDisplay(image, "AllGreen-Signed");
		ImagesToFromFiles.writeImageToFile(image, "AllGreen-Signed");
		
		System.out.println("Checking for signature of green image using correct key  "+ ENCRYPTION_KEY);
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
		
		System.out.println("Checking for signature of green image using incorrect key  "+ (ENCRYPTION_KEY+1));
		if (SignAndVerifyImageSignature.checkSignImage(ENCRYPTION_KEY+1, image))
			System.out.println("Correct signature");
		else System.out.println("Incorrect signature");
	};
	
	public static List<List<List<Integer>>> getCoordinatesList(int x, int y, int z) {
	    List<Integer> coordinate = new ArrayList<>();
	    coordinate.add(x);
	    coordinate.add(y);
	    coordinate.add(z);
	    
	    List<List<Integer>> coordinates2DList = new ArrayList<>();
	    coordinates2DList.add(coordinate);
	    
	    List<List<List<Integer>>> coordinates3DList = new ArrayList<>();
	    coordinates3DList.add(coordinates2DList);
	    
	    // add more coordinates as needed
	    
	    return coordinates3DList;
	}
	
	public static void main(String args[]) throws IOException{
		
//		TestImageAllBlack();
//		TestImageAllWhite();
//		TestImageAllBlue();
//		TestImageAllYellow();
//		TestImageAllRed();
//		TestImageAllGreen();
//		Color black = new Color(0, 0, 0);
//		int black_rgb = black.getRGB();
//		Color white = new Color(255, 255, 255);
//		int white_rgb = white.getRGB();
//		System.out.println(white_rgb);
//		Random randomNumberGenerator = new Random();
//		int encryptionKey = 4;
//		int pixelSeqLength = 11;
//		randomNumberGenerator.setSeed(encryptionKey);
//		for(int i=0;i<20;i++) {
//			System.out.println(randomNumberGenerator.nextInt(pixelSeqLength));
//		}
		int k = 999999999;
		
		return;
	}

}
