package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class BubbleSortAlgorithm extends ISort {

    @Override
    public void sort(int[] array) {
        System.out.println("\n" + "Переданный массив: " + Arrays.toString(array) + "\n");
        for (int i = array.length - 1; i >= 0; i--)
        {
            int currentComparisonCounter = 0;
            int swapCounter = 0;

            for (int j = 0; j < i; j++)
            {
                comparisonCounter ++;
                currentComparisonCounter ++;
                System.out.println("Сравнение: " + array[j] + " с " + (array[j + 1]));
                if (array[j] > (array[j + 1]))
                {
                    swap(array, j, j + 1);
                    System.out.println("·Перестановка: " + array[j + 1] + "->" + (array[j]));
                    this.swapCounter++;
                    swapCounter++;
                }
            }
            System.out.println("Сравнений в текуще шаге: " + currentComparisonCounter);
            System.out.println("Перестановок в текущем шаге: " + swapCounter);
            System.out.println("-----------------------------------------------");
            System.out.println(Arrays.toString(array)  + "\n");
        }
        System.out.println("Всего сравнений: " + comparisonCounter);
        System.out.println("Всего перестановок: " + swapCounter + "\n");
    }
}
