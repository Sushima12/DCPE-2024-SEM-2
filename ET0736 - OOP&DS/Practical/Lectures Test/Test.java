public class Test { 
    public static void main(String[] args) { 
        Faculty f1 = new Faculty(); 
    } 
} 

class Person { 
    Person() { 
        System.out.println ("Person's no-arg constructor"); 
    } 
} 
class Faculty extends Employee { 
    Faculty() { 
        System.out.println("Faculty's no-arg constructor");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
    } 
}

class Employee extends Person { 
    Employee() { 
        System.out.println("Employee's no-arg constructor"); 
    } 
} 
