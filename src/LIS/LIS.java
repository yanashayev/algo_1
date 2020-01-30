package LIS;
import java.util.ArrayList;
import java.util.Arrays;
public class LIS {


        public static void main(String[] args) {
            int arr[] = {0, 8, 4, 12, 2, 2, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
            //{0, 8, 4, 15, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 12};

            // Greedy algorithm
            Greedy(arr);

            //FullSearch
            LIS_FullSearch(arr);

            // LIS using LCS
            LIS_using_LCS(arr);

            // calculate the length of LIS dynamic programming
            LIS_length(arr);

            //calculate length and example of subsequence
            LIS_subsequence(arr);
        }


        private static void Greedy(int[] arr) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(arr[0]);
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > ans.get(ans.size()-1))
                    ans.add(arr[i]);
            }
            System.out.println("Greedy: LIS = " + ans.size() + ", increasing sequence = " + ans.toString());
        }

        private static void LIS_FullSearch(int[] arr) {
            int[] binaryArray = new int[arr.length];
            int interations = (int)Math.pow(2, arr.length)-1;
            ArrayList<Integer> temp = new ArrayList<Integer>();
            boolean check;
            int lis = 0;
            ArrayList<Integer> longestSubArray = new ArrayList<Integer>();
            for (int i = 0; i < interations; i++) {
                Plus1(binaryArray);
                temp.clear();

                //copy elements with '1' in the binary array
                for (int j = 0; j < binaryArray.length; j++) {
                    if (binaryArray[j]==1)
                        temp.add(arr[j]);
                }
                int x = 0;
                if (i == 249)
                {
                    x = 8;
                }
                //check if increasing
                check = true;
                for (int j = 1; j < temp.size() && check == true; j++) {
                    if (temp.get(j) < temp.get(j-1))
                        check = false;
                }

                if (check==true && temp.size()>lis)
                {
                    lis = temp.size();
                    longestSubArray.clear();
                    for (int j = 0; j < temp.size(); j++) {
                        longestSubArray.add(temp.get(j));
                    }
                }
            }

            System.out.println("Full Search: LIS = " + lis + ", increasing subsequence = " + longestSubArray.toString());


        }
        private static void Plus1(int[] array) {
            boolean flag = true;
            int i = array.length-1;
            while(flag == true)
            {
                if (array[i] == 0)
                {
                    array[i] = 1;
                    flag = false;
                }
                else
                {
                    array[i] = 0;
                    i--;
                }
            }
        }

        private static void LIS_using_LCS(int[] arr) {
            int sorted[] = new int[arr.length];

            // copy array
            for (int i = 0; i < arr.length; i++) {
                sorted[i] = arr[i];
            }

            //sort
            Arrays.sort(sorted);

            //------Call LCS-------

            //calculate matrix and subsequence
            int[][] Mat = LCS(arr,sorted);
            String subsequence = GetSubsequence(arr, sorted, Mat);

            System.out.println("LIS using LCS: LIS = " + Mat[arr.length][arr.length] + ", increasing subsequence = " + subsequence);

        }
        public static int[][] LCS(int[] x, int[] y) {
            int[][] Mat = new int[x.length+1][y.length+1];
            for (int i = 1; i <= x.length; i++) {
                for (int j = 1; j <= y.length; j++) {
                    if (x[i-1]==y[j-1])
                    {
                        Mat[i][j] = Mat[i-1][j-1]+1;
                    }
                    else
                        Mat[i][j] = Math.max(Mat[i][j-1], Mat[i-1][j]);
                }
            }
            return Mat;
        }
        public static String GetSubsequence(int[] x, int[] y, int[][] mat) {
            int size = x.length;
            int i = size;
            int j = size;
            String ans = "";
            while (i>0 && j>0)
            {
                if (x[i-1]==y[j-1])
                {
                    ans = x[i-1] +", "+ ans;
                    i = i-1;
                    j = j-1;
                }
                else
                {
                    if (mat[i-1][j] > mat[i][j-1])
                        i--;
                    else
                        j--;
                }
            }
            return ans;
        }

        private static void LIS_length(int[] arr) {

            int[] temp = new int[arr.length];
            temp[0] = arr[0];
            int lis = 1;
            int index;
            for (int i = 1; i < arr.length; i++) {
                index = FindRightIndexWithBinarySearch(temp, arr[i], 0, lis-1);
                temp[index] = arr[i];
                if (index == lis)
                    lis++;
            }

            System.out.println("DP: LIS = " + lis);

        }
        private static int FindRightIndexWithBinarySearch(int[] temp, int num, int left, int right) {
            if (num < temp[left])
                return left;
            if (num > temp[right])
                return right+1;
            if (left == right)
                return left;
            int mid = (left+right)/2;

            if (temp[mid]>num)
                return FindRightIndexWithBinarySearch(temp, num, left, mid);
            else
                return FindRightIndexWithBinarySearch(temp, num, mid+1, right);
        }

        private static void LIS_subsequence(int[] arr) {
            int[][] mat = new int[arr.length][arr.length];
            mat[0][0] = arr[0];
            int lis = 1;

            for (int i = 1; i < arr.length; i++) {
                int index = FindRightIndexWithBinarySearch(mat, arr[i], 0, lis-1);
                mat[index][index] = arr[i];
                for (int j = 0; j < index; j++) {
                    mat[index][j] = mat[index-1][j];
                }
                if (index == lis)
                    lis++;
            }

            System.out.print("DP: LIS = " + lis + ", increasing subsequence = ");
            for (int i = 0; i < lis; i++) {
                System.out.print(mat[lis-1][i] + ", " );
            }
            System.out.println();
        }
        private static int FindRightIndexWithBinarySearch(int[][] mat, int num, int left, int right) {
            if (num < mat[left][left])
                return left;
            if (num > mat[right][right])
                return right+1;
            if (left == right)
                return left;
            int mid = (left+right)/2;

            if (mat[mid][mid]>num)
                return FindRightIndexWithBinarySearch(mat, num, left, mid);
            else
                return FindRightIndexWithBinarySearch(mat, num, mid+1, right);
        }
    }

