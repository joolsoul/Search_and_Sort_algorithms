package ru.vsu.kudinov_i_m.searchAlgorithm;

import java.util.Arrays;

import static ru.vsu.kudinov_i_m.util.QuickSort.sort;

public class BinarySearchAlgorithm implements ISearch
{

    @Override
    public int search(int[] array, int desiredValue)
    {
        sort(array);

        System.out.println("\n" + "Переданный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println("Величина переданного массива: " + array.length + " элементов");
        System.out.println("Искомое значение элемента: " + desiredValue + "\n");

        boolean isFound = false;
        int leftBorder = 0;
        int rightBorder = array.length -1;
        int middle = (rightBorder + leftBorder) / 2;
        int numberOfComparisons = 0;
        int indexOfDesiredValue = -1;

        while (!isFound && rightBorder >= leftBorder)
        {
            if(desiredValue == array[middle])
            {
                isFound = true;
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[middle] + '=' + desiredValue);
                System.out.println("Произведено сравнений: " + numberOfComparisons + "\n");

                indexOfDesiredValue = middle;
                System.out.println("Индекс искомого значения элеманта в массиве: " + indexOfDesiredValue);
                return indexOfDesiredValue;
            }
            else if(desiredValue < array[middle])
            {
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[middle] + '>' + desiredValue);
                rightBorder = middle - 1;
                middle = (rightBorder + leftBorder) / 2;
            }
            else
            {
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[middle] + '<' + desiredValue);
                leftBorder = middle + 1;
                middle = (rightBorder + leftBorder) / 2;
            }
        }
        System.out.println("Произведено сравнений: " + numberOfComparisons + "\n");
        System.out.println("Искомое значение элемента не найдено");
        return indexOfDesiredValue;
    }
}
