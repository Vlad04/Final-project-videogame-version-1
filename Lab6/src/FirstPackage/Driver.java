package FirstPackage;
import  java.io.BufferedReader;
import  java.io.IOException;
import  java.io.InputStreamReader;


import java.lang.Character.UnicodeBlock;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Driver {

	//Menu options
		
		public static void main(String[]args) throws Exception{
			//Init 
		    InputStreamReader isr = new  InputStreamReader (System.in);
		    BufferedReader br = new BufferedReader(isr);
		 
		   //Welcome message
		    System.out.println("HI, Please write your name");
		    String name_player = br.readLine();
		    System.out.println("Hello "+name_player);
		    
		    
		
		    UnsortedList<Card> UnsortedCardList = new UnsortedList<Card>();
		    UnsortedList<Circle> UnsortedCircleList = new UnsortedList<Circle>();
		    Scanner sc = new Scanner(System.in);
		    boolean open = true;
		
		do {
			try {
				
				 System.out.println("Please, chose one option");
			        System.out.println("1) Add a random value to the list of Cards.");
			        System.out.println("2) Add a value to the list of Circles");
			        System.out.println("3) Remove a value of the list of Cards.");
			        System.out.println("4) Remove a value of the list of Circles");
			        System.out.println("5) Show the number of elements of the list of Cards");
			        System.out.println("6) Show the number of elements of the list of Circles");
			        System.out.println("7) Exit");

				int options = sc.nextInt();
				
				
				switch (options) {
				case 1:
					Card my_Card = new Card();
					UnsortedCardList.add(my_Card);
					System.out.println("Random card was added to the list.");
					System.out.println("--" + my_Card + "--");
					break;
				case 2:
					Circle my_Circle = null;
					int circle_radio = 0;
					do {
						try {
							System.out.println("Input the length for the radio of the Circle");
							circle_radio = sc.nextInt();
							my_Circle = new Circle(circle_radio);
						} catch (InputMismatchException e) {
							System.err.println("Please write a number");
						}
						sc.nextLine();
					} while (circle_radio <= 0);
					UnsortedCircleList.add(my_Circle);
					System.out.println("Circle added to the list.");
					System.out.println("--" + my_Circle + "--");
					break;
				case 3:
					int cardRank = 0, cardSuit = 0;
					do {
						try {
							System.out.println("Input the rank of the card.\n");
							cardRank = sc.nextInt();

						} catch (InputMismatchException e) {
							System.err.println("The card rank is no valid.");
						}
						sc.nextLine();
					} while (cardRank<=0 || cardRank>13);
					do {
						try {
							System.out.println("Input the Suit of the card.\n1)clubs\n2)diamonts\n3)hearths\n4)spades");
							cardSuit = sc.nextInt();
						} catch (InputMismatchException e) {
							System.err.println("The card suit is no valid.");
						}
						sc.nextLine();
					} while (cardSuit <=0 || cardSuit>4);
					if (UnsortedCardList.remove(new Card(cardRank,cardSuit))) {
						System.out.println("Card \"" + new Card(cardRank,cardSuit) + "\" removed");
					} else {
						System.out.println("Card \"" + new Card(cardRank,cardSuit) + "\" removed");

					}
					break;
					
				case 4:
					circle_radio = 0;
					do {
						try {
							System.out.println("Enter the radio of the Circle you want to remove from the list.");
							circle_radio = sc.nextInt();

						} catch (InputMismatchException e) {
							System.err.println("Please write a number");
						}
						sc.nextLine();
					} while (circle_radio <= 0);
					if (UnsortedCircleList.remove(new Circle(circle_radio))) {
						System.out.println("object \"Circle\" removed");
					}
					else {
						System.out.println("Object \"Circle\" removed");
					}
					break;
				case 5:
					System.out.println(UnsortedCardList);
					System.out.println("The number of elements in this list is " + UnsortedCardList.size()+"\n");
					break;
				case 6:
					System.out.println(UnsortedCircleList);
					System.out.println("The number of elements in this list is " + UnsortedCircleList.size()+"\n");
					break;
				case 7:
					System.out.println("Good bye");
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
