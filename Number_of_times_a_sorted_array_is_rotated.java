package BinarySearch;

import java.util.Scanner;

public class Number_of_times_a_sorted_array_is_rotated {
    // TC = O(N), SC = O(1)
    public static int rotationCount_inLinearTime(int[] array){
        for(int i=0 ; i<array.length-1 ; i++){
            if(array[i] > array[i+1]){
                return i+1;
            }
        }
        return 0;
    }
    // TC = O(log N), SC = O(1)
    public static int rotationCount_binarySearch(int[] array){
        int low = 0, high = array.length-1;
        while (low <= high){
            int mid = low + (high - low)/2;
            // base condition if the mid ele is smaller than both of its neighbour elements then it is a smallest number
            // present in the array, then simply return mid
            int prevIndex = (mid - 1 + array.length) % array.length;
            int nextIndex = (mid + 1) % array.length;
            if((array[mid] <= array[prevIndex]) && (array[mid] <= array[nextIndex])) {
                return mid;
            }
            // if the mid-indexed element is smaller than high-indexed element then it means that this part is sorted,
            // but we always have to move in unsorted part so assign high = mid - 1
            else if(array[mid] <= array[high]){
                high = mid - 1;
            }
            // if the mid-indexed element is greater than low-indexed element then it means that this part is sorted,
            // but we always have to move in unsorted part so assign low = mid + 1
            else if(array[mid] >= array[low]){
                low = mid + 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of testcases:");
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();

            System.out.println("Enter the elements of the array:");
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }

            System.out.println("The rotation count is(in linear complexity) : " + rotationCount_inLinearTime(array));
            System.out.println("The rotation count is(in logarithm complexity) : " + rotationCount_binarySearch(array));
        }
    }
}
