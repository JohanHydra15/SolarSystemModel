/*Sun
  This was programmed by Johan Sebastiampillai on January 8, 2018.
  This class containes a method to draw the background, stars, and the sun.*/


import java.awt.*;
import hsa.Console;

public class Sun
{
    //decleration of variables
    private int x, y, radius;
    static private Console c;

    //constructor
    public Sun (int x, int y, int radius, Console c)
    {
	this.x = x;
	this.y = y;
	this.radius = radius;
	this.c = c;
    }//end of constructor


    public void drawSun ()
    {
	int j, k, l, a = c.maxx () / 2, e = c.maxy () / 2, f = 1, di = 5;

	//background
	c.fillRect (0, 0, x * 2, y * 2);

	//stars
	for (int i = 0 ; i < 10000 ; i++)
	{
	    j = (int) (255 * Math.random ());
	    k = (int) (255 * Math.random ());
	    l = (int) (255 * Math.random ());

	    Color myColor = new Color (255, 255, 255);
	    c.setColor (myColor);

	    x = (int) (10001 * Math.random ());
	    y = (int) (10001 * Math.random ());

	    c.fillOval (x, y, 2, 2);
	}//end of for loop

	//sun
	for (int p = 0 ; p < 2 ; p++)
	{
	    for (int i = 247 ; i > 0 ; i -= di)
	    {
		Color myColor2 = new Color (i, 0, 0);
		c.setColor (myColor2);

		a--;
		e--;
		f += 2;

		c.drawOval (a, e, f, f);

	    }//end of inner for loop
	    di = 6;
	}//end of outer for loop
    }//end of drawSun method
}//end of class
