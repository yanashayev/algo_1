package lcs;

public class lcs {
    public static void main(String[] args) {
   //     String a= "abcde";
    //   String b= "bcjea";
        String a="asbdazxbya";
        String b="asbabazccd";
        int[][] ans=check(b,a);
        System.out.println(getpath(ans,b,a));
//        for(int i=0;i<ans.length;i++){
//            for (int j=0;j<ans.length;j++){
//                System.out.print(" "+ans[i][j]);
//            }
//            System.out.println();
//        }
    }
    public static int[][] check(String a, String b){
        int[][] t= new int[a.length()+1][a.length()+1];
        for(int i=0;i<a.length();i++){ //the first col and row is 0
            t[0][i]=0;
            t[i][0]=0;
        }
        for(int i=1;i<t[0].length;i++){
          for (int j=1;j<t[0].length;j++){
              if(b.charAt(i-1)==a.charAt(j-1)){
                  t[i][j]=t[i-1][j-1]+1;
             }
              else{
                  t[i][j]=Math.max(t[i][j-1],t[i-1][j]);
              }
          }


        }


        return t;
    }
    public static String getpath(int[][] matrix, String a,String b){
        String ans="";
        int j=a.length()-1;
        int i=b.length()-1;
        int temp=matrix[i+1][j+1];
        while(temp!=0){
            if(b.charAt(i)==a.charAt(j)){
                ans+=a.charAt(j);
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
}
