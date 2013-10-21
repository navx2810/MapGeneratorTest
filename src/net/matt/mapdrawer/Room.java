package net.matt.mapdrawer;

import java.util.ArrayList;

public class Room {
	Point startPoint, endPoint;
	ArrayList<Point> points;
	String name;
	
	public Room(Point startPoint, Point endPoint, String name) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.name = name;
		points = new ArrayList<Point>();
	}
	
	public void addPoint(Point point){
		points.add(point);
	}
	
	public ArrayList<Point> getPoints() {
		return points;
	}
}

