/*Solar System CPT
  This was programmed by Johan Sebastiampillai on January 8, 2018.
  This program displays a 2D model of the solar system.*/


import hsa.Console;
import java.awt.*;
import javax.swing.JOptionPane;

public class SolarSystemCPT
{
    public static void main (String[] args)
    {
	Console d = new Console (39, 176);

	//decleration of variables
	int counterMoon = 0, counterAstroids = 0, input;
	boolean showOrbit;

	//create arrays of planet, moon, asteroid, and thread objects
	Orbit[] c = new Orbit [9];
	Orbit[] astroids = new Orbit [20];
	MoonOrbit[] m = new MoonOrbit [13];
	Thread[] t = new Thread [42];
	
	//declare colors
	Color venus = new Color (255, 226, 30);
	Color darkRedBrown = new Color (153, 0, 0);
	Color lightRedBrown = new Color (206, 165, 165);
	Color gray = new Color (153, 153, 153);
	Color orangeBrown = new Color (199, 166, 123);
	Color greenBrown = new Color (182, 199, 112);
	Color orange = new Color (205, 127, 50);
	Color paleBlue = new Color (70, 130, 180);
	Color paleGold = new Color (238, 232, 170);
	Color lightBlue = new Color (3, 104, 255);
	Color purpleBlue = new Color (43, 64, 245);
	Color skyBlue = new Color (0, 204, 204);
	Color brown = new Color (139, 69, 19);

	//check if user wants to display orbits or not
	input = JOptionPane.showConfirmDialog (null, "Do you want to show the orbits of the planets and moons?", "Show Orbits?", JOptionPane.YES_NO_OPTION);
	if (input == 0)
	    showOrbit = true;
	else
	    showOrbit = false;


	//call method to draw black background, stars, and sun
	Sun s = new Sun (d.maxx () / 2, d.maxy () / 2, 50, d);
	s.drawSun ();

	//call constructors for planets to create objects
	c [0] = new Orbit (100, d.maxx () / 2, d.maxy () / 2, 280, 5, 0, Color.lightGray, showOrbit, d); //mercury
	c [1] = new Orbit (115, d.maxx () / 2, d.maxy () / 2, 190, 6, 0, venus, showOrbit, d); //venus
	c [2] = new Orbit (140, d.maxx () / 2, d.maxy () / 2, 40, 7, 0, Color.blue, showOrbit, d); //earth
	c [3] = new Orbit (170, d.maxx () / 2, d.maxy () / 2, -200, 5, 0, darkRedBrown, showOrbit, d); //mars
	c [4] = new Orbit (232, d.maxx () / 2, d.maxy () / 2, -1000, 15, 0, orangeBrown, showOrbit, d); //jupiter
	c [5] = new Orbit (290, d.maxx () / 2, d.maxy () / 2, -1500, 10, 0, paleGold, showOrbit, d); //saturn
	c [6] = new Orbit (332, d.maxx () / 2, d.maxy () / 2, -2000, 5, 0, lightBlue, showOrbit, d); //uranus
	c [7] = new Orbit (365, d.maxx () / 2, d.maxy () / 2, -2500, 7, 0, purpleBlue, showOrbit, d); //nepture
	c [8] = new Orbit (385, d.maxx () / 2, d.maxy () / 2, -3000, 2, 0, skyBlue, showOrbit, d); //pluto

	//call constructors for astroids to create objects
	astroids [0] = new Orbit (190, d.maxx () / 2, d.maxy () / 2, -500, 2, 0, Color.lightGray, false, d);
	astroids [1] = new Orbit (195, d.maxx () / 2, d.maxy () / 2, -500, 3, 0.2, Color.darkGray, false, d);
	astroids [2] = new Orbit (200, d.maxx () / 2, d.maxy () / 2, -500, 2, 1.9, brown, false, d);
	astroids [3] = new Orbit (201, d.maxx () / 2, d.maxy () / 2, -500, 1, 2.5, Color.lightGray, false, d);
	astroids [4] = new Orbit (196, d.maxx () / 2, d.maxy () / 2, -500, 3, 3.3, Color.darkGray, false, d);
	astroids [5] = new Orbit (194, d.maxx () / 2, d.maxy () / 2, -500, 2, 3.5, Color.gray, false, d);
	astroids [6] = new Orbit (200, d.maxx () / 2, d.maxy () / 2, -500, 2, 4.1, brown, false, d);
	astroids [7] = new Orbit (192, d.maxx () / 2, d.maxy () / 2, -500, 3, 4.5, Color.lightGray, false, d);
	astroids [8] = new Orbit (196, d.maxx () / 2, d.maxy () / 2, -500, 2, 4.6, brown, false, d);
	astroids [9] = new Orbit (200, d.maxx () / 2, d.maxy () / 2, -500, 1, 4.8, Color.lightGray, false, d);
	astroids [10] = new Orbit (190, d.maxx () / 2, d.maxy () / 2, -500, 2, 5.1, Color.darkGray, false, d);
	astroids [11] = new Orbit (193, d.maxx () / 2, d.maxy () / 2, -500, 2, 5.6, Color.gray, false, d);
	astroids [12] = new Orbit (201, d.maxx () / 2, d.maxy () / 2, -500, 2, 5.8, Color.lightGray, false, d);
	astroids [13] = new Orbit (200, d.maxx () / 2, d.maxy () / 2, -500, 3, 5.9, brown, false, d);
	astroids [14] = new Orbit (198, d.maxx () / 2, d.maxy () / 2, -500, 2, 6.2, Color.lightGray, false, d);
	astroids [15] = new Orbit (199, d.maxx () / 2, d.maxy () / 2, -500, 1, 0.5, Color.lightGray, false, d);
	astroids [16] = new Orbit (192, d.maxx () / 2, d.maxy () / 2, -500, 2, 0.7, Color.lightGray, false, d);
	astroids [17] = new Orbit (196, d.maxx () / 2, d.maxy () / 2, -500, 2, 1.1, brown, false, d);
	astroids [18] = new Orbit (200, d.maxx () / 2, d.maxy () / 2, -500, 3, 1.6, Color.darkGray, false, d);
	astroids [19] = new Orbit (201, d.maxx () / 2, d.maxy () / 2, -500, 2, 2.8, Color.lightGray, false, d);


	//call constructors for moons to create objects
	m [0] = new MoonOrbit (11, 2, 0, Color.lightGray, showOrbit, d, c [2]); //earth's moon

	m [1] = new MoonOrbit (12, 2, 0, lightRedBrown, showOrbit, d, c [3]); //mars' moons
	m [2] = new MoonOrbit (9, 2, 3, gray, showOrbit, d, c [3]);

	m [3] = new MoonOrbit (31, 4, 0, greenBrown, showOrbit, d, c [4]); //jupiter's moons
	m [4] = new MoonOrbit (28, 3, 2, paleBlue, showOrbit, d, c [4]);
	m [5] = new MoonOrbit (24, 3, 3, orange, showOrbit, d, c [4]);
	m [6] = new MoonOrbit (21, 2, 5, lightRedBrown, showOrbit, d, c [4]);


	m [7] = new MoonOrbit (23, 4, 0, Color.lightGray, showOrbit, d, c [5]); //saturn's moons
	m [8] = new MoonOrbit (20, 3, 2, lightRedBrown, showOrbit, d, c [5]);
	m [9] = new MoonOrbit (16, 2, 4, gray, showOrbit, d, c [5]);


	m [10] = new MoonOrbit (16, 3, 0, Color.lightGray, showOrbit, d, c [6]); //uranus' moons
	m [11] = new MoonOrbit (11, 2, 3, Color.darkGray, showOrbit, d, c [6]);

	m [12] = new MoonOrbit (13, 2, 0, greenBrown, showOrbit, d, c [7]); //neptune's moon


	//create thread objects and start the threads
	for (int i = 0 ; i < 42 ; i++)
	{
	    if (i < 9)
	    {
		t [i] = new Thread (c [i]);
	    }//end of if statement
	    else if (i < 22)
	    {
		t [i] = new Thread (m [counterMoon]);
		counterMoon++;
	    }//end of else if statement
	    else
	    {
		t [i] = new Thread (astroids [counterAstroids]);
		counterAstroids++;
	    }//end of else statement
	    t [i].start ();
	}//end of for loop
    }//end of main method
}//end of class
