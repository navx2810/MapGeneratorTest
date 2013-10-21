package net.matt.entity;

import java.util.Random;

public class Map {

	public int maxMapHeight, maxMapWidth, maxRoomSize, minRoomSize;
	public char[][] map;
	Random random;

	/**
	 * Minimum Constructor | This will set the map's height and width then fill
	 * it with '-' characters
	 * 
	 * @param maxMapHeight
	 *            - the maximum height for the map
	 * @param maxMapWidth
	 *            - the maximum width for the map
	 */
	public Map(int maxMapHeight, int maxMapWidth) {
		this.maxMapHeight = maxMapHeight;
		this.maxMapWidth = maxMapWidth;
		map = new char[maxMapWidth][maxMapHeight];
		random = new Random();
		maxRoomSize = 5;
		minRoomSize = 3;
		fillMap();
	}

	/**
	 * Full Constructor | This will set the map's height and width then fill the
	 * map with '-' character and lay the walls
	 * 
	 * @param maxMapHeight
	 *            - the maximum height for the map
	 * @param maxMapWidth
	 *            - the maximum width for the map
	 * @param numberOfTimesFilled
	 *            - the number of times to draw random rooms
	 */
	public Map(int maxMapHeight, int maxMapWidth, int numberOfTimesFilled) {
		this(maxMapHeight, maxMapWidth);
		layRoom(numberOfTimesFilled);
		layWalls();
	}

	/**
	 * This method is to print out the map to the console
	 */
	public void printMap() {
		for (int h = 0; h < maxMapHeight; h++)
			for (int w = 0; w < maxMapWidth; w++)
				if (w == maxMapHeight - 1)
					System.out.print(map[h][w] + "\n");
				else
					System.out.print(map[h][w] + " ");
	}

	@Deprecated
	public void testFillMap() {
		for (int i = 0; i < maxMapHeight; i++)
			for (int x = 0; x < maxMapWidth; x++)
				map[i][x] = 'T';
	}

	@Deprecated
	int decideNumberOfRooms() {
		return random.nextInt(3) + 1 + maxMapHeight;
	}

	/**
	 * Flood the map with '-' characters to denote "blank spaces"
	 */
	void fillMap() {
		for (int h = 0; h < maxMapHeight; h++)
			for (int w = 0; w < maxMapWidth; w++)
				map[h][w] = '-';
	}

	/**
	 * Choose random locations and generate rooms inside of them
	 */
	void layRoom() {
		int rX = random.nextInt(maxMapHeight - maxRoomSize), rY = random
				.nextInt(maxMapHeight - maxRoomSize + 1);
		if (checkBounds(rX)) {
			for (int h = 0; h < maxRoomSize; h++)
				for (int w = 0; w < maxRoomSize; w++)
					map[rX + w][rY + h] = 'R';
		}
	}

	void layRoom(int numberOfTimes) {
		for (int x = 0; x < numberOfTimes; x++)
			layRoom();
	}

	void layWalls() {
		for (int h = 0; h < maxMapHeight; h++)
			for (int w = 0; w < maxMapWidth; w++) {
				if (map[h][w] == 'R')
					if (isWall(h, w))
						map[h][w] = 'W';
			}

	}

	void layCorridors() {

	}

	private boolean isWall(int h, int w) {
		if (h == 0 || w == 0)
			return true;
		else if (h == maxMapHeight - 1 || w == maxMapWidth - 1)
			return true;
		else if (map[h - 1][w] == '-' || map[h + 1][w] == '-'
				|| map[h][w - 1] == '-' || map[h][w + 1] == '-'
				|| map[h - 1][w - 1] == '-' || map[h + 1][w + 1] == '-'
				|| map[h - 1][w + 1] == '-' || map[h + 1][w - 1] == '-')
			return true;
		else
			return false;
	}

	boolean checkBounds(int x) {
		if (x <= (maxMapHeight - maxRoomSize))
			return true;
		else
			return false;
	}

	/* ***************************************************************************************************
	 * Method idea, pick a point and start walking draw out the world from
	 * walking instead of "Stamping" /*
	 * *****************************************
	 * ******************************************************
	 */

}
