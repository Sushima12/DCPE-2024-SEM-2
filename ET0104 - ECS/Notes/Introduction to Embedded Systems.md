
---
--- Contents ---
1. What Are Embedded Systems
2. Typical Microcomputer Organization
3. History of Microprocessors
4. Embedded Systems Characteristics

---
#### What are Embedded Systems

>Characteristics of Embedded Systems
- Special Versions of everyday computers
- Part of another System
- Smaller in size
- A system built to do that single task

>Examples of Embedded Systems
- Remote Controls
- Washing Machine
- Automobiles
- Aircraft

---
#### Typical Microcomputer Organization

>Basic Computer System
- CPU
- Memory
- Input
- Output
![[Pasted image 20241202213800.png]]

>CPU
- Parts of CPU
  - ALU
  - Registers
  - Control Unit
`ALU`
- Performs arithmetic & logical operations on binary data

`Registers`
- Storing data, addresses / instructions
- number & type depends on particular computer system
- Accumulator (main register)
  - Stores data to be used by ALU at start of arithmetic & logic operations
  - Stores the result at the end of the operation

`Control Unit`
- Directs operation of all other units
  - by providing
    1. Timing
    2. Control Signals
- Contains
  - Logic & Timing circuits
    - to generate proper signals that are required to execute each instruction
- Capable of responding to external signals (Interrupts)
- Process of Interrupt Request
  1. Cause Control circuit to temporarily interrupt main program
  2. Jump to a special routine to service the interrupting device
  3. Automatically return to main program

>Memory Unit
- Contains large number of memory cells
  - RAM
  - ROM
- Function of Memory Unit
  - Store instruction sequences
  - Store programs that will be executed by computer which are:
    1. Data processed by program
    2. Data resulting from processing it
- Operation of Memory Unit
  - Controlled by Control Unit
  - Has 2 Signals from Control Unit
    1. `READ` Operations
    2. `WRITE` Operations

>Input / Output Units (Peripherals)
1. Input 
   - To supply data for processing
   - To tell program how to operate on data
   - Example
     - Keyboards
     - Mouse
2. Output
   - Supply results of the computer operations to user
   - Example
     - Printer
     - Visual Display Units
3. Input / Output Ports
   - Interface circuits that provide electrical connections between device & computer system
   - Parallel set of buffers / D-flip flops
     latched data strobed by `CPU`

>Bus Structure
- `CPU` is linked to other parts of the system by buses
- Bus
  - group of conductors connected to all of the system's main block
- Type of Bus
  1. Address Bus
  2. Data Bus
  3. Control Bus

`Address Bus`
- Used by CPU
  - to send out address of memory location that is to be read or written into
  - to send out address of a particular input / output port
- Unibidirectional
  - information moves in 1 direction
  - starts from cpu