import game.Game;
import gui.GUI;

public class SpaceInvaders {

	public static void main(String[] args) {
		GUI gui = new GUI();
		Game game = new Game(gui);
		gui.setGame(game);
		game.start();
	}

}
