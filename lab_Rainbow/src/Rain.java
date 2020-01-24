/*
 Author: Nathaniel Thomas
 Date: 10/19/19
 Rev: 01
 */
import java.awt.Image;
import java.awt.Graphics;

public class Rain
{
  private Image picture;
  private CoordinateSystem coordinates;
  private int xCord, yCord;
  private final int initXCord, initYCord;
  
  

  public Rain(int x, int y, Image pic)
  {
    picture = pic;
    coordinates = new CoordinateSystem(x, y, pic);
    xCord = x;
    yCord = y;
    initYCord = y;
    initXCord = x;
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
  
  public int getInitXCord() {
	  return initXCord;
  }
  
  public int getInitYCord() {
	  return initYCord;
  }
  
  public int getxCord() {
	  return xCord;
  }
  
  public int getyCord() {
	  return yCord;
  }
}

