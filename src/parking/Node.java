package parking;

public class Node {
    public char data;
    public Node next,prev;
    public Node(char data,Node prev,Node next){
        this.data=data;
        this.prev=prev;
        this.next=next;
    }

    public char getData(){
        return this.data;
    }
    public void setData(char data){
        this.data=data;
    }
    public  Node getPrev(){
        return this.prev;
    }
    public Node getNext(){
        return this.next;
    }
}
