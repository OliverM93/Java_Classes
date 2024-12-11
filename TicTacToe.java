import java.util.Scanner;

public class TicTacToe {
	public static int row, col;
	public static Scanner scan = new Scanner(System.in);
	public static char[][] board = new char[3][3];
	public static char turn = 'X';
	public static int count = 0;
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
		
		Play();
		//PrintBoard();
	}
	
	public static void Play() {
		boolean playing = true;
		PrintBoard();
		while(playing) {
			System.out.print("\nType in the Location of your sign, Player " + turn);
			System.out.println();
			row = scan.nextInt() - 1;
			col = scan.nextInt() - 1;
			
				//Out Of Bounds Zahlenangaben abfangen und Schleife wiederholen
			if(row >= 3 || col >= 3 || row < 0 || col < 0) {
				System.out.println("Invalid Numbers. They have to be between 1 and 3");
				continue;
			}	
				//Falls Feld besetzt ist --> Schleife wiederholen
			if(board[row][col] != '_') {
				System.out.println("There's already a sign. Try again, Player " + turn);
				continue;
			}	
			
			board[row][col] = turn;
			
			PrintBoard();
			
			if (GameOver(row, col)) {
				playing = false;
				System.out.println("Game over! Player " + turn + " wins!");
				break;
			}
			
			if (GameOver()) {
				playing = false;
				System.out.println("Game over! The Board is full and nobody won!");
			}
			
			if(turn == 'X') {
				turn = 'O';
			} else {
				turn = 'X';
			}
			count += 1;
		}
	}
	
	
	public static void PrintBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.print(" | ");
			for(int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}
	
	public static boolean GameOver(int rMove, int cMove) {
		 // check straight victory
		if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove]) { //column victory
			return true;
		}
		if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2]) { //row victory
			return true;
		}
		 // check diagonal victory
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[1][1] != '_') {
			return true;
		}
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_') {
			return true;
		}
		return false;
		}
	
	public static boolean GameOver() {
		if(count == 8) {
			return true;
		} else {
			return false;
		}
	}
	
	}
