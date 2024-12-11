import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random rand = new Random();
		int n = rand.nextInt(100);
		n += 1;
		int a = 0;
		System.out.println("I've got a between number between 1 and 100 on my mind.");
			
		while (a != n) {
		System.out.print("Make your guess: ");
			a = scanner.nextInt();
			
			if(a < 1 || a > 100) {
				System.out.println("That's not how it works. Pick a number between 1 and 100!");
			} else {
			
				if(a == n) {
					System.out.println("You guessed right. Congratulations!");
					System.exit(0);
				} else if(a > n) {
					System.out.println("Your number is bigger than mine");
				} else {
					System.out.println("Your number is smaller than mine");
				}
		
			}
		}
		scanner.close();
	}
}	
	
