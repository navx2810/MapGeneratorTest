package net.matt.mapdrawer;

import java.util.ArrayList;

public class RoomStack {

	public static ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static ArrayList<Room> getRooms() {
		return rooms;
	}
	
	public static void addRoom(Room room){
		rooms.add(room);
	}
	
	public static void combineRooms(){
		for(int x=0; x<rooms.size(); x++)
			for(int y=0; y<rooms.size(); y++)
				if( rooms.get(x).hasPoint(rooms.get(y)) ){
					rooms.get(x).addPoint(rooms.get(y));
					rooms.remove(rooms.get(y));
				}
	}
	

}
