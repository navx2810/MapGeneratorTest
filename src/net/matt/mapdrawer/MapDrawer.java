package net.matt.mapdrawer;

import java.util.ArrayList;
import java.util.Random;

import net.matt.entity.Map;

public class MapDrawer {
	public Map map;
	
	Point lastPos, currentPos, roomStartPos, roomEndPos;
	ArrayList<Room> rooms = new ArrayList<Room>();
	ArrayList<Point> specialPoints = new ArrayList<Point>();
	Random random = new Random();
	
	public MapDrawer(Map map) {
		super();
		this.map = map;
		rooms = new ArrayList<Room>();
		specialPoints = new ArrayList<Point>();
	}
	
	public void fillPath(){
		currentPos = new Point(map.maxMapHeight-map.maxRoomSize, map.maxMapWidth-map.maxRoomSize);
			//start walking
			
	}
	
	
}
