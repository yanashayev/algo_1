package square;

import java.util.Arrays;

public class square {
    public static void main(String[] args) {
        int[][] m={
                {1,0,0,1,1},
                {0,1,1,0,1},
                {0,1,1,1,0},
                {1,1,1,1,0},
                {1,1,1,1,0}
        };
        check(m);

    }
    public static void check(int[][] m){
        int[][] ans= new int[m.length][m[0].length];
        for(int i=0; i<m[0].length;i++){
            ans[i][0]=m[i][0];
            ans[0][i]=m[0][i];
        }
        for (int i=1;i<m[0].length;i++){
            for(int j=1;j<m[0].length;j++){
                if(m[i][j]==0){
                    ans[i][j]=0;
                }
                else{
                    ans[i][j]=Math.min(ans[i-1][j-1],Math.min(ans[i][j-1],ans[i-1][j]))+1;
                }
            }
        }
        for(int i=0;i<ans.length;i++){
            for (int j=0;j<ans.length;j++){
                System.out.print(" "+ans[i][j]);
            }
            System.out.println();
        }
    }
}
