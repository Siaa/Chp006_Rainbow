// Chapter 6 Question 19
//Sia's Rainbow 

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  Color skyColor= Color.CYAN; 

  public Rainbow()
  {
    setBackground(skyColor); //set color to the background. 
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth(); //getting the width of the panel    
    int height = getHeight(); //getting the height of the panel

    int xCenter = (int)(width*0.5); //the center of the x component is half way from the width  
    int yCenter = (int)(height*.75); //the center of the y component is half way from the height 
 
    int largeRadius = (int)((.25)*width); //the radius of the outter ring is a quarter of width of the panel
    g.setColor(Color.RED);// it is red

    g.fillArc(xCenter-largeRadius, yCenter-largeRadius, largeRadius*2, largeRadius*2, 0, 180);
    //the arc is 180 degrees (0 is beginning 180 is end), the height and the width of the rainbow
    //is the diameter of the circle so that it looks even. The rainbow starts large radius from the 
    //center on both the x and y component. 

    int smallRadius = (int)(0.25*height); //the radius of the second inner most ring is 1/4 of the width
    int mediumRadius = (int)(Math.sqrt(smallRadius*largeRadius)); //the radius of the second outer ring is 
    //the geometric mean of second inner most ring and outer most ring.  
    g.setColor(Color.GREEN); //color of the second outer ring is green
    g.fillArc(xCenter-mediumRadius, yCenter-mediumRadius, mediumRadius*2, mediumRadius*2, 0, 180);
    //the arc is 180 degrees (0 is beginning 180 is end), the height and the width of the rainbow
    //is the diameter of the circle so that it looks even. The rainbow starts medium radius from the 
    //center on both the x and y component. 
    g.setColor(Color.MAGENTA); //color to magenta 
    g.fillArc(xCenter-smallRadius, yCenter-smallRadius, smallRadius*2, smallRadius*2, 0, 180);
    //the arc is 180 degrees (0 is beginning 180 is end), the height and the width of the rainbow
    //is the diameter of the circle so that it looks even. The rainbow starts small radius from the 
    //center on both the x and y component. 

    int skycolorRadius = (int) (smallRadius-(Math.pow((mediumRadius-smallRadius),2)/(largeRadius-mediumRadius)));
    //determining the radius of the sky which makes it so that the average of the small and large radius is the medium radius
    g.setColor(Color.CYAN); //set color
    g.fillArc(xCenter-skycolorRadius, yCenter-skycolorRadius, skycolorRadius*2, skycolorRadius*2, 0, 180);
    //the arc is 180 degrees (0 is beginning 180 is end), the height and the width of the rainbow
    //is the diameter of the circle so that it looks even. The rainbow starts sky radius from the 
    //center on both the x and y component. 

  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
