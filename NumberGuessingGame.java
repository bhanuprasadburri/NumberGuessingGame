import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
public class NumberGuessingGame {
	Scanner sc=new Scanner(System.in);
	Random random=new Random();
	int score=0;
	int highScore=0;
	int gamesPlayed=0;
	int gamesWon=0;
	int gamesLost=0;
	
	public void level() {
		System.out.println("\r\n"+"         🎮 SELECT DIFFICULTY\r\n");
		System.out.println("1. 🟢 Easy\n"
	        +"   • Range    : 1 - 100\n"
	        +"   • Attempts : 5\n"
	        +"   • Reward   : +10 Points\n");
		System.out.println();
	        
		System.out.println("2. 🟡 Medium\n"
			+"   • Range    : 1 - 250\n"
			+"   • Attempts : 7\n"
			+"   • Reward   : +20 Points\n");
		System.out.println();
	     
	    System.out.println("3. 🔴 Hard\n"
 	        +"   • Range    : 1 - 500\n"
 	        +"   • Attempts : 9\n"
 	        +"   • Reward   : +30 Points\n");
	 	System.out.println("========================================");
		System.out.println("Enter your choice (1-3): ");
		int level=sc.nextInt();
		switch(level) {
			case 1:
	            playGame(100,5,10);
	            break;
	        case 2:
	            playGame(250,7,20);
	            break;
	        case 3:
	            playGame(500,9,30);
	            break;
			default:
				System.out.println("❌ Invalid choice! Please choose 1, 2 or 3.");
				level();
		}
	}

	public void playGame(int maxNumber,int maxAttempts,int points) {
		ArrayList<Integer> guessHistory = new ArrayList<>();
        int secretNumber=random.nextInt(maxNumber)+1;
        int attempts=0;
        boolean guessedCorrectly=false;
        int hintsLeft = 3;
        HashSet<Integer> usedHints = new HashSet<>();
        while(attempts<maxAttempts) {
            long start=System.currentTimeMillis();
            System.out.println("\n🎯 Attempts Left: "+(maxAttempts-attempts));
            System.out.println("💡 Hints Left : " + hintsLeft);
            System.out.print("Enter your guess (1-"+maxNumber+"):");
            if(!sc.hasNextInt()) {
                System.out.println("⚠ Enter numbers only!");
                sc.next();
                continue;
            }
            int guess=sc.nextInt();
            if (guess == 0) {
                if (hintsLeft > 0) {
                	giveHint(secretNumber, maxNumber, usedHints);
                    hintsLeft--;
                    System.out.println("Hints Remaining : " + hintsLeft);
                }
                else {
                    System.out.println("❌ No hints left!");
                }
                continue;
            }
            if(guess!=0){
                guessHistory.add(guess);
            }
            if (guess<1 || guess>maxNumber) {
                System.out.println("⚠ Enter a number between 1 and "+maxNumber+".");
                continue;
            }
            attempts++;
            if(guess>secretNumber) {
                System.out.println("📈 Too High!");
            } 
            else if(guess<secretNumber) {
                System.out.println("📉 Too Low!");
            } 
            else {
            	gamesPlayed++;
            	gamesWon++;
            	guessedCorrectly = true;
                score += points;
                if (score > highScore) {
                    highScore = score;
                }
                long end = System.currentTimeMillis();
                System.out.println("\n🎉 Congratulations!");
                System.out.println("You guessed the number in "+attempts+" attempt(s).");
                System.out.println("🏆 You earned "+points+" points!");
                System.out.println("⭐ Current Score : "+score);
                System.out.println("🏆 High Score    : "+highScore);
                System.out.println("Time taken : "+((end-start)/1000.0)+" seconds");
                break;
            }
        }

        if(!guessedCorrectly) {
        	gamesPlayed++;
        	gamesLost++;
            System.out.println("🎮 Better luck next time!\r\n"
            	+"\r\n"
            	+"Try again and beat the game! 🍀");
            System.out.println("The correct number was: "+secretNumber);
            System.out.println("⭐ Current Score : " + score);
            System.out.println("🏆 High Score    : " + highScore);
        }
        showGuessHistory(guessHistory);
        showStatistics();
        playAgain();
    }

    public void playAgain() {
        while(true) {
            System.out.print("\nPlay Again? (Y/N): ");
            char choice=sc.next().charAt(0);

            if(choice=='Y' || choice=='y') {
                level();
                return;
            }
            if(choice=='N' || choice=='n') {
                System.out.println("\nThanks for Playing! 😊");
                sc.close();
                return;
            }
            System.out.println("⚠ Please enter Y or N.");
        }
    }
    
    public void showStatistics() {
        System.out.println("\n========== GAME STATISTICS ==========");
        System.out.println("🎮 Games Played : "+gamesPlayed);
        System.out.println("🏆 Games Won    : "+gamesWon);
        System.out.println("❌ Games Lost   : "+gamesLost);
        if(gamesPlayed != 0){
            double winRate=(gamesWon * 100.0)/gamesPlayed;
            System.out.printf("📊 Win Rate     : %.2f%%\n",winRate);
        }
        System.out.println("=====================================");
    }
    
    public void showGuessHistory(ArrayList<Integer> guessHistory){
        System.out.println("\n📜 Guess History");
        if(guessHistory.isEmpty()){
            System.out.println("No guesses made.");
            return;
        }
        for(int guess : guessHistory){
            System.out.print(guess + " ");
        }
        System.out.println();
    }
    
    public void giveHint(int secretNumber, int maxNumber, HashSet<Integer> usedHints) {
        if (usedHints.size() == 6) {
            System.out.println("💡 All available hints have already been used.");
            return;
        }
        int hintType;
        do {
            hintType = random.nextInt(6);
        } while (usedHints.contains(hintType));
        usedHints.add(hintType);
        switch (hintType) {
            case 0:
                System.out.println(secretNumber % 2 == 0 ?
                        "💡 Hint: The number is EVEN."
                        :
                        "💡 Hint: The number is ODD.");
                break;
            case 1:
                System.out.println("💡 Hint: The number is "
                        + (secretNumber > maxNumber / 2 ? "GREATER" : "LESS")
                        + " than " + (maxNumber / 2));
                break;
            case 2:
                System.out.println("💡 Hint: The last digit is " + (secretNumber % 10));
                break;
            case 3:
                System.out.println(secretNumber % 5 == 0 ?
                        "💡 Hint: The number is divisible by 5."
                        :
                        "💡 Hint: The number is NOT divisible by 5.");
                break;

            case 4:
                int range = Math.max(10, maxNumber / 10);

                int low = ((secretNumber - 1) / range) * range + 1;
                int high = Math.min(low + range - 1, maxNumber);

                System.out.println("💡 Hint: The number lies between "
                        + low + " and " + high + ".");
                break;
            case 5:
                int sum = 0;
                int temp = secretNumber;

                while (temp > 0) {
                    sum += temp % 10;
                    temp /= 10;
                }
                System.out.println("💡 Hint: Sum of digits = " + sum);
                break;
        }
    }

    public static void main(String[] args) {
        NumberGuessingGame game=new NumberGuessingGame();
        System.out.println("=================================\r\n"
        	+"      🎯 NUMBER GUESSING GAME\r\n"
        	+"=================================");
        game.level();
    }
}