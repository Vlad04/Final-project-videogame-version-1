package FirstPackage;

public class Circle implements Comparable<Circle> {
	protected int Radio;									//Radio variable of int type, represents the radio of the Circle
	
	
	public Circle(int radio){							//Constructor of Circle class that get a radio as a parameter
		this.Radio = radio;								//initialize the value of the radio
	}
	
	
	public int perimeter(){								//perimeter method of int type
		return (int) (2*(3.1416)*Radio);				//returns the perimeter of the circle
	}
	
	
	public int area(){									//area method with empty parameters
		return (int) ((int)(3.1416)*(Math.pow(Radio,2)));								//returns the area of the circle
	}
	
	
	public String toString(){								//A toString method that returns the circle
		return "Circle with radio " + this.Radio + " cm";		//returns the circle with an specific radio
	}
	
	
	public boolean equals(Object object){					//Boolean method that check if the Object is equals
															//and get as parameter an object
		
		if(object!=null){									//If Object is different from null	
			if(object instanceof Circle){					//and then, if object is of type Circle (for this we use instanceof
															//to check that, and that is new for me, so I learn something new as
															//I said.	
				
				Circle square=(Circle)object;					//Then we create an object of Circle type.
				if(square.Radio==this.Radio){						//So, if the radio of the circle is equal to actual radio.	
							
					return true;								//returns true
				}
			}
		}
		return false;										//if not, returns false
	}
	
	
	public int compareTo(Circle circle) {					//compareTo method, that is focused in compare the Circle object.	
		if (this.Radio < circle.Radio) {						//If this actual radio is less than the radio of the radio.	
			return -1;										//returns a -1
		} else if(this.Radio == circle.Radio) {				//Else, if the actual radio is equal to the radio of the circle
			return 0;										//Then returns a 0
		}
		else{												//Else
			return 1;										//returns 1
		}
	}
}
																
							
														
