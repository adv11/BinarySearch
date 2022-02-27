package BinarySearch;

import java.util.Scanner;

/*
* In this problem, we have given an array sorted in descending order and a key.
* We have to find is the key present in the array or not? if present then return its
* position(index + 1 for 0 ordered index) otherwise return -1.
*
* Example:
* Input : A = {5, 4, 3, 2, 1}, key = 4
* Output : 2
*/
public class BinarySearch_forDescendingOrderArray {
    public static int binarySearchReverse(int[] array, int low, int high, int key){
        while(low <= high){
            int mid = low + (high - low)/2; // for getting rid of integer overflow
            if(array[mid] == key)
                return mid+1;
            else if(array[mid] > key){
                low = mid + 1;
            }
            else{
                high = mid - 1;
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

            // position of the key value present in the array.
            int position = binarySearchReverse(array, 0, array.length - 1, key);
            System.out.println("Position of " + key + " in the array is : " + position);
        }
    }
}
