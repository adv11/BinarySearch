package BinarySearch;
/*
* In Binary Search, the array should be sorted.
* TC = O(log N)
* SC = O(1)
*/
import java.util.Scanner;

public class BinarySearchImplementation {
    public static int binarySearch(int[] array, int low, int high, int key){
        while(low <= high){
            int mid = (low + high)/2;   // or we can use mid = (((high - low) / 2) + low)  for ignoring integer overflow

            // if the mid-index element == key then return index = mid + 1;
            if(array[mid] == key)
                return mid+1;
            else if(array[mid] < key)   // if array[mid] < key then low = mid + 1;
                low = mid + 1;
            else
                high = mid - 1; // if array[mid] > key then high = mid - 1;
        }
        return -1;  // if key element is not present in the array then return -1
    }

    // Recursive method for binary search algorithm
    public static int binarySearchRecursive(int[] array, int low, int high, int key){
        if(high >= low){
            int mid = low + (high - low)/2;
            if(array[mid] == key)
                return mid + 1;
            if(array[mid] > key)
                return binarySearchRecursive(array, low, mid-1 , key);
            return binarySearchRecursive(array, mid+1, high, key);
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
            int position = binarySearch(array, 0, array.length - 1, key);
            System.out.println("Position of " + key + " in the array is : " + position);


            System.out.println("By recursive method : " + binarySearchRecursive(array, 0, array.length-1, key));
        }
    }
}
