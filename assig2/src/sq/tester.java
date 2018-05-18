package sq;

public class tester {
	
	public static void main(String[] args){
	
	
		Stack<Integer> test = new Stack<Integer>();
		
		test.push(5);
		test.push(6);
		test.push(7);
		test.push(8);
		
		
		System.out.println("This is the stack from top to bottom");
		
		Client.printStack(test);
		
		Client.flipStack(test);
		
		System.out.println("This is the stack flipped");
		
		Client.printStack(test);
		
		
		
		int result = test.pop();

		
		System.out.println("popped: " + result);
		
		Client.printStack(test);
		
			
		
		
		
		
	
	
	
	
	}

}
