
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SignAndVerifyImageSignature {
	
	    public static Random randomNumberGenerator = new Random();


	    public static void signImage(int encryptionKey, BufferedImage img ){
	    	
	    	int numberOfImagePixels = img.getWidth()*img.getHeight();
	    	int numberOfPixelsToSign = (int)( Math.sqrt(Math.sqrt(numberOfImagePixels)));
	    	signImage( encryptionKey,  numberOfPixelsToSign,  img );
	    }
	      

	    public static void signImage(int encryptionKey, int numberOfPixelsToSign, BufferedImage img ) {
	    	

		  int pixelsSignedCounter =0;


	    	int width = img.getWidth();
	    	int height = img.getHeight();
	    	
	    	int numberOfImagePixels = width*height;
	    	
	    	int pixelSeqLength = numberOfImagePixels/numberOfPixelsToSign;
	    	
	    	int pixelValueToLeft;
	    	
	    	randomNumberGenerator.setSeed(encryptionKey);
	    	int x;
	    	int y;
	    	
	    	int pixelEnumeration; 
	    	
	    	for (int pixelCount=0; pixelCount<numberOfPixelsToSign; pixelCount++) {
	    		
	    		pixelEnumeration = pixelCount*pixelSeqLength;
	    		pixelEnumeration = pixelEnumeration + randomNumberGenerator.nextInt(pixelSeqLength);

	    	    x = pixelEnumeration%width;
	    	    if (x==0) x=1; 
	    	    y = pixelEnumeration/width;

	    		pixelValueToLeft =	img.getRGB(x-1, y);
	    		
	    		
	    		if (pixelValueToLeft==Colours.black_rgb)
	    		{img.setRGB(x,y, pixelValueToLeft+1);pixelsSignedCounter++;}
	    		
	    		else   {img.setRGB(x,y, pixelValueToLeft-1);pixelsSignedCounter++;}
	    		
	    	}
	    	System.out.println("Signed "+pixelsSignedCounter+" pixels" );
	    }

	    public static boolean checkSignImage(int encryptionKey, BufferedImage img ){

	    	int numberOfImagePixels = img.getWidth()*img.getHeight();
	    	int numberOfPixelsToSign = (int) (Math.sqrt(Math.sqrt(numberOfImagePixels)));
	    	return checkSignImage( encryptionKey,  numberOfPixelsToSign,  img );
	    }
	  

	  public static boolean checkSignImage(int encryptionKey, int numberOfPixelsToSign, BufferedImage img ) {  
		  

		    int width = img.getWidth();
	    	int height = img.getHeight();
	    	
	    	int numberOfImagePixels = width*height;
	    	
	    	int pixelSeqLength = numberOfImagePixels/numberOfPixelsToSign;
	    	
	    	int pixelValueToLeft;
	    	int pixelValue;
	    	
	    	randomNumberGenerator.setSeed(encryptionKey);
	    	int x;
	    	int y;
	    	
	    	int pixelEnumeration; // left to right and top to bottom
	    	
	    	for (int pixelCount=0; pixelCount<numberOfPixelsToSign; pixelCount++) {
	    		
	    		pixelEnumeration = pixelCount*pixelSeqLength;
	    		pixelEnumeration = pixelEnumeration + randomNumberGenerator.nextInt(pixelSeqLength);
	    		
	    	    x = pixelEnumeration%width;
	    	     if (x==0) x=1;
	    	    y = pixelEnumeration/width;
	    		
	    	    pixelValueToLeft =	img.getRGB(x-1, y);
	    		pixelValue =	img.getRGB(x, y);
	    		
	    		
	    		if (pixelValueToLeft==Colours.black_rgb) {
	    			if (pixelValueToLeft != pixelValue-1) {
	    			   System.out.println("Problem pixel at ("+x+", "+y+")");
                       return false;}
	    		}
	    	 else if (pixelValueToLeft != pixelValue+1){
  			   System.out.println("Problem pixel at ("+x+", "+y+")");
               return false;}
	    	}
	    	
	    	return true;
	  }
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
	  
	  
	  public static int get_sequence(BufferedImage img) {
		  int width = img.getWidth();
	    	int height = img.getHeight();
	    	int numberOfImagePixels = width*height;
	    	int numberOfPixelsToSign = (int) (Math.sqrt(Math.sqrt(numberOfImagePixels)));
	    	return numberOfImagePixels/numberOfPixelsToSign;
	  }
	  
	  public static List<List<List<Integer>>>check_encrypted(BufferedImage img) {
		  List<List<List<Integer>>> coordinatesList = getCoordinatesList(0, 0, 0);
		  
		  	int width = img.getWidth();
	    	int height = img.getHeight();
	    	int numberOfImagePixels = width*height;
	      int numberOfPixelsToSign = (int) (Math.sqrt(Math.sqrt(numberOfImagePixels)));
		  
	      
		    
	    	
	    	int pixelSeqLength = numberOfImagePixels/numberOfPixelsToSign;
	    	
	    	int pixelValueToLeft;
	    	int pixelValue;
	    	
	    	int x;
	    	int y;
	    	int pixelEnumeration;
	    	int j=0;
	    	for (int pixelCount=0; pixelCount<numberOfPixelsToSign; pixelCount++) {
	    		
	    		int visited = 0;
	    		for(int i=1;i<pixelSeqLength;i++) {
	    			
	    			pixelEnumeration = pixelCount*pixelSeqLength+i;
	    			x = pixelEnumeration%width;
		    	     if (x==0) continue;
	    			y = pixelEnumeration/width;
	    			pixelValueToLeft =	img.getRGB(x-1, y);
		    		pixelValue =	img.getRGB(x, y);
		    		
		    		if (pixelValueToLeft==Colours.black_rgb) {
		    			if (pixelValueToLeft == pixelValue-1) {
		    			  // System.out.println("Problem pixel at ("+x+", "+y+","+pixelCount+")");
		    			   coordinatesList.addAll(getCoordinatesList(i,j++,pixelCount));
		    			   
		    			   visited =1;}
		    		}
		    		else if (pixelValueToLeft == pixelValue+1){
		   			   	//	System.out.println("Problem pixel at ("+x+", "+y+","+pixelCount+")");
		   			   		coordinatesList.addAll(getCoordinatesList(i,j++,pixelCount));
		   			   		visited =1;
		   			   	//System.out.println("("+visited+")");
		    		}
		    		if(i == pixelSeqLength-1 && visited == 0) {
		    			coordinatesList.addAll(getCoordinatesList(-1,-1,-1));
		    			return coordinatesList;
		    		}
		 	    	}
	    			    		
	    		}
	    	    	
		  coordinatesList.remove(0);
		return coordinatesList;
		  
	  }
	  
	  public static ArrayList<Integer> genarate_sequence(int key, int number, int sequence) {
		  Random randomNumberGenerator = new Random();
			int encryptionKey = key;
			int pixelSeqLength = sequence;
			ArrayList<Integer> list = new ArrayList<>(number);
			randomNumberGenerator.setSeed(encryptionKey);
			for(int i=0;i<number;i++) {
				list.add(randomNumberGenerator.nextInt(pixelSeqLength));
			}
			return list;
	  }

	  
	  public static boolean judge(ArrayList<Integer> arr,List<List<List<Integer>>> pixel) {
		 // System.out.println(pixel.size());
		  int start = 0,end = 0;
		  
		  for(int i = 0; i< arr.size();i++) {
			  for(int s = 0;s<pixel.size();s++) {
				  if(pixel.get(s).get(0).get(2)==i) {
					  start = pixel.get(s).get(0).get(1);
					  break;
				  }
			  }
			 // System.out.println("start:"+start);
			  for(int e = start;e<pixel.size();e++) {
				  if(e == pixel.size()-1) {
					  end = pixel.size() -1;
					  break;
				  }
				  if(pixel.get(e).get(0).get(2)>i) {
					  end = pixel.get(e-1).get(0).get(1);
					  break;
				  }
			  }
			 // System.out.println("end:"+end);
			  for(int j = start; j< end+1;j++) {
				  int s1 = arr.get(i);
				  int s2 = pixel.get(j).get(0).get(0);
				  if(s1 == s2) {
					  //System.out.println(arr.get(i)+","+pixel.get(j).get(0)+"start:"+start+"  end:"+end);
					  break;
				  
				  }
				  else if (j == end) {
					 // System.out.println(j+"  "+ pixel.get(j+1).get(0));
					  return false;
				  }
			  }
			  start = end;
		  }
	
		  return true;
	  }
	  
	  

	  public static void main(String args[])throws IOException{
		  
		  String[] photo = {"AllBlack","AllBlue",
				  "AllGreen","AllRed",
				  "AllWhite","AllYellow",
				 "Apple-colour",
				  "ArsenalBY","banana",
				  "barcelona","BKGRND",
				  "HeadPhotoPaul","pinky-image",
				  "RandomImageNoise"
		  };
		  
		  List<String> arr = new ArrayList<String>();
		  
		  List<List<List<Integer>>>[] list = new List[photo.length];
		  for(int i=0; i<photo.length; i++) {
		      list[i] = check_encrypted(ImagesToFromFiles.getImage(photo[i]));
		      if(list[i].get(list[i].size()-1).get(0).get(0) != -1) {
		    	  int pixel_signed = list[i].get(list[i].size() - 1).get(0).get(2)+1;
		    	  int sequence = get_sequence(ImagesToFromFiles.getImage(photo[i]));
		    	  
		    	  for(int key=1;key<1000000;key++) {
					  ArrayList <Integer> key_arr = genarate_sequence(key, pixel_signed,sequence);
					  boolean s = judge(key_arr, list[i]);
					  if(s)
					  {
						  System.out.println(key);
						  System.out.println(photo[i]);
					  }
					  
				  }
		    	  
		      }
		  }
		  
		  System.out.println("done");
		 
	    
	  }
	  
	}
