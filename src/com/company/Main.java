package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 10000;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
        System.out.println("-------------------\n Mars mission \n По условию необходимо переправить 90000 ящиков " +
                "\n при вместимости контейнера - 34 ящика, вместимость корабля - 11 контейнеров");
        Scanner numOfBoxes = new Scanner(System.in);
        System.out.println("Введите число ящиков:");
        int box = numOfBoxes.nextInt();

        Scanner inputContainerCapacity = new Scanner(System.in);
        System.out.println("Введите вместимость контейнера:");
        int containerCapacity = inputContainerCapacity.nextInt();

        Scanner inputShipCapacity = new Scanner(System.in);
        System.out.println("Введите вместимость корабля:");
        int shipCapacity = inputShipCapacity.nextInt();
        int containersAmount = box / containerCapacity;// количество контейнеров
        int shipsAmount = containersAmount / shipCapacity;//количество кораблей
        int modBoxAmount = box % containersAmount;//количество не вошедших в контейнер ящиков
        int modContainerAmount = shipsAmount % shipCapacity;//количество не вошедших в корабль контейнеров

        if (modBoxAmount == 0 && modContainerAmount == 0) {//остатков ящиков и контейнеров нет, выводим список
            for (int i = 1; i <= shipsAmount; i++) {
                System.out.println("Корабль " + i);
                for (int j = 1; j <= shipCapacity; j++) {
                    System.out.println("  Контейнер " + j);
                    for (int k = 1; k <= containerCapacity; k++) {
                        System.out.println("     Ящик " + k);
                    }
                }
            }
        } else {// имеем контейнеры и (или) ящики не попавшие на корабль или в контейнер
            for (int i = 1; i <= shipsAmount; i++) {
                if (i == shipsAmount) {//начинаем выводить список до момента вывода последнего корабля
                    System.out.println("Корабль " + i);
                    for (int j = 1; j <= shipCapacity; j++) {
                        System.out.println("  Контейнер " + j);
                        for (int k = 1; k <= containerCapacity; k++) {
                            System.out.println("     Ящик " + k);
                        }
                    }
                    System.out.println("Корабль " + (i + 1));
                    if (modContainerAmount == 0 && modBoxAmount != 0) {//добавляем последний корабль в списке при случае
                                                                       //отсутствия контейнеров и наличия ящиков
                        System.out.println("  Контейнер 1");
                        for (int j = 1; j <= modBoxAmount; j++) {
                            System.out.println("     Ящик " + j);
                        }
                    } else {
                        for (int j = 1; j <= modContainerAmount; j++) {//добавляем в последний корабль контейнер при
                                                                       //отсутствии ящиков
                            System.out.println("  Контейнер " + j);
                            for (int k = 1; k <= containerCapacity; k++) {
                                System.out.println("     Ящик " + k);
                            }
                            if (j == modContainerAmount) {
                                if (modBoxAmount == 0 && modContainerAmount != 0) {
                                    System.out.println("");
                                } else { //добавляем последние контейнеры при наличии контейнеров и ящиков
                                    System.out.println("  Контейнер " + (j + 1));
                                    for (int k = 1; k <= modBoxAmount; k++) {
                                        System.out.println("     Ящик " + k);
                                    }
                                }
                            }
                        }
                    }
                } else {//вывод списка до предпоследного корабля
                    System.out.println("Корабль " + i);
                    for (int j = 1; j <= shipCapacity; j++) {
                        System.out.println("  Контейнер " + j);
                        for (int k = 1; k <= containerCapacity; k++) {
                            System.out.println("     Ящик " + k);
                        }
                    }
                }
            }
        }
    }
}
