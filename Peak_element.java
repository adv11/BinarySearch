package BinarySearch;
// This problem can also be asked as to find the max element in the bitonic array.
// Bitonic array is the sequence of numbers which strictly increases up to a certain point and after that it will strictly reduce.
// Example :
// A = [1, 2, 3, 10, 8, 7, 5]   -> Bitonic array
// Point = 10
/*


* Given an array we have to find the index of the index of the peak element.
* Peak element is A[i-1] < A[i] and A[i] > A[i+1]

* Example:
* A = [1, 4, 2, 5]
* Output : 1
*
*
* Key Point:
* Always move pointers low and high which are causing mid indexed element not to be a
* peak element.
* Simply means move where larger element lies.
* if(A[mid] < a[mid-1]) then move left side that is high = mid - 1
* if(A[mid] < a[mid+1]) then move right side that is low = mid + 1
*/
import java.util.Scanner;

public class Peak_element {
    public static int peakElement(int[] array){
        int low = 0, high = array.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < array.length-1){
                if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
                    return mid;
                }else if(array[mid] < array[mid-1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else if(mid == 0){     // edge case 1
                if(array[0] > array[1]){
                    return 0;
                }else{
                    return 1;
                }
            }else if(mid == array.length-1){    // edge case 2
                if(array[array.length-1] > array[array.length-2]){
                    return array.length-1;
                }else{
                    return array.length-2;
                }
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
            System.out.println("Peak element's index is : " + peakElement(array));
        }
    }
}
