package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class LinearInsertionSortAlgorithm extends ISort{

    @Override
    public void sort(int[] array) {
        int swapsCount = 0;
        System.out.println("\n" + "Переданный массив: " + Arrays.toString(array) + "\n");
        int size = array.length;
        for (int i = 0; i < size; i++)
        {
            int key = array[i];
            System.out.println("Текущий элемент: " + key + " Индекс элемента: " + i);
            int j;
            int currentSwapsCount = 0;
            for (j = i - 1; j >= 0 && array[j]> key; j--)
            {
                currentSwapsCount++;
                System.out.println(array[j] + ">" + key);
                swap(array, j, j + 1);
                swapsCount++;
            }
            System.out.println("Сравнений текущего элемента: " + currentSwapsCount);
            System.out.println("Всего сравнений: " + swapsCount + "\n");
            System.out.println(Arrays.toString(array));
            array[j + 1] = key;
        }
    }
}
