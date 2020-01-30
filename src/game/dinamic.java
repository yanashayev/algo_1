package game;

public class dinamic {
    public static void main(String[] args) {
      int[] arr={9,3,7,4};
        // int[] arr={9,7,5,6,4,10,11,13,0,3,2,1,8,12,15,3};
       int[][] a=checkr(arr);
       for(int i=0;i<a.length;i++){
           for (int j=0;j<a.length;j++){
               System.out.print(" "+a[i][j]);
           }
           System.out.println();
       }
        //System.out.println(checkr(arr));
    }
    public static int[][] checkr(int[] a){
        int[][] ar= new int[a.length][a.length];
        for (int i=0;i<a.length;i++){ // put all number from the given array
            ar[i][i]=a[i];
        }
     for(int i=a.length-2;i>=0;i--){
         for(int j=i+1;j<a.length;j++){
             ar[i][j]=Math.max(a[i]-ar[i+1][j],a[j]-ar[i][j-1]);
         }
     }
        return ar;
    }
}
