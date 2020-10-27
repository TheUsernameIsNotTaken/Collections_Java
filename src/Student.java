import java.util.Comparator;

public class Student implements Comparable<Student>{
	String name;
	String code;
	int age;

	public Student(String name, String code, int age) {
		this.name = name;
		this.code = code;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + "(" + age + ")-" + code;
	}

	@Override
	public int compareTo(Student other) {
		int dif = this.name.compareTo(other.name);
		if (dif != 0) return dif;
		return Integer.compare(this.age, other.age);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals: "+ this + " " + obj.toString());
		if (obj == null || !(obj instanceof Student)) {
			return false;
		}
		Student s = (Student) obj;
		return code.equals(s.code);
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode: " + this);
		return name.length();                                   // ha az új elem hossza különbözik a korábbiaktól csak a hashcode hívódik meg, ha bármelyikkel megegyezne akkor az equals is meg fog hívódni
	}

	public static class SortByCodeAndAge implements Comparator<Student> {

		@Override
		public int compare(Student s1, Student s2) {
			int dif = s1.code.compareTo(s2.code);
			if(dif != 0)	return dif;
			return Integer.compare(s1.age, s2.age);
		}
	}
}
