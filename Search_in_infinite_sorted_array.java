package BinarySearch;
/*
* We have given a sorted array of infinite length and a key value.
* we have to search this value in the array and return its index.
*
* Example : A = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, .................... ], key = 11
* Output : 10(index)
*/

// Problem : How to decide value of high variable because array is of infinite length.
// For this we are considering low = 0 and high = 1
// while key value is greater than A[high]
// assign low = high and double the value of high
import java.util.Scanner;

public class Search_in_infinite_sorted_array {
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
    public static int searchInInfiniteSortedArray(int[] array, int key){
        int low = 0, high = 1;  // take low as 0 and high as 1
        while (key > array[high]){  // while key is > than A[high]
            low = high; // assign high to low
            high *= 2;  // and double high's value
        }
        return binarySearch(array, low, high, key);
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

            System.out.println("Index of key element is : " + searchInInfiniteSortedArray(array, key));
        }
    }
}
