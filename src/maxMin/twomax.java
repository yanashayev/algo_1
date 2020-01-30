package maxMin;

import com.sun.deploy.security.SelectableSecurityManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class twomax {
    public static void main(String[] args) {
    //Node[] array=new Node[10];
    ArrayList<Node> array= new ArrayList<>();
    addnodes(array);
    int[] ans=findMax(array);
        System.out.println("max1 "+ans[0]);
        System.out.println("max2  "+ans[1]);

    }
    public static void addnodes(ArrayList<Node> n){
        Node y= new Node(9);
        n.add(y);
        y= new Node(7);
        n.add(y);
        y= new Node(15);
        n.add(y);
        y= new Node(4);
        n.add(y);
        y= new Node(2);
        n.add(y);
        y= new Node(1);
        n.add(y);
        y= new Node(10);
        n.add(y);
        y= new Node(13);
        n.add(y);
        y= new Node(0);
        n.add(y);
        y= new Node(3);
        n.add(y);


    }
    static class Node{
        private int data;
        private Stack s;
        public Node(int data){
            this.data=data;
            this.s=new Stack();
        }
        public int getData(){
            return this.data;
        }
        public Stack getS(){
            return s;

        }
        public void add(int data){
            this.s.push(data);
        }


    }
    public static int[] findMax(ArrayList<Node> n ){
        int ans[]=new int[2];
        while(n.size()!=1) {
            for (int i = 0; i < n.size() - 1; i += 2) { // check if the n.size-1 is right
                if (n.get(i).data < n.get(i + 1).data) {
                    n.get(i + 1).s.push(n.get(i).data);
                    n.remove(i);
                } else {
                    n.get(i).s.push(n.get(i + 1).data);
                    n.remove(i + 1);
                }
            }
        }
        ans[0]=n.get(0).data;
        int max=-1;
       while (!n.get(0).getS().empty()){
           if((int)n.get(0).getS().peek()>max){
                   max = (int) n.get(0).getS().pop();
               }
           else n.get(0).getS().pop();
       }
       ans[1]=max;
       return ans;
    }



}
