package ru.vsu.kudinov_i_m.searchAlgorithm;

import ru.vsu.kudinov_i_m.searchAlgorithm.ISearch;

import java.util.Arrays;

public class LinearSearchAlgorithm implements ISearch
{
    @Override
    public int search(int[] array, int desiredValue)
    {
        System.out.println("\n" + "Переданный массив:");
        System.out.println(Arrays.toString(array));
        System.out.println("Величина переданного массива: " + array.length + " элементов");
        System.out.println("Искомое значение элемента: " + desiredValue + "\n");
        int numberOfComparisons = 0;
        int indexOfDesiredValue = -1;

        for (int i = 0; i < array.length; i++)
        {
            if(array[i] == desiredValue)
            {
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[i] + '=' + desiredValue);
                System.out.println("Произведено сравнений: " + numberOfComparisons + "\n");

                indexOfDesiredValue = i;
                System.out.println("Индекс искомого значения элеманта в массиве: " + indexOfDesiredValue);
                return indexOfDesiredValue;
            }
            else if (array[i] > desiredValue)
            {
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[i] + '>' + desiredValue);
            }
            else
            {
                numberOfComparisons++;
                System.out.println("Сравнение " + numberOfComparisons + ": " + array[i] + '<' + desiredValue);
            }
        }
        System.out.println("Произведено сравнений: " + numberOfComparisons + "\n");
        System.out.println("Искомое значение элемента не найдено");
        return indexOfDesiredValue;
    }
}
