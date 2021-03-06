package sq;

public class Client<T>{

    // prints the contents of stack of Integers s, in
    // top-to-bottom order. This mthod may change s
    // temporarily, but by the time it exits, s must be
    // set back to the contens it had when printStack was
    // called.
	public static void printStack(Stack<Integer> s){
		
		if(s.isEmpty()){
			
			System.out.println("The stack is empty");
			
			return;
		}
	    
		Stack<Integer> temp = new Stack<Integer>();
		
		while(!(s.isEmpty())){
			
			int tempInt = s.pop();
			
			System.out.println(tempInt +"");
			
			temp.push(tempInt);
			
			
				
		}
		
		
		while(!(temp.isEmpty())){
			
			s.push(temp.pop());
					
		}
		
	
		
	}

    // this method reverses the order of the items in the
    // stack.  What was the top Integer becomes the bottom,
    // next-to-top become next-to-bottom, etc.
	public static void flipStack(Stack<Integer> s){
		
		if(s.isEmpty()){
			
			System.out.println("The stack is empty");
			
			return;
		}
		
		Queue<Integer> temp = new Queue<Integer>();
		
		while(!(s.isEmpty())){
			
			temp.enqueue(s.pop());	
			
		}
		
		while(!(temp.isEmpty())){
			
			s.push(temp.dequeue());
			
			
		}
	  
	    
	}
}