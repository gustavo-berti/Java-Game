import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Bullet {

	private Game game;
	int x;
	int xa;
	int y;
	boolean status = false;
	int width = 25;
	int heith = 5;

	public Bullet(Game game) {
		this.game = game;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void status(boolean status) {
		this.status = status;
	}
	
	public void move() {
		if(game.player.playerIsRight==true && xa == 0)
			xa = 1;
		if(game.player.playerIsRight==false && xa == 0)
			xa = -1;
		if(x + xa < 0 || x+xa>game.getWidth()) {
			status = false;
			x = 0;
			y =0;
			xa = 0;
		}
		x += xa;
	}
	public void paint(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(x, y, width, heith);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,width,heith);
	}
	
	public int getTopY() {
		return y;
	}
	
}