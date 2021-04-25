package gui;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class GUI {
	private JFrame mainFrame;
	private static final int MAP_COUNT = 2;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 520;
	private static final int WIDTH_OFFSET = 12;
	private static final int HEIGHT_OFFSET = 35;
	
	public GUI() {
		initFrame();
		SpaceShip spaceShip = new SpaceShip(mainFrame);
		Enemy enemy = new Enemy(mainFrame);
		showBackground();
		mainFrame.setVisible(true);
		//TODO: thread, sonst schlecht
		//enemy.startMoving();
		mainFrame.addKeyListener(new KeyHandler(spaceShip));
	}
	
	private void initFrame() {
		mainFrame = new JFrame("SpaceInvaders");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(WIDTH+WIDTH_OFFSET, HEIGHT+HEIGHT_OFFSET);
		mainFrame.setResizable(false);
		mainFrame.setLocationRelativeTo(null);
	}
	
	private void showBackground() {
		JLabel background = new JLabel(new ImageIcon(randomMap()));
		background.setBounds(0, 0, WIDTH, HEIGHT);
		mainFrame.add(background);
	}
	
	private String randomMap() {
		Random rand = new Random();
		int map = rand.nextInt(MAP_COUNT)+1;
		return "background" + map + ".png";
	}
	
}
