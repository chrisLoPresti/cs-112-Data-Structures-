package sizebst;


/**
 * Class SizeBST represents a Binary Search Tree that can also be used, for any integer j,
 *  to answer the question "how many numbers in the tree are less than or equal to j" in worst 
 *  case time h where h is the height of the tree (not the number of nodes).
 * 
 *  The actual nodes of the tree are of class SizeBSTN.  SizeBST represents the overall tree.
 *  IF instance variable rootNode is null, the tree is empty, otherwise rootNode is the root
 *  of the tree of SizeBSTN's
 * @author lou
 *
 */
public class SizeBST {
	SizeBSTN rootNode;

	public SizeBST(SizeBSTN root){
		rootNode =  root;
	}

	public String toString(){
		if (rootNode == null)
			return "(null)";
		else {
			return "("+ SizeBSTN.nodeString(rootNode) + ")";
		}
	}

	/**
	 * @param target the number to search for
	 * @return true iff target is in this tree
	 */
	public boolean search(int target){
		
		if(rootNode.data == target) {
			 
			 return true;
			 
		 }else if( target < rootNode.data){
			 
			 if(rootNode.LSubtree.data == null)
				 
				 return false;
			 else
			 
			return search(rootNode.LSubtree);
			 
		 }else {
			 
			 if(rootNode.RSubtree.data == null)
			 
				 return false;
			 
			 else
				 
			return search(rootNode.RSubtree);
			 
		 }

		return false; // replace this line
	}

	/**
	 * insert newData into tree;  if already there, do not change tree
	 * @param newData int to insert
	 */
	public void insert(int newData){
		
		if(rootNode.data == null) {
			 
			 rootNode = new SizeBSTN(null,newData,null);
			 
		 }else if( newData < rootNode.data){
			 
			 if(rootNode.LSubtree.data == null)
				 
				 rootNode.LSubtree = new SizeBSTN(null,newData,null);
			 else
			 
			return search(rootNode.LSubtree);
			 
		 }else {
			 
			 if(rootNode.RSubtree.data == null)
			 
				 return false;
			 
			 else
				 
			return search(rootNode.RSubtree);
			 
		 }

		return false;
		
	}

	/**
	 * @return returns how many numbers in the tree are less than or equal to target.  Returns -1 if tree is empty
	 * @param target
	 */
	public int numLEq(int target){
		return -1;  // replace this line
	}

	public static void main(String args []){
		SizeBST tree1 = new SizeBST(null);
		System.out.println("empty: "+tree1);
		tree1.insert(40);
		System.out.println("40 "+tree1);
		// add any test code you want here - this is not graded.  Just be sure it compiles
	}
}
