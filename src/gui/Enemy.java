package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Enemy {
	
	private JLabel enemy;
	private static final String ENEMY_NAME = "enemy1.png";
	private static final int START_X = 350;
	private static final int Y = 150;
	private int x;
	private static int SPEED = 8;
	
	public Enemy(JFrame mainFrame){
		initEnemy(mainFrame);
	}
	
	private void initEnemy(JFrame mainFrame) {
		enemy = new JLabel(new ImageIcon(ENEMY_NAME));
		x = START_X;
		enemy.setBounds(x, Y, 112, 55);
		mainFrame.add(enemy);
		enemy.setVisible(true);
	}
	
	
	//TODO: anpassen an Threadnutzung
	public void startMoving() {
		for(int i=0; i<10000; i++){
			moveRight();
			moveLeft();
		}
	}

	
	public void moveRight() {
		enemy.setVisible(false);
		x += SPEED;
		enemy.setBounds(x, Y, 112, 55);
		enemy.setVisible(true);
	}
	
	public void moveLeft() {
		enemy.setVisible(false);
		x -= SPEED;
		enemy.setBounds(x, Y, 112, 55);
		enemy.setVisible(true);
	}
}
