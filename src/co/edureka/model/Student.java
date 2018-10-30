package co.edureka.model;

public class Student {
    private int rollId;
    private String name;
    private String email;
    private int age;
    private String address;

    public Student(){

    }

    public Student(int rollId) {
        this.rollId = rollId;
    }

    public Student(int rollId, String name, String email, int age, String address) {
        this.rollId = rollId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public Student(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public int getRollId() {
        return rollId;
    }

    public void setRollId(int rollId) {
        this.rollId = rollId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollId=" + rollId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
