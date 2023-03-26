//Напишіть жартівливу програму  «Дешифратор», яка в текстовому файлі могла б замінити всі прийменники слово «Java».

package Ex_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deshifrovator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ім'я текстового файлу: ");
        String filename = scanner.nextLine();

        try {
            File file = new File(filename);
            Scanner fileScanner = new Scanner(file);

            StringBuilder sb = new StringBuilder();
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.toLowerCase().equals("в") || word.toLowerCase().equals("на") || word.toLowerCase().equals("з") || word.toLowerCase().equals("під")) {
                        sb.append("Java ");
                    } else {
                        sb.append(word + " ");
                    }
                }
                sb.append("\n");
            }

            FileWriter writer = new FileWriter(file);
            writer.write(sb.toString());
            writer.close();

            System.out.println("Заміна прийменників на 'Java' успішно виконана!");

        } catch (IOException e) {
            System.out.println("Сталася помилка: " + e.getMessage());
        }
    }
}