package foundation.hashtable.hashcode;

import java.util.HashMap;
import java.util.Objects;

public class HashCode {

    static class Student {
        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("kaiyan");
        Student student2 = new Student("kaiyan");
        System.out.println(student1.equals(student2));

        HashMap<Integer, Integer> map = new HashMap<>();
        int a = 1;
        int b = 1;
        map.put(a, 3);
        System.out.println(map.get(b));
    }


}
