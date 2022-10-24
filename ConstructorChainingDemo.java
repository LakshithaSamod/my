
class SuperClass {

    SuperClass() {
        System.out.println("Executing constructor of the super class");
    }
}

public class ConstructorChainingDemo extends SuperClass{
//default constructor of the class

    public ConstructorChainingDemo() {
        //super(); //automatic put this
        System.out.println("Executing no-arg constructor");
    }

    public ConstructorChainingDemo(String str) {
        this();
        System.out.println("Executing constructor with one parameter");
    }

    public ConstructorChainingDemo(String str, int num) {
//It will call the constructor with String argument
        this("Hello");
        System.out.println("Executing constructor with two parameters");
    }

    public ConstructorChainingDemo(int num1, int num2, int num3) {
// It will call the constructor with (String, integer) arguments
        this("Hello", 2);
        System.out.println("Executing constructor with three parameters");
    }

    public static void main(String args[]) {
//Creating an object using Constructor with 3 int arguments
        ConstructorChainingDemo object = new ConstructorChainingDemo(10, 5, 15);
    }
}
