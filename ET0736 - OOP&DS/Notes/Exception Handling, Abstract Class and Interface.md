
#### Contents
1. Exceptions
2. throw vs throws
3. checked/unchecked exceptions
4. Try-with-reference
5. Interface
6. Abstract Class

---
#### Exception

>What is Exception
- unexpected even caused by runtime errors
- if it is not handled, it may terminate abnormally
- coded in either structures
	- `try-catch`
	- `try-catch-finaly`
- as there are many different types of exceptions, refer to API document to know which to catch

>How `try-catch` works
- `try {...}` 
	- tries to run the code first, if there is an exception, it will skip to the catch block immediately
- `catch() {...}`
	- if the exception occurs , the `catch` block will run the code inside

>Examples of Exceptions
- Arithmetic
	- when divided by 0 or illegal math
- ArrayIndexOutOfBounds
	- when index does not exist in the array
- NumberFormat
	- when a string is attempted to be converted to a numeric data type

>Multiple Catch
- it is possible to have multiple catches to catch the exception
- Example
```java
try {
	//code
}
catch(ArithmeticException e){ 
	System.out.println("Warning: ArithmeticException"); 
}
catch(ArrayIndexOutOfBoundsException e){ 
	System.out.println("Warning: ArrayIndexOutOfBoundsException"); 
} 
catch(Exception e){ 
	System.out.println("Warning: Some Other exception"); 
} 

System.out.println("Out of try-catch block...");
```

>try-catch-finally
- `finally {...}`
	- always execute the block of code even if there is or there isn't an exception from the try block

---
#### throw and throws

>`throw` keyword
- is used in a method
- usage:
	- when it is required to throw an Exception explicitly
- Example
```java
public class Test { 
	public static void main(String[] args) { 
		try { 
			validate (7); 
		}
		catch (ArithmeticException e) { 
			System.out.println(e.getMessage()); 
		} 
	}
}

public static void validate(int age) { 
	if(age<18) { 
		throw new ArithmeticException ("Person is not eligible for competition"); 
	}
	else { 
		System.out.println("Person is eligible for competition"); 
	} 
} 
```
- the exception is thrown from `validate()` to `main()`
- `main()` will have to handle it via `try-catch`
- if it is another method, it throw to the next higher level

>`throws` keyword
- used in the method signature
- used when the method has some statements that can lead to exceptions
- Example
```java
public static void writeToFile() throws IOException { 
	BufferedWriter bw = new BufferedWriter( 
		new FileWriter("myFile.txt")
	); 
	bw.write("Compiler enforces the throws keyword to be included"); 
	bw.close(); 
} 

public class Test { 
	public static void main(String[] args) { 
		try { 
			writeToFile();
		} 
		catch (IOException e) { 
			System.out.println(e.getMessage()); 
		} 
	} 
}
```


---
#### Checked / Unchecked Exceptions

>Checked vs Unchecked
- Checked
- Unchecked
	- no compilation error
	- compiler will not check during compile time

>Examples of Checked Exceptions
- SQLException
- IOException
- ClassNotFoundException
- InvocationTargetException

>Examples of Unchecked Exception
- NullPointerException
- ArrayIndexOutOfBoundsException
- IllegalArgumentException
- NumberFormatException

