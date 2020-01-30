public class twogamers {
    public static void main(String arg[]) {
        int[] a = {1, 3, 6, 1, 3, 6};
int sup=15,place=6;
        System.out.println(getTime(sup,place));
        System.out.println(getTime(5,3));

        // System.out.println(subarray(a,1,3).length);
    //    System.out.println(profit(a));
    }

    public static int profit(int[] arr) {
        int length = arr.length;
        if (arr.length == 1) {
            return +arr[0];
        } else
            return Math.max(arr[0] - profit(subarray(arr, 1, length - 1)), arr[length - 1] - profit(subarray(arr, 0, length - 2)));
    }


    public static int[] subarray(int[] a, int start, int end) {
        int[] ans = new int[end - start + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = a[start + i];
        }
        return ans;
    }


    public static int getTime(int numOfSuf, int numOfPlace) {
        if (numOfPlace >= numOfSuf) return 2; // מספר הסופגניות קטן מגודל המחבת
        if ((2*numOfSuf) % numOfPlace == 0) {// מספר הסופגניות מתחלק באופן שלם בגודל המחבת
            return ((2 * numOfSuf) / numOfPlace);
        }
        return   ((2*numOfSuf) / numOfPlace) + 1; // כמות השלמים

    }
}