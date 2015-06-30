package vjezbe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main3 extends JFrame {
	private static final long serialVersionUID = -4298975420222819333L;

	private MyPanel panel = new MyPanel();
	private int size = 20;
	
	public Main3() {
		add(panel);
		
		Timer t = new Timer(10, new Action());
		t.start();
		
		setTitle("Timers example");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class MyPanel extends JPanel {
		private static final long serialVersionUID = 8281156269736697513L;
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int red = (int) (Math.random() * 256);
			int green = (int) (Math.random() * 256);
			int blue = (int) (Math.random() * 256);
			
			g.setColor(new Color(red, green, blue));
			g.fillRect(10, 10, size, size);
		}
	}
	
	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			size += 1;
			panel.repaint();
		}
		
	}
	
	public static void main(String[] args) {
		new Main3();
	}

}
