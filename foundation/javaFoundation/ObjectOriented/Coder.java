package foundation.javaFoundation.ObjectOriented;

public class Coder extends SingleDog {

    private String time;

    private int salary;

    public Coder() {

    }


    @Override
    public void work() {
        System.out.println("Coder work");
    }

    public void cs() {
        System.out.println("Coder cs");
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
