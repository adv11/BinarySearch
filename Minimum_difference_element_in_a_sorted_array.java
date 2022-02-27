package BinarySearch;
/*
* We have given a sorted array and a key value. We have to find the element which has minimum difference
* when we subtract it from the key element, we have to return that element from the array.
*
* Example : A = [1, 3, 8, 10, 15], key = 12
* Output : 10 (because 12 - 10 == 2 is minimum)


* Key point :
* 1) If the key value is present in the array then simply return key because (key - key == 0)
* 2) If key element is not present then we need to only find the difference with the neighbours of the key element.
* Example : A = [1, 3, 8, 10, 15], key = 12
* |1 - 12| = 11
* |3 - 12| = 9
* |8 - 12| = 4
* |10 - 12| = 2 (minimum)
* |15 - 12| = 3

* For finding the neighbours we need not to do anything unique, because general binary search after the completion
* simply returns the neighbour element of the key element if the key is not present in the array.
*/
import java.util.Scanner;

public class Minimum_difference_element_in_a_sorted_array {
    public static int minimumDifferenceElement(int[] array, int key){
        int low = 0, high = array.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){  // if key is present return it
                return key;
            }else if(array[mid] > key){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        // otherwise, find difference of the neighbour elements of the key and return minimum one.
        int t1 = Math.abs(array[low] - key);
        int t2 = Math.abs(array[high] - key);
        if(t1 < t2){
            return array[low];
        }
        return array[high];
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

            System.out.println("Minimum difference element is : " + minimumDifferenceElement(array, key));
        }
    }
}
