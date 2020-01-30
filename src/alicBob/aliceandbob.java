package alicBob;

public class aliceandbob {
    public static boolean ast4(int bob, int alice){
        int bobgess=bob==0?1:0;
       int alicegess=alice;
        if(alicegess==bob||bobgess==alice) {
            return true;
        }
        return false;
    }
    public static void main(String arg[]){
        boolean f1=ast4(0,0);
        System.out.println(f1);
        boolean f2=ast4(0,1);
        System.out.println(f2);
        boolean f3=ast4(1,0);
        System.out.println(f3);
        boolean f4=ast4(1,1);
        System.out.println(f4);

    }
}
