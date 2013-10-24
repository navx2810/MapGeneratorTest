package net.matt.mapdrawer;

public class Point {
	public int xPos, yPos;

	public Point(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	/** Will check if a point equals another point
	 * @param point - the point to be checked
	 * @return - True : If the point's x value and y value equals x value and y value | False : If the point's x value and y value do not equal the x value and y value
	 */
	public boolean equals(Point point){
		if (point.xPos == xPos && point.yPos == yPos)
			return true;
		else
			return false;
	}
	
	
}
