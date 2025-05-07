import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class Service {

  public void addStudent(Student student) throws IOException {
    try (BufferedWriter b = new BufferedWriter(new FileWriter("db.txt", true))) {
      b.write(student.toString());
      b.newLine();
    }
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    try (BufferedReader reader = new BufferedReader(new FileReader("db.txt"))) {
      String line;
      while ((line = reader.readLine()) != null) {
        Student parsed = Student.Parse(line);
        if (parsed != null) {
          ret.add(parsed);
        }
      }
    }
    return ret;
  }

  public Collection<Student> findStudentsByName(String name) throws IOException {
    var students = getStudents();
    var matches = new ArrayList<Student>();
    for (Student student : students) {
      if (student.getName().equalsIgnoreCase(name)) {
        matches.add(student);
      }
    }
    return matches;
  }
}
