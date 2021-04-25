package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SpaceShip {

	private JLabel spaceShip;
	private static final String SHIP_NAME = "raumschiff.png";
	private static final int START_X = 352;
	private static final int Y = 450;
	private int x;
	private static int SPEED = 8;

	public SpaceShip(JFrame mainFrame) {
		initSpaceShip(mainFrame);

	}

	private void initSpaceShip(JFrame mainFrame) {
		spaceShip = new JLabel(new ImageIcon(SHIP_NAME));
		x = START_X;
		spaceShip.setBounds(x, Y, 112, 55);
		mainFrame.add(spaceShip);
		spaceShip.setVisible(true);
	}

	public void moveRight() {
		if(x < 687) {
			spaceShip.setVisible(false);
			x += SPEED;
			spaceShip.setBounds(x, Y, 112, 55);
			System.out.println("X: " + x);
			spaceShip.setVisible(true);
		}
	}

	public void moveLeft() {
		if(x > 0) {
			spaceShip.setVisible(false);
			x -= SPEED;
			spaceShip.setBounds(x, Y, 112, 55);
			System.out.println("X: " + x);
			spaceShip.setVisible(true);
		}
	}

}
