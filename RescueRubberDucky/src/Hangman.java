import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Hangman {
	private char[] word;
	private char[] letters = {'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 
			'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 
			'w', 'x', 'y', 'z'};
	private String correctGuess = "";
	int turns = 11;
	int win;
	
	public Hangman() {
		word = chooseWord();
		setWinCondition();
	}
	
//--------------------------------------------
	
	public char[] getWord() {
		return word;
	}

	public char[] getLetters() {
		return letters;
	}

	public int getTurns() {
		return turns;
	}
//-------------------------------------------------------

	private char[] chooseWord() {
		int wordNumber = (int)(Math.random()*1371)+1;
		char[] word = getWord(wordNumber);
		return word;
	}
	
	private char[] getWord(int line) {
		String wordSt = "";
		try(BufferedReader file = new BufferedReader(new FileReader (".\\words.txt"))) {
			for (int i = 0; i < line; i++) {
				file.readLine();
			}
			wordSt = file.readLine();
			file.close();
			
		}
		catch(IOException e) {}
		
		return wordSt.toLowerCase().toCharArray();
	}
	
	private void getResult(char guess) {
		for (int j = 0 ; j<word.length ; j++) {
			if (word[j] == guess && !(correctGuess.contains(""+guess))) {
				correctGuess += 1;
			}
		}
		for (int i = 0 ; i < letters.length; i++) {
			if(guess == letters[i]) {
				letters[i] = ' ';	
			}
		}
		
		
	}
	
	public boolean doTurn(char guess) {
		getResult(guess);
		turns-= 1;
		return checkForWinner();
	}
	
	private boolean checkForWinner() {
		if (correctGuess.length() == win) {
			return true;
		}else {
			return false;
		}

	}
	
	private void setWinCondition() {
		String allLetters = "";
		for (char letter : word) {
			if (!(correctGuess.contains(""+letter))){
				allLetters += ""+letter;
			}
		}
		win = allLetters.length();
	}
	
	public boolean gameOver() {
		if (turns<1) {
			return true;
		}else {
			return false;
		}
		
	}

}
