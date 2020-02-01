package retangle;

import java.util.Stack;

public class retangle
{
    public static void main(String[] args) {

    }
    public static int check(int[][] a){
        int maxarea=-1, area;
        int[] help=new int[a[0].length];
        for(int i=0;i<help.length;i++){// init the first time
            help[i]=0;
        }
        for(int i=0; i<a.length;i++){
            for (int j=0;j<a[0].length;j++){
                if(a[i][j]==1){
                    help[j]=help[j]+1;
                }
                else {
                    help[j]=0;
                }
            }
            area=area(help);
            if (area>maxarea){
                maxarea=area;
            }
        }



        return maxarea;
    }
    public static int area(int a[]){
        Stack<Integer> s=new Stack<>();
        int top,i=0,maxerea=-1,areafortop=-1;
        while (i<a.length){
            if(s.empty()||a[i]>=a[s.peek()]){
                s.push(i++);
            }
            else {
                top=s.pop();
                areafortop=a[top]*(s.empty()?i:i-s.peek()-1);
                if(areafortop>maxerea){
                    maxerea=areafortop;
                }
            }

        }
        return maxerea;
    }

}
