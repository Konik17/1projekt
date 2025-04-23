public class Student {
  private String Name;
  private String Nazwisko; 
  private int Age;

 
  public Student(String name, int age, String nazwisko) {
    Name = name;
    Age = age;
    Nazwisko = nazwisko; 
  }

  public String GetName() {
    return Name;
  }

  public String GetNazwisko() { 
    return Nazwisko;
  }

  public int GetAge() {
    return Age;
  }

  public String ToString() {
    return Name + " " + Nazwisko + " " + Age; 
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if (data.length != 3) 
      return new Student("Parse Error", -1, "Parse Error");
    return new Student(data[0], Integer.parseInt(data[2]), data[1]); 
  }
}