import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.Color;

public class Enemy {
	
	Random random = new Random();
	Color color = new Color(139, 0, 0);
	int x = 0;
	int xa = 1;
	int y = 325;
	int ya = 0;
	int currentY = y;
	int vertex = 50;
	boolean status = true;
	private Game game;
	
	public Enemy(Game game) {
		this.game = game;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,vertex,vertex);
	}
	
	void respawn() {
		if(status ==false) {
			x = 0;
			y = 325;
			status = true;
		}
	}
	
	void move() {
		y += 1;
		if(x + xa < 0)
			xa = 1;
		if(x + xa > game.getWidth()-vertex)
			xa = -1;
		if(y + ya > 0 && y + ya < game.getHeight()-vertex)
			y += ya;
		if(y == currentY-vertex-50) {
			ya = 0;
		}
		if(playerCollision()) {
			game.gameOver();
		}
		if(bulletCollision()) {
			status = false;
			game.bullet.setX(0);
			game.bullet.setY(0);
			game.bullet.status = false;
		}
		x += xa;
		y += ya;
	}
	
	public void collision(Rectangle rect) {
		if(rect.intersects(getBounds()) && rect.getMinY() > y) {
			y = (int) (rect.getY() - vertex);
			currentY= y;
			ya = 0;
		 }
		if(rect.intersects(getBounds()) && rect.getMinY() < y) {
			y = (int) (rect.getY()+rect.height);
			currentY= y;
			ya = 0;
		}
			 
	}
	
	private boolean playerCollision() {
		return game.player.getBounds().intersects(getBounds());
	}
	
	private boolean bulletCollision() {
		return game.bullet.getBounds().intersects(getBounds());
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,vertex,vertex);
	}

}
