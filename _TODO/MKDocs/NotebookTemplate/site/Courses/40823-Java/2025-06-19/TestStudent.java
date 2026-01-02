class Student {
    String name;
    int age;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
        System.out.println("无参构造方法被调用。");
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("带参构造方法被调用。");
    }

    public void displayInfo() {
        System.out.println("姓名：" + name + ", 年龄：" + age);
    }
}

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.displayInfo();
        System.out.println("---");

        Student student2 = new Student("张三", 25);
        student2.displayInfo();
    }
}