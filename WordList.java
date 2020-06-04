package akoshkarova.hw2;


/**
 * Once you copy this file into your USERID.hw2 package, you must complete this implementation.
 * 
 * This class will be used by Question Q1 on Homework2.
 */
public class WordList {
	Node first=null;
	int n=0;
	/** 
	 * Leave this Node class as is. While you don't need to make changes to this class,
	 * it is acceptable if you would like to add methods to this class.
	 */
	class Node {
		String     word;
		Node       next;

		Node(String w) {
			this.word = w;
			//this.next=null;
		}
	}
	
//	WordList(){
//		this.first=new Node (null);
//		
//	}


	/**
	 * If the given element doesn't exist in the set then update 
	 * the set and return true; otherwise return false. This means that
	 * adding a duplicate element to a set must return false.
	 * 
	 * @param elt      element to be added.
	 * 
	 */
	public boolean add(String elt) {
		/*
		 * if (contains(elt)==false) {
			Node new_node = new Node(elt); 	
		    if (head == null) 
		    { 
		        head = new Node(elt);
		        return true;
		    } 
		    new_node.next = null; 
		    Node last = head;  
		    while (last.next != null) 
		        last = last.next; 
		    last.next = new_node; 
		    return true; 
		}
		 */
		if (contains(elt)) {
			return false;
			} 
		else if (first == null) {
			first = new Node(elt);
			n = 1;
			return true;
			}
		Node oldFirst = first;
		first=new Node(null);
		first.word=elt;
		first.next=oldFirst;
		n++;
		return true;
		}

	/** Returns the number of elements in the set. */ 
	public int size() {
		return n;
	}

	/**
	 * Returns true if the given element was in the set (and was removed) or 
	 * false if the given element did not belong to the set.
	 * @param elt      element to be removed.
	 */
	public boolean remove (String elt) {
//		Node currentRemove=first;
//		Node previousRemove=null;
		
		
		/*
		 * if(currentRemove!=null && currentRemove.word==elt) {
			first=currentRemove.next;
			n--;
			return true;
		}
		while(currentRemove!=null && currentRemove.word!=elt) {
			previousRemove=currentRemove;
			currentRemove=currentRemove.next;
		}
		if(currentRemove==null) {
			return false;
		}
		previousRemove.next=currentRemove.next;
		n--;
		return true;
		 */
//		if (first==null) {
//			return false;
//		}
//		if(contains(elt)) {
//			while(currentRemove.word!=elt && currentRemove!=null) {
//				previousRemove=currentRemove;
//				currentRemove=currentRemove.next;
//			}
//			if (previousRemove==null) {
//				first=currentRemove.next;
//			}
//			else {
//				first.next=currentRemove.next;
//				
//			}
//			n--;
//			return true;
//				
//		
//		}
//		else
//			return false;
//		
		boolean result = false;

        if (first == null || first.word == "") {

               return false;

        } else {Node prev = null;

               Node after = first;
               if (after != null && after.word.contentEquals(elt)) {
                     first = after.next;
                     n--;
                     return true;
               }
               while (after != null && !after.word.contentEquals(elt)) {
                     prev = after;
                     after = after.next;
               }
               if (after == null) {
                     return false;
               }
               prev.next = after.next;
               n--;
               result = true;
        }
        return result;
	}

	/**
	 * Returns true if the element exists within the collection.
	 * @param elt      target element to be searched.
	 */
	public boolean contains(String elt) {
		String searchWord;
		for (Node currNode=first; currNode!=null; currNode=currNode.next) {
			searchWord=currNode.word;
			if(searchWord.equals(elt)) {
				return true;
				}
		}
		return false;		
	}

	/** For debugging, return comma-separated string of elements. */
	public String elements() {
		String elements="";
		Node tempNode=first;
		if(tempNode==null){
			return elements;
			}
//		for (int j=1; j<=n; j++) {
//			elements=first.word;
//			if(j<n) {
//				elements=elements+",";
//			}
//		}
		elements=tempNode.word;
		tempNode=tempNode.next;
		
//		for(Node tempNode=tempNode.next;tempNode.next !=null; tempNode=tempNode.next.next) {
//			elements=elements+","+tempNode.next.word;
//			
//		}
		while(tempNode !=null) {
			elements=elements+","+tempNode.word;
			tempNode=tempNode.next;
		}
		return elements;
	}

	// you should not have to modify anything below. These are testing routines for you to check your work.
	// ----------------------------------------------------------------------------------------------------
	static void validate(Object o1, Object o2) {
		if (o1.equals(o2)) { return; }
		throw new RuntimeException(o1 + " doesn't equal " + o2);
	}

	// Once you have completed the implementation, you should be able to run this method and have
	// it complete without any runtime exceptions. While not an exhaustive test, this should be 
	// sufficient to help you uncover many of the boundary cases.
	public static void main(String[] args) {

		WordList wl = new WordList();
		validate(0, wl.size());
		validate("", wl.elements());           // empty word list must return ""
		validate(false, wl.contains("this"));
		validate(true, wl.add("test"));
		validate("test", wl.elements());       // no trailing or pre comma.
		validate(false, wl.contains("this"));
		validate(true, wl.contains("test"));

		validate(false, wl.add("test"));       // can't add twice
		validate(true, wl.remove("test"));     // can remove first element
		validate(false, wl.remove("test"));    // can't remove first empty
		validate(true, wl.add("test"));
		validate(true, wl.add("that"));
		validate(false, wl.remove("not"));
		validate(true, wl.remove("test"));
		validate("that", wl.elements());       // no trailing or pre comma.
		validate(true, wl.remove("that"));
	} 
}
