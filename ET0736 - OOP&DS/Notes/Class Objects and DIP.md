
---
--- CONTENTS ---
1. Defining a Class and Creating Object
2. Constructor
3. `this` keyword
4. Array of Objects and Sorting with Comparators
5. Passing Objects to Methods
6. String Class
7. Static Variable and Methods
8. Getter and Setter Methods
9. Package in Java
10. Java Wrapper Class

---
#### Defining a Class and Creating Object

>Characteristics of Class
1. Has a class name
2. Has data fields / attributes / properties
3. Has methods / functions
4. Class hides data fields and methods

>Defining a Class
```java
public class Project {
	public static void main(String[] args) {
		//main code
	}
} 
// end of project class
// start your custom class from here
class SpStudent{
	String name;
	String ID;
	double GPA;
}

```
`Note`
- If `SpStudent` class is inside a `Project` class, then have to add `public static`
```java
public class Project {
	public static void main(String[] args) {
		//main code
	}
	public static class SpStudent{
		String name;
		String ID;
		double GPA;
	}
} 
```

>Objects
- Are created from classes

>Creating Objects and Initializing Data Fields
- Given the same `SpStudent` class, in `main()`:
```java
public class Project {
	public static void main(String[] args) {
		//main code
		//Creating an object
		SpStudent s1 = new SpStudent();
		
		//Initializing the Data Fields from the class
		s1.name="Aoyama";
		s1.ID = "1919191";
		s1.GPA = 3.88;
	}
} 
```
`s1`
- an instance/object of type `SpStudent` class

---
#### Constructor

>Class Constructor
- A special type of method
- Defined inside the class
- Must have the same name as the class
- Does not have a return type _(Not even void)_
- Called automatically when object is created with `new` keyword
- Commonly used to 'automate' the initializing of variables of object

>Creating Class Constructor
```java
public class Project {
	public static void main(String[] args) {
		//main code
		SpStudent s1 = new SpStudent("Name", "ID", "GPA");
	}
} 
// end of project class
// start your custom class from here
class SpStudent{
	String name;
	String ID;
	double GPA;
	
	//Constructor
	SpStudent(String n, String id, String gpa) {
		name = n;
		ID = id;
		GPA = gpa;
	}
}
```

>Overloading Constructors
- Multiple constructor with unique signatures
```java
public class Project {
	public static void main(String[] args) {
		//main code
		SpStudent s1 = new SpStudent();
		SpStudent s2 = new SpStudent("Name", "ID", "GPA");
	}
} 

class SpStudent{
	String name;
	String ID;
	double GPA;
	
	//Constructor 1
	SpStudent(){
		name = "Alpha";
		ID = "2241885";
		GPA ="3.14";
	}
	
	//Constructor 2
	SpStudent(String n, String id, String gpa) {
		name = n;
		ID = id;
		GPA = gpa;
	}
}
```
`s1`
- Reference to `Constructor 1`
`s2`
- Reference to `Constructor 2`

---
#### `this` keyword

>Usage of `this` keyword
- When parameter names are the same as attribute names
- To differentiate class attributes  and incoming input parameters

>Example
```java
class SpStudent{
	String name;
	String ID;
	double GPA;
	
	SpStudent(String name, String ID, String GPA) {
		this.name = name;
		this.ID = ID;
		this.GPA = GPA;
	}
}
```
`(String name, String ID, String GPA)`
- Incoming input parameters

`this.name`
`this.ID`
`this.GPA`
- Refers to `name`, `ID`, and `GPA` attribute as declared at the top in the class

---
#### Array of Objects and Sorting with Comparators

>Array of Objects
- Example:
```java
Car[] cars = { 
	new Car ("SGX1234","Toyota",4.3), 
	new Car ("SNG8888","Honda",1.9) 
};
```

>Sorting Array of Objects
- `Arrays.sort(array,Helper_Class)`,
```java
//in main():
Arrays.sort (cars, new SortByBrand());
```
  and
