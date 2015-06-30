package w7.d2;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that creates a frame with a label inside it.
 * The frame reacts to the presses of the keyboard and types
 * in the label whatever the user types.
 * It also works if the key types is a backspace.
 * 
 * @author Zaid
 *
 */
public class TypingJLabel extends JFrame {
	private static final long serialVersionUID = -614971746967094892L;

	private JLabel label = new JLabel("");
	private Font font1 = new Font("Serif", Font.PLAIN, 20);
	
	public TypingJLabel() {
		label.setFont(font1);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		addKeyListener(new Key());
		
		setTitle("Type something");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TypingJLabel();
	}
	
	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			String s = label.getText();
			
			if (e.getKeyChar() == KeyEvent.VK_BACK_SPACE && s.length() != 0) {
				label.setText(s.substring(0, s.length() - 1));
			} else {
				label.setText(s + e.getKeyChar());				
			}			
		}
		
	}

}
