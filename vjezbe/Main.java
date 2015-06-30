package vjezbe;

import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {
	private static final long serialVersionUID = -3037227350838747481L;

	private JLabel label = new JLabel("Focused");
	
	public Main() {
		add(label);
		label.setFont(new Font("Sans Serif", Font.PLAIN, 35));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		addFocusListener(new Focus());
		
		setTitle("FocusListener example");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
	private class Focus implements FocusListener {

		@Override
		public void focusGained(FocusEvent arg0) {
			System.out.println("Dobijen je fokus.");
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			System.out.println("Izgubljen je fokus.");
		}
		
	}

}
