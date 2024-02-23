import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Timer;

public class Player {
	
	Timer timer = new Timer();
	Color color = new Color(70,130,180);
	private static final int vertex = 50;
	int y = 325;
	int currentY = y;
	int ya = 0;
	int x = 360;
	int xa = 0;
	private Game game;
	
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
		if(collision()) {
			y = game.plataform.getTopY() - vertex;
			currentY= y;
		}
		if(enemyCollision()) {
			game.gameOver();
		}
	}
	
	private boolean collision() {
		return game.plataform.getBounds().intersects(getBounds());
	}
	
	private boolean enemyCollision() {
		return game.enemy.getBounds().intersects(getBounds());
	}
	
	public void keyRealesed(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e){
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && currentY == y) {
			currentY = y;
			ya = -2;
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,vertex,vertex);
	}
	
}
