class Node{
	private int data;
	private Node nextNode;

	Node(int data){
		this.data = data;
		nextNode = null;
	}

	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return data;
	}

	public void setNextNode(Node nextNode){
		this.nextNode = nextNode;
	}

	public Node getNextNode(){
		return nextNode;
	}
}

public class SingleLinkedList{
	private static Node head;

	SingleLinkedList(){
		head = null;
	}

	public static void insertAtFirst(int data){
		Node temp = new Node(data);
		if(head==null) head = temp;
		else{
			temp.setNextNode(head);
			head = temp;
		}
	}

	public static void insertAtLast(int data){
		Node temp = new Node(data);
		if(head==null) head = temp;
		else {
			Node current = head;
			while(current.getNextNode()!=null){
				current = current.getNextNode();
			}
			current.setNextNode(temp);
		}
	}

	public static void insertAtRandomPosition(int data, int pos)throws Exception{

		Node temp = new Node(data);
		if(pos<0) throw new Exception("Wrong position given");
		else if(pos==0) insertAtFirst(data);
		else{
			Node current = head;
			while(pos>1){
				current = current.getNextNode();
				if(current==null) throw new Exception("Size Exception in Linked List");
				pos--;
			}
			temp.setNextNode(current.getNextNode());
			current.setNextNode(temp);
		}
	}

	public static void removeAtFirst() throws Exception{
		if(head==null) throw new Exception("Empty linked list");
		head = head.getNextNode();
	}

	public static void removeAtLast() throws Exception{
		if(head==null) throw new Exception("Empty linked list");
		else if(head.getNextNode()==null) head = null;
		else{
			Node current = head;
			while(current.getNextNode().getNextNode()!=null){
				current = current.getNextNode();
			}
			current.setNextNode(null);
		}
	}

	public static void removeAtRandomPosition(int pos) throws Exception{
		if(pos<0) throw new Exception("Wrong position given");
		else if(pos==0) removeAtFirst();
		else{
			Node current = head;
			while(pos>1){
				current = current.getNextNode();
				pos--;
				if(current==null || current.getNextNode() ==null ) throw new Exception("Size Exception in Linked List");
			}
			current.setNextNode(current.getNextNode().getNextNode());			
		}
	}

	public static void display(){
		Node current = head;
		while(current!=null){
			System.out.println(current.getData());
			current = current.getNextNode();
		}
	}

	public static void main(String args[]){
		try{
		for(int i=5 ; i>0; i--){
			insertAtFirst(i);
		}
		for(int i=1 ; i<=5; i++){
			insertAtLast(i);
		}
		removeAtRandomPosition(5);
		display();
	} catch(Exception e){
		System.out.println(e.getMessage());
	}
	

	}

}