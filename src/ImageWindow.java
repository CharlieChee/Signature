import java.awt.*;
import java.awt.image.*;
import javax.swing.*;


public class ImageWindow
{


  public static void imageDisplay(BufferedImage image, String str)
  {
    
        JFrame editorFrame = new JFrame(str+" "+image.getWidth()+"x"+image.getHeight());
        editorFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

        ImageIcon imageIcon = new ImageIcon(image);
        JLabel jLabel = new JLabel();
        jLabel.setIcon(imageIcon);
        editorFrame.getContentPane().add(jLabel, BorderLayout.CENTER);

        editorFrame.pack();
        editorFrame.setLocationRelativeTo(null);
        editorFrame.setVisible(true);

  }
}