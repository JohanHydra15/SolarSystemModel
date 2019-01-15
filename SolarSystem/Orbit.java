/*Orbit
  This was programmed by Johan Sebastiampillai on January 8, 2018.
  This class has methods that allows to display the animation of an orbiting object (planet) given certain attributes.*/


import hsa.Console;
import java.awt.*;

public class Orbit implements Runnable
{
    //decleration of variables
    private int orbitRadius, xOrbit, yOrbit, speed, radius, x, y;
    private double startAngle;
    private boolean drawOrbit;
    static private Console c;
    private Color color;

    //constructor
    public Orbit (int orbitRadius, int xOrbit, int yOrbit, int speed, int radius, double startAngle, Color color, boolean drawOrbit, Console c)
    {
	this.orbitRadius = orbitRadius;
	this.xOrbit = xOrbit;
	this.yOrbit = yOrbit;
	this.speed = speed;
	this.radius = radius;
	this.startAngle = startAngle;
	this.color = color;
	this.drawOrbit = drawOrbit;
	this.c = c;
    }//end of constructor

    public int getXOrbit ()//return the x coordinates of the centre of a planet
    {
	return x;
    }//end of getXOrbit method
    
    public int getYOrbit ()//return the y coordinates of the centre of a planet
    {
	return y;
    }//end of getYOrbit method

    //draw a circle given centre coordinates and radius
    public void drawCircle (double xOrbit, double yOrbit, double radius)
    {
	//decleration of variables
	int xStart, yStart, length;
	//use the coordinates of the centre of the circle to find the coordinates of the top left corner of the rectangle a circle will be draw in for the fillOval method in the console class
	xStart = (int) (xOrbit - radius);
	yStart = (int) (yOrbit - radius);
	length = (int) (radius * 2);
	c.setColor (color); //set color
	c.fillOval (xStart, yStart, length, length); //draw the circle
	delay (20);
	c.setColor (Color.black); //set color
	c.fillOval (xStart, yStart, length, length);//erase drawn circle for animation purposes
    } //end of drawCircle method


    public void rotateCircle (int xOrbit, int yOrbit, int orbitRadius, double rotationAngle, int radius)
    {
	x = (int)(xOrbit + orbitRadius * Math.cos (rotationAngle));
	y = (int)(yOrbit - orbitRadius * Math.sin (rotationAngle));
	drawCircle (xOrbit + orbitRadius * Math.cos (rotationAngle), yOrbit - orbitRadius * Math.sin (rotationAngle), radius);
    } //end of rotateCircle method

    public void run ()
    {
	//decleration of variables
	double rotationAngle = startAngle, deltaAngle;

	deltaAngle = (2 * Math.PI) / (360 - speed); //amount you need to change angle by
	//loop to call the rotateCircle method in order to change the coordinates and draw the circle a new position
	while (true)
	{
	    if (drawOrbit)
	    {
		c.setColor (Color.darkGray);
		c.drawOval (xOrbit - orbitRadius, yOrbit - orbitRadius, orbitRadius * 2, orbitRadius * 2);
	    }//end of if statement
	    rotateCircle (xOrbit, yOrbit, orbitRadius, rotationAngle, radius);
	    rotationAngle += deltaAngle;
	} //end of for loop

    } //end of run method


    public static void delay (int time)  //method to delay to show animation
    {
	try
	{
	    Thread.sleep (time);
	} //end of try
	catch (InterruptedException e)
	{

	} //end if catch
    } //end of delay
} //end of class
