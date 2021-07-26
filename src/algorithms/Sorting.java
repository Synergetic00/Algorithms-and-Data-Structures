package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting {

    public static int min(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
    
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Selection Sort

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) minIndex = j;
            }
            swap(arr, minIndex, i);
        }
    }

    // Bubble Sort

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    // Recursive Bubble Sort

    public static void bubbleSortRecursive(int[] arr) {
        bubbleSortRecursive(arr, arr.length);
    }

    public static void bubbleSortRecursive(int[] arr, int length) {
        if (length == 1) return;
        for (int i = 0; i < length-1; i++) {
            if (arr[i] > arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
        bubbleSortRecursive(arr, length-1);
    }

    // Insertion Sort

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    // Merge Sort

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) return;

        int mid = arr.length / 2;
        int[] l = new int[mid];
        int[] r = new int[arr.length - mid];

        for (int i = 0; i < mid; i++) l[i] = arr[i];
        for (int i = mid; i < arr.length; i++) r[i - mid] = arr[i];

        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
    }

    public static void merge(int[] arr, int[] l, int[] r) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            if (l[i] <= r[j]) arr[k++] = l[i++];
            else arr[k++] = r[j++];
        }
        while (i < l.length) arr[k++] = l[i++];
        while (j < r.length) arr[k++] = r[j++];
    }

    // Quick Sort

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index-1);
            quickSort(arr, index+1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start-1;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1, end);
        return i+1;
    }

    // Heap Sort

    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) heapify(arr, arr.length, i);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest]) largest = l;
        if (r < n && arr[r] > arr[largest]) largest = r;

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    // Counting Sort

    public static void countingSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }

        int[] count = new int[(max - min + 1)];
        int[] output = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - min]++;
        }

        // Get the cumilative total thus far so you
        // know the starting index for the next number
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i] - min] - 1] = arr[i];
            count[arr[i] - min]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    // Radix Sort

    public static void radixSort(int[] arr) {
        int base = 10;
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }

        for (int exp = 1; max / exp > 0; exp *= base) {
            baseCountSort(arr, exp);
        }
    }

    public static void baseCountSort(int[] arr, int exp) {
        int base = 10;
        int[] output = new int[arr.length];
        int[] count = new int[base];

        for (int i = 0; i < arr.length; i++) {
            count[(arr[i] / exp) % base]++;
        }
 
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % base] - 1] = arr[i];
            count[(arr[i] / exp) % base]--;
        }
 
        for (int i = 0; i < arr.length; i++) {
            arr[i] = output[i];
        }
    }

    // Bucket Sort

    public static void bucketSort(int[] arr) {
        int max = max(arr);
        int min = min(arr);
        int numOfBuckets = max - min + 1;
        List<List<Integer>> buckets = new ArrayList<>(numOfBuckets);

        for (int i = 0; i < numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            int hash = hash(arr[i], min, numOfBuckets);
            buckets.get(hash).add(arr[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                arr[index++] = value;
            }
        }
    }

    private static int hash(int elem, int min, int numberOfBucket) {
        return (elem - min) / numberOfBucket;
    }

    // Shell Sort

    public static void shellSort(int[] arr) {
        for (int i = seqMaxValue(arr.length); i >= 1; i--) {
            int gap = A108870(i);
            for (int j = gap; j < arr.length; j++) {
                int temp = arr[j];
                int k;
                for (k = j; k >= gap && arr[k - gap] > temp; k -= gap) {
                    arr[j] = temp;
                }
            }
        }
    }

    private static int seqMaxValue(int length) {
        int output = 1;
        for (output = 1; A108870(output) <= length; output++);
        return output - 1;
    }

    private static int A108870(int k) {
        double nineOnFourPow = Math.pow((9d / 4d), k-1);
        double inBrackets = 9d * nineOnFourPow - 4d;
        return (int) Math.ceil((1d / 5d) * inBrackets);
    }

    // TimSort

    static final int MIN_MERGE = 32;

    public static void timSort(int[] arr) {

    }

}