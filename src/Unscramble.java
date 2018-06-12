import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Unscramble extends JFrame implements ActionListener {
	
	public Unscramble(String title) {
		super(title);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

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
