import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Game extends JPanel{

	Plataform plataform = new Plataform();
	Player player = new Player(this);
	
	public Game(){
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				player.keyRealesed(e);
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				player.keyPressed(e);
				
			}
		});
		setFocusable(true);
	}
	
	private void move(){
		player.move();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		plataform.paint(g2d);
		player.paint(g2d);
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame window = new JFrame("Plataform Game");
		Game game = new Game();
		window.add(game);
		window.setSize(720, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			game.move();
			game.repaint();
			Thread.sleep(5);
		}
	
	}
	
}
