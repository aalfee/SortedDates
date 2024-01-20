import java.util.ArrayList;

// This class is used for both storage for inpul file reading and for unsorted list of date objects 'Date212'
public class UnsortedDate212List {
    // First create a private array list that sotres the object 'Date212'
    private ArrayList<Date212> dateList;

    public UnsortedDate212List() {              // Constructor for no argument
        this.dateList = new ArrayList<>();
    }
    public void add(Date212 date) {              // Method to add a Date212 object to the list
        dateList.add(date);
    }
}

