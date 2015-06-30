package vjezbe;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main2 extends JFrame {
	private static final long serialVersionUID = -853596519211272574L;

	public Main2() {
		addKeyListener(new Key());
		
		setTitle("KeyListener example");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main2();
	}
	
	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {	
			System.out.println(e.getKeyChar());
			System.out.println(e.getKeyCode());
		}

		@Override
		public void keyTyped(KeyEvent e) {			
			
		}
		
	}

}
