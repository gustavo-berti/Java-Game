import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class Player {
	
	Timer timer = new Timer();
	Color color = new Color(70,130,180);
	static final int vertex = 50;
	int y = 325;
	int currentY = y;
	int ya = 0;
	int x = 360;
	int xa = 0;
	private Game game;
	public boolean playerIsRight = true;
	
	public Player(Game game) {
		this.game = game;
	}

	public void paint(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,vertex,vertex);
	}
	
	void move() {
		y += 1;
		if(x + xa > 0 && x + xa < game.getWidth()-vertex)
			x += xa;
		if(y + ya > 0 && y + ya < game.getHeight()-vertex)
			y += ya;
		if(y == currentY-vertex-50) {
			ya = 0;
		}
		
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
	
	public void keyRealesed(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
			playerIsRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
			playerIsRight = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && currentY == y) {
			currentY = y;
			ya = -2;
		}
		if (e.getKeyCode() == KeyEvent.VK_X) {
			if(game.bullet.status==false) {
				if(playerIsRight)
					game.bullet.setX(x+vertex);
				if(playerIsRight == false)
					game.bullet.setX(x-game.bullet.width);
					game.bullet.setY(y+vertex/2);
					game.bullet.status = true;
			}
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,vertex,vertex);
	}
	
}
