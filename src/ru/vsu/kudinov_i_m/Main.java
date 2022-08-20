package ru.vsu.kudinov_i_m;

import ru.vsu.kudinov_i_m.searchAlgorithm.BinarySearchAlgorithm;
import ru.vsu.kudinov_i_m.searchAlgorithm.ISearch;
import ru.vsu.kudinov_i_m.searchAlgorithm.LinearSearchAlgorithm;
import ru.vsu.kudinov_i_m.sortAlgorithm.*;

import java.util.Arrays;

import static ru.vsu.kudinov_i_m.util.ArrayUtils.readIntArrayFromConsole;
import static ru.vsu.kudinov_i_m.util.ConsoleUtils.getRandomArray;
import static ru.vsu.kudinov_i_m.util.ConsoleUtils.readAnswer;

public class Main
{

    public static void main(String[] args)
    {
        // массив для примера - 8 5 9 2 1 4 6 10 5
        // массив для примера - 81, 23, 97, 55, 85, 38, 40, 85, 44, 2, 32, 23, 84, 98, 58
        createConsoleDialog();
    }

    public static void createConsoleDialog()
    {
        boolean checkConsoleDialog = true;
        while (checkConsoleDialog)
        {
            int[] array = new int[0];
            ISearch searchAlgorithm = null;
            ISort sortAlgorithm2 = null;
            int[] copy = new int[0];
            ISort  sortAlgorithm = null;
            boolean checkArrayInputType = false;
            boolean checkAlgorithmType = false;
            boolean isDouble = false;

            System.out.println("\n" + "Чтобы выбрать линейный алгоритм поиска - нажмите 1" + "\n");
            System.out.println("Чтобы выбрать бинарный алгоритм поиска - нажмите 2" + "\n");
            System.out.println("Чтобы выбрать линейный алгоритм сортировки  - нажмите 3" + "\n");
            System.out.println("Чтобы выбрать бинарный алгоритм сортировки - нажмите 4" + "\n");
            System.out.println("Чтобы выбрать пузырьковый алгоритм сортировки - нажмите 5" + "\n");
            System.out.println("Чтобы выбрать алгоритм сортировки Шелла - нажмите 6" + "\n");
            System.out.println("Чтобы выбрать алгоритм быстрой сортировки - нажмите 7" + "\n");
            System.out.println("Чтобы выбрать алгоритм сортировки слиянием - нажмите 8" + "\n");
            System.out.println("Чтобы выбрать алгоритм быстрой сортировки и алгоритм сортировки слиянием - нажмите 9");

            while (!checkAlgorithmType)
            {
                int algorithmTypeAnswer = readAnswer();
                System.out.println();

                switch (algorithmTypeAnswer)
                {
                    case 1 -> {
                        searchAlgorithm = new LinearSearchAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 2 -> {
                        searchAlgorithm = new BinarySearchAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 3 -> {
                        sortAlgorithm = new LinearInsertionSortAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 4 -> {
                        sortAlgorithm = new BinaryInsertionSortAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 5 -> {
                        sortAlgorithm = new BubbleSortAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 6 -> {
                        sortAlgorithm = new ShellAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 7 -> {
                        sortAlgorithm = new QuickSortAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 8 -> {
                        sortAlgorithm = new MergeSortAlgorithm();
                        checkAlgorithmType = true;
                    }
                    case 9 -> {
                        sortAlgorithm = new QuickSortAlgorithm();
                        sortAlgorithm2 = new MergeSortAlgorithm();
                        isDouble = true;
                        checkAlgorithmType = true;
                    }
                }
                if (!checkAlgorithmType)
                    System.out.println("Вы ввели неверное значение, попробуйте еще раз");
            }

            System.out.println("Если вы хотите ввести массив вручную - нажмите 1");
            System.out.println("Если вы хотите случайно сгенерировать массив - нажмите 2");

            while (!checkArrayInputType)
            {
                int arrayInputTypeAnswer = readAnswer();
                System.out.println();

                switch (arrayInputTypeAnswer)
                {
                    case 1 -> {
                        array = readIntArrayFromConsole(null);
                        copy = Arrays.copyOf(array, array.length);
                        checkArrayInputType = true;
                    }
                    case 2 -> {
                        array = getRandomArray();
                        checkArrayInputType = true;
                        System.out.println("Созданный массив:");
                        System.out.println(Arrays.toString(array));

                        copy = Arrays.copyOf(array, array.length);
                    }
                }
                if (!checkArrayInputType)
                    System.out.println("Вы ввели неверное значение, попробуйте еще раз");
            }
            if(searchAlgorithm != null) {
                System.out.println("Введите элемент, который хотите найти:");

                int desiredValue = readAnswer();
                searchAlgorithm.search(array, desiredValue);
            }
            if(sortAlgorithm != null && sortAlgorithm2 == null)
            {
                sortAlgorithm.sort(array);
            }
            if(isDouble)
            {
                sortAlgorithm.sort(array);
                sortAlgorithm2.sort(copy);

                System.out.println("\n" + "Переданный массив: " + Arrays.toString(array) + "\n");
                System.out.println("Быстрая сортировка:");
                System.out.println("Сравнений: " + sortAlgorithm.getComparisonCounter());
                System.out.println("Перестановок: " + sortAlgorithm.getSwapCounter());
                System.out.println("-----------------------------------------------");
                System.out.println("Сортировка слиянием:");
                System.out.println("Сравнений: " + sortAlgorithm2.getComparisonCounter());
                System.out.println("Перестановок: " + sortAlgorithm2.getSwapCounter());
            }

            System.out.println("\n" + "Для повторного ввода нажмите 1");
            System.out.println("Для выхода нажмите 2");
            int consoleDialogAnswer = readAnswer();
            if(consoleDialogAnswer == 2)
                checkConsoleDialog = false;

        }
    }
}
