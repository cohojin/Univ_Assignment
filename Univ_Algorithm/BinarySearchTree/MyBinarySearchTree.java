package hw6_1;

public class MyBinarySearchTree {
	private Node root=null;
	
	//노드 (키 ,왼쪽자식,오른쪽자식)
	private class Node{
		private String key; 
		private Node left;
		private Node right;
		
		public Node(String key) {
			this.setKey(key);
			setLeft(null);
			setRight(null);
		}
		
		//getter와setter
		public void setLeft(Node left) {
			this.left=left;
		}
		public Node getLeft() {
			return left;
		}
		public void setRight(Node right) {
			this.right=right;
		}
		public Node getRight() {
			return right;
		}
		public void setKey(String key) {
			this.key=key;
		}
		public String getKey() {
			return key;
		}
	}
	
	//문자열을 매개변수로 받아 트리에 삽입 , 이미 존재하는 키값이면 삽입 실패
	public void add(String str) {
		Node newNode=new Node(str);
		
		//root에 값이 null이면 입력받은 str 값이 root가 된다.
		if(root==null) {
			root=newNode;
			return;
		}
		//비교할 현재 노드를 current 그 값은 root , parent=null
		Node current = root;
		Node parent =null;
		while(true) {
			parent=current;
			//삽입된 문자열이 비교하려는 현재 키값보다 작으면 왼쪽
			if(str.compareToIgnoreCase(current.getKey()) < 0) {
				current=current.getLeft();
				if(current==null) {
					parent.setLeft(newNode);
					return;
				}	
			}//삽입된 문자열이 비교하려는 현재 키값보다 크면 오른쪽
			else if(str.compareToIgnoreCase(current.getKey()) > 0){
				current = current.getRight();
				if(current==null) {
					parent.setRight(newNode);
					return;
				}
			}else //이미 존재하면 그냥 return
			{
				return;
			}
		}
	}
	
	//매개변수는 없으며 , 트리 키값들을 오름차순으로 출력 즉,inorder(root);호출
	//printTree or toString 하나만 정의
	public void printTree() {
		inorder(root);
		System.out.println();
	}
	//중위 순회 (왼쪽부터 호출 , 키 값 호출 , 오른쪽 호출)
	private void inorder(Node root) {
		if(root!=null) {
			inorder(root.getLeft());
			System.out.print(" "+root.getKey());
			inorder(root.getRight());
		}
	}
	
	
}
