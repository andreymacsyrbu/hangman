import java.util.Random;
import java.util.Scanner;

public class Game {
    public int number = 0;
    public int guess = 0;
    public boolean running = true;
    public int guessAmount = 9;

    HangmanStages hangmanStages = new HangmanStages();

    // run the game
    public void run() {
        createNumber();
        showNumber();
        while (running && guessAmount != 0) {
            takeInput();
            checkInput();
        }
        if (guess == number) {
            System.out.println("you won :)");
        } else {
            System.out.println("you lost :(");
        }
        showNumber();
    }

    // to take input
    public void takeInput() {
        System.out.print("guess the number (0 - 100) : ");
        guess = (new Scanner(System.in)).nextInt();
    }

    // to check the input entered by the player
    public void checkInput() {
        if (guess == number) {
            running = false;
            guessAmount = 0;
        }

        if (guess < number) {
            System.out.println("the number is to small :(");
            guessAmount--;
            loadHangmanStages();
        }

        if (guess > number) {
            System.out.println("the number is to big :(");
            guessAmount--;
            loadHangmanStages();
        }
    }

    // to create a random number
    public void createNumber() {
        Random random = new Random();
        number = random.nextInt(100);
    }

    // to load the hangman stages from the HangmanStages.java
    public void loadHangmanStages() {
        switch (guessAmount) {
    		case 8:
    			hangmanStages.stage1();
    			break;
        	case 7:
        		hangmanStages.stage2();
        		break;
        	case 6:
        		hangmanStages.stage3();
        		break;
            case 5:
                hangmanStages.stage4();
                break;
            case 4:
                hangmanStages.stage5();
                break;
            case 3:
                hangmanStages.stage6();
                break;
            case 2:
                hangmanStages.stage7();
                break;
            case 1:
                hangmanStages.stage8();
                break;
            case 0:
                hangmanStages.stage9();
                break;
        }

    }

    // to show the number 
    public void showNumber() {
        System.out.println("the number was " + number);
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}