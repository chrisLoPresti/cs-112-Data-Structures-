package sq;

public class Queue<T> {

	private CLL<T> queue;  // the circular linked list that
	//                        represents the queue
	
	// constructor - new Queue( ) returns a
	// reference to an empty Queue
	public Queue( ){
	    
		this.queue = new CLL<T>();
	    
	}
	
	public void enqueue(T data){
	    
		queue.addAtRear(data);
	    
	}
	public T dequeue( ){
		
		if(queue.isEmpty()){
			
			return null;
		}
	    
		T result = queue.removeFront();
	    
		return result;
	}
	
	public boolean isEmpty( ){
	    
		if(queue.isEmpty() == false){
			
			return false;
			
		}else{
			
			return true;
		}
	    
	}	
}