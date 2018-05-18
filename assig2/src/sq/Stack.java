package sq;

public class Stack<T>{
    
	private CLL<T> stack;  // the circular llinked list that
	//                        reqresents the stack

	// constructor - new Stack( ) returns a
	// reference to an empty Stack	
	public Stack( ){
	    
		this.stack = new CLL<T>();
	
	
	}
	
	public void push(T data){
		
		stack.addAtRear(data);

	
	}
	
	
	
	
	public T pop( ){
		
	if(stack.isEmpty()){
			
		return null;
	}
		
	CLL<T> temp = new CLL<T>();
	
	while(!(stack.isEmpty())){
		
		temp.addAtFront(stack.removeFront());
			
	}
	
	T data = temp.removeFront();
	
	while(!(temp.isEmpty())){
		
		stack.addAtFront(temp.removeFront());
			
	}
	
	return data;
  
	}
	
	
	
	
	public boolean isEmpty( ){
	   
		if(stack.isEmpty() == false){
			
			return false;
			
		}else{
			
		return true;
		}
	    
	}
}