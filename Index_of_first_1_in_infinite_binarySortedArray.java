package BinarySearch;
/*
* We have given an infinite sorted array containing only 0 and 1 (binary array).
* We have to find the first index of the 1 present in the given array.
* Example : A = [0, 0, 0, 0, 1, 1, 1, 1, 1, ..........................]
* Output : 4

* Key point :
* It is combination of two problems.
* 1) Search in an infinite sorted array
* 2) Find first index of the key element
*/
import java.util.Scanner;

public class Index_of_first_1_in_infinite_binarySortedArray {
    // finding the first index of 1
    public static int findFirstIndexOfKey(int[] array, int key){
        int low = 0, high = array.length-1;
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                ans = mid;
                high = mid - 1;
            }else if(array[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    // searching in an infinite sorted array
    public static int findingRangeInInfiniteBinaryArray(int[] array, int key){
        int low = 0, high = array.length-1;
        while (key > array[high]){
            low = high;
            high *= 2;
        }
        return findFirstIndexOfKey(array, key);
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

            System.out.println("First of 1 in an infinite binary array is : " + findingRangeInInfiniteBinaryArray(array, key));
        }
    }
}
