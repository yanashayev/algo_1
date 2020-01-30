package LIS;
import lcs.*;

import java.util.Arrays;


public class LisByLcs {
    public static void main(String[] args) {
        int[] a={8,4,12,2,3,10,14};
       int[] b=sort(a);
       int[][] ans=check(a,b);
        System.out.println(getpath(ans,b,a));

    }
    public static String getpath(int[][] matrix, int[] a,int[] b){
        String ans="";
        int j=a.length-1;
        int i=b.length-1;
        int temp=matrix[i+1][j+1];
        while(temp!=0){
            if(b[i]==a[j]){
                ans+=a[j];
                temp=matrix[i][j];
                i--;
                j--;

            }
            else{
                if(matrix[i][j-1]<matrix[i-1][j]){
                    temp=matrix[i][j];
                    i--;
                }
                else{
                    temp= matrix[i][j];

                    j--;
                }
            }


        }
        String t="";
        for(int l=ans.length()-1;l>=0;l--){
            t+=ans.charAt(l);

        }



        return t;
    }
    public static int[][] check(int[] a, int[] b){
        int[][] t= new int[a.length+1][a.length+1];
        for(int i=0;i<a.length;i++){ //the first col and row is 0
            t[0][i]=0;
            t[i][0]=0;
        }
        for(int i=1;i<t[0].length;i++){
            for (int j=1;j<t[0].length;j++){
                if(b[i-1]==a[j-1]){
                    t[i][j]=t[i-1][j-1]+1;
                }
                else{
                    t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
                }
            }


        }


        return t;
    }
    public static int[] sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[i]>a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }

        }
        return a;
    }
}



