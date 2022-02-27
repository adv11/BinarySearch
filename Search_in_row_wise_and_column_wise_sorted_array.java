package BinarySearch;
/*
* We have given an 2D array where rows and columns are sorted in ascending order.
* We have also given a key value, and we have to search it in tha 2D array whether it is present or not.
*
* Example:
* A = 10 20 30 40
*     15 25 35 45
*     19 29 39 49
*     21 31 41 51
* Key = 19
* Output : 2 0
*
*
* Key point:
* 1) Always start searching from top right corner of the array.
* 2) If array[i][j] == key return i and j.
* 3) If array[i][j] > key then decrease the value of col j--.
* 4) If array[i][j] < key then increase the value of row i++.
*/
import java.util.ArrayList;
import java.util.Scanner;

public class Search_in_row_wise_and_column_wise_sorted_array {
    public static ArrayList<Integer> searchKeyIn2DArray(int[][] array, int key, int row, int col){
        int i = 0, j = col-1;   // initializing from top right corner
        while ((i>=0 && i<row) && (j>=0 && j<col)){
            if(array[i][j] == key){
                ArrayList<Integer> ans = new ArrayList<>();
                ans.add(i);
                ans.add(j);
                return ans;
            }else if(array[i][j] > key){    // decreasing col
                j--;
            }else if(array[i][j] < key){    // increasing row
                i++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(-1);
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            // size of the array
            System.out.println("Enter number of rows:");
            int row = sc.nextInt();
            System.out.println("Enter number of columns:");
            int col = sc.nextInt();

            // taking input
            System.out.println("Enter elements of the array");
            int[][] array = new int[row][col];
            for(int i=0 ; i<row ; i++){
                for(int j=0 ; j<col ; j++){
                    array[i][j] = sc.nextInt();
                }
            }

            // key ele
            System.out.println("Enter key element:");
            int key = sc.nextInt();

            ArrayList<Integer> ans = searchKeyIn2DArray(array, key, row, col);
            for(int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
