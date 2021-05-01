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
	private static final int ENEMY_ANZAHL = 10;
	private Enemy[] enemies = new Enemy[ENEMY_ANZAHL];

	public GUI() {
		initFrame();
		showBackground();
		SpaceShip spaceShip = new SpaceShip(background);
		//TODO HAllo Larissa ich hab mir einfach nur einen angemacht, dass ich es für mich einfacher hab :)
		/*
		for(int i = 0; i <ENEMY_ANZAHL; i++) {
			enemies[i] = new Enemy(i, background);
		}
		 */
		enemies[0] = new Enemy(0, background);
		this.keyHandler = new KeyHandler(spaceShip);
		mainFrame.addKeyListener(this.keyHandler);
		mainFrame.setVisible(true);
	}

	private void initFrame() {
		mainFrame = new JFrame("SpaceInvaders");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(WIDTH+WIDTH_OFFSET, HEIGHT+HEIGHT_OFFSET);
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
		int map = rand.nextInt(MAP_COUNT)+1;
		return "background" + map + ".png";
	}

	public Enemy[] getEnemies() {
		return this.enemies;
	}

	public void setGame(Game game) {
		this.game = game;
		this.keyHandler.setGame(game);
	}
	
}
