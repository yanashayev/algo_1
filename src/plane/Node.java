package plane;

public class Node {
    private double x;
    private double y;
    private double price;
    public Node(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }
    public double getPrice(){
        return this.price;
    }
    public void setX(double x){
        this.x=x;
    }

    public void  setY(double y){
        this.y=y;
    }
    public void  setPrice(double price){
        this.price=price;
    }
}
