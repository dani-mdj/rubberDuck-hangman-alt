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
public class Driver {
	
	public static void main(String[] args) {
		boolean playAgain = true;
		while (playAgain) {
			
			DuckyConsole duck = new DuckyConsole();
			boolean gameOn = true;
			
			duck.introduction();
	
			while (gameOn) {
				duck.drawBoard();
				gameOn = duck.playerTurn();
	
			}
			playAgain = duck.playAgain();
		}
		
		
	}

}
