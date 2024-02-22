import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player {

	Color color = new Color(70,130,180);
	private static final int y = 350;
	private static final int vertex = 50;
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
		if(x + xa > 0 && x + xa < game.getWidth()-vertex)
			x = x + xa;
	}
	
	public void keyRealesed(KeyEvent e) {
		xa = 0;
	}
	
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			xa = -1;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xa = 1;
		}
	}
	
}
