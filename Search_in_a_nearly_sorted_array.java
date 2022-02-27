package BinarySearch;
/*
* Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
* i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
* Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
Example :
Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2
Output is index of 40 in given array

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
-1 is returned to indicate element is not present
*
A simple solution is to linearly search the given key in given array.
* Time complexity of this solution is O(n). We can modify binary search to do it in O(Log N) time.
The idea is to compare the key with middle 3 elements, if present then return the index. If not present,
* then compare the key with middle element to decide whether to go in left half or right half.
* Comparing with middle element is enough as all the elements after mid+2 must be greater than element
* mid and all elements before mid-2 must be smaller than mid indexed element.
*/
import java.util.Scanner;

public class Search_in_a_nearly_sorted_array {
    public static int searchInNearlySortedArray(int[] array, int key){
        int low = 0, high = array.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                return mid;
            }if(mid-1 > low && array[mid-1] == key){    // check mid-1 > low to avoid out of bound or -ve index exception
                return mid-1;
            }if(mid+1 < high && array[mid+1] == key){   // check mid+1 < high to avoid out of bound
                return mid+1;
            }if(array[mid] > key){  // if A[mid] > key then low = mid + 2 because key can be present at (i-1)th, ith, and (i+1)th index
                low = mid + 2;
            }if(array[mid] < key){  // if A[mid] < key then high = mid - 2 because key can be present at (i-1)th, ith, and (i+1)th index
                high = mid - 2;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of test cases:");
        int testCases = sc.nextInt();

        while (testCases-- > 0) {
            // size of the array
            System.out.println("Enter the number of elements in the array:");
            int size = sc.nextInt();

            // taking input
            System.out.println("Enter the elements in sorted order:");
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }

            // taking input for key element to search
            System.out.println("Enter the key element to search in the array:");
            int key = sc.nextInt();

            System.out.println("Key element is present at index : " + searchInNearlySortedArray(array, key));
        }
    }
}
