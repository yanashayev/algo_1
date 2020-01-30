package secritery;

import java.util.Arrays;

public class secri {
    public static void main(String[] args) {
        int[] time= {3,4,10,2,1,5,6};

        System.out.println(check(time));
      //  System.out.println(Arrays.toString(a));
    }
    public static double check(int[] a){
    sort(a);
        System.out.println(Arrays.toString(a));
    double avr=0,ans=0;

    for(int t:a){

        avr=avr+t;
        ans+=avr;
        System.out.println( "t "+t);
        System.out.println("avr "+avr);

    }

        return (ans/a.length);
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
