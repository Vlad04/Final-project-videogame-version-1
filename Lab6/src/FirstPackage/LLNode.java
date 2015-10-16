package FirstPackage;

/*
Made with the help of the book Object-Oriented Data Structures using Java (3ed edition)
*/
public class LLNode<T>{

	private LLNode link;							//private link of LLNode Type
	private T info;									//Information 

	
	public LLNode(){								//constructor of LLNode class
		this.info = null;							//info is null in the beginning
		link=null;									//initialize link to null
	}

	
	public LLNode(T info){							//second constructor that get an info like parameter
		this.info = info;							//this actual info is equal to info
		link = null;								//link is null
	}
	
	public void setInfo(T info){					//setInfo method to set the information of LLNode
	
		this.info = info;							//the actual info is equals to info
	}

	
	public T getInfo(){								//getInfo method that get the information of LLNode
	
		return info;
	}
	
	public void setLink(LLNode<T> link){			//setLink method that set the link of LLNode
	
		this.link = link;
	}

	
	public LLNode<T> getLink(){						//LLNode method that returns link to LLNode
	// Returns link of this LLNode.
		return link;
	}
}
