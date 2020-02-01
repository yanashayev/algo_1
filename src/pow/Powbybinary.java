package pow;

public class Powbybinary {
    public static void main(String[] args) {
        System.out.println(powbybin(2,5));
    }
    public static int powbybin(int x,int n) {
        int result = 1;
       while (n!=0){
           if(n%2==1){
               result=result*x;
           }
           x=x*x;
           n=n/2;
       }
   return result;
    }
}
