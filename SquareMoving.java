package w7.d2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SquareMoving extends JFrame {
	private static final long serialVersionUID = 3957595912716671278L;
	private static final int PLA_SIZE = 25;
	private MyPanel panel = new MyPanel();
	private int playerX = 50;
	private int playerY = 50;
	private int playerDelta = 5;

	public SquareMoving() {
		add(panel);
		addKeyListener(new Key());

		setTitle("Square Moving");
		setSize(350, 450);
		setLocationRelativeTo(null);
		// setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				playerY += playerDelta;
				if (playerY + PLA_SIZE > panel.getHeight()) {
					playerY -= playerDelta;
				}
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				playerY -= playerDelta;					
				if (playerY < 0) {
					playerY += playerDelta;	
				}
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				playerX -= playerDelta;					
				if (playerX < 0) {
					playerX += playerDelta;	
				}
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				playerX += playerDelta;					
				if (playerX + PLA_SIZE > panel.getWidth()) {
					playerX -= playerDelta;
				}
			}
			panel.repaint();
		}

		@Override
		public void keyReleased(KeyEvent arg0) {

		}

		@Override
		public void keyTyped(KeyEvent arg0) {

		}

	}

	private class MyPanel extends JPanel {
		private static final long serialVersionUID = 6348370850404499029L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.setColor(Color.GREEN);
			g.fill3DRect(playerX, playerY, PLA_SIZE, PLA_SIZE, true);
		}
	}

	public static void main(String[] args) {
		new SquareMoving();
	}

}
