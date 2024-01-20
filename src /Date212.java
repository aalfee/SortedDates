
public class Date212 implements Comparable <Date212> {
    // These are the three private instance varibales
    private int year;
    private int month;
    private int day;

    public Date212(String date) { // This is the constructor that takes in a string representing a date
        // Theis is a private validity check  method that makes sure the month and day values are legal
        // if it is not a valid date, print it to the console and do not put it in the array of dates 
        if (isValidDate(date) != true) throw new IllegalDate212Exception(date + " is not a valid date" );   
        // This is using the substring method to separate the string into date, month and year using parseInt
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(4,6));
        day = Integer.parseInt(date.substring(6, 8));
     } // close Date212 constructor

   
    public int getYear() {      // method to read the the year number
        return year;
    }

    public int getMonth() {     // method to read the month number
        return month;
    }

    public int getDay() {       // method to read the day number
        return day;
    }

    public Date212 getData() {  // method to read the data
        return this;
    }
    
    // This is a private validity check to make sure the date values are legal
    private boolean isValidDate(String date) {
        // tests if a date is valid
        if (date.length() != 8) return false;                   // checking if the length of the whole string is within the yyyymmdd range of 8 size
        // checking if the numbers in the index position between 4 and 6 are not within the month range of 1-12
        if (Integer.parseInt(date.substring(4,6)) < 1 || Integer.parseInt(date.substring(4,6)) > 12) return false;  
        // if it is then we assign it to the month integer variable
        int m = Integer.parseInt(date.substring(4,6));
        // creating an array of all possible max days in a month for comparison 
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // checking if the numbers in the index between 6 and 8 are within the range of values for max days in each month 
        if (Integer.parseInt(date.substring(6, 8)) < 1 || Integer.parseInt(date.substring(6, 8)) > monthDays[m - 1]) return false;
        // finally return true when all checks have been completed
        return true;
     } // close isValidDate
     



// This method compares two Date212 objects to determine their order
// first compares the year, then the month, and then the day
public int compareTo(Date212 otherDate) {
        
    if (this.year != otherDate.year) {
        return Integer.compare(this.year, otherDate.year);
    } else if (this.month != otherDate.month) {
        return Integer.compare(this.month, otherDate.month);
    } else {
        return Integer.compare(this.day, otherDate.day);
    }
} // close compareTo

    
    // Create a toString method that will return the date in the form mm/dd/yyyy 
    // using this method we wil display the dates in the GUI
    public String toString() {
        String yearStr = Integer.toString(year);
        String monthStr = Integer.toString(month);
        String dayStr = Integer.toString(day);
        return monthStr + "/" + dayStr + "/" + yearStr; //create the form for dates in mm/dd/yyyy
    }
} // close toString


