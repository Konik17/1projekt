import java.io.IOException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while (running) {
        System.out.println("\nWybierz opcję:");
        System.out.println("1: Dodaj studenta");
        System.out.println("2: Wyświetl wszystkich studentów");
        System.out.println("3: Wyjdź");
        System.out.println("4: Wyszukaj studentów po imieniu");
        System.out.println("5: Usuń studenta (po imieniu i nazwisku)");
        System.out.println("6: Zaktualizuj dane studenta (zmień wiek)");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
          case 1:
            System.out.print("Podaj imię: ");
            String name = scanner.nextLine();

            System.out.print("Podaj nazwisko: ");
            String nazwisko = scanner.nextLine();

            System.out.print("Podaj wiek: ");
            int age = scanner.nextInt();

            int rok, miesiac, dzien;
            do {
              System.out.print("Podaj rok urodzenia (1900–2025): ");
              rok = scanner.nextInt();
            } while (rok < 1900 || rok > 2025);

            do {
              System.out.print("Podaj miesiąc urodzenia (1–12): ");
              miesiac = scanner.nextInt();
            } while (miesiac < 1 || miesiac > 12);

            do {
              System.out.print("Podaj dzień urodzenia (1–31): ");
              dzien = scanner.nextInt();
            } while (dzien < 1 || dzien > 31);

            scanner.nextLine(); 

            String dataUrodzenia = String.format("%04d-%02d-%02d", rok, miesiac, dzien);
            s.addStudent(new Student(name, age, nazwisko, dataUrodzenia));
            System.out.println("Dodano studenta.");
            break;

          case 2:
            var students = s.getStudents();
            if (students.isEmpty()) {
              System.out.println("Brak studentów w bazie.");
            } else {
              for (Student current : students) {
                System.out.println(current.toDisplayString());
              }
            }
            break;

          case 3:
            running = false;
            break;

          case 4:
            System.out.print("Podaj imię do wyszukania: ");
            String imieSzukane = scanner.nextLine();
            var znalezieni = s.findStudentsByName(imieSzukane);
            if (znalezieni.isEmpty()) {
              System.out.println("Nie znaleziono studentów o podanym imieniu.");
            } else {
              System.out.println("Znalezieni studenci:");
              for (Student st : znalezieni) {
                System.out.println(st.toDisplayString());
              }
            }
            break;

          case 5:
            System.out.print("Podaj imię studenta do usunięcia: ");
            String imieDel = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta do usunięcia: ");
            String nazwiskoDel = scanner.nextLine();

            boolean success = s.removeStudentByNameAndSurname(imieDel, nazwiskoDel);
            if (success) {
              System.out.println("Student został usunięty.");
            } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
            }
            break;

          case 6:
            System.out.print("Podaj imię studenta do zaktualizowania: ");
            String imieAktualizowane = scanner.nextLine();

            System.out.print("Podaj nazwisko studenta do zaktualizowania: ");
            String nazwiskoAktualizowane = scanner.nextLine();

            System.out.print("Podaj nowy wiek: ");
            int nowyWiek = scanner.nextInt();

            boolean updated = s.updateStudentAgeByNameAndSurname(imieAktualizowane, nazwiskoAktualizowane, nowyWiek);
            if (updated) {
              System.out.println("Wiek studenta został zaktualizowany.");
            } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu i nazwisku.");
            }
            break;

          default:
            System.out.println("Nieprawidłowy wybór, spróbuj ponownie.");
        }
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.println("Wystąpił błąd: " + e.getMessage());
    }
  }
}
