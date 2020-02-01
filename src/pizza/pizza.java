package pizza;

public class pizza {
    public static void main(String[] args) {
        // ben eat in speed 2 while dan eat in speed 1
        int slace=chackslis(2);
        System.out.println(slace);
    }
    public static int chackslis(double speed){
        if((int)speed==speed){ // the speed is integer
            return (int)speed+1;
        }
        else // the speed is double for example 2.3
        return (int)speed+2;
    }
}
