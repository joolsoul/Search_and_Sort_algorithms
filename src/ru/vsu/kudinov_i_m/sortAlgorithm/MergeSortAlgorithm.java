package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class MergeSortAlgorithm extends ISort {

    @Override
    public void sort(int[] array) {
        System.out.println("\n" + "Переданный массив: " + Arrays.toString(array) + "\n");
        mergeSort(array, array.length);
        System.out.println("\n" + "Всего сравнений: " + comparisonCounter + "\n");
        System.out.println("Всего перестановок: " + swapCounter + "\n");
        System.out.println(Arrays.toString(array));
    }

    public void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            comparisonCounter ++;
            if (l[i] < r[j]) {
                a[k++] = l[i++];
                swapCounter ++;
            } else {
                a[k++] = r[j++];
                swapCounter ++;
            }
        }
        while (i < left) {
            a[k++] = l[i++];
            swapCounter ++;
        }
        while (j < right) {
            a[k++] = r[j++];
            swapCounter ++;
        }
        System.out.println(Arrays.toString(a));
    }
}
