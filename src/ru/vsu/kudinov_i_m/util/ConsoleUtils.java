package ru.vsu.kudinov_i_m.util;

import java.util.Scanner;

public class ConsoleUtils
{
    public static int readAnswer()
    {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    private static int getRandomNumber(int min, int max)
    {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static int[] getRandomArray()
    {
        System.out.println("Введите размер массива");
        int size = readAnswer();
        System.out.println("Введите нижнюю границу генерации элементов:");
        int min = readAnswer();
        System.out.println("Введите верхнюю границу генерации элементов:");
        int max = readAnswer();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = getRandomNumber(min, max);
        }
        return array;
    }
}
