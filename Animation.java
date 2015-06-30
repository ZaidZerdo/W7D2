package w7.d2;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Describes a frame that contains a panel which draws a rectangle
 * on itself. A timer sets the time when to trigger movement and a repaint.
 * 
 * @author Zaid
 *
 */
public class Animation extends JFrame {
	private static final long serialVersionUID = -4536672821595927860L;
	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	
	private MyPanel panel = new MyPanel();	
	private int coordX = 0;
	private int coordY = 0;
	private int deltaX = 4;
	private int deltaY = 4;
	private boolean isFocused = false;
	
	public Animation() {
		add(panel);
		addFocusListener(new Focus());
		
		Timer t = new Timer(20, new Action());
		t.start();
		
		setTitle("Animation");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Animation();
	}
	
	private class Focus implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			isFocused = true;
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			isFocused = false;
		}
		
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (isFocused) {
				coordX += deltaX;
				coordY += deltaY;
				
				if (coordX + WIDTH > panel.getWidth() || coordX < 0) {
					deltaX = -deltaX;
				}
				
				if (coordY + HEIGHT > panel.getHeight() || coordY < 0) {
					deltaY = -deltaY;
				}
				
				panel.repaint();
			}
		}
		
	}
	
	private class MyPanel extends JPanel {
		private static final long serialVersionUID = -4895311251468456161L;
				
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (isFocused) {
				g.fill3DRect(coordX, coordY, Animation.WIDTH, Animation.HEIGHT, true);
			}
		}
	}

}
