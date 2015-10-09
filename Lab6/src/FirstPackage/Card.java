package FirstPackage;

import java.util.Random;

public class Card implements Comparable<Card>{
	private int rank,suit;								//rank and suit of the card
	private final int max_Suit = 4;						//maximum of possible suit is 4
	private final int min_Suit = 1;						//minimum of possible suit is 1
	private final int max_Rank = 13;					//maximum of possible rank is 13
	private final int min_Rank = 1;						//minimum of possible rank is 1
	
	
	public Card(){										//constructor of Card class
		Random rand = new Random();						//create a new random type named rand.
		this.rank = rand.nextInt(max_Rank-min_Rank+1)+min_Rank;			//the value of this rank will be between 1 and 13
		this.suit= rand.nextInt(max_Suit-min_Suit+1)+min_Suit;			//the value of this suit will be between 1 and 4
	}
	
	public Card(int rank, int suit){					//second constructor of Card class that expects a rank and suit (integers)
		this.rank = rank;								//as parameters. Initialize rank and suit.
		this.suit = suit;
	}

	
	public String toString(){							//a toString method with empty parameters that have two empty strings.
		String myString = "";							//myString and myString2
		String myString2 = "";
		
		switch(this.rank){								//conditional selection to rank
		case 1:											//In case 1 my String is Ace
			myString= "Ace";							//Then break
			break;
		case 2:
			myString= "Two";							//In case 2 my String is Two
			break;										//Then break
		case 3:
			myString= "Three";							//In case 3 my String is Three
			break;										//Then break
		case 4:
			myString="Four";							//In case 4 my String is Four
			break;										//Then break
		case 5:
			myString= "Five";							//In case 5 my String is Five
			break;										//Then break
		case 6:
			myString= "Six";							//In case 6 my String is Six
			break;										//Then break
		case 7:
			myString= "Seven";							//In case 7 my String is Seven
			break;										//Then break
		case 8:
			myString= "Eight";							//In case 8 my String is Eight
			break;										//Then break
		case 9:
			myString= "Nine";							//In case 9 my String is Nine
			break;										//Then break
		case 10:
			myString= "Ten";							//In case 10 my String is Ten
			break;										//Then break
		case 11:
			myString= "Jack";							//In case 11 my String is Jack
			break;										//Then break
		case 12:
			myString= "Queen";							//In case 12 my String is Queen
			break;										//Then break
		case 13:
			myString= "King";							//In case 13 my String is Ace
			break;										//Then break
		}

		switch(suit){									//conditional selection to suit
		case 1:													
			myString2= "Clubs";							//In case 1 my String2 is Clubs
			break;										//Then break
		case 2:
			myString2= "Diamonds";						//In case 2 my String2 is Diamonds
			break;										//Then break
		case 3:
			myString2= "Hearts";						//In case 3 my String2 is Hearts
			break;										//Then break
		case 4:
			myString2= "Spades";						//In case 4 my String2 is Spades
			break;										//Then break
		}
		return myString + " of "+ myString2;			//return the name of the card.
	}
	
	public boolean equals(Object object){				//Boolean method that check if the Object is equals
														//and get as parameter an object
		
		if (object != null) {							//If Object is different from null								
			if (object instanceof Card) {				//and then, if object is of type Card (for this we use instanceof
														//to check that, and that is new for me, so I learn something new.
				
				Card card = (Card) object;				//Then we create an object of Card type.
				
				if (this.rank== card.rank  && this.suit==card.suit) {		//So, if the actual rank is equal to the rank of the	
																		//card AND the actual suit is equal to the suit of the
																		//card.
					return true;										//Then return true	
				}
			}
		}
		return false;													//If not, so return false
	}
	
	public int compareTo(Card card) {							//compareTo method, that is focused in compare the card object.	
		if (this.rank < card.rank) {							//If this actual rank is less than the rank of the card.	
			return -1;											//returns a -1
		} else if(this.rank == card.rank){						//Else, if the actual rank is equal to the rank of the card
			return 0;											//Returns 0
		} else {												//Else, finally
			return 1;											//returns 1
		}
	}
}
