package net.matt.mapdrawer;

import java.util.ArrayList;

public class Room {
	Point startPoint, endPoint;
	ArrayList<Point> points;
	String name;
	
	/** Full Constructor 
	 * @param startPoint - the starting point of the room
	 * @param endPoint - the ending point of the room
	 * @param name - the name of the room
	 */
	public Room(Point startPoint, Point endPoint, String name) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.name = name;
		points = new ArrayList<Point>();
	}
	
	/** Map Constructor | This is used to build a rooms list for the Map class
	 * 
	 */
	public Room(){
		points = new ArrayList<Point>();
	}
	
	/** Will add a point to the room.
	 * @param point - the point to add to the room
	 */
	public void addPoint(Point point){
		points.add(point);
	}
	
	public void addPoint(Room room){
		points.addAll(room.getPoints());
	}
	
	/** Will return the ArrayList of points for this room
	 * @return - the ArrayList of points inside this room
	 */
	public ArrayList<Point> getPoints() {
		return points;
	}
	
	/** Will compare two points to see if they are equal to each other
	 * @param room - the room to compare
	 * @return - True : if the point exists inside this room | False : if this point does not exist inside this room
	 */
	public boolean hasPoint(Room room){
		for (Point point : room.points) 
			for (Point point2 : points) {
				if(point.equals(point2))
					return true;
			}
		return false;
		}

	
}
	
	


