import java.io.*;
import java.util.Scanner;

public class testzadanie {
    private static final String data = "notebook.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите команду (read, write): ");
            String vvod = scanner.nextLine();

            if (vvod.equals("read")) {
                readEntries();
            } else if (vvod.equals("write")) {
                System.out.print("Введите новую запись: ");
                String entry = scanner.nextLine();
                addEntry(entry);
                break;
            } else {
                System.out.println("Неизвестная команда. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    private static void addEntry(String entry) {
        try (FileWriter writer = new FileWriter(data, true)) {
            writer.write(entry + "\n");
            System.out.println("Запись добавлена.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
        }
    }

    private static void readEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(data))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла.");
        }
    }
}
