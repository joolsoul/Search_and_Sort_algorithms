package ru.vsu.kudinov_i_m.sortAlgorithm;

public abstract class ISort {

    Integer swapCounter = 0;
    Integer comparisonCounter = 0;
    public abstract void sort(int[] array);

    public  <T> void swap(int[] array, int i, int j)
    {
        int tempTwo = array[i];
        array[i] = array[j];
        array[j] = tempTwo;
    }

    public Integer getSwapCounter() {
        return swapCounter;
    }

    public Integer getComparisonCounter() {
        return comparisonCounter;
    }
}
