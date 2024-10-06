import java.util.ArrayList;

public class Delimiters {

    private String openDel;
    private String closeDel;

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    public String getOpenDel() { // Getter method to get open delimiter
        return openDel;
    }

    public String getCloseDel() { // Getter method to get close delimiter
        return closeDel;
    }

    public ArrayList<String> getDelimitersList(String[] tokens) { //token variable represents each individual element in the tokens array that is being iterated over
        ArrayList<String> delimitersList = new ArrayList<>(); // ArrayList to store delimiters

        for (int i = 0; i < tokens.length; i++) { //can also use --> for (String token : tokens) {
            String token = tokens[i];
            if (token.equals(openDel) || token.equals(closeDel)) {
                delimitersList.add(token); // Add the delimiter to the list
            }
        }

        return delimitersList;
    }

    // checking if delimiters are balanced
    public boolean isBalanced(ArrayList<String> delimiters) {
        int openCount = 0;
        int closeCount = 0;

        for (String delimiter : delimiters) {
            if (delimiter.equals(openDel)) {
                openCount++;
            } else if (delimiter.equals(closeDel)) {
                closeCount++;
            }

            if (closeCount > openCount) {
                return false; // this is because delimiters are not balanced
            }
        }

        return openCount == closeCount; // return true if balanced, false otherwise
    }
}