- Helper class implementing `Comparator` interface:
```java
class SortByBrand implements Comparator<Car> { 
	@Override 
	public int compare(Car a, Car b) { 
	// sort by car brand 
		return(int)(a.brand.compareTo(b.brand));
	}
}
```
`implements Comparator<Car>`
- implementing Comparator interface with type `Car` _(Class/Object)_
- `< E >` indicates that the container is a generic class

`public int compare(Car a, Car b)`
- Required to implement the method, `compare(E, E)`

`a.brand.compareTo(b.brand)`
- String Class method
  - Compares 2 string lexicographically
  - Refer to [[Introduction to Java Object Oriented Programing]]


---
#### Referencing Objects and Passing Objects to Methods

>Object Reference
- Object Types
  - not primitive types of variables
- Name of Object Variable
  - is the 'reference' to the object
- Example
```java
class ClassName {
	//code
}

//in main()
ClassName c1 = new ClassName(); //refering to object c1
ClassName c2 = new ClassName(); //refering to object c2

c2 = c1
```

`c2 = c1`
- `c2` points to object `c1`
- Not a copy of object `c1`
- The object previously referenced is no longer accessible, referred as  `garbage`
  
>Cloning of objects
- Class need to implement `java.lang.Cloneable` interface

>Passing Object to Method
- Passed by reference into methods
```java
class Animal {
	// some code
}

public class main {
	public static void main(String[] args) {
		//Creating Object "animal"
		Animal animal = new Animal();
		
		//Call ChopAnimal() function
		ChopAnimal(animal)
	}
	
	//Function with parameter that only accepts Animal type objects
	static void ChopAnimal(Animal a) {
		//some code
	}
}
```

---
#### String Class

>Modifying String Objects
- Can use Classes such as:
  - `StringBuilder()`
```java
class TestString { 
	public static void main(String[] args) { 
		StringBuilder s = new StringBuilder ("I like orange" );
		ABC(s); 
		System.out.println ("After ABC() called, s = " +s); 
	} 
				  
	public static void ABC(StringBuilder a) { 
		// new string object is created as old literal is immutable 
		a += " and apple"; 
	
		System.out.println ("Inside ABC() , s = " +a); 
	} 
}
```
  - `StringBuffer()`

---
#### Static Variable and Methods

>Static Variable
- is attached to a `Class`
- shared by all objects of the `Class`
- has only 1 copy of the variable
- is declared with `static` keyword
- Can be assessed by 
  - `Class_name.Variable_name`
  - `Object_name.Variable_name`
- Example:
```java
class Circle { 
	String Color; 
	double Radius; 
	static int count=0; // class variable 
	
	Circle (String c, double r){ 
		Color = c; 
		Radius = r; 
		count++; 
	} 
} 

public class TestClassVariable { 
	public static void main(String[] args) { 
		Circle x = new Circle("red",1.0); 
		System.out.println ("count=" + Circle.count); // Count = 1
		Circle y = new Circle("red",5.0); 
		Circle z = new Circle("blue",10.0); 
		System.out.println ("count=" + y.count); //Count = 3
	} 
}
```

>Static Methods
- Attached to a class (not to any specific object)
- Similar to class variable, where a `static` modifier is added in front of a method
- Can be accessed by 
  - `Class_name.method_name`
  - `Object_name.method_name`
- Can only other static methods and static variables defined in the class
- Using non-static method and variable in the class results in the compiler warning that it cannot be referenced from a static context
- Example of static methods:
```java
class SPApartmentRental { 
	private double rental; 
	private static int UnitsLeft=10; 
	SPApartmentRental(double r) { 
		UnitsLeft--; 
		rental = r; 
	} 
	static int getUnitsLeft() { 
		return UnitsLeft; 
	} 
} 
public class TestStaticMethod { 
	public static void main(String[] args) { 
		System.out.println(SPApartmentRental.getUnitsLeft()); //class_name.method_name
		SPApartmentRental s1 = new SPApartmentRental(1800.50); 
		System.out.println(s1.getUnitsLeft()); //object_name.method_name
		//Output:
		//10
		//9
	}
}
```
---
#### Encapsulation
>Characteristics commonly associated with OOP
- Encapsulation
- Abstraction
- Inheritance
- Polymorphism

