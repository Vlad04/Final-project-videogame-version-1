package FirstPackage;

//import UnsortedListL.LLNode;

public class UnsortedListL<T> implements UnsortedListInterface<T>{
	protected int numElements;
	protected LLNode<T> currentPos;
	
	protected boolean found;
	protected LLNode<T> location;
	protected LLNode<T> previous;
	
	protected LLNode<T> list;

	
	public UnsortedListL(){
		this.numElements=0;
		list = null;
		currentPos=null;
	}
	
	//pre: an object of any kind.
	//pos: an object in the linked list.
	public void add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numElements++;
	}

	//pre: an object of any kind.
	//pos: modifies the variable found.
	public void find(T target) {
		this.location = list;
		this.found = false;
		
		while (location != null) {
			if (location.getInfo().equals(target)) {
				this.found = true;
				return;
			}
			else{
				this.previous = this.location;
				this.location = this.location.getLink();
			}
		}
	}
	
	//pre: none.
	//pos: returns the number of elements in the liked list.
	public int size() {
		return this.numElements;
	}
	
	//pre: any object.
	//pos: returns true if a the object is in the link.
	public boolean contains(T element) {
		this.find(element);
		return found;
	}

	//pre: any object.
	//pos: returns true if the object is listed and removes it.
	public boolean remove(T element) {
		this.find(element);
		if (this.found) {
			if (this.list == this.location) {
				this.list = this.list.getLink();
			}
			else{
				this.previous.setLink(location.getLink());
			}
			this.numElements--;
		}
		return found;
	}
	
	//pre: any object.
	//pos: returns the object if is linked.
	public T get(T element) {
		this.find(element);
		if (found) {
			return this.location.getInfo();
		}
		else{
			return null;
		}
	}
	//pre: none.
	//pos: returns a string with the elements in the list.
	public String toString(){
		LLNode<T> currNode = list;
		String listString = "List:\n";
		
		while (currNode != null) {
			listString = listString + " " + currNode.getInfo() + "\n";
			currNode = currNode.getLink();
			
		}
		return listString;
	}
	
	
	//pre: none.
	//pos: returns the current position to 0.
	public void reset() {
		
		this.currentPos = this.list;
		
	}

	//pre: none.
	//pos: modifyes the position in the list.
	public T getNext() {
		T next = this.currentPos.getInfo();
		if (this.currentPos.getLink() == null) {
			this.currentPos = list;
		}
		else{
			this.currentPos = this.currentPos.getLink();
		}
		return next;
	}

}
