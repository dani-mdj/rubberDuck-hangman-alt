/*
 * Written by Danielle Jenson based on Hangman game
 * Ascii Art from AsciiArtArchives.com
 * 02-2025
 * This project was built for the sake of learning and fun, enjoy
 */
/*
 * Entry into program
 * directs game to continue to play and draw board until user wants to stop
 */
import hangmanInterface.IHangmanUI;

public class Driver {
	
	public static void main(String[] args) {
		
		boolean consoleMode = true;
		
		boolean playAgain = true;
		while (playAgain) {
			Hangman hang = new Hangman();
			IHangmanUI ui;
			//This if statement appears redundant but it is preparing for 
			//alternative UI versions
			if(consoleMode) {
				ui = new DuckyConsole(hang);
			}else {
				ui = new RubberDuckGUI(hang);//replace with other UI than Console or whatever
			}
			boolean gameOn = true;
			
			ui.introduction();
	
			while (gameOn) {
				ui.drawBoard();
				gameOn = playerTurn(ui, hang);
	
			}
			playAgain = ui.playAgain();
		}
		
		
	}
	
	private static boolean playerTurn(IHangmanUI ui, Hangman hang) {
		char guess = ui.getInput();
		boolean isWinner = hang.doTurn(guess);
		
		if (isWinner) {
			ui.drawBoard();
			ui.celebrate();
			return false;
		}else if (hang.gameOver()) {
			ui.gameOver();
			return false;
		}else {
			return true;
		}

	}

}
