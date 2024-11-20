
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


---
#### Passing Objects to Methods


---
#### String Class


---
#### Static Variable and Methods


---
#### Getter and Setter Methods


---
#### Package in Java


---
#### Java Wrapper Class


---