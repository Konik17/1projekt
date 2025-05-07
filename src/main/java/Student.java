public class Student {
  private String name;
  private String nazwisko;
  private int age;
  private String dataUrodzenia;

  public Student(String name, int age, String nazwisko, String dataUrodzenia) {
    this.name = name;
    this.age = age;
    this.nazwisko = nazwisko;
    this.dataUrodzenia = dataUrodzenia;
  }

  public String getName() {
    return name;
  }

  public String getNazwisko() {
    return nazwisko;
  }

  public int getAge() {
    return age;
  }

  public String getDataUrodzenia() {
    return dataUrodzenia;
  }

  @Override
  public String toString() {
    return name + ";" + nazwisko + ";" + age + ";" + dataUrodzenia;
  }

  public static Student Parse(String str) {
    if (str == null) return null;
    String[] data = str.split(";");
    if (data.length != 4)
      return null;

    try {
      String name = data[0];
      String nazwisko = data[1];
      int age = Integer.parseInt(data[2]);
      String dataUrodzenia = data[3];
      return new Student(name, age, nazwisko, dataUrodzenia);
    } catch (Exception e) {
      return null;
    }
  }

  public String toDisplayString() {
    return name + " " + nazwisko + ", " + age + " lat, ur. " + dataUrodzenia;
  }
}
