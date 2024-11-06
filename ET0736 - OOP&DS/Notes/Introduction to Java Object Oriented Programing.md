
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
2. Arithmetic
	- `+, -, *, /, %, ++, --`
3. Comparison / Relational
   - `>=, <=, ==, >, <, !=`
4. Boolean
   - `!, &&, ||, ^(xor)`
5. Integer bitwise
   - `>>, <<, \, &, >>>`

>Character & String Type
1. Character Value
   - Value is enclosed by single-quote `''`
2. String Value
   - Enclosed by double-quote `""`
   - not a primitive type, but a `class`

>Character Type & Operations
1. Character
   - Stored as a sequence of binary (`0` & `1`)
   - Mapping a character to binary is called encoding
2. Unicode
   - 16 bit encoding scheme (hex 0000 - FFFF)
   - Valid to code with`\u` (for 2 byte):
```Java
char a = '\u1C2F';
```
  - Includes ASCII, 8-bit encoding scheme
	  - for characters `\u0000` to `\u007F` for first 128 values

| Character      | Value in Decimal | Unicode Values       |
| -------------- | ---------------- | -------------------- |
| `'0'` to `'9'` | `48` to `57`     | `\u0030` to `\u0039` |
| `'A'` to `'Z'` | `65` to `90`     | `\u0041` to `\u005A` |
| `'a'` to `'z'` | `97` to `122`    | `\u0061` to `\u007A` |

>String Class
1. String object can be created with `new` keyword or from a literal
```Java
String m1 = new String("Welcome to Java!");
char[] c = new char[] {'c','o','v','i','d'};
String m2 = new String(c); 
String m3 = new String(m3); 
String m4 = "Welcome to Java!";
```

>String Literal
1. A series of alphanumeric enclosed in double-quotes
   - Example:
```java
String s1 = "This is a String";
```
2. Java behaviour when encountered a string
   - Java encounters string literal for first time
   - Creates a string object with string literal
   - If the same value of the stored literal is required again, java will not create a new copy, instead it will reuse it.

>Comparing Strings

`new` keyword
- Create a new object
	- The new object is not the same as the old object it was based on
	- Example:
```java
String s1 = new String("I love Java"); 
String s2 = new String("I love Java"); 
String s3 = " I love Java"; 
String s4 = " I love Java"; 
String s5 = new String (s4);
String s6 = " I love Java";
```
`s3` = `s4` = `s6`
`s5` != `s4`

`==` Comparison Operator when used with string:
- Compares References

`.equals()`
- Compares contents of string

`A.compareTo(B)`
- Compare 2 string lexicographically
- Comparison is based on the unicode value of each character in the string
- Return values & definitions,
  - `0`:  `A` == `B`
  - `Value < 0`: `A` < `B`
  - `Value > 0`: `A`  > `B`

>Some Methods of string class

`.length()`
- Returns the number of character in the string

`charAt()`
- Returns the character at the specific index

`.indexOf()`
- Returns the index where the word was first found in the string

`.substring(a, b)`
- Returns the characters starting at `index a`, to the character before `index b`
  - Character at `index b` does not count
    
`.contains()`
- Returns 
  - `true`if the word(s) in the brackets is found in the string
  - `false` if the word(s) in the brackets is not found in the string

>Conversion of string
1. Variables to string
```java
int variable = 230;
String.valueOf(variable); // converts 230 to "230"
```

2. String to Variable
   - Original String should contain only numeric & no alphabets, by the appropriate class & method
```java
String s1 = "356"; int a = Integer.parseInt(s1); // a=356 
String s2 = "3.789"; 
double b = Double.parseDouble(s2); // b=3.789

String s3 = "I am 88"; 
double d = Double.parseDouble(s3); // Error!!
```

>Characteristics of String
1. Strings are immutable
   - Values cannot be changed after creation

>Getting input from console
1. Use `Scanner` class
   - `System.in` refers to console input from keyboard
   - Example:
```java
int age;
String name; 
double GPA;
Scanner sc = new Scanner(System.in);

System.out.print ("enter name: ");
name = sc.nextLine();

System.out.print ("enter age: ");
age = sc.nextInt(); 

System.out.print ("enter GPA: ");
GPA= sc.nextDouble();
```

>Implicit Casting
1. Data type is automatically cast / converted
2. Applies when data type with smaller range is assigned into a bigger data type

>Explicit Casting
1. Specific indication of data type within parentheses() and is needed when assigning values to variable of a type with smaller range
   - May result in a loss of precision
   - Example:
```java
int k = (int) (6.0/4.7);
float t = 100.99f; 
int p = t; // error
int p = (int) t; // no error
```

>Formatting Output:
```java
System.out.printf("%d\n", 1234); //1234
System.out.printf("%f\n", 12345.678f); //12345.677734
System.out.printf("%e\n", 12.345);//1.234500e=01
System.out.printf("%010d\n", 12);//0000000012
```

`.format()`
```java
System.out.format( "%s is a %s with %d sides.", "Pentagon", "shape", 5);
//Output:
//Pentagon is a shape with 5 sides.
```

>Java Methods (Functions)
1. Method
   - Belongs to a class
   - a block of code performing an operation inside a class
   - has a method name
   - code in the method can be reuse
   - called using method name
2. Naming Method
```java
public static int printHeader(int parameter){
//Code
}
```

`int`
- The return type of the method
- `void` if the is no return type

`printHeader()`
- Name of the method

`(int parameter)`
- Parameter / argument to be passed into the method
- separated by `,`

3. Overloading Methods
   - Methods with the same name, but different signatures
     - i.e. argument / return value type are not the same between methods
     - The Java compiler will automatically choose which method to use