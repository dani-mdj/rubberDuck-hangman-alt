import java.util.Scanner;

public class DuckyConsole {
	Hangman hang;
	Scanner userInput = new Scanner(System.in);
	
	public DuckyConsole() {
		hang = new Hangman();
	}
	
	
	public void drawBoard() {
		System.out.print(imageString());
		System.out.println();
		drawCountDown();
		drawPassword();
		
		for (int i = 0; i < 73; i++) {
			System.out.print("_");
		}
		drawLetters();
	}
	
	
	private String imageString() {
		
		String image = "                                                    \r\n"  
				+ "    ____              ____________                    _,,_______________\r\n"
				+ "   ||  ||     _      (__((__((___()                  //|                |\r\n"
				+ "   ||__||   >(.)__  (__((__((___()()________________// |  "
				+ String.format("Attemps: %2s",(11-hang.getTurns()))
				+ "   |\r\n"
				+ "   [ -=.]`)  (___/ (__((__((___()()()---------------'  |________________|\r\n"
				+ "   ====== 0 \r\n";
		
		return image;
		
	}
	
	private void drawCountDown() {
		System.out.printf("%s TRIES REMAINING\n", hang.getTurns());
	}
	
	private void drawLetters() {
		System.out.printf("\n\n%43s\n", "Available Letters");
		for (int i = 0; i < 73; i++) {
			System.out.print("_");
		}
		System.out.println("\n");
		char[] letters = hang.getLetters();
		for(int i = 0; i< letters.length; i++) {
			System.out.printf("%5s", letters[i]);
			if (i == 12) {
				System.out.println();
			}
			
		}
	}
	
	
	private void drawPassword() {
		System.out.println("Enter Your Password To Stop Countdown:\n");
		char[] word = hang.getWord();
		
		for(char character : word) {
			for (char letter: hang.getLetters()) {
				if(letter == character) {
					System.out.print("___ ");
					break;
				}else if (letter == 'z'){
					System.out.printf(" %s  ",character);
				}
			}
	
		}
		System.out.println();
	}
	
	
	private char getInput() {
		char guess = 'A';
		System.out.println("\n\nGuess a letter in your password:");
		boolean notValidGuess = true;
		while (notValidGuess) {
			try {
				guess = userInput.next().charAt(0);
				userInput.nextLine();
				notValidGuess = false;
			}catch(Exception e) {
				System.out.println("invalid guess, guess a letter");
			}
		}
		return guess;
		
		
	}
	
	public boolean playerTurn() {
		char guess = getInput();
		boolean isWinner = hang.doTurn(guess);
		
		if (isWinner) {
			drawBoard();
			celebrate();
			return false;
		}else if (hang.gameOver()) {
			boom();
			return false;
		}else {
			return true;
		}

	}
	
	private void celebrate() {
		System.out.print("\nYOU DID IT\nTHE RUBBER DUCK IS SAVED\n\n");
	}
	
	private void boom() {
		System.out.print("          _ ._  _ , _ ._\r\n"
				+ "        (_ ' ( `  )_  .__)\r\n"
				+ "      ( (  (    )   `)  ) _)\r\n"
				+ "     (__ (_   (_ . _) _) ,__)\r\n"
				+ "         `~~`\\ ' . /`~~`\r\n"
				+ "              ;   ;\r\n"
				+ "              /   \\\r\n"
				+ "_____________/_ __ \\_____________\n\n");
		
		System.out.printf("Your password was \n%s\n try not to forget your duck next time.\n\n", new String(hang.getWord()));
	}
	
	public void introduction() {
		System.out.print("OH NO!\n"
				+ "You were so frustrated with your code you decided to blow up your computer!\n "
				+ "However you realized you left behind your favorite rubber duck *gasp*!\n\n"
				+ "You can't seem to remember the password to stop the explosion\n"
				+ "but you allowed 11 tries to guess the letters.\n\n"
				+ "You can do this! Save the Rubber Duck!\n\n"
				+ "GOOD LUCK\n\n");
		for(int i = 0; i<75; i++) {
			System.out.print("_");
		}
		System.out.println("\nHit enter to begin");
		userInput.nextLine();
	}
	
	public boolean playAgain() {
		System.out.print("Want to play again? (y for yes, any key for quit)");
		String answer = userInput.nextLine();
		if (answer.equalsIgnoreCase("y")) {
			return true;
		}else {
			userInput.close();
			System.out.println("Thanks for playing!");
			System.out.println("Game by Danielle Jenson");
			return false;
		}
	}
	

	

}
