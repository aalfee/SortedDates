import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// this class handles actions related to the "Edit" menu in the GUI.
// it specifically responds to the "Search" option, prompting the user to enter a year.
// Once a year is entered, it calls a method in Date212GUI to display dates matching that year.
public class EditMenuHandler implements ActionListener {
    Date212GUI dategui;         // reference to the main GUI
    TextArea filteredUnsorted;  // text area for displaying filtered unsorted dates
    TextArea filteredSorted;    // text area for displaying filtered sorted dates

    // constructor to initialize the handler with references to the GUI and text areas.
    public EditMenuHandler(Date212GUI dg, TextArea unsorted, TextArea sorted) {
        dategui = dg;                           // this is the handler for the gui
        filteredUnsorted = unsorted;            // this is for the filteredUnsorted text area
        filteredSorted = sorted;                // this is for the filteredSorted text area
    }
   
    // this method is called when an action (like a button click) is performed in the "Edit" menu.
    // it prompts the user to input a year, then displays dates matching that year in the GUI.
    public void actionPerformed(ActionEvent e) {
        // ask the user to enter a year using a pop-up input dialog.
        String userInput = JOptionPane.showInputDialog("Enter the year to search: ");

        try {
            // convert the user input to an integer (year).
            int searchYear = Integer.parseInt(userInput);
            
            // call the displayFilteredDates method in Date212GUI to show dates for the entered year.
            dategui.displayFilteredDates(searchYear, filteredUnsorted, filteredSorted);
        } catch (NumberFormatException ex) {
            // display an error message if the user enters something that is not a valid year.
            JOptionPane.showMessageDialog(null, "Invalid input. please enter a valid year.");
        }
    }
}
