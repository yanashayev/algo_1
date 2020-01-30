package hezyon;

public class twoarrays {
    public static void main(String[] args) {
        int[] a={1,10,20,40};
        int[] b={15,22,30,31};
        int[] ans=getar(a,b);
        for (int j=0;j<ans.length;j++){
            System.out.println(" "+ans[j]);
        }

    }
    public static int[] getar(int[] a, int[] b){
        int[] ans=new int[a.length];
        for(int i=0,j=b.length-1;i<a.length||j>=0; j--,i++){
                ans[i]=Math.max(a[i],b[j]);

        }

        return ans;
    }
}
