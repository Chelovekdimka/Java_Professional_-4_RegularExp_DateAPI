//Створити регулярний вираз для відфільтровування невалідних паролів.
//        Вимоги до пароля придумайте якомога високими і реалізуйте цей патерн.
//
//        Пароль повинен містити принаймні одну велику і одну малу літеру.
//        Пароль повинен містити принаймні одну цифру.
//        Пароль повинен містити принаймні один спеціальний символ.
//        Пароль повинен бути не менше 8 символів у довжину.

package Ex_5_advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPass {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введіть пароль: ");
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&_-])[A-Za-z\\d@$!%*?&_-]{8,}$");

//        ^ - Початок рядка.
//        (?=.*[a-z]) - Перегляд назад, щоб знайти малу літеру в паролі.
//        (?=.*[A-Z]) - Перегляд назад, щоб знайти велику літеру в паролі.
//        (?=.*\\d) - Перегляд назад, щоб знайти цифру в паролі.
//        (?=.*[@$!%*?&]) - Перегляд назад, щоб знайти принаймні один спеціальний символ.
        while (true) {
            String password = bf.readLine();
            Matcher matcher = pattern.matcher(password);
            if(matcher.matches()){
                System.out.println("пароль проходить валідацію");
                break;
            } else {
                System.out.println("пароль не проходить валідацію");
            }
    }
    }
}
