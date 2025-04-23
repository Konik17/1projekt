
import java.io.IOException;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner scanner = new Scanner(System.in);

      System.out.println("Podaj imie:");
      String name = scanner.nextLine();
      
      System.out.println("Podaj wiek:");
      int age = scanner.nextInt();
      
      s.addStudent(new Student(name, age));

      var students = s.getStudents();
      for(Student current : students) {
        System.out.println(current.ToString());
      }
      
      scanner.close();
    } catch (IOException e) {

    }
  }
}
