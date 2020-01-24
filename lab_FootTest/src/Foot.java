// Represents a foot, used for displaying walking creatures.

import java.awt.Image;//The Image class is the superclass of all classes that represent graphical Images
import java.awt.Graphics;//The Graphics class is the base class for all graphics contexts that allow an application to draw
//The Image and Graphics classes are being used in this program

public class Foot
{
  private Image picture;//Holds a picture, used to draw a picture on the screen
  private CoordinateSystem coordinates;//Holds coordinates, used to place the image at a certain place

  // Constructor
  public Foot(int x, int y, Image pic)
  {
    picture = pic;
    coordinates = new CoordinateSystem(x, y, pic);
  }

  // Moves this foot forward by distance pixels
  // (or backward if distance < 0).
  public void moveForward(int distance) //Takes in an integer and returns nothing, this moves the coordinates forward by the parameter
  {
    coordinates.shift(distance, 0);
  }

  // Moves this foot sideways by distance pixels
  // (to the right if distance  > 0 or to the left
  // if distance < 0).
  public void moveSideways(int distance) //Takes in an integer and returns nothing, this moves the coordinates sideways by the parameter
  {
    coordinates.shift(0, distance);
  }

  // Turns this foot (clockwise for degrees > 0).
  public void turn(int degrees) //Takes in an integer and returns nothing, this rotates the coordinates by the parameter in degrees
  {
    coordinates.rotate(Math.PI * degrees / 180.0);
  }

  // Draws this foot in the appropriate coordinate system.
  public void draw(Graphics g) //Takes in a Graphics parameter and returns nothing, this draws the Image at the coordinates
  {
    coordinates.drawImage(g, picture);
  }
}

