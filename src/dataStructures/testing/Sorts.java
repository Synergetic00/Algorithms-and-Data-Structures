package dataStructures.testing;

import algorithms.Sorting;
import java.util.Random;

public class Sorts {

    public static final int ARRAY_LENGTH = 100;
    public static final int RANDOM_MAX = 100;
    public static int[] randomArr = new int[ARRAY_LENGTH];
    public static Random random = new Random();

    public static void main(String[] args) {
        testSortingAlgorithm("Shell");
    }

    public static void genNewRandArr() {
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            randomArr[i] = random.nextInt(RANDOM_MAX);
        }
    }

    public static final int[] getDeepCopy(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            { copy[i] = arr[i]; }
        return copy;
    }

    public static final void print(String prefix, int[] arr) {
        String output = prefix+": ";
        for (int i = 0; i < arr.length-1; i++) {
            output += arr[i] + ", ";
        }
        output = "[" + output + arr[arr.length-1] + "]";
        System.out.println(output);
    }

    public static final String identical(int[] original, int[] modified) {
        for (int i = 0; i < original.length-1; i++) {
            if (original[i] != modified[i]) {
                print("Original", original);
                print("Modified", modified);
                return String.format("Mismatch found at index %d, expected: %d but was: %d", i, original[i], modified[i]);
            }
        }
        return "The two arrays were identical, the algorithm works!";
    }

    public static long testSortingAlgorithm(String algorithm) {
        int[] mySort = getDeepCopy(randomArr);
        long startTime = System.currentTimeMillis();
        
        switch (algorithm) {
            case "Selection":
                Sorting.selectionSort(mySort);
                break;
            case "Bubble":
                Sorting.bubbleSort(mySort);
                break;
            case "Insertion":
                Sorting.insertionSort(mySort);
                break;
            case "Merge":
                Sorting.mergeSort(mySort);
                break;
            case "Quick":
                Sorting.quickSort(mySort);
                break;
            case "Heap":
                Sorting.heapSort(mySort);
                break;
            case "Counting":
                Sorting.countingSort(mySort);
                break;
            case "Radix":
                Sorting.radixSort(mySort);
                break;
            case "Bucket":
                Sorting.bucketSort(mySort);
                break;
            case "Shell":
                Sorting.shellSort(mySort);
                break;
            default:
                break;
        }

        System.out.println(identical(randomArr, mySort));
        long endTime = System.currentTimeMillis();
        long diff = (endTime - startTime);
        return diff;
    }
    
}