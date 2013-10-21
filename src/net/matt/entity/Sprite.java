package net.matt.entity;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

public class Sprite {
	int xPos, yPos;
	public static int SCALE = 20;
	boolean isRoom;
	Color color;

	public Sprite(int xPos, int yPos, Color color) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.color = color;

	}

	public void draw() {

		glColor3f(color.r, color.g, color.b);
		
		glBegin(GL_QUADS);
		glVertex2i(xPos, yPos);
		glVertex2i(xPos + SCALE, yPos);
		glVertex2i(xPos + SCALE, yPos + SCALE);
		glVertex2i(xPos, yPos + SCALE);
		glEnd();
	}

	public enum Color {

		WALL(0.1f,0.1f,0.1f), ROOM(0.2f,0.2f,0.2f), BLANK(0.5f,0.5f,0.5f);

		public float r, g, b;

		private Color(float r, float g, float b) {
			this.r = r;
			this.g = g;
			this.b = b;
		}
	}

}
