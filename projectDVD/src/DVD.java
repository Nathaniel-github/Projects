/*
 Author: Nathaniel Thomas
 Date: 10/19/19
 Rev: 01
 */
import java.awt.Image;//The Image class is the superclass of all classes that represent graphical Images
import java.awt.Graphics;//The Graphics class is the base class for all graphics contexts that allow an application to draw
//The Image and Graphics classes are being used in this program

public class DVD
{
  private Image picture;//Holds a picture, used to draw a picture on the screen
  private CoordinateSystem coordinates;//Holds coordinates, used to place the image at a certain place
  private int xCord, yCord;
  
  
  // Constructor
  public DVD(int x, int y, Image pic)
  {
    picture = pic;
    coordinates = new CoordinateSystem(x, y, pic);
    xCord = x;
    yCord = y;
  }

  public void moveForward(int distance)
  {
    coordinates.shift(distance, 0);
    xCord += distance;
  }

  public void moveSideways(int distance) 
  {
    coordinates.shift(0, distance);
    yCord += distance;
  }

  public void draw(Graphics g) 
  {
    coordinates.drawImage(g, picture);
  }
  
  public int getxCord() {
	  return xCord;
  }
  
  public int getyCord() {
	  return yCord;
  }
}

