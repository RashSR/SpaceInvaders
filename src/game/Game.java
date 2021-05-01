package game;

import gui.GUI;

public class Game extends Thread{

	private GUI gui;
	private final int MOVE_COUNT = 10;
	private final int WAIT_TIME_IN_MILLIS = 500;
	private boolean isRunning; 

	public Game(GUI gui) {
		this.gui = gui;
		this.isRunning = true;
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
		if(isRunning) {
			isRunning = false;
		}else {
			isRunning = true;
		}
	}
}
