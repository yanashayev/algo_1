package maxMin;
public class minmax {

    public static void main(String[] args) {
       int[] arr={3,1,9,5};
        //int[] arr={9,7,5,6,4,10,11,13,0,3,2,1,8,12,15};
        int [] ans=minMax(arr);
        System.out.println("min : "+ans[0]);
        System.out.println("max : "+ans[1]);
        int[] ans2=getmaxmac(arr);
        System.out.println("max1 : "+ans2[0]);
        System.out.println("max2 : "+ans2[1]);

    }
    public static int[] minMax(int[] arr){
        int[] ans=new int[2];
      int min, max;
      if (arr[0]>arr[1]){
          max=arr[0];
          min=arr[1];
      }
      else{
          max=arr[1];
          min=arr[0];
      }
      for(int i=2;i<arr.length-2;i+=2){
          if(arr[i]<arr[i+1]){
              min= Math.min(min, arr[i]);
              max= Math.max(max, arr[i + 1]);
          }
          else{
              min= Math.min(min, arr[i + 1]);
              max= Math.max(max, arr[i]);
          }


      }
      if(arr.length%2!=0){
          if(arr[arr.length-1]>max){
              max=arr[arr.length-1];
          }
          if(arr[arr.length-1]<min){
              min=arr[arr.length-1];
          }

      }
      ans[0]=min;
      ans[1]=max;

      return ans;

    }
    public static int[] getmaxmac(int[] a){
        int[] ans=new int[2];
        int max1,max2;
        if (a[0]>a[1]){
            max1=a[0];
            max2=a[1];
        }
        else{
            max1=a[1];
            max2=a[0];
        }
        for(int i=2;i<a.length-1;i+=2){
            if (a[i]>a[i+1]){
                if(a[i]>max1){
                    if(a[i+1]>max1){
                        max1=a[i];
                        max2=a[i+1];
                    }
                    else {
                        max2 = max1;
                        max1 = a[i];
                    }
                }
                else if(a[i]>max2){
                    max2=a[i];
                }

            }
            else{
                if(a[i+1]>max1) {
                    if (a[i] > max1) {
                        max1 = a[i + 1];
                        max2 = a[i];
                    } else {
                        max2 = max1;
                        max1 = a[i + 1];
                    }
                }
                else if(a[i+1]>max2){
                    max2=a[i+1];
                }

            }
        }
        if(a.length%2!=0){
            if(a[a.length-1]>max1){
                max2=max1;
                max1=a[a.length-1];
            }
          else  if (a[a.length-1]>max2){
                max2=a[a.length-1];
            }

        }

        ans[0]=max1;
        ans[1]=max2;

        return ans;
    }
}
