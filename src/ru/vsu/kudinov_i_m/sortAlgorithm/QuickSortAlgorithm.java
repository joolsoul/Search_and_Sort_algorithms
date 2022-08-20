package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class QuickSortAlgorithm extends ISort{

    @Override
    public void sort(int[] orderValues) {
        System.out.println("\n" + "Переданный массив: " + Arrays.toString(orderValues) + "\n");
        quickSort(orderValues, 0, orderValues.length);
        System.out.println("\n" + "Всего сравнений: " + comparisonCounter + "\n");
        System.out.println("Всего перестановок: " + swapCounter + "\n");
        System.out.println(Arrays.toString(orderValues));
    }

    private int partition(int[] arr, int left, int right)
    {
        int l = left;
        int r = right - 1;
        int comparisonElement = arr[r];
        System.out.println("\n" + "Левый индекс: " + l + "  Правый индекс: " + r);
        System.out.println("Текущий опорный элемент: " + comparisonElement);
        while (l <= r) {
            while (arr[l] < comparisonElement)
            {
                System.out.println("Сравнение: " + comparisonElement + " > " + arr[l]);
                comparisonCounter++;
                l++;
            }
            System.out.println(comparisonElement + " =< " + arr[l]);
            System.out.println("Выбранный для обмена левый элемент: " + arr[l]);
            while (arr[r] > comparisonElement)
            {
                System.out.println("Сравнение: " + comparisonElement + " < " + arr[r]);
                comparisonCounter++;
                r--;
            }
            System.out.println(comparisonElement + " >= " + arr[r]);
            System.out.println("Выбранный для обмена правый элемент: " + arr[r]);
            if (l <= r)
            {
                swap(arr, r, l);
                System.out.println("Обмен: " + arr[l] + " <-> " + arr[r]);
                System.out.println(Arrays.toString(arr));
                if(l != r)
                swapCounter++;
                l++;
                r--;
            }
        }
        if (l == right)
        {
            l--;
        }
        return l;
    }

    private void quickSort(int[] arr, int left, int right)
    {
        if (left < right - 1)
        {
            int xIndex = partition(arr, left, right);
            quickSort(arr, left, xIndex);
            quickSort(arr, xIndex, right);
        }
    }
}
