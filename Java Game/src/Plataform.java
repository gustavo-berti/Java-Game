import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Plataform {

	private int x;
	private int y;
	private int width;
	private int heith;
	
	public Plataform(int x, int y, int width, int heith) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.heith = heith;
	}
	
	Color color = new Color(2,113,72);
	
	public void paint(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, width, heith);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,heith);
	}
	
	public int getTopY() {
		return y;
	}
	
}
