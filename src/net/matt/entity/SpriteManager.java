package net.matt.entity;

import net.matt.entity.Sprite.Color;
import net.matt.mapdrawer.MapDrawer;


public class SpriteManager {
	Sprite[][] sprites;
	net.matt.entity.Map map;
	MapDrawer mapDrawer;
	
	public SpriteManager(net.matt.entity.Map map) {
		this.map = map;
		sprites = new Sprite[map.maxMapHeight][map.maxMapWidth];
		populatedArrayList();
	}
	
	public SpriteManager(Map map, boolean useMapDrawer){
		mapDrawer = new MapDrawer(map);
		this.map = map;
		sprites = new Sprite[map.maxMapHeight][map.maxMapWidth];
	}
	
	void populatedArrayList(){
		sprites = new Sprite[map.maxMapHeight][map.maxMapWidth];
		for (int h = 0; h < map.maxMapHeight; h++) 
			for(int w = 0; w < map.maxMapWidth; w++)
				if(map.map[h][w] == 'R')
					sprites[h][w] = new Sprite(h*Sprite.SCALE, w*Sprite.SCALE, Color.ROOM);
				else if(map.map[h][w] == 'W')
					sprites[h][w] = new Sprite(h*Sprite.SCALE, w*Sprite.SCALE, Color.WALL); 
				else
					sprites[h][w] = new Sprite(h*Sprite.SCALE, w*Sprite.SCALE, Color.BLANK); 
	}
	
	public void draw(){
		for (int h = 0; h < map.maxMapHeight; h++) 
			for(int w = 0; w < map.maxMapWidth; w++)
				sprites[h][w].draw();
		
	}
	
	public void getNewMap(){
		map = new Map(map.maxMapHeight, map.maxMapWidth,15);
		populatedArrayList();
	}
	
	public void getNewMap(int numberOfTimesFilled){
		map = new Map(map.maxMapHeight, map.maxMapWidth, numberOfTimesFilled);
		populatedArrayList();
	}
	
}
