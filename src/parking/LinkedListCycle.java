package parking;


public class LinkedListCycle {
 private int size;
 private Node head,tail;
 public LinkedListCycle(){
     this.head=this.tail=null;
     this.size=0;
 }
 public void add(char data){
     if(head==null){
         head=new Node(data,null,null);
         tail=head;
         head.next=head.prev=tail;
     }
     else {
         Node n=new Node(data,tail,head);
         tail.next=n;
         tail=n;
         head.prev=tail;
     }
     size++;
 }
 public Node getHead(){
     return this.head;
 }
public Node getTail(){
     return this.tail;
}
public Node getNext(Node n){
     return n.next;
}


}
