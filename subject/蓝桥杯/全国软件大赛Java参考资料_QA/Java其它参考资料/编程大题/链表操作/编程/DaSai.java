import java.io.*;
class Node {//�����
		private char data; //�������
	    private Node next; //��һ�����
	    
		public Node(){
			next = null;
		}
		public Node(char data,Node next){
			this.data = data;
			this.next = next;
		}
		public void setData (char data){   
 			this.data = data;
		}
		public char getData(){  
 			return data;
		}
		public void setNext(Node next){
			this.next = next;
		}		
		public Node getNext(){
			return next;
		}
  }

class LinkList {//������
	private Node head;     //ͷ���
	private int length;    //������
	
	public LinkList(){     
	    length = 0;
		head = null;
	}
	
	public LinkList(String str) {  //ͨ���ַ����ཨ������
    	for(int i = 0; i < str.length(); i ++){
		    head = addNode(str.charAt(i));
		}
		length = str.length();
	}	
		
	public LinkList(char[] c){ //ͨ���ַ����齨������
		for(int i = 0; i < c.length; i ++){
		    head = addNode(c[i]);
		}
		length = c.length;
	}   

    public LinkList(int n) {//��[A,Z]��Χ�ڵ������ĸ����n����������  
        if(n > 0){
        	int k;
            for(int i = 0; i < n ;i ++){
                k = (int) (Math.random() * 26 + 65);
				head = addNode((char)k);
            }
            length = n;
        }
        else
        	System.out.println("���ݷǷ���");
    }
    
	public Node last(){//�õ����һ���ڵ�
		Node lastnode = head;
		while(lastnode.getNext() != null){
			lastnode = lastnode.getNext();
		}
		return lastnode;
	}
	
	public Node addNode(char c) { //��ǰ�����β������һ�����
		if(head == null){
			head = new Node();
			head.setData(c);
		}
		else{
			Node node = new Node();
			node.setData(c);
			last().setNext(node);
		}
		length ++; 
		return head;
	}
	
	public Node addNode(char c,int index) { //������ĵ�index�����֮������һ�����
		if(head == null){
			head = new Node();
			head.setData(c);
		}
		else{
			Node node = new Node();
			node.setData(c);
			Node temp=head;
			for(int i = 0;i < index;i ++){
				temp = temp.getNext(); 
			}
			node.setNext(temp.getNext()); 
			temp.setNext(node); 
		}
		length ++;             
		return head;
	}
	
	public Node deleteNode(char c)throws Exception{ //ɾ��ָ�����ݵĽ��
		if(head == null){           
			throw new Exception("null node");
		}		
	    char ch = head.getData();
	    if(ch == c) {
	    	head = head.getNext();
	    	return head;
	    }	    
	    Node linkNode = head.getNext();       //��ȡ��һ��������
	    Node tempNode = head;                 //�洢��һ��������
	    while(linkNode != null) {
	    	ch = linkNode.getData();
	    	if(ch == c){
	    	    tempNode = linkNode.getNext(); 
	    	    return head;
	    	}
	    	tempNode = linkNode;	    	
			linkNode = linkNode.getNext();
		}
		length--;                             
		return head;
	}
	
	public void deleteNode(int index)throws Exception{ //ɾ������ָ��λ�õĽ��
		if(head == null){           
			throw new Exception("null node");
		}
		if(index<0 || index >length){
			System.out.print("λ�ò�����!");
		} 
		Node temp = head;
		if(index == 0)head = head.getNext();
		else{
			for(int i = 0; i < index-1; i ++){
				temp = temp.getNext();
			}	
			temp.setNext(temp.getNext().getNext());
		}		
		length --;
	} 

	public int length() {      //���������н��ĸ���
	    return this.length;
	}
	
	public char charAt(int index){       //��ȡ������ָ������λ�õ��ַ�����
	    int ilen = length;
	    if(index < 0 || index >= ilen){
	    throw new StringIndexOutOfBoundsException("���������߽磺"+index);
		}
		Node linkNode = head;
		for(int i = 0; i < index; i ++){
			linkNode = linkNode.getNext();
		}
	    return linkNode.getData();
	}
	
	public boolean isEmpty(){
		if(length() == 0)
			return true;
		else
			return false;
	}
}

public class DaSai{
    public static void main(String[] args) {
    	LinkList linkOne = new LinkList(6);    //�����������
    	LinkList linkTwo=new LinkList(6);    
		
		System.out.println("������ɵ���ĸ����1�ǣ� ");
		for(int i = 0; i < linkOne.length(); i ++){
			System.out.print(linkOne.charAt(i));
		}
		
		System.out.println("\n\n������ɵ���ĸ����2�ǣ� ");
		for(int i = 0; i < linkTwo.length(); i ++){
			System.out.print(linkTwo.charAt(i));
		}
				
		System.out.println("\n\n����1�Ĳ����ǣ� ");
		complement(linkOne);

		System.out.println("\n\n����1������2�Ľ����ǣ� ");
		intersection(linkOne,linkTwo);
		
		System.out.println("\n\n����1������2�Ĳ����ǣ� ");
		union(linkOne,linkTwo);
		
		System.out.println("\n\n����1������2�Ĳ���ȥ�����ļ��ǣ� ");
		delRedundant(linkOne);		
	}
	
	
	static void complement(LinkList listOne){//������Ĳ���
		System.out.println("�ȴ�������ɣ�");
	}	
		
	static void intersection(LinkList listOne,LinkList listTwo){//������Ľ���
		System.out.println("�ȴ�������ɣ�");
	}
		
	static void union(LinkList listOne,LinkList listTwo){//������Ĳ���
		System.out.println("�ȴ�������ɣ�");
	}
	
	static void  delRedundant(LinkList listOne){//ȥ���������
		System.out.println("�ȴ�������ɣ�");
	}
}
