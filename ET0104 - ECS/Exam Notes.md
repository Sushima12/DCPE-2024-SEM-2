
#### Chapter 3

>Number of memory locations
- 2^n
	- where `n` is the is the number of address lines
> Units of memory may be connected in parallel
- to meet processor data width

>Steps to access memory
![[Pasted image 20250303092549.png]]
- Address is placed on the address bus
	- lower bits will be used  by memory device for internal decoding
	- higher bits go to a decoder chip which generates chip select signal `CS`
	- Which in turn selects one of several memory device
- READ
	- during read operation, proccessor will generate read signal `RD`
		- Connected to output enable `OE` of memory chip
	- memory device place data from memory location after short delay
- WRITE
	- proccessor place data to be written on data bus
		- Which will generate Write signal `WR`, connected to write enable `WE` of memory chip
		- memory device latch data in

>Partial Decoding
- have unused pins
>Full Address Decoding
- All address pins are used

> Memory Foldover
- When memory address / group of physical address responds to several different processor addresses
- Calculation
$$
	\frac{NumberOfMemoryLocations}{NumberOfUsedLocations}
$$

---
#### Chapter 7

>Types of signals
- Digital Signal
	- discrete values
- Analog Signal
	- Continuously variable 

>Digital System
- Before it can be used, analog signals to be converted to digital signals

>Scale Factor
- Formula
$$
ScaleFactor =\frac{Input}{voltage}
$$



---
#### Chapter 11

>Multithreading
- Thread
	- Independent low of execution in process
- Multithreading OS
	- a process consists of one or more threads
	- All threads in a process share the code, data, heap abd system memory areas
	- Each thread has a separate CPU state and stack (block of memory allocated out of the process stack memory area)
	- Local variables and function arguments are private to the specific thread

>Scheduling
- Multitasking OS can be done in 2 ways
	- Cooperative
		- Programs give way to one another when doing input/output
		- Example, waiting for user to press a key
	- Pre-emptive
		- Programs forced to give way to one another to prevent 'hogging'
- Time Slice
	- amount of time an OS let a task execute
	- fixed duration
- Scheduler
	- Determines which task will have the next time slice
	- Program runs after the time slice for running task ends
- Task can be one of three states
	- Running - task is executing
	- Ready - task is waiting for their turn
	- Blocked - task is waiting for something to happen

>Mutex object
- Critical section object
	- Use in coordinating Mutually Exclusive accesses to a shared resource
- Can be in 2 states:
	- Owned
	- Free
- Mutex object can only be owned by one task at a time

>Semaphore Objects
- Consists of
	- a data item (count)
		- determines what happens when a wait or release operation executes
	- pair of operations
		- wait - task requesting access
		- release - task is finished with the resources
- When program creates Semaphore
	- sets the count to an initial positive value
		- value indicates the number of tasks the semaphore will let pass before closing the door
	- During wait operation
		- OS checks if count is greater than 0
			- call operation succeeds and task is allowed to be continued, and count decrease by one
		- if count is 0, task is blocked