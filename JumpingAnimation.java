package w7.d2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class JumpingAnimation extends JFrame {
	private static final long serialVersionUID = -4400713211512666274L;

	private MyPanel panel = new MyPanel();
	private int startY = 220;
	private double coordX = 175;
	private double coordY = startY;
	private boolean isJumping = false;
	private double startDelta = 8;
	private double delta = startDelta;
	private double slowEffect = -0.2;
	private Timer timer;
	
	public JumpingAnimation() {
		add(panel);
		addKeyListener(new Key());
		
		setTitle("Jumping Animation");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JumpingAnimation();
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			coordY -= delta;
			delta += slowEffect;
			panel.repaint();
			
			if (coordY > startY) {
				coordY = startY;
				isJumping = false;
				delta = startDelta;
				timer.stop();
			}
		}
		
	}
	
	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (!isJumping) {
					isJumping = true;
					timer = new Timer(10, new Action());
					timer.start();
				}
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
	}
	
	private class MyPanel extends JPanel {
		private static final long serialVersionUID = -4253952032595481898L;
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.fillRect((int) coordX, (int) coordY, 50, 50);
		}
	}

}
