//Спроектуйте та розробте метод на Java, який визначає, скільки часу пройшло із заданої дати.
//
//        За допомогою цього методи виведіть у консоль, скільки часу пройшло з
//        вашого дня народження у зручному для сприйняття вигляді, наприклад:
//        «Вам виповнилося 20 років, 3 місяці, 18 днів, 4 години, 5 хвилин та 10 секунд».

package Ex_4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class AgeCalculator {

    public static void main(String[] args) {
        LocalDate birthday = LocalDate.of(1986, 8, 5);
        LocalDateTime now = LocalDateTime.now();

        Period period = Period.between(birthday, now.toLocalDate());
        Duration duration = Duration.between(LocalTime.MIDNIGHT, now.toLocalTime());

        System.out.printf("Вам виповнилося %d років, %d місяців, %d днів, %d годин, %d хвилин та %d секунд",
                period.getYears(), period.getMonths(), period.getDays(),
                duration.toHoursPart(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}