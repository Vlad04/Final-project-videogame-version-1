package FirstPackage;

public class Square implements Comparable<Square> {
	protected int Side;									//Side variable of int type, represents the sides of the Square
	
	
	public Square(int side){							//Constructor of Square class that get a side as a parameter
		this.Side = side;								//initialize the value of the Side
	}
	
	
	public int perimeter(){								//perimeter method of int type
		return Side*4;									//returns the perimeter of the square
	}
	
	
	public int area(){									//area method with empty parameters
		return Side*Side;								//returns the area of the square
	}
	
	
	public String toString(){								//A toString method that returns the square
		return "Square with size " + this.Side + " cm";		//returns the square with an specific size
	}
	
	
	public boolean equals(Object object){					//Boolean method that check if the Object is equals
															//and get as parameter an object
		
		if(object!=null){									//If Object is different from null	
			if(object instanceof Square){					//and then, if object is of type Square (for this we use instanceof
															//to check that, and that is new for me, so I learn something new as
															//I said.	
				
				Square square=(Square)object;					//Then we create an object of Square type.
				if(square.Side==this.Side){						//So, if the side of the square is equal to actual side.	
							
					return true;								//returns true
				}
			}
		}
		return false;										//if not, returns false
	}
	
	
	public int compareTo(Square square) {					//compareTo method, that is focused in compare the square object.	
		if (this.Side < square.Side) {						//If this actual side is less than the side of the square.	
			return -1;										//returns a -1
		} else if(this.Side == square.Side) {				//Else, if the actual side is equal to the side of the square
			return 0;										//Then returns a 0
		}
		else{												//Else
			return 1;										//returns 1
		}
	}
}
																
							
														
