package jobPrep2019.amazon.other;

import java.util.ArrayList;
import java.util.HashSet;

public class findCommonManager {

    class Employee {
        private int id;
        private String name;
        private ArrayList<Employee> reports;

        public ArrayList<Employee> getReports() {
            return reports;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    Employee findLCAHelper(Employee em, Employee em1, Employee em2) {
        if (em == null || em == em1 || em == em2)
            return em;
        ArrayList<Employee> nexts = em.getReports();
        HashSet<Employee> set = new HashSet<Employee>();

        for (Employee next : nexts) {
            set.add(findLCAHelper(next, em1, em2));
        }

        set.remove(null);
        if (set.size() == 1) {
            for (Employee tmp : set) {
                return tmp;
            }
        } else return em;
        return null;
    }

    Employee findCommonManager(Employee ceo, Employee em1, Employee em2) {
            Employee ans = findLCAHelper(ceo, em1, em2);
            if (ans == ceo) return null;
            return ans;
    }
}
