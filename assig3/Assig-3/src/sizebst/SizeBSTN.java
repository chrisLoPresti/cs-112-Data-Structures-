package sizebst;

/**
 * Instances of class SizeBSTN are Nodes of the Size Binary Search Tree 
 * @author lou
 *
 */
public class SizeBSTN {
	SizeBSTN LSubtree;  // left subtree of this tree (may be null)
	SizeBSTN RSubtree;  // right subtree of this tree (may be null)
	int data; // data at this node of the tree
	int size; // number of tree entries that are less than or equal to data
	
private int Leq;
	

/**
 * create a new leaf of the tree with the given data
 * @param data
 */
	public SizeBSTN(int data){
		LSubtree = null;
		RSubtree = null;
		this.data = data;
		size = 1;
	}
	
	/* see assignment for proper format for nodeString
	 */
	public static String nodeString(SizeBSTN node){
		
		if( node.data == null){
			
			return "null";
			
		}else {
			
			
			String output = "[" + "["+nodeString(node.LSubtree)+"]" + node.data +", "+ node.size + "[" + nodeString(node.RSubtree) +"]" +"]";  
			
			return output;
			
		}
		
		
		
	}
	
	/**
	 * search for the number target in the tree this node is the root of
	 * @param target number to search for
	 * @return either the node that holds target,
	 * if there is one, or the node which should point to the node that 
	 * will hold target if it is added now  
	 */
	public static SizeBSTN getNode(SizeBSTN node, int target){
	
		
		//might not need this 
		
		
		
		 if(node.data == target) {
			 
			 return node;
			 
		 }else if( target < node.data){
			 
			 if(node.LSubtree.data == null)
				 
				 return node;
			 else
			 
			return getNode(node.LSubtree);
			 
		 }else {
			 
			 if(node.RSubtree.data == null)
			 
				 return node;
			 
			 else
				 
			return getNode(node.RSubtree);
			 
		 }
	
	}
	
	/**
	 * like getNode but increments size fields as appropriate
	 * @param target number to search for
	 */
	public static void getNodeIncr(SizeBSTN node, int target){
		

		 if(node.data == target) {
			 
			 int count = 1; 
			 
			 SizeBSTN temp = node;
			 
			 while(!(temp.LSubtree.data == null)){
				 
				 count ++;
				 
				 temp = temp.LSubtree;
				 
			 }
			
			 node.size = count;
			  
		 }else if( target < node.data){
			 
			 getNode(node.LSubtree);
			 
		 }else {
			 
			 getNode(node.RSubtree);
 
			 
		 }
	}
	
	/**
	 * actually calculates number of numbers <= target.  
	 * Does search for target like getNode but adds up 
	 * the size fields of all nodes whose data is <= target.
	 * @return the number of nodes with data <= target in the
	 * tree this node is the root of.
	 */
	public static int sumNodesLeq(SizeBSTN node, int target){
		
		if(node.data == target) {
			
			Leq ++; 
			 
			 return Leq;
			 
		 }else if( target < node.data){
			 
			 if(node.data <= target){
				 
				 Leq++;
				 
			 }else if(node.LSubtree.data == null)
				 
				 return;
				 
			 else
			 
			 getNode(node.LSubtree);
			 
		 }else {
			 
			 if(node.data <= target){
				 
				 Leq++;
				 
			 }else if(node.RSubtree.data == null)
			 
				 return ;
			 
			 else
				 
			 getNode(node.RSubtree);
			 
		 }
		
		
	}	
}