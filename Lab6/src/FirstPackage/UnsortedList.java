package FirstPackage;

public class UnsortedList<T> implements UnsortedListInterface<T>{
	protected T[] list;
	protected final int capacity = 100;
	protected int original_capacity;
	protected int number_of_elements = 0;
	protected int current_position;
	
	protected boolean found;
	protected int location;

	public UnsortedList(int originCap) {
		this.list = (T[]) new Object [originCap];
		this.original_capacity = originCap;
	}
	
	public UnsortedList() {
		this.list = (T[]) new Object [this.capacity];
		this.original_capacity = this.capacity;
	}
	
	private void enLarge(){
		
		T[] larger = (T[]) new Object [list.length + this.original_capacity];
		for (int i = 0; i < number_of_elements; i++) {
			larger[i] = this.list[i];
		}
		
		this.list = larger;
	}
	
	@Override
	public void find(T target) {
		//Searches list for an occurrence of an element such that 	
		//e.equals(target). If successful, sets instance variables
		//found to true, location to node containing, and previous to the node that
		//links to location. If not successful, sets found to false.
		this.location = 0;
		this.found = false;
		
		while (location < number_of_elements) {
			if (this.list[location].equals(target)) {
				this.found = true;
				return;
			} else {
				location++;
			}
		}
	}
	
	@Override
	public void add(T commonCard) {
		// Adds elements to the list.
		if (number_of_elements == list.length) {
			enLarge();
		}
		list[number_of_elements] = commonCard;
		number_of_elements++;
	}

	@Override
	public int size() {
		// Returns the number of elements on this list.
		return number_of_elements;
	}

	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}

	@Override
	public boolean remove(T element) {
		//Removes an element from this list such that e.equals(element).
		//and returns true; if no such element exits, returns false.
		this.find(element);
		if (found) {
			list[location] = list[number_of_elements-1];
			list[number_of_elements-1] = null;
			number_of_elements--;
		}
		return found;
	}

	@Override
	public T get(T element) {
		// Returns an element e from this list such that e.equals(element);
		// if no such element exists, returns null.
		find(element);
		if (found) {
			return list[location];
		}
		else {
			return null;
		}
	}
	
	public String toString(){
		//returns a nicely formatted string that represents this list.
		String listString = "list:\n";
		for (int i = 0; i < number_of_elements; i++) {
			listString = listString + " " + list[i] + "\n";
		}
		return listString;
	}
	
	public void reset() {
		current_position = 0;
		
	}

	@Override
	public T getNext() {
		//PRECONDITION: The list is NOT empty.
		//				The list has been reset.
		//The list has not been modified since the most recent reset.
		//Returns the element at the current position on this list.
		//If the current position is the last element, then it advances the value of 
		//the current position to the first element; otherwise, it advances the value 
		//of the current position to the next element.
		T next = list[current_position];
		if (current_position==(number_of_elements-1)) {
			current_position=0;
		} else {
			current_position++;
		}
		return next;
	}

	

}
