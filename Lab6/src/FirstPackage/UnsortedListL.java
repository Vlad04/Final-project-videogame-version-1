package FirstPackage;

//import UnsortedListL.LLNode;

public class UnsortedListL<T> implements UnsortedListInterface<T>{
	protected int number_of_elements;							//number of elements in the list
	protected LLNode<T> current_position;						//current position in the list
	
	protected boolean found;									 
	protected LLNode<T> location;							
	protected LLNode<T> previous;
	
	protected LLNode<T> list;

	
	public UnsortedListL(){										//constructor of UnsortedListL class
		this.number_of_elements=0;								//number of elements equals to 0
		list = null;											//initialize list with null
		current_position=null;									//initialize current position with null
	}
	
	public void add(T element) {								//Adds elements to the list with help of Nodes (help from book).		
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		number_of_elements++;
	}

	
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
	
	
	public int size() {
		return this.number_of_elements;
	}
	
	
	public boolean contains(T element) {
		this.find(element);
		return found;
	}

	
	public boolean remove(T element) {
		this.find(element);
		if (this.found) {
			if (this.list == this.location) {
				this.list = this.list.getLink();
			}
			else{
				this.previous.setLink(location.getLink());
			}
			this.number_of_elements--;
		}
		return found;
	}
	
	
	public T get(T element) {
		this.find(element);
		if (found) {
			return this.location.getInfo();
		}
		else{
			return null;
		}
	}
	
	public String toString(){
		LLNode<T> currNode = list;
		String listString = "List:\n";
		
		while (currNode != null) {
			listString = listString + " " + currNode.getInfo() + "\n";
			currNode = currNode.getLink();
			
		}
		return listString;
	}
	
	
	
	public void reset() {
		
		this.current_position = this.list;
		
	}

	
	public T getNext() {
		T next = this.current_position.getInfo();
		if (this.current_position.getLink() == null) {
			this.current_position = list;
		}
		else{
			this.current_position = this.current_position.getLink();
		}
		return next;
	}

}
