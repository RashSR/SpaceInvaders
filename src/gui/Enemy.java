package gui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Enemy {
	
	private JLabel enemy;
	private static final String ENEMY_NAME = "enemy1.png";
	private static final int START_X = 30;
	private static final int START_Y = 50;
	private int x;
	private int y;
	private static int X_SPEED = 8;
	private static int Y_SPEED = 10;
	
	public Enemy(int posIndex, JLabel background){
		for(int j=0; j< 2;j++) {
			initEnemy(posIndex, j, background);
		}
	}
	
	private void initEnemy(int posIndex, int j, JLabel background) {
		enemy = new JLabel(new ImageIcon(ENEMY_NAME));
		x = START_X + posIndex*75;
		y = START_Y + j*75;
		enemy.setBounds(x, y, 40, 40);
		background.add(enemy);
	}
	
	public void moveRight() {
		x += X_SPEED;
		enemy.setBounds(x, y, 40, 40);
	}
	
	public void moveLeft() {
		x -= X_SPEED;
		enemy.setBounds(x, y, 40, 40);
	}
	
	public void moveDown() {
		y += Y_SPEED;
		enemy.setBounds(x, y, 40, 40);
	}
}
