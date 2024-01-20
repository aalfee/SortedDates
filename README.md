# Project 4: Date Lists and Search

## Overview
This project involves creating a program to manage and display lists of dates. The main components of the project include a Date212 class representing a date, a graphical user interface (Date212GUI) to display sorted and unsorted lists of dates, and handlers (FileMenuHandler and EditMenuHandler) to manage file input and date searches.

## Files
1. Date212.java

- Represents a date with methods for creating, validating, and comparing dates.

2. Date212GUI.java

- GUI class with functionalities to display sorted and unsorted lists of dates.
- Utilizes FileMenuHandler and EditMenuHandler for file input and date searches.

3. FileMenuHandler.java

- Handles actions related to the "File" menu in the GUI.
- Allows users to open files and quit the program.

4. EditMenuHandler.java

- Handles actions related to the "Edit" menu in the GUI.
- Specifically responds to the "Search" option, prompting the user to enter a year.

5. Project4.java

- Main class with the main method serving as the entry point for the program.
- Calls Date212GUI.initiateGUI to start the GUI.

6. SortedDate212List.java

- Class for managing a sorted list of Date212 objects.

7. UnsortedDate212List.java

- Class for managing an unsorted list of Date212 objects.

# How to Run
To run the program, execute the main method in the Project4.java class. This will initiate the GUI (Date212GUI) and provide options for opening files, sorting and displaying lists of dates, and searching for dates by year.

# Usage
1. Opening Files

- Click on the "File" menu and select "Open" to choose a file with date information.

2. Displaying Lists

- The GUI will display both sorted and unsorted lists of dates.

3. Searching by Year

- Click on the "Edit" menu and select "Search."
- Enter a year when prompted, and the GUI will display dates matching that year.

4. Quitting the Program

- Click on the "File" menu and select "Quit" to exit the program.

# Screenshots

![Alt text](/Screenshot/Screenshot1.png?raw=true "Date212GUI")
![Alt text](/Screenshot/Screenshot2.png?raw=true "Screenshot2")
![Alt text](/Screenshot/Screenshot3.png?raw=true "Screenshot3")
![Alt text](/Screenshot/Screenshot4.png?raw=true "Screenshot4")

# Notes
Ensure that input files adhere to the expected format for successful date parsing.
