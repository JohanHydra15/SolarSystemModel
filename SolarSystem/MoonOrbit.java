/*Moon Orbit
  This was programmed by Johan Sebastiampillai on January 8, 2018.
  This class has methods that allows to display the animation of an orbiting object (moon) given certain attributes.*/

import hsa.Console;
import java.awt.*;

public class MoonOrbit extends Orbit implements Runnable
{
    //decleration of variables
    private int orbitRadius, xOrbit, yOrbit, radius;
    private double startAngle;
    private boolean drawOrbit;
    static private Console c;
    private Orbit planet;
    private Color color;

    //constructor
    public MoonOrbit (int orbitRadius, int radius, double startAngle, Color color, boolean drawOrbit, Console c, Orbit planet)
    {
	super (orbitRadius, 0, 0, 0, radius, startAngle, color, drawOrbit, c);
	this.orbitRadius = orbitRadius;
	this.radius = radius;
	this.startAngle = startAngle;
	this.color = color;
	this.drawOrbit = drawOrbit;
	this.planet = planet;
	this.c = c;
    } //end of constructor


    public void run ()
    {
	//decleration of variables
	double rotationAngle = startAngle, deltaAngle;

	deltaAngle = (2 * Math.PI) / 200; //amount you need to change angle by
	//loop to call the rotateCircle method in order to change the coordinates and draw the circle a new position
	while (true)
	{
	    if (drawOrbit)
	    {
		c.setColor (Color.darkGray);
		c.drawOval (xOrbit - orbitRadius, yOrbit - orbitRadius, orbitRadius * 2, orbitRadius * 2);
	    } //end of if statement
	    super.rotateCircle (xOrbit, yOrbit, orbitRadius, rotationAngle, radius);
	    if (drawOrbit)
	    {
		c.setColor (Color.black);
		c.drawOval (xOrbit - orbitRadius, yOrbit - orbitRadius, orbitRadius * 2, orbitRadius * 2);
	    } //end of if statement
	    xOrbit = planet.getXOrbit ();
	    yOrbit = planet.getYOrbit ();
	    rotationAngle += deltaAngle;
	} //end of for loop

    } //end of run method
} //end of class
