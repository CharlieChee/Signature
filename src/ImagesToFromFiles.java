import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import javax.imageio.ImageIO;

public class ImagesToFromFiles {
	
	public static String FILE_SEPARATOR = File.separator;
	
	public static String DEFAULT_IMAGES_FOLDER_PATH = "Images";
	public static String DEFAULT_IMAGES_TYPE = "png";
	
	public static String ImagesFolderPath = DEFAULT_IMAGES_FOLDER_PATH;
	public static String ImagesType = DEFAULT_IMAGES_TYPE;
	

  public static void setImagesFolderPath() throws IllegalArgumentException{
    
   setImagesFolderPath(DEFAULT_IMAGES_FOLDER_PATH);
}
	
	public static void setImagesFolderPath(String path) throws IllegalArgumentException{
		
		File f = new File(path);
		if (!f.isDirectory()) throw new IllegalArgumentException("Not a valid directory path");
		 else ImagesFolderPath = path;
}
	
	public static BufferedImage getImage(String filename) 
    		throws IllegalArgumentException {
		
		return getImage(filename, ImagesFolderPath);
		}
	
    public static BufferedImage getImage(String filename, String path) 
    		throws IllegalArgumentException {

      try {setImagesFolderPath(path);} 
       catch(IllegalArgumentException e){
             setImagesFolderPath(".."+FILE_SEPARATOR+ImagesFolderPath);

       }
       
      BufferedImage img = null;
      File f = null;

        f = new File(ImagesFolderPath+FILE_SEPARATOR+filename+"."+DEFAULT_IMAGES_TYPE);
        if(!f.isDirectory()){
           try{ img = ImageIO.read(f);
               
	            }
            catch(IOException e1){}
          }
        else {
          f = new File(".."+FILE_SEPARATOR+ImagesFolderPath+FILE_SEPARATOR+filename+"."+DEFAULT_IMAGES_TYPE);
          if(!f.isDirectory()){
            try { img = ImageIO.read(f);
              
	    	        }  
	    	    catch(IOException e2){}
          }
	       };

	    if (img == null) throw new IllegalArgumentException("Could not locate the specified image file: "+filename+"."+ImagesType);
	    else  return img;
	    
      }

      public static void writeImageToFile(BufferedImage img, String filename){

        writeImageToFile( img,  filename, ImagesFolderPath);
      }
    
	
public static void writeImageToFile(BufferedImage img, String filename, String path) {


        try {setImagesFolderPath(path);} 
       catch(IllegalArgumentException e){
             setImagesFolderPath(".."+FILE_SEPARATOR+ImagesFolderPath);
        
       }

		
        File f = null;

        f = new File(ImagesFolderPath +FILE_SEPARATOR+filename+"."+DEFAULT_IMAGES_TYPE);
        
       

        if(!f.isDirectory()){
        f.setWritable(true);
        
	      try{ 
	           ImageIO.write(img, ImagesType, f);
      
	       }
	     catch(IOException e1){}
	      catch(Exception e2){}
     }
     else {

   f = new File(".."+FILE_SEPARATOR+ImagesFolderPath +FILE_SEPARATOR+filename+"."+DEFAULT_IMAGES_TYPE);

   if(f.exists() && !f.isDirectory()){

       f.setWritable(true);
	   	
	      try{
              ImageIO.write(img, DEFAULT_IMAGES_TYPE, f);
             
               } 
         catch(Exception e2) {}
	  } 
    }    
	}


    
    /**
     * Compares two images pixel by pixel.
     *
     * @param imgA the first image.
     * @param imgB the second image.
     * @return -1 if images different size, otherwise number of different pixels
     */
    public static int compareImagesCountDifferentPixels(BufferedImage imgA, BufferedImage imgB) {
      // The images must be the same size.
      if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
        return -1;
      }

      int width  = imgA.getWidth();
      int height = imgA.getHeight();
      int count =0;

      // Loop over every pixel.
      for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
          // Compare the pixels for equality.
          if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) count++;
        }
      }

      return count;
    }
    
    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

}
