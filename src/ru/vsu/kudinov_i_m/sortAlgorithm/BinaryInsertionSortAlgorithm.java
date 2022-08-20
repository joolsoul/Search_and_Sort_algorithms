package ru.vsu.kudinov_i_m.sortAlgorithm;

import java.util.Arrays;

public class BinaryInsertionSortAlgorithm extends ISort{

    @Override
    public void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            System.out.println("Текущий элемент: " + key + " Индекс элемента: " + i);
            int leftBorder = 0;
            int rightBorder = i;
            int currentSwapsCount = 0;
            while (leftBorder < rightBorder) {
                int mid = leftBorder + (rightBorder - leftBorder) / 2;
                swapCounter++;
                if (key < (array[mid])) {
                    rightBorder = mid;
                    System.out.println(key + "<" +  array[mid]);
                } else {
                    leftBorder = mid + 1;
                    System.out.println(key + ">" +  array[mid]);
                }
            }
            for (int j = i; j > leftBorder; j--) {
                array[j] = array[j - 1];
            }
            array[leftBorder] = key;
            System.out.println("Сравнений текущего элемента: " + currentSwapsCount);
            System.out.println("Всего сравнений: " + swapCounter + "\n");
            System.out.println(Arrays.toString(array));
        }
    }
}
