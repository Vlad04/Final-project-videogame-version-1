package FirstPackage;


import java.lang.Character.UnicodeBlock;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

	public static void main(String[] args) {
		System.out.println("Welcome to my unboundedlist proyect. \n");
		System.out.println("You have the options to manipulate 2 diferent lists. \n");
		System.out.println("The first one is a list if cards and the second a list of squares. \n");
		System.out.println("The first one is a list if cards and the second a list of squares. \n");
		System.out.println("You have the options to add, remove and count the number of items on every list. \n");
		
		UnsortedList<Square> UnsortedCardList = new UnsortedList<Square>();
		UnsortedList<Square> UnsortedSquareList = new UnsortedList<Square>();
		Scanner sc = new Scanner(System.in);
		boolean open = true;
		
		do {
			try {
				System.out.println("Please select an option. \n");
				System.out.printf("%-10s %10s %n", "[1]", "Add a random value to the a list of cards");
				System.out.printf("%-10s %10s %n", "[2]", "Add a value the a list of Squares");
				System.out.printf("%-10s %10s %n", "[3]", "remove a value the list of cards");
				System.out.printf("%-10s %10s %n", "[4]", "remove a value the list of Squares");
				System.out.printf("%-10s %10s %n", "[5]", "Show the number of elements of the list of cards");
				System.out.printf("%-10s %10s %n", "[6]", "Show the number of elements of the list of squares\n");
				System.out.printf("%-10s %10s %n", "[9]", "Closes the program");

				int options = sc.nextInt();

				switch (options) {
				case 1:
					Card commonCard = new Card();
					UnsortedCardList.add(commonCard);
					System.out.println("Random card added to the list.");
					System.out.println("**" + commonCard + "**");
					break;
				case 2:
					Square commonSquare = null;
					int sideLength = 0;
					do {
						try {
							System.out.println("Input the length for the side of the square");
							sideLength = sc.nextInt();
							commonSquare = new Square(sideLength);
						} catch (InputMismatchException e) {
							System.err.println("Please enter a number");
						}
						sc.nextLine();
					} while (sideLength <= 0);
					UnsortedSquareList.add(commonSquare);
					System.out.println("Square added to the list.");
					System.out.println("**" + commonSquare + "**");
					break;
				case 3:
					int cardRank = 0, cardSuit = 0;
					do {
						try {
							System.out.println("Input the rank of the card.\n");
							cardRank = sc.nextInt();

						} catch (InputMismatchException e) {
							System.err.println("The card rank is invalid.");
						}
						sc.nextLine();
					} while (cardRank<=0 || cardRank>13);
					do {
						try {
							System.out.println("Input the Suit of the card.\n[1]clubs\n[2]diamonts\n[3]hearths\n[4]spades");
							cardSuit = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("The card suit is invalid.");
						}
						sc.nextLine();
					} while (cardSuit <=0 || cardSuit>4);
					if (UnsortedCardList.remove(new Card(cardRank,cardSuit))) {
						System.out.println("Card \"" + new Card(cardRank,cardSuit) + "\" REMOVED");
					} else {
						System.out.println("Card \"" + new Card(cardRank,cardSuit) + "\" NOT FOUND");

					}
					break;
					
				case 4:
					sideLength = 0;
					do {
						try {
							System.out.println("Enter the size of the square you want to remove from the list.");
							sideLength = sc.nextInt();

						} catch (InputMismatchException e) {
							System.err.println("Please enter a number");
						}
						sc.nextLine();
					} while (sideLength <= 0);
					if (UnsortedSquareList.remove(new Square(sideLength))) {
						System.out.println("object \"Square\" REMOVED");
					}
					else {
						System.out.println("Object \"Square\" NOT FOUND");
					}
					break;
				case 5:
					System.out.println(UnsortedCardList);
					System.out.println("The number of elements in this list is " + UnsortedCardList.size()+"\n");
					break;
				case 6:
					System.out.println(UnsortedSquareList);
					System.out.println("The number of elements in this list is " + UnsortedSquareList.size()+"\n");
					break;
				case 9:
					System.out.println("See you later :)");
					open = false;
					break;
				}
			} catch (InputMismatchException e) {
				System.err.println("Inconrrect input\n");
			} 
			sc.nextLine();
		} while (open);
		sc.close();
	}

}
