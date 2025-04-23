import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);
      boolean running = true;

      while (running) {
        System.out.println("Wybierz opcję:");
        System.out.println("1: Dodaj studenta");
        System.out.println("2: Wyświetl studentów");
        System.out.println("3: Wyjdź");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
          case 1:
            System.out.println("Podaj imie:");
            String name = scanner.nextLine();

            System.out.println("Podaj nazwisko:");
            String nazwisko = scanner.nextLine();

            System.out.println("Podaj wiek:");
            int age = scanner.nextInt();
            scanner.nextLine(); 

            s.addStudent(new Student(name, age, nazwisko)); 
            break;
          case 2:
            var students = s.getStudents();
            for(Student current : students) {
              System.out.println(current.ToString());
            }
            break;
          case 3:
            running = false;
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