>Encapsulation
- Hiding implementation details of object within itself
- Allows access to necessary data/method from outside the class
- Done by:
  - Employing various access modifiers
  - Organizing programs in packages

>Access Modifiers (Public vs Private)
- `public`
	-  Variable / Method in the class is accessible and available to all the other objects in the program
- `private`
	- Variable / Method in the class is available within the class only
	- Accessing private attributes in a class from outside can be achieved  by Getter and Setter Methods
---
#### Getter and Setter Methods

>Getter Method
```java
class SpStudent {
	private double GPA = 0.0;
}
public double getGPA() {return(GPA);}
```

```java
//Accessing Getter Method
public class Project {
	public static void main (String[] args) {
		SpStudent s1 = new SpStudent();
		System.out.println("GPA after year 1:" + s1.getGPA());
	}
}
```

>Setter Method
```java
class Circle {
	private double radius;

	public Circle() {radius 7.0;}
	public Circle(double r) {radius = r;}

	public double getRadius() {return radius;}
	public setRadius(double r) {radius = r;}
}
```
---
#### Package in Java
> Package
- used for better organizing the various classes in a program.
- better accessibility control can be implemented
- uses `package`

---
#### Java Wrapper Class

>Wrapper Class
- Provides the mechanism to convert primitive into object and object into primitive 
- Why Wrapper Class
	- Classes of collection framework deal with objects only, thus the need to convert


| Primitive Type | Wrapper Class |
| -------------- | ------------- |
| boolean        | Boolean       |
| char           | Character     |
| byte           | Byte          |
| short          | Short         |
| int            | Integer       |
| long           | Long          |
| float          | Float         |
| double         | Double        |


>Autoboxing
- Conversion of primitive type into an object
- Example:
```java
Byte byteobj=b; 
Short shortobj=s; 
Integer intobj=i; 
Long longobj=l; 
Float floatobj=f; 
Double doubleobj=d; 
Character charobj=c; 
Boolean boolobj=bb;

```

>Autounboxing
- Conversion of object to primitive type
- Example
```java
byte bytevalue=byteobj; 
short shortvalue=shortobj; 
int intvalue=intobj; 
long longvalue=longobj; 
float floatvalue=floatobj; 
double doublevalue=doubleobj; 
char charvalue=charobj; 
boolean boolvalue=boolobj;
```

>Converting String to int
```java
String s = "33";
int i = Integer.parseInt(s); // "33" to int 33
```

>Converting String to Integer
```java
String s = "33";
Integer i = Integer.valueOf(s);//"33" to Integer 33
```
---
#### "has-a" Relationship

>What is a "has-a" relation
- when 2 objects is related by "has-a" relationship
- known as composition
- Example:
  - a `Traveller` object "has-a" `Car` object
- Impact:
  - causes a close coupling between objects

---
#### Dependency Inversion Principle (DIP)

>Dependency Inversion Principle
- refers to coupling between the different classes
- High level classes should rely on abstractions instead of concrete implementations of the lower classes
- Classes following DIP are loosely coupled, thus it is more maintainable , reusable and easier to test
- Implementing DIP
	- Setter Method
	- Constructor Method

>DIP by Setter
```java
public static void main(String[] args) { 
	Car theCar = new Car(“SHA1234); 
	Traveller a = new Traveller(); 
	a.setCar(theCar); 
	a.travel("AMK"); }
```
- Car object is outside Traveller Class
	- This decouples the lifecycle of Car objects from Traveller Class

```Java
class Traveller { 
	Car myCar; 
	public void setCar(Car c) { 
		myCar = c; } 
	public void travel(String dest) { 
		myCar.move(dest); 
	}
}
```
- Car object is passed in via the Setter method
	- Changes made to the constructor in Car Class will not affect the Traveller Class

```java
class Car { 
	String licensePlate; 
	Car(String n) { 
		licensePlate = n; 
	} 
	public void move(String dest) {
		System.out.println ("Going to" + dest + "by car"); 
	} 
}
```

>DIP by Constructor 