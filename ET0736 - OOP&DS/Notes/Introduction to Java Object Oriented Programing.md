---

---
---
--- CONTENTS ---
1. [[#Terminology]]
2. [[#About Java Programming Language]]
3. [[#Object Oriented Programming]] 
4. [[#Data Structures & Algorithms]]
5. [[#Basics of Java]]
---
#### Terminology

`Java Program` -> `Compiler` -> `Byte Code` -> `JVM` -> `Result`

> Java Program
1. Written with text editor or with an IDE

> Compiler
1. Compiles Source code to standard byte code
	- Independent of platform

> Java Virtual Machine _(JVM)_
1. Runs the bytecode
	- Platform dependent
2. Part of JRE
3. Responsible for:
	- Loading Code
	- Verify Code
	- Linking Code
	- Executing Code

> Java Development Kit _(JDK)_
1. Consists of:
	- Compiler
	- Byte Code
	- JVM
	- Result / Output

`Java Development Kit (JDK)` vs `Java Runtime Environment (JRE)`

> Java Development Kit _(JDK)_
1. Includes:
	- JRE
	- Compiler
	- Debugger
2. To compile & Debug Java Program

> Java Runtime Environment _(JRE)_
1. Provides environment to run Java Programs


---
#### About Java Programming Language

>It is Class Based
1. Basic unit is class except 8 primitives data types
	- `Boolean`
	- `char`
	- `byte`
	- `int`
	- `short`
	- `long`
	- `float`
	- `double`

>It is Object Oriented

>Case Sensitive

>Statements are in blocks of `{}`

>Statements ends with `;`

>Applications begin execution from `main()`

> Better memory management than `C++`

>Program Template
```java
public class HelloWorld { 
	public static void main(String args[]) { //main method
	System.out.println(“Hello, world!”); 
	}
}
```

>--- Output---
>Hello, World!

>`public class HelloWorld {...}`
1. File name should be the same as class name: 
	- HelloWord.java

>`public static void main(String args[]) {...}`
1. Main method where the execution begins
2. `String arg[]`
	- Input parameter
	- Can insert to the array via the `CLI`
	- To key in input parameter:
		- `java ClassName A B C`
		- `A B C` are the input parameters to be pushed to the array, separated by space

---
#### Object Oriented Programming

>What is Object Oriented Programming _(OOP)_
1. Attempts to model all problem situation as objects

>Objects 
1. Objects / Instance belong to a class

>Class
1. Blueprint definition containing:
	- Attributes / properties / data mem
	- Behaviors / Methods 

>OOP vs Non - OOP
1. Non - OOP
	- In Non-OOP setting, we would create 3 Separate arrays:
		- `name[]`
		- `id[]`
		- `gpa[]`
2. OOP
	- In OOP, we can the data can be clusterd into a class / 1 unit
		- Example:
```Java
class SPStudent {
	String name; 
	String ID; 
	double GPA;
}
```
---
#### Data Structures & Algorithms

>Data Structures
1. Data that is being organized in a program for better accessibility & scalability
	 - Shows how data is linked to each other _(Like a map)_
	 - For Example:
		 - Storing Longitude and Latitude data
		 - Data Structure can show 1 location to another graphically

>Algorithms
1. Series of steps to be taken to arrive at the solution with use of a program
---
#### Basics of Java

>Identifier
1. Name given to:
	- Class
	- Method
	- Variable
2. A place where data is stored
3. Characteristics of Identifier:
	- Cannot start with a digit
	- Cannot contain space
	- Cannot be a java keyword _(e.g. `class`)_
	- Can only contain the following special characters:
		- `$` and `_`
	- Can start with a special character, limited to only `_`

>Variable Name
1. Identifier for computer memory space to store data
2. Data can be changed

>Constant
1. Data whose values are fixed
2. Declared with the keyword `final`