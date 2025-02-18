
#### Contents
1. Inheritance (extends)
2. Method Overriding
3. Array of Objects
4. super()
5. this()
6. Polymorphism
7. ArrayList and Sorting
8. Generic Class and Method

---
#### Inheritance

>Subclass and Class
- Given the main class `Member`, and subclasses `student` and `staff`
- Subclasses inherits characteristics from the main class

>extends keyword
- to inherit characteristics from a class to a class (subclass)
- Example:
```java
class Member{
	// something
	//main class
}

class student extends Member {
	//something
	// Subclass
}
```

---
#### Object Class and Method Overriding

>Object Class
- Parent class of all classes in java
- top most class
- useful when the object whose type is unknown

>What is Overriding
- Redefining the logic for an inherited
- Benefits
	- customizable existing methods

>Overriding `toString()`
- Example
```java
class Member { 
	public String name; 
	public String ID; 
	public String department; 
	protected int quota; 
	
	public void setQuota(int q) { 
		quota = q; 
	}
	
	 public int getQuota() { 
		return quota; 
	} 
	
	public String toString() { 
		return("Name:"+name + "," + 
				"ID:"+ ID + "," + 
				"Dept:" + department + "," + 
				"Quota: " + quota); 
	} 
}
```

`public String toString()`
- Overriding `toString()` method to print out the values / variables
- Without it, it will not print the values/ variables

>Overriding `equals()`
- Example:
```java
class Circle { 
	private int radius; 
	Circle (int radius) { 
		this.radius = radius; 
	} 
	
	public double getArea() { 
		return (radius*radius*22.0/7.0); 
	} 
	
	public boolean equals(Circle x) { 
		if (x.radius == radius) return (true); 
		else return (false); 
	}
}
```

`public boolean equals(Circle x)`
- Overriding `equals()` method to check if  the radius of circle is equal

---
#### Subclass Keywords

>`super()` method
- To be used in sub class constructor
- to call the no-arg constructor in the above class
- can happen automatically in sub class constructor
- can be invoked explicitly

> Auto `super()` call
```java
public class Test { 
	public static void main(String[] args) { 
		Employee e1 = new Employee(); 
	} 
} 

class Person { 
	Person() { 
		System.out.println ("Person's no-arg constructor"); 
	} 
} 

class Employee extends Person { 
	Employee() { 
		/*Hidden automatic super() call*/
		System.out.println("Employee's no-arg constructor"); 
	} 
}
```

>Matching `super()` call
- Automatic / Explicit `super()` call from sub class will activate the matching superclass constructors
- Match is determined by:
	- Number of arguments
	- Argument data type
- Example

| Call from subclass   | Matching Constructor Superclass |
| -------------------- | ------------------------------- |
| `super()`            | `Person()`                      |
| `super(int)`         | `Person(int)`                   |
| `super(int, String)` | `Person(int, String)`           |

>`this()` method
- to call the no-arg constructor of it's own class
- to be used in constructor
- must be in the first line of the constructor
- if added, automatic `super()` method will be disabled

 ---
#### Polymorphism

>What is Polymorphism
- An Object that has many forms or in another form
- Object of a subclass that can be used with any code that is designed to work with an object of it's super class
- Example
	- given:
		- Super class: Animal
		- Sub classes: Fish and Dog
```java
//In main()
Animal a = new Animal();

Fish f = new Fish();
Dog d = new Dog();

a = f;
a = d;
```
- Object `f` and `d` can be assigned to Object `a`
- `f = a` or `d = a` will cause errors
- In another words, Object `f` and `d` are  Object `a` types

---
#### ArrayList

>What is ArrayList
- Resides in Java Core Libraries
	- `import java.util.ArrayList`
- Linear and Dynamic
- Base on dynamic array (resizable)
- can store different data types
- stores data in consecutive memory location
- Index based structure
	- supports random access for the elements
	- i.e. choose an index anytime to access element in the list
	- Example:
```java
for (int i=1; i<=5; i++) 
	a1.add(i);
// supports random access
System.out.println(a1.get(2));
a1.remove(0);
System.out.println(a1.get(2));
```
- does not take primitive types
	- storing primitive types will require respective wrapper classes to be use

>`< >` in ArrayList declaration
- Indicates that container is a generic class
	- i.e. can take in different data types or objects

>Example of ArrayList
`add()`, `remove(index)`, `remove(object)`
``` java
ArrayList<Integer> a1 = new ArrayList<>(); //ArrayList that stores only Integers
ArrayList<Double> a2 = new ArrayList<>(); // ArrayList that stores only Doubles

for (int i=1; i<=5; i++) 
	a1.add(i);//Add Integer i to a1 ArrayList
//a1 = [1,2,3,4,5]
a1.remove(2); // remove element at index 2 which is Integer 3
a1.remove(Integer.valueOf(5)); // remove element that is Integer 5
```

`add(index, value)`, `get(index)`, `set(index, Object)`
```java
for (int i=1; i<=5; i++) 
	a1.add(i);//Add Integer i to a1 ArrayList

a1.add(3,888); //insert integer 888 at index 3

System.out.println(a1.get(3)); // get element at index 3 and print it

a1.set(0,999); // update the element at index 0 to Integer 111

```

`sort(comparator)`
```java
public static void main(String[] args) { 
	ArrayList<Integer> a1 = new ArrayList<>(); 
	for (int i=1; i<=5; i++) 
		a1.add(6-i); // 5,4,3,2,1 
	
	a1.sort(new SortIntegerList()); //Sort the Arraylist using the Comparator SortIntegerList
}

class SortIntegerList implements Comparator<Integer> { 
	@Override public int compare(Integer a, Integer b) { 
		return (a-b); 
	}
}
```

`size()`, `contains()`, `isEmpty()`, `clear()`
```java
for (int i=1; i<=5; i++) 
	a1.add(6-i);
a1.add(999);

System.out.println(a1.size()); // print the size of ArrayList a1
System.out.println(a1.contains(999)); // check if the ArrayList contains the element
System.out.println(a1.contains(888)); // false 
System.out.println(a1.isEmpty()); // Check if the ArrayList is empty or not

a1.clear() //empty the elements in ArrayList a1
System.out.println(a1.isEmpty())); // true
```

>To create an ArrayList to store mixed objects
```java
ArrayList a1 = new ArrayList();
```

>Arrays vs ArrayList
- ArrayList is not strongly typed
	- i.e. ArrayList can accept null values


---
#### Generic Class

>What is Generic Class
- Able to handle different data types
- Example of a Generic Class would be `ArrayList`

>Custom Generic Class
- Example:
	- defining a custom class `MyQueue`
		- can use `ArrayList`
```java
class MyQueue<E> {
//code
}
```
`<E>` to represent the generic type