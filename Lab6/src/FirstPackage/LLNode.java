package FirstPackage;


public class LLNode<T>{
	
	private LLNode<T> link;			
	private T info;					//Variable named "info" of type T.
  
	public LLNode(T info){			//Constructor where we initialize the information and the link.
    
		this.info = info;
		link = null;
	
	}
 
	public void setInfo(T info){		//Set the information of this node.
		
		this.info = info;
	}

	public T getInfo(){				//Get the information of this node.
		
		return info;
	}
 
	public void setLink(LLNode<T> link){	//Set the link of this node.
  
		this.link = link;
	}

	public LLNode<T> getLink(){		//Return the link of this node.
		
		return link;
	}
}