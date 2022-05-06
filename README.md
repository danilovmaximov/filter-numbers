# filter-numbers
This is a test task for TTC Marconi. The script filters numbers according to their amount:
- If an odd amount of numbers given, it returns odd numbers
- If the amount is even, it returns even numbers

# Usage
Compile script from the project root using: _javac src/com/danilovmaximov/FilterNumbers.java_

Start app from the "src" directory using: _java com.danilovmaximov.FilterNumbers_

# Startup Parameters

First parameter (madatory): input
  - Either a positive integer to reveive input from the console
  - Or a file name like _input.txt_. File must be located in the directory from which the app is being started.
 
**Input format:** integers separated by a space. For example: 1 -2 -3 4 5

Second parameter (optional): output
  - A file name like _output.txt_. If file does not exist, it (and specified parent directories) will be created automatically.
