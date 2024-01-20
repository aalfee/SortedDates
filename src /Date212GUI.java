import java.awt.*;
import java.util.*;
import java.util.Collections;
import java.util.List;
import javax.swing.*;


public class Date212GUI extends JFrame {
// This is the beginning of the program
    public static Date212GUI initiateGUI(Date212GUI myGUI) {
        myGUI = new Date212GUI();                                                // Creating a new GUI
        myGUI.setSize(600, 600);                                    // Setting the size of the GUI in pixes width and height
        myGUI.setLocation(200, 200);                                         // Setting the location 200 pixes right and 200 pixes down
        myGUI.setLayout(new GridLayout(1, 2));                         // "The GUI should have a GridLayout with one row and two columns"
        myGUI.setTitle("Project 4: Date Lists and Search");                // Setting the title of the window/program itself
        myGUI.setDefaultCloseOperation(EXIT_ON_CLOSE);                         
        Container myContentPane = myGUI.getContentPane();                        // Creating the main "page" where all the content goes
        TextArea sorted = new TextArea();                                        // Creating a text area to append all our text and sorted dates to
        TextArea unsorted = new TextArea();                                      // this text area is for the unsorted dates
        myContentPane.add(unsorted);                                             // Connecting the unsorted text area to appear on the ContentPane
        myContentPane.add(sorted);                                               // Connecting the sorted text area to the ContentPane
        sorted.append("Sorted List"+ "\n\n");                                    // Initalizing the text area to contain titles of the lists
        unsorted.append("Unsorted List" + "\n\n");
      

        JMenuBar menuBar = new JMenuBar();                                       // This section initializes the menu bar to hold:
        myGUI.createFileMenuBar(menuBar, sorted, unsorted);                      //     the file input menu bar (with "quit" option)
        myGUI.createEditMenuBar(menuBar, unsorted, sorted);                      //     the edit menu bar and search option

        myGUI.setVisible(true);                                                // "Turns on" the GUI itself
        return myGUI;                                                            // returns the object GUI back to the main class
    }

    // This class is responsible for creating the menu to input a file and quit the program
    public void createFileMenuBar(JMenuBar menuBar, TextArea sorted, TextArea unsorted) {
        JMenuItem item1;
        JMenu fileMenu = new JMenu("File");                                    // The first tab in the menu called "File" is initialized
        FileMenuHandler fmh = new FileMenuHandler(this, sorted, unsorted);       // and an instance of the FileMenuHandler class is created 
        item1 = new JMenuItem("Open");                                      //      the first option in the "File" tab is called "Open"
        item1.addActionListener(fmh);                                            //      will open any file for reading using addActionListener
        fileMenu.add(item1);                                                     // This appends the item "Open" onto the menu "File" 
        fileMenu.addSeparator();                                                 // This creates a little separation between the next item
        JMenuItem item2 = new JMenuItem("Quit");                            //      which is called "Quit", and will close the program
        item2.addActionListener(fmh);
        fileMenu.add(item2);
        setJMenuBar(menuBar);                                                    // This updates the menuBar that was passed in and attaches
        menuBar.add(fileMenu);                                                   //     the fileMenu we just created
    }
    // Similarly to the createFileMenuBar, this creates a menu to edit the lists and display only certain year dates
    public void createEditMenuBar(JMenuBar menuBar, TextArea unsorted, TextArea sorted) {
        JMenu editMenu = new JMenu("Edit");                                    // This creates the tab in the menu called "Edit"
        EditMenuHandler emh = new EditMenuHandler(this, unsorted, sorted);       // and an instance of the EditMenuHandler is created
        JMenuItem item1 = new JMenuItem("Search");                          //      the first option in the "Edit" tab is called "Search"
        item1.addActionListener(emh);                                            //      will prompt the user for a year when clicked
        editMenu.add(item1);                                                     // This appends the item "Search" onto the meny "Edit"
        setJMenuBar(menuBar);
        menuBar.add(editMenu);
    }

    // Use ArrayList instead of DateNode
    static ArrayList<Date212> sdl = new ArrayList<>();                          // Using "sdl" variable name for SortedDate212List shorthand
    static ArrayList<Date212> udl = new ArrayList<>();                 // Using "udl" variable name for UnsortedDate212List shorthand

    // This method prints the dates from the list passed in onto the GUI
    public static void printFileToGUI(String[] list, Date212GUI dg, TextArea sorted, TextArea unsorted) {
        for (int i = 0; i < list.length; i++) {                                 // For loop iterator 
            sdl.add(new Date212(list[i]));                           // Appends the read in string onto the sorted ArrayList 
            udl.add(new Date212(list[i]));                           //     and onto the unsorted ArrayList
        }

        sorted.setText("Sorted List" + "\n---------\n");                        // Provide clear sign of the updates TextArea 
        Collections.sort(sdl);                                       // Using collections.sort() method to arrange the arraylist form smallest to largest
        // Iterate through the arraylist and append the string to the GUI       // according to the compareTo function in the Date212 class
        for (Date212 date : sdl) {                                   
            sorted.append(date.toString() + "\n");
        }

        unsorted.setText("Unsorted List" + "\n-----------\n");                  // Also underlining to show the start of a new list
        List<Date212> unsortedList = udl;
        for (Date212 date : unsortedList) {
            unsorted.append(date.toString() + "\n");
        }
    }


    public void displayFilteredDates(int searchYear, TextArea unsorted, TextArea sorted) {
    if (Date212GUI.sdl.isEmpty()) {                                             // Checks if the sorted ArrayList is empty (or if no files were open already)
        JOptionPane.showMessageDialog(null, "Please open a file to load data first.");
        return;
    }
    // Clear the existing content in the filtered TextArea
    unsorted.setText("Filtered Unsorted List" + "\n~~~~~~~~~~~~~~~~~\n");       // Provide a clear sign of an updates TextArea
    sorted.setText("Filtered Sorted List" + "\n~~~~~~~~~~~~~~~\n");             // Underline serves as the start of the list

    for (Date212 date : Date212GUI.udl) {
        if (date.getYear() == searchYear) {                                     // Iterate through the udl and compare each date's year
            try {                                                               //      to the searchYear inputed by user
                unsorted.append(date.toString() + "\n");                        //      if it matches, we append the year
            } catch (IllegalDate212Exception exception) {                       //      to the new "Filtered Unsorted List" 
                System.err.println(exception.getMessage());
            }
        }
    }

    // Same logic follows for the sdl 
    for (Date212 date : Date212GUI.sdl) {
        if (date.getYear() == searchYear) {
            try {
                sorted.append(date.toString()+"\n");
            } catch (IllegalDate212Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
    }
}

    public static void printInsertToGUI(Date212 date, TextArea sorted, TextArea unsorted) {
        sdl.add(date);
        sorted.setText("Sorted List");
        Collections.sort(sdl);                                                  // Using Collecions.sort() to sort the dates
        for (Date212 sortedDate : sdl) {
            sorted.append(sortedDate.toString() + "\n");
        }

        udl.add(date);
        unsorted.setText("Unsorted List");
        List<Date212> unsortedList = udl;
        for (Date212 unsortedDate : unsortedList) {
            unsorted.append(unsortedDate.toString() + "\n");

        }
    }

}