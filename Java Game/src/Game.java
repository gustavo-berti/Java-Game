import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Game extends JPanel{

	Plataform plataform = new Plataform(0, 400, 720, 50);
	Plataform plat1 = new Plataform(125, 325, 150, 10);
	Plataform plat2 = new Plataform(400, 275, 150, 10);
	Player player = new Player(this);
	Enemy enemy = new Enemy(this);
	Bullet bullet = new Bullet(this);
	
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
		if(enemy.status)
			enemy.move();
		if(bullet.status)
			bullet.move();
		player.collision(plataform.getBounds());
		player.collision(plat1.getBounds());
		player.collision(plat2.getBounds());
		if(enemy.status)
			enemy.collision(plataform.getBounds());
	}
	
	public void gameOver() {
		JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		plataform.paint(g2d);
		plat1.paint(g2d);
		plat2.paint(g2d);
		player.paint(g2d);
		if(enemy.status)
			enemy.paint(g2d);
		if(bullet.status)
			bullet.paint(g2d);
	}
	
	public static void main(String[] args) throws InterruptedException {
		JFrame window = new JFrame("Plataform Game");
		Game game = new Game();
		window.add(game);
		window.setSize(720, 480);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while(true) {
			game.enemy.respawn();
			game.move();
			game.repaint();
			Thread.sleep(5);
		}
	
	}

}
