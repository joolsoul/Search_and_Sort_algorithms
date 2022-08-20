package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class ShellAlgorithm extends ISort{

    @Override
    public void sort(int[] array) {
        System.out.println("\n" + "Переданный массив: " + Arrays.toString(array) + "\n");
        int h = 1;
        while (h*3 < array.length)
            h = h * 3 + 1;

        while(h >= 1) {
            hSort(array, h);
            h = h/3;
        }
        System.out.println("Всего сравнений: " + comparisonCounter);
        System.out.println("Всего перестановок: " + swapCounter + "\n");
    }

    private void hSort(int[] array, int h) {
        System.out.println("\n" + "Текущий шаг: " + h);
        int currentComparisonCounter = 0;
        int currentSwapCounter = 0;
        for (int i = h; i < array.length; i++) {
            for (int j = i; j >= h; j = j - h) {
                System.out.println("Сравнение: " + array[j - h] + " c " + array[j]);
                currentComparisonCounter++;
                comparisonCounter++;
                if (array[j] < array[j - h]) {
                    System.out.println("·Перестановка: " + array[j] + "->" + array[j - h]);
                    swap(array, j, j - h);
                    currentSwapCounter++;
                    this.swapCounter++;
                } else
                    break;
            }
            System.out.println("-----------------------------------------------");
            System.out.println(Arrays.toString(array) + "\n");
        }
        System.out.println("Сравнений в текуще шаге: " + currentComparisonCounter);
        System.out.println("Перестановок в текуще шаге: " + currentSwapCounter + "\n");
    }
}
