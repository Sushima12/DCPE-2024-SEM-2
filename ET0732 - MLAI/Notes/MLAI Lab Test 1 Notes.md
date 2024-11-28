
---
--- Contents ---
1. Python OOP
2. Numpy Array

---
#### Python OOP

>Class & Object
- Defining Classes:
```python
class MyClass:
	x = 5
```

- Defining Objects:
```python
Object_1 = MyClass()
```

>Method
- Functions that are in the Class
- Defining Methods
```python
class MyClass:
	def say_hi(self):
		print('Hello..')
		
	#method with a parameter:	
	def print_message(self, message):
		print(message)
			
#Calling the Method:
Obj = MyClass()
Obj.say_hi()
Obj.print_message('my name is abc...')
```


>The `init()` Function
- All Classes have  `__init__()` function
  - Always executed when class is initiated, similar to Java Constructors
- Uses:
  - to assign values to object properties
  - operations that needs to do when object is created
- Example:
```python
class Person:
	#init function with name and age as parameters
	def __init__(self, name, age):
		self.name = name
		self.age = age
		
#Calling the __init__()
p = Person("John", 36)
#Accessing attributes/variables of the object p
print(p.name)
print(p.age)
```

>Accessing attributes/variables within a class
```python
class Person:
	#init function with name and age as parameters
	def __init__(self, name, age):
		self.name = name
		self.age = age
		
	def DisplayInfo(self):
		print("Name: ", self.name)
		print("Age: ", self.age)
		
```

>Inheritance
- Example
```python
class Parent: # Define the parent class. 
parentAttr = 100 
	def __init__(self): 
		print("Invoke the parent class to construct a function.")
		
	def parentMethod(self): 
		print('Invoke a parent class method.') 
		
	def setAttr(self, attr): 
		Parent.parentAttr = attr 
		
	def getAttr(self): 
		print("Parent attribute:", Parent.parentAttr)
		
class Child(Parent): # Define a child class.
	def __init__(self): 
		print("Invoke a child class to construct a method.") 
		
	def childMethod(self): 
		print('Invoke a child method.') 
		
c = Child() # Instantiate a child class. 
c.childMethod() # Invoke the method of a child class. 
c.parentMethod() # Invoke the method of a parent class. 
c.setAttr(200) # Invoke the method of the parent class again to set the attribute value. 
c.getAttr() # Invoke the method of the parent class again to obtain the attribute value.
```

---
#### Numpy Array Slicing

