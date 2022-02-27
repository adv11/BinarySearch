package BinarySearch;
/*
* We have given an array and a key value, we have to find the floor value of the key value present in the array.
* if the floor value is not present then return -1
*/
import java.util.Scanner;

public class Floor_of_element_in_sorted_array {
    public static int floorOfEle(int[] array, int key){
        int low = 0, high = array.length-1;
        int ans = 0;
        while (low <= high){
            int mid = low + (high - low)/2;
            if(array[mid] == key){
                return key;
            }else if(array[mid] > key){
                high = mid - 1;
            }else{
                ans = array[mid];
                low = mid + 1;
            }
        }
        return ans;
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

            System.out.println("Floor of the key is : " + floorOfEle(array, key));
        }
    }
}
