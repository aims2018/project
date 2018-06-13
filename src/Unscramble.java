import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Unscramble extends JFrame implements ActionListener {
	private String word;
	private JButton first;
	private JButton[] buttons;
	private MessagePanel messagePanel;
	private String message;
	
	private void scramble(char[] c) {
		int counter = 0;
		
		while (counter < 100) {
			int position1 = (int)(c.length*Math.random());
			
			int position2 = position1;
			
			while (position2 == position1)
				position2 = (int)(c.length*Math.random());
			
			char temp = c[position1];
			c[position1] = c[position2];
			c[position2] = temp;
			
			counter++;
		}
	}
	
	public Unscramble(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		word = Words.getWord();
		
		word = word.toUpperCase();
		
		char[] characters = word.toCharArray();
		
		scramble(characters);
		
		buttons = new JButton[word.length()];
		
		for (int counter=0;counter<buttons.length;counter++) {
			buttons[counter] = new JButton("" + characters[counter]);
			
			buttons[counter].addActionListener(this);
			
			add(buttons[counter]);
		}
		
		message = "Wrong";
		
		add(messagePanel = new MessagePanel(700,300));
		
	}
	
	public class MessagePanel extends JPanel {
		private int width;
		private int height;
		
		public MessagePanel(int width,int height) {
			setPreferredSize(new Dimension(width,height));
			
			this.width = width;
			this.height = height;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setFont(new Font("Comic Sans MS",Font.BOLD,40));
			
			FontMetrics metrics = g.getFontMetrics();
			
			g.drawString(message, width/2 - metrics.stringWidth(message)/2, 200);			
		}		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if (first == null)
			first = (JButton)arg0.getSource();
		else {
			JButton second = (JButton)arg0.getSource();
			
			String temp = first.getText();
			first.setText(second.getText());
			second.setText(temp);
			
			first = null;
			
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Unscramble unscramble = new Unscramble("Unscramble");
		
		unscramble.setSize(800,800);
		unscramble.setLocationRelativeTo(null);
		unscramble.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unscramble.setVisible(true);

	}

}
