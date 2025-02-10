package hangmanInterface;

public interface IHangmanUI {
	abstract void drawBoard();
	void introduction();
	boolean playAgain();
	boolean playerTurn();

}
