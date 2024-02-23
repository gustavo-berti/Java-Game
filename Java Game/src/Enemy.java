import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;

public class Enemy {
	
	Color color = new Color(139, 0, 0);
	int x = 0;
	int xa = 1;
	int y = 325;
	int ya = 0;
	int currentY = y;
	int vertex = 50;
	private Game game;
	
	public Enemy(Game game) {
		this.game = game;
	}
	
	public void paint(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x,y,vertex,vertex);
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
		if(collision()) {
			y = game.plataform.getTopY() - vertex;
			currentY= y;
		}
		x += xa;
		y += ya;
	}
	
	private boolean collision() {
		return game.plataform.getBounds().intersects(getBounds());
	}
	
	
	public Rectangle getBounds() {
		return new Rectangle(x,y,vertex,vertex);
	}

}
