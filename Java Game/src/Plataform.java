import java.awt.Graphics2D;
import java.awt.Color;

public class Plataform {

	Color color = new Color(2,113,72);
	private static final int x = 0;
	private static final int y = 400;
	private static final int width = 720;
	private static final int heith = 50;
	
	public void paint(Graphics2D g) {
		g.setColor(color);
		g.fillRect(x, y, width, heith);
	}
	
}
