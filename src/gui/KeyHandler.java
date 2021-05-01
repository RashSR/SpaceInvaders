package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.Game;


public class KeyHandler implements KeyListener{
	private SpaceShip spaceShip;
	private Game game;

	public KeyHandler(SpaceShip spaceShip) {
		this.spaceShip = spaceShip;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT: 
			spaceShip.moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			spaceShip.moveRight();
			break;
		case KeyEvent.VK_ESCAPE:
			System.exit(0);
			break;
		case KeyEvent.VK_P:
			game.pauseGame();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void setGame(Game game) {
		this.game = game;
	}

}
