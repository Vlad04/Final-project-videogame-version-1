package FirstPackage;

/*
Made with the help of the book Object-Oriented Data Structures using Java (3ed edition)
*/
public class LLNode<T>{

	private LLNode link;
	private T info;

	//Pre: None
	//Post: None
	public LLNode(){
		this.info = null;
		link=null;
	}

	//None
	//this.info equals to info
	public LLNode(T info){
		this.info = info;
		link = null;
	}
	//Pre: None
	//Post: Set infor of this LLNode
	public void setInfo(T info){
	// Sets info of this LLNode.
		this.info = info;
	}

	//Pre: None
	//Post: Return the info of the link
	public T getInfo(){
	// Returns info of this LLONode.
		return info;
	}
	//Pre: None
	//Post: Sets link of this LLNode.
	public void setLink(LLNode<T> link){
	// Sets link of this LLNode.
		this.link = link;
	}

	//Pre: None
	//Post: Returns link of this LLNode.
	public LLNode<T> getLink(){
	// Returns link of this LLNode.
		return link;
	}
}
