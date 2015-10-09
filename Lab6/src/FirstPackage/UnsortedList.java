package FirstPackage;

public class UnsortedList<T> implements UnsortedListInterface<T>{
	protected T[] list;
	protected final int defCap = 100;
	protected int originCap;
	protected int numElements = 0;
	protected int currentPos;
	
	protected boolean found;
	protected int location;

	public UnsortedList(int originCap) {
		this.list = (T[]) new Object [originCap];
		this.originCap = originCap;
	}
	
	public UnsortedList() {
		this.list = (T[]) new Object [this.defCap];
		this.originCap = this.defCap;
	}
	
	private void enLarge(){
		// increments the capacity of the list by an amount
		// equal to the original capacity.
		T[] larger = (T[]) new Object [list.length + this.originCap];
		for (int i = 0; i < numElements; i++) {
			larger[i] = this.list[i];
		}
		
		this.list = larger;
	}
	
	@Override
	public void find(T target) {
		// searches list for an occurrence of an element e such that
		// e.equals(target). If successful, sets instance variables
		// found to true and location to the array index of e. If not
		// successful, set found to false.
		this.location = 0;
		this.found = false;
		
		while (location < numElements) {
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
		if (numElements == list.length) {
			enLarge();
		}
		list[numElements] = commonCard;
		numElements++;
	}

	@Override
	public int size() {
		// Returns the number of elements on this list.
		return numElements;
	}

	@Override
	public boolean contains(T element) {
		find(element);
		return found;
	}

	@Override
	public boolean remove(T element) {
		// Removes an element e fron this list such that e.equals(element)
		// and returns true; if no such element exists, return false
		this.find(element);
		if (found) {
			list[location] = list[numElements-1];
			list[numElements-1] = null;
			numElements--;
		}
		return found;
	}

	@Override
	public T get(T element) {
		// Returns an element e fron this list such that e.equals(element);
		// if no such element exists, return null.
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
		for (int i = 0; i < numElements; i++) {
			listString = listString + " " + list[i] + "\n";
		}
		return listString;
	}
	
	public void reset() {
		currentPos = 0;
		
	}

	@Override
	public T getNext() {
		
		T next = list[currentPos];
		if (currentPos==(numElements-1)) {
			currentPos=0;
		} else {
			currentPos++;
		}
		return next;
	}

	public void add(Card commonCard) {
		// TODO Auto-generated method stub
		
	}

	public boolean remove(Card card) {
		// TODO Auto-generated method stub
		return false;
	}

}
