import java.util.ArrayList;

// This class instansiates and sorts the array lists from the unsorted list
public class SortedDate212List {        
    // First create a starting array list that stores the object 'Date212'
    private ArrayList<Date212> sortedList;
    // Then bring in the unsorted list to use as a refereence 

    public SortedDate212List() {
        this.sortedList = new ArrayList<>();
    }

    // Add a method to get the sorted list
    public ArrayList<Date212> getSortedList() {
        return sortedList;
    }
}

