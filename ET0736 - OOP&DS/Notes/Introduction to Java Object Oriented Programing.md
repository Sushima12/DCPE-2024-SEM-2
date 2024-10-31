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

>Primitive Data Types

`byte`
- byte length integer
- 8 bits
- Min = - 2<sup>7</sup> = - 128
- Max = 2<sup>7</sup> - 1 = 127
- Default: `(byte) 0`

`short`
- short integer
- 16 bits
- Min = - 2<sup>15</sup>= - 32 768
- Max = 2$^7$ - 1 = 32 767
- Default: `(short) 0`

`int`
- integer
- 32 bits
-  Min = - 2<sup>31</sup> 
- Max = 2<sup>31</sup> - 1 
- Default: `0`

`long`
- long integer
- 64 bits
-  Min = - 2<sup>63</sup> 
- Max = 2<sup>63</sup> - 1 
- Default: `0 L`

`float`
- Single-Precision floating point
- 32 bits, IEEE 754
- ± 3.4E38 _(6 to 7 significant digits of accuracy)_
- Default: `0.0F`

`double`
- Double-Precision floating point
- 64 bits, IEEE 754
- ± 1.7E308 (14 to 15 significant digits of accuracy)
- Default: `0.0`

`char`
- Single character
- 16 bits
- Default: `'\u0000'`

`boolean`
- Boolean value
- 8 bits
- Default: `false`

>Declaring Variable
1. To be declared before assigning / initializing
2. Can only be declared once
3. Can be declared again under a different scope of code
	- Will be a different variable
	
>Declaring & Initializing Constant
1. Defined with the keyword `final`
	- Makes value fixed, thus making a constant
2. Naming of constant consists of capitalized letters & underscore
	- Example:
```Java
final double MAX_WIDTH = 432.78;
```

3. `static` keyword + `final` keyword
	- Makes it available without loading any instance of class which is defined
	- Example:
```Java
static final int MAX_CLASS_SIZE = 20;
```

>Displaying Output in Terminal
```Java
int variable;

System.out.println("text here" + variable + "more text");
```

>Literals
1. Fixed values found in a program

`Literals` vs `Constant`
- `Literal`
	- Can be assigned to / stored to variable's value / to constant
	- A value / raw data
	- Can be used for direct calculation
- `Constant`
	- Fixed variable
	- cannot be changed

>Operators
1. Assignment
	- `=, +=, -=, *=, /=, %=`
1. Arithmetic
2. Comparison / Relational
3. Boolean
4. Integer bitwise