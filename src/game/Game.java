package game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import gui.GUI;

public class Game extends Thread{

	private GUI gui;
	private final int MOVE_COUNT = 10;
	private final int WAIT_TIME_IN_MILLIS = 10;
	private boolean isRunning;
	private boolean hasEnded;
	private static final String GAME_OVER = "gameover2.png";

	public Game(GUI gui) {
		this.gui = gui;
		this.isRunning = true;
		this.hasEnded = false;
	}

	@Override
	public void run() {
		int count = 0;
		while(!Thread.interrupted()) {
			while(this.isRunning) {
				try {
					Thread.sleep(WAIT_TIME_IN_MILLIS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				if(count < MOVE_COUNT) {
					for(int i = 0; i < gui.getEnemies().length; i++) {
						if(gui.getEnemies()[i] != null) {
							gui.getEnemies()[i].moveRight();
						}
					}
				}else if(count == MOVE_COUNT) {
					for(int i = 0; i < gui.getEnemies().length; i++) {
						if(gui.getEnemies()[i] != null) {
							gui.getEnemies()[i].moveDown();
						}
					}
				}else if(count < MOVE_COUNT * 2) {
					for(int i = 0; i < gui.getEnemies().length; i++) {
						if(gui.getEnemies()[i] != null) {
							gui.getEnemies()[i].moveLeft();
						}
					}
				}else if(count == MOVE_COUNT * 2) {
					for(int i = 0; i < gui.getEnemies().length; i++) {
						if(gui.getEnemies()[i] != null) {
							gui.getEnemies()[i].moveDown();
						}
					}
					count = 0;
				}
			}
		}
	}

	public boolean isRunning() {
		return this.isRunning;
	}

	public void pauseGame() {
		if(!hasEnded) {
			if(isRunning) {
				isRunning = false;
				System.out.println("Your Game is paused.");
			}else {
				isRunning = true;
				System.out.println("Your Game is unpaused.");
			}
		}
	}

	public void endGame() {
		if(isRunning) {
			hasEnded = true;
			isRunning = false;
			System.out.println("You lost the Game!");
			gui.hideEnemies();
			JLabel gameover = new JLabel(new ImageIcon(GAME_OVER));
			gui.getBackground().add(gameover);
			gameover.setBounds(250, 180, 250, 200);
		}
	}
}
