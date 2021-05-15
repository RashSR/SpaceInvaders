package gui;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import game.Game;

public class GUI {
	private JFrame mainFrame;
	private JLabel background;
	private Game game;
	private KeyHandler keyHandler;
	private static final int MAP_COUNT = 2;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 520;
	private static final int WIDTH_OFFSET = 12;
	private static final int HEIGHT_OFFSET = 35;
	private static final int ENEMY_ANZAHL = 25; // Anzahl Gegner
	private static final int ENEMY_IN_ROWS = 7; // Anzahl Gegner in Reihen

	private Enemy[] enemies = new Enemy[ENEMY_ANZAHL];

	public GUI() {
		initFrame();
		showBackground();
		SpaceShip spaceShip = new SpaceShip(background);
		initGuiEnemies();
		this.keyHandler = new KeyHandler(spaceShip);
		mainFrame.addKeyListener(this.keyHandler);
		mainFrame.setVisible(true);
	}

	private void initGuiEnemies() {
		int enemyNumber = 0;
		int enemyRows = ENEMY_ANZAHL / ENEMY_IN_ROWS;

		if ((ENEMY_ANZAHL % ENEMY_IN_ROWS) != 0) {
			enemyRows++;
		}

		for (int i = 0; i < enemyRows; i++) {
			for (int j = 0; j < ENEMY_IN_ROWS; j++) {
				enemies[enemyNumber] = new Enemy(j, i, background);
				enemyNumber++;
				if (enemyNumber >= ENEMY_ANZAHL) {
					break;
				}
			}
		}
	}
	

	private void initFrame() {
		mainFrame = new JFrame("SpaceInvaders");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(WIDTH + WIDTH_OFFSET, HEIGHT + HEIGHT_OFFSET);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
	}

	private void showBackground() {
		background = new JLabel(new ImageIcon(randomMap()));
		background.setBounds(0, 0, WIDTH, HEIGHT);
		mainFrame.add(background);
	}

	private String randomMap() {
		Random rand = new Random();
		int map = rand.nextInt(MAP_COUNT) + 1;
		return "background" + map + ".png";
	}

	public Enemy[] getEnemies() {
		return this.enemies;
	}

	public void setGame(Game game) {
		this.game = game;
		this.keyHandler.setGame(game);
		for(int i = 0; i < enemies.length; i++) {
			enemies[i].setGame(game);
		}
	}
	
	public JLabel getBackground() {
		return background;
	}
	
	public void hideEnemies() {
		for(int i = 0; i < enemies.length; i++) {
			if(enemies[i] != null) {
				enemies[i].hideEnemy();
			}
		}
	}

}
