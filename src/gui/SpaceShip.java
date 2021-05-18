package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpaceShip {

	private JLabel spaceShip;
	private static final String SHIP_NAME = "raumschiff.png";
	private static final int START_X = 350;
	private static final int Y = 450;
	private int x;
	private static int SPEED = 8;

	public SpaceShip(JLabel background) {
		initSpaceShip(background);
	}

	private void initSpaceShip(JLabel background) {
		spaceShip = new JLabel(new ImageIcon(SHIP_NAME));
		x = START_X;
		spaceShip.setBounds(x, Y, 112, 55);
		background.add(spaceShip);
	}

	public void moveRight() {
		if(x + SPEED < 800 - 112) {
			x += SPEED;
			spaceShip.setBounds(x, Y, 112, 55);
		}
	}

	public void moveLeft() {
		if(x - SPEED > 0) {
			x-= SPEED;
			spaceShip.setBounds(x, Y, 112, 55);
		}
	}
	
	public void hideShip() {
		spaceShip.setVisible(false);
	}
	
	public void showShip() {
		spaceShip.setVisible(true);
	}

}
