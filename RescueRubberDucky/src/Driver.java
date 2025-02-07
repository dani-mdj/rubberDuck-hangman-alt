
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
