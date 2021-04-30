package gui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Enemy {
	
	private JLabel enemy;
	private static final String ENEMY_NAME = "enemy1.png";
	private static final int START_X = 30;
	private static final int START_Y = 50;
	private int x;
	private int y;
	private static int SPEED = 8;
	
	public Enemy(int posIndex, JFrame mainFrame){
		for(int j=0; j< 2;j++) {
			initEnemy(posIndex, j, mainFrame);
		}
		System.out.println();
	}
	
	private void initEnemy(int posIndex, int j, JFrame mainFrame) {
		enemy = new JLabel(new ImageIcon(ENEMY_NAME));
		x = START_X + posIndex*75;
		y = START_Y + j*75;
		enemy.setBounds(x, y, 40, 40);
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
		enemy.setBounds(x, y, 40, 40);
		enemy.setVisible(true);
	}
	
	public void moveLeft() {
		enemy.setVisible(false);
		x -= SPEED;
		enemy.setBounds(x, y, 40, 40);
		enemy.setVisible(true);
	}
}
