import hangmanInterface.IHangmanUI;

public class RubberDuckGUI implements IHangmanUI {
	Hangman hang;
	public RubberDuckGUI(Hangman hang) {
		this.hang=hang;
	}
	
	@Override
	public void drawBoard() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void introduction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean playAgain() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void celebrate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public char getInput() {
		// TODO Auto-generated method stub
		return 0;
	}

}
