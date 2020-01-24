// This class represents a walker with two feet
import java.awt.Image;
import java.awt.Graphics;
/*
Author: Nathaniel Thomas
Date: 10/20/19
Rev: 01
*/


public class Walker
{
  public static final int PIXELS_PER_INCH = 6;
  private Foot leftFoot, rightFoot;
  private int stepLength;
  private int stepsCount;
  private int otherStepCount;
  //Fields
  
  
  // Constructor
  public Walker(int x, int y, Image leftPic, Image rightPic)
  {
    leftFoot =  new Foot(x, y - PIXELS_PER_INCH * 10, leftPic);
    rightFoot = new Foot(x, y + PIXELS_PER_INCH * 10, rightPic); //Instantiates the objects
    stepLength = PIXELS_PER_INCH * 16; //Sets value of stepLength
  }  

  // Returns the left foot
  public Foot getLeftFoot()
  {
    return leftFoot;
  }

  // Returns the right foot
  public Foot getRightFoot()
  {
    return rightFoot;
  }

  // Makes first step, starting with the left foot
  public void firstStep()
  {
    leftFoot.moveForward(stepLength);
    stepsCount = 1;
  }

  // Makes next step
  public void nextStep()
  {
    if (stepsCount % 2 == 0)  // if stepsCount is even
      leftFoot.moveForward(2 * stepLength);
    else  
      rightFoot.moveForward(2 * stepLength);

    stepsCount++;  // increment by 1
  }

  //Makes walker go back one step
  public void backStep()
  {
    if (otherStepCount % 2 == 0)  // if stepsCount is even
      leftFoot.moveForward(-2 * stepLength);
    else  
      rightFoot.moveForward(-2 * stepLength);

    otherStepCount++;  // increment by 1
  }
  
  public void downStep() // Moves both feet down by 270 pixels
  {
      leftFoot.moveSideways(270);
      rightFoot.moveSideways(270);
  }
  
  // Stops this walker (brings its feet together)
  public void stop()
  {
    if (stepsCount % 2 != 0) {
    	rightFoot.moveForward(2 * stepLength);
    }
    else {
    	leftFoot.moveForward(2 * stepLength);
    }
  }

  // Returns the distance walked
  public int distanceTraveled()
  {
    return stepsCount * stepLength;
  }

  // Draws this walker
  public void draw(Graphics g)
  {
    leftFoot.draw(g);
    rightFoot.draw(g);
  }
}
