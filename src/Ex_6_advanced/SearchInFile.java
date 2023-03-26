//Є файл. В файлі купа тексту.
//        Користувач вводить щось, що він хоче знати, чи є згадки про це слово у тексті.
//        Програма заглядає у файл, робить пошук, та видає результат у вигляді кількості згадувань у тексті цього слова.
//        Можливості пошуку закінчуються по стоп-слову.

package Ex_6_advanced;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SearchInFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть слово, яке хочете знайти: ");
        String wordToFind = scanner.nextLine();

        System.out.print("Введіть стоп-слово для завершення пошуку: ");
        String stopWord = scanner.nextLine();

        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("e:\\Java_Course\\IT Generation\\04_Java Professional\\Homework_4\\src\\Ex_6_advanced\\file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(stopWord)) {
                    break; // досягнуто стоп-слова, завершуємо пошук
                }
                count += countOccurrences(line, wordToFind);
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
            System.exit(1);
        }

        System.out.printf("Кількість згадувань слова '%s' у тексті: %d%n", wordToFind, count);
    }

    private static int countOccurrences(String line, String wordToFind) {
        int count = 0;
        int lastIndex = 0;
        while (lastIndex != -1) {
            lastIndex = line.indexOf(wordToFind, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += wordToFind.length();
            }
        }
        return count;
    }
}