package org.example;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        System.out.println("Задание 1");
        task1();

        System.out.println("\nЗадание 2");
        task2();

        System.out.println("\nЗадание 3");
        task3();

        System.out.println("\nЗадание 4");
        task4();

        System.out.println("\nЗадание 5");
        task5();
    }

    private static void task1() {
        String filename = "plant.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write("Любимое растение: Кактус\n");
            writer.write("Семейство: Кактусовые\n");
            writer.write("Родина: Америка\n");
            writer.write("Условия: много солнца, мало воды\n");
            System.out.println("Файл создан: " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\nДанные о файле");
        File file = new File(filename);
        System.out.println("Имя: " + file.getName());
        System.out.println("Размер: " + file.length() + " байт");
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Существует: " + file.exists());
        System.out.println("Можно читать: " + file.canRead());

        System.out.println("\nСодержимое файла");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }

    private static void task2() {
        String filename = "f2.txt";
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите 10 чисел (можно дробные, только положительные и ноль):");
            for (int i = 0; i < 10; i++) {
                double num = 0;
                boolean valid = false;

                while (!valid) {
                    System.out.print((i + 1) + "-е: ");
                    try {
                        num = scanner.nextDouble();
                        if (num < 0) {
                            System.out.println("Отрицательные числа не допускаются! Введите ещё раз.");
                        } else {
                            valid = true;
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Ошибка: нужно ввести число.");
                        scanner.nextLine();
                    }
                }

                numbers[i] = num;
                writer.println(numbers[i]);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        System.out.println("\nЧисла из файла");
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double num = Double.parseDouble(line.trim());
                System.out.println(num);

                if (num % 1 == 0) {
                    if (num % 2 == 0 || num % 3 == 0) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("\nКоличество целых чисел, кратных 2 или 3: " + count);
    }

    private static void task3() {
        String fileF = "f3.txt";
        String fileG = "g3.txt";
        String fileH = "h3.txt";
        Random random = new Random();

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileF))) {
            for (int i = 0; i < 20; i++) {
                writer.println(random.nextInt(100) + 1);
            }
            System.out.println("Файл f3.txt создан: 20 случайных чисел");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(fileF));
             PrintWriter writerG = new PrintWriter(new FileWriter(fileG));
             PrintWriter writerH = new PrintWriter(new FileWriter(fileH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                if (num % 5 == 0 && num % 7 == 0) {
                    writerG.println(num);
                } else {
                    writerH.println(num);
                }
            }
            System.out.println("Числа распределены по файлам g3.txt и h3.txt");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\nФайл g (кратные 5 и 7)");
        printFile(fileG);
        System.out.println("\nФайл h (остальные)");
        printFile(fileH);
    }

    private static void task4() {
        String filename = "radiation.txt";
        Scanner scanner = new Scanner(System.in);
        int N = 15;

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            System.out.println("Введите " + N + " значений уровня радиации (только положительные):");
            for (int i = 0; i < N; i++) {
                double value = 0;
                boolean valid = false;

                while (!valid) {
                    System.out.print((i + 1) + "-е: ");
                    try {
                        value = scanner.nextDouble();
                        if (value < 0) {
                            System.out.println("Уровень радиации не может быть отрицательным! Введите ещё раз.");
                        } else {
                            valid = true;
                        }
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Ошибка: нужно ввести число.");
                        scanner.nextLine();
                    }
                }

                writer.println(value);
            }
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        double sum = 0;
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double value = Double.parseDouble(line.trim());
                sum += value;
                count++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        if (count > 0) {
            double average = sum / count;
            System.out.printf("\nСредний уровень радиации: %.2f%n", average);
        } else {
            System.out.println("Файл пуст");
        }
    }

    private static void task5() {
        String filename = "f5.txt";

        int[] numbers = {10, 80, 45, 90, 76, 75, 100, 32, 85, 60};
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int num : numbers) {
                writer.println(num);
            }
            System.out.println("Файл f5.txt создан с 10 числами");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nЧисла из файла");
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line.trim());
                System.out.println(num);
                if (num > 75 && num >= 0) {
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }

        System.out.println("\nКоличество чисел > 75: " + count);
    }

    private static void printFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения: " + e.getMessage());
        }
    }
}