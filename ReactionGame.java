package w7.d2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class that describes a frame with a label on it that,
 * after a random amount of time, triggers and says to press a key.
 * After pressing the key the program calculates the amount of time
 * needed to press the key. It is, basically, a reaction game.
 * 
 * @author Zaid
 *
 */
public class ReactionGame extends JFrame {
	private static final long serialVersionUID = -4276192382118938055L;
	private JLabel label = new JLabel("Wait for it...");
	private Font font1 = new Font("Serif", Font.PLAIN, 20);
	private boolean pressNow = false;
	private boolean over = false;
	private long startTime = 0;
	
	public ReactionGame() {
		label.setFont(font1);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		addKeyListener(new Key());
		Timer t = new Timer((int) (Math.random() * 11 + 5) * 1000, new Action());
		t.start();
		
		setTitle("How fast are you?");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ReactionGame();
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!over) {
				pressNow = true;
				label.setText("Press now!");
				startTime = System.currentTimeMillis();
			}
		}
		
	}
	
	private class Key implements KeyListener {

		@Override
		public void keyPressed(KeyEvent e) {
			if (!over && pressNow) {
				long timeTaken = System.currentTimeMillis() - startTime;
				
				label.setText("Time: " + timeTaken + " [ms]");
				over = true;
			} else if (!over){
				label.setText("You pressed early... :(");
				over = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
					
		}
		
	}
}
