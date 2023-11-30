import java.time.Duration;
import java.time.Instant;

public class Main {
   public static void main(String[] args) {
        // Запускаємо основний потік
        Thread mainThread = new Thread(() -> {
            Instant startTime = Instant.now();

            while (true) {
                Instant currentTime = Instant.now();
                Duration duration = Duration.between(startTime, currentTime);
                System.out.println("Пройшло часу: " + duration.getSeconds() + " секунд");

                try {
                    // Пауза на 1 секунду
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаємо потік для виведення повідомлення кожні 5 секунд
        Thread messageThread = new Thread(() -> {
            while (true) {
                System.out.println("Минуло 5 секунд");

                try {
                    // Пауза на 5 секунд
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запускаємо обидва потоки
        mainThread.start();
        messageThread.start();

    }
}