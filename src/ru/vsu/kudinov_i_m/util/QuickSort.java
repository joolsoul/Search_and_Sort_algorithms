package ru.vsu.kudinov_i_m.util;

public class QuickSort
{
    public static <T> void sort(int[] sortableArray)
    {
        quickSort(sortableArray, 0, sortableArray.length);
    }

    private static <T> int partition(int[] sortableArray, int leftBorder, int rightBorder)
    {
        int l = leftBorder;
        int r = rightBorder - 1;
        int x = sortableArray[(l + r) / 2];
        while (l <= r) {
            while (sortableArray[l] < x)
            {
                l++;
            }
            while (sortableArray[r] > x)
            {
                r--;
            }
            if (l <= r)
            {
                swap(sortableArray, r, l);

                l++;
                r--;
            }
        }
        if (l == rightBorder)
        {
            l--;
        }

        return l;
    }

    private static <T> void quickSort(int[] sortableArray, int leftBorder, int rightBorder)
    {
        if (leftBorder < rightBorder - 1)
        {
            int xIndex = partition(sortableArray, leftBorder, rightBorder);
            quickSort(sortableArray, leftBorder, xIndex);
            quickSort(sortableArray, xIndex, rightBorder);
        }
    }

    private static void swap(int[] sortableArray, int firstVariable, int secondVariable)
    {
        int tempTwo = sortableArray[firstVariable];
        sortableArray[firstVariable] = sortableArray[secondVariable];
        sortableArray[secondVariable] = tempTwo;
    }
}
