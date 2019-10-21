package foundation.javaFoundation.ObjectOriented;

public class SingleDog {

    // encapsulation
    private String name;

    private String gender;

    private String job;

    public SingleDog() {

    }

    public void work() {
        System.out.println("Single Dog work");
    }

    public void play() {
        System.out.println("Single Dog play");
    }


    static {
        System.out.println("static");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
