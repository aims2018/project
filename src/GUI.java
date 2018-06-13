import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI extends JFrame implements ActionListener, ItemListener, Runnable {
	private JButton button;
	private JComboBox fonts;
	private String message;
	private JComboBox red;
	private JComboBox green;
	private JComboBox blue;
	
	public GUI(String title) {
		super(title);
		
		setLayout(new FlowLayout());
		
		add(button = new JButton("Press Me"));
		
		button.addActionListener(this);
		
		add(button);
		
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
        add(fonts = new JComboBox(fontNames));
        
        JPanel panel = new JPanel();
        
        Integer[] choices = new Integer[256];
        
        for (int counter=0;counter<choices.length;counter++)
        	choices[counter] = counter;
        
        panel.add(new JLabel("Red"));
        panel.add(red = new JComboBox(choices));
        panel.add(new JLabel("Green"));
        panel.add(green = new JComboBox(choices));
        panel.add(new JLabel("Blue"));
        panel.add(blue = new JComboBox(choices));
        
        panel.setPreferredSize(new Dimension(400,50));
        
        add(panel);
        
	    message = "Hello";	
	}

	public void pause(double seconds) {
		try {
			Thread.sleep((int)(seconds*1000));
		} catch (InterruptedException ie) {
			System.out.println(ie);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Font font = new Font(fonts.getSelectedItem().toString(),Font.BOLD,20);
		
		g.setFont(font);
		
		int red = Integer.parseInt(this.red.getSelectedItem().toString());
		int green = Integer.parseInt(this.green.getSelectedItem().toString());
		int blue = Integer.parseInt(this.blue.getSelectedItem().toString());
		
		g.setColor(new Color(red,green,blue));
		
		g.drawString(message, 20, 200);
		
		Image image = new ImageIcon("images\\zero.jpg").getImage();
		
		g.drawImage(image, 20,400,20,20,null);
		
		System.out.println(image);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		repaint();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GUI gui = new GUI("GUI");
		
		gui.setSize(500,500);
		gui.setLocationRelativeTo(null);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
