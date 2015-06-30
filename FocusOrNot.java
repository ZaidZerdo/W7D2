package w7.d2;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Class that represents a window that prints whether
 * or not the window is in focus.
 * @author Zaid
 *
 */
public class FocusOrNot extends JFrame implements FocusListener {
	private static final long serialVersionUID = 3170196036917229100L;

	private JLabel label = new JLabel("Not focused...");
	private Font font1 = new Font("Serif", Font.PLAIN, 20);
	
	public FocusOrNot() {
		label.setFont(font1);
		label.setHorizontalAlignment(JLabel.CENTER);
		add(label);
		
		addFocusListener(this);
		
		setTitle("Focused?");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FocusOrNot();
	}

	@Override
	public void focusGained(FocusEvent e) {
		label.setText("Focused!");
	}

	@Override
	public void focusLost(FocusEvent e) {
		label.setText("Not focused...");
	}

}
