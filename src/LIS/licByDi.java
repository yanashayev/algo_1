package LIS;

public class licByDi {
    public static void main(String[] args) {
        int[] a = {8, 4, 12, 2, 3, 10, 14};
    }
    public static int check(int[] a){
        int[][] mat= new int[a.length][a.length];
        mat[0][0]=a[0];
        int lis=1;
        for (int i=1;i<a.length;i++){
            int index=binatysearch(mat,lis,a[i]);
            mat[index][index]=a[i];
            //copy
            if (lis==index){
                lis++;
            }
        }



        return 0;
    }
    public static int binatysearch(int[][] mat,int lis, int num){
        if(num>mat[lis-1][lis-1]){
            return lis;
        }
        if (num<mat[0][0]){
            return 0;
        }
        int low=0, high=lis;
        while (low<=high){
            if (low==high){
                return low;
            }
            int mid=(low+high)/2;
            if(mat[mid][mid]==num){
                return mid;
            }
            if (mat[mid][mid]>num){
                high=mid;
            }
            else {
                low=mid+1;
            }
        }
       return -1;
    }
    
}