package FirstPackage;

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
	
	public void add(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		newNode.setLink(list);
		list = newNode;
		numElements++;
	}

	@Override
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
		return this.numElements;
	}

	public boolean contains(T element) {
		this.find(element);
		return found;
	}

	@Override
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
	
	
	@Override
	public void reset() {
		
		this.currentPos = this.list;
		
	}

	@Override
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
