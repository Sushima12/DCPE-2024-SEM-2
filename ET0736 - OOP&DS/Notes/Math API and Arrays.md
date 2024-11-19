
---
--- CONTENTS ---
1. Math API
2. Categories of Data Structures
3. Linear Data Structure - Array in Java
4. Bubble Sort
5. Linear Search and Binary Search
6. 2D Array
7. Array Class in Java
---
#### Math API
`Math.random()`
- Random generated floating point values from 0 to 1
- Application:
```java
//Can be used to generate values from 0 to a max number
//For example, to print values from 0 to 100
System.out.println(Math.random() * 100);

//To make it only generate random int:
int x = (int) Math.random() * 100;
System.out.println(x);
```



---
#### Categories of Data Structures

>Linear Data Structures
1. Static Linear Data Structure
   - Array
2. Dynamic Linear Data Structure
   - Stack
   - Queue
   - Linked List
   - ArrayList
   - Vector

>Non-Linear Data Structures
1. Type
   - Tree 
   - Graph
---
#### Linear Data Structure - Array in Java 
>Array
1. Characteristics of Arrays
   - Linear and Static
   - Stores a group of same data type item under one variable name 
   - Storage memory is dynamically allocated, but cannot be changed once declared an array size
   - Array size must be specified by `int` or `short` values _(not `long`)_
   - Supports randomly access for elements stored
2. Elements of Array
   - An item in an Array
   - Starts at index 0, first element will be index 0

>Example of declaring an arrays
1. Array of dynamic size
	- `Data_Type [] Variable_Name`;
	- `Data_Type Variable_Name[]`;
```java
int[] x;
//or
int x[];
```
2. Array of fixed size
	- `Data_Type [] = new Data_Type[Array_Size]`;
```java
int[] x  = new int[9];
```
3. Array with memory allocation and initialization
	- `Data_Type[] Variable_Name = {a, b, c, d, e,....};`
```java
int[] x = {11, 44, 55, 66, 77, 88, 99};
```

>Accessing Array Elements
1. For-Loop
```java
int[] c = {11,22,33};

for (int x=0; x<c.length; x++) {
	System.out.println(x);
}
```
2. Enhanced For-Loop
```java
int[] c = {11,22,33};

for (int x : c) {
	System.out.println(x);
};
```

>Storing elements in Array
```java
int x [];
x[0] = 11;
```

>`System.arraycopy()`
- Copies from a source array to another destination array
- Documentation:
```java
arraycopy(Object src, int srcPos, Object dest, int destPos, int length)

// Example
int[] c = {11,22,33};
int[] d = {44,55,66,77}; 
System.arraycopy(c,0,d,0,3); // array d becomes {11,22,33,77}
```
`src`
- Source Array
`dest`
- Destination Array
`srcPos`
- Index in source array to start copying from
`destPos`
- Index in Destination Array to start copying to
`length`
- Number of elements to be copied

>Referencing Array
- There is no copying of content from one array to another
- Instead it is a changes the reference of variable
```java
int[] c = {11,22,33};
int[] d = {44,55,66,77};
d=c; // d now referencing {11,22,33}
```

---
#### Bubble Sort

>Concept of Bubble Sort
-  Given Array of numbers `{2,8,5,3,9,4,1}`
	- To sort in ascending order,
		1. Work from left to right
		2. For every item, compare it with the next item on the right
		3. Swap if item > item on right
		4. Repeat until sorted
- Example:
```java
int temp;
for (int x = 0; x < array.length - 1; x++){
	for (int n = 0; n < array.length - 1; n++){
		if (array[n] > array[n+1]) {
			//change the sign to sort in decending order
			//Swap
			temp = array[n+1];
			array[n+1] = array[n];
			array[n] = temp;
		}
	}
}
```

---
#### Linear Search and Binary Search

>Linear / Sequential Search
1. Concept
	- Search key is compared with each element 1 by 1
	-  If there is a match, it returns the position index of the element
	- Else, it will return -1
	- It has the worst-case complexity of O(n)
	- Used when data is not sorted
2. Example:
```java
public static int search(int[] nums, int key) {
	for (int i=0; i<nums.length; i++){ 
		if (nums[i]==key) {
			return(i); 
		}
	}
	return(-1); 
}
```

>Binary Search
1. Concept
	- Applicable only to sorted arrays
	- Compares search key with middle element
	- If it is a match, it will return the element's index
	- If it is less than the middle element, it will repeat search on the left half
	- If greater than the middle element, it will repeat search on the rioght half
	- If remaining element to be searched is 0, it will return -1
	- Has the worst case complexity of O(log$_2$n)
2. Example
```java
public static void BinarySearch(int [] array, int key) {
        //Binary Search
        int Index_Middle_Element; //Index of middle element
        if (array.length % 2 == 0) {
            //Even Number of Array Length
            Index_Middle_Element = (array.length / 2);
        } else {
            //Odd Number of Array Length
            Index_Middle_Element = (array.length / 2) + 1;
        }

        int Middle_Key = array[Index_Middle_Element];
        while (true){
            if (key == Middle_Key){
                // Key found
                System.out.println("Key Found!");
                System.out.println("Index of key: " + Index_Middle_Element);
                break;
            }else if (key < Middle_Key) {
                //Continue Search in the left direction
                if ( key > ( array[Index_Middle_Element - 1]) && !((Index_Middle_Element - 1) < 0)){
                    //Check key in next index to prevent Loop
                    System.out.println("Key Not Found (Loop Prevention)");
                    break;
                }
                Index_Middle_Element = Index_Middle_Element - 1;
                if (Index_Middle_Element < 0) {
                    System.out.println("Key Not Found (End of Index)");
                    break;
                }

                Middle_Key = array[Index_Middle_Element];
            } else {
                //Continue Search in the right direction
                if (key > (array[Index_Middle_Element + 1]) && !((Index_Middle_Element + 1) > array.length)) {
                    //Check key in next index to prevent Loop
                    System.out.println("Key Not Found (Loop Prevention)");
                    break;
                }
                Index_Middle_Element = Index_Middle_Element + 1;
                if (Index_Middle_Element == array.length) {
                    System.out.println("Key Not Found (End of Index)");
                    break;
                }
                Middle_Key = array[Index_Middle_Element];
           }
     }
}
```

---
#### 2D Array

>Concept of 2D Array
1. A two-dimensional is stored in the computer's memory one row after another
2. Empty 2D array
   - `data_type varaible_name[][] = new data_type[rows][columns]`
```java
int z[][] = new int[3][5];
```
3. 2D Array with initialization and memory allocation 
```java
//4 rows and 3 columns
int[][] a = {{11,22,33},
			 {44,55,66},
			 {77,88,99},
			 {100,200,300}};
```
4. Obtaining rows and columns
```java
System.out.println( "rows = " + a.length);
System.out.println( "columns = " + a[0].length);
```

>Ragged 2D Array
- Only first dimension (Rows) need to be declared/allocated
- each row can have different number of columns
- Example
```java
int z[][]=new int[3][]; // three rows  

z[0] = new int[2]; // first row - 2 elements 
z[1] = new int[5]; // second row - 5 elements 
z[2] = new int[9]; // third row - 9 elements
```
---
#### Array Class in Java

>Concept
1. From `java.util package`
2. Has methods for arrays to
   - fill
   - sort
   - search...etc
3. Example
```java
public static void main(String[] args) { 
	int [] a= { 10, 20, 15, 22, 35};
	whereAmI(a, 20); 
	Arrays.sort(a);
	whereAmI(a, 20);
} 

public static void whereAmI(int []x, int key){
	for (int i=0; i<x.length; i++) {
		if (x[i]==key) 
			System.out.println(key + “ found at index = “ + i); 
		}
	}
}
```