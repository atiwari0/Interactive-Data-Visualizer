/**
(1) Prompt the user for a title for data. Output the title. (1 pt)

Ex:

Enter a title for the data:
Number of Novels Authored
You entered: Number of Novels Authored

(2) Prompt the user for the headers of two columns of a table. Output the column headers. (1 pt)

Ex:

Enter the column 1 header:
Author name
You entered: Author name

Enter the column 2 header:
Number of novels
You entered: Number of novels

(3) Prompt the user for data points. Data points must be in this format: string, int. Store the information before the comma into a string variable and the information after the comma into an integer. The user will enter -1 when they have finished entering data points. Output the data points. Store the string components of the data points in an ArrayList of strings. Store the integer components of the data points in a second ArrayList of integers. (4 pts)

Ex:

Enter a data point (-1 to stop input):
Jane Austen, 6
Data string: Jane Austen
Data integer: 6

(4) Perform error checking for the data point entries. If any of the following errors occurs, output the appropriate error message and prompt again for a valid data point.

If entry has no comma
Output: Error: No comma in string. (1 pt)
If entry has more than one comma
Output: Error: Too many commas in input. (1 pt)
If entry after the comma is not an integer
Output: Error: Comma not followed by an integer. (2 pts)

Ex:

Enter a data point (-1 to stop input):
Ernest Hemingway 9
Error: No comma in string.

Enter a data point (-1 to stop input):
Ernest, Hemingway, 9
Error: Too many commas in input.

Enter a data point (-1 to stop input):
Ernest Hemingway, nine
Error: Comma not followed by an integer.

Enter a data point (-1 to stop input):
Ernest Hemingway, 9
Data string: Ernest Hemingway
Data integer: 9

(5) Output the information in a formatted table. The title is right justified with a minimum of 33 characters. Column 1 is left justified with a minimum of 20 characters. Column 2 is right justified with a minimum of 23 characters. (3 pts)

Ex:

        Number of Novels Authored
Author name         |       Number of novels
--------------------------------------------
Jane Austen         |                      6
Charles Dickens     |                     20
Ernest Hemingway    |                      9
Jack Kerouac        |                     22
F. Scott Fitzgerald |                      8
Mary Shelley        |                      7
Charlotte Bronte    |                      5
Mark Twain          |                     11
Agatha Christie     |                     73
Ian Flemming        |                     14
Stephen King        |                     54
Oscar Wilde         |                      1

(6) Output the information as a formatted histogram. Each name is right justified with a minimum of 20 characters. (4 pts)

Ex:

         Jane Austen ******
     Charles Dickens ********************
    Ernest Hemingway *********
        Jack Kerouac **********************
 F. Scott Fitzgerald ********
        Mary Shelley *******
    Charlotte Bronte *****
          Mark Twain ***********
     Agatha Christie *************************************************************************
        Ian Flemming **************
        Stephen King ******************************************************
         Oscar Wilde *
*/

import java.util.Scanner;
import java.util.ArrayList;

public class DataVisualizer {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      // Prompting for title
      System.out.println("Enter a title for the data:");
      String title = scnr.nextLine();
      System.out.println("You entered: " + title);
      System.out.println("");

      // Prompting for the headers of two columns
      System.out.println("Enter the column 1 header:");
      String column1Header = scnr.nextLine();
      System.out.println("You entered: " + column1Header);
      System.out.println("");

      System.out.println("Enter the column 2 header:");
      String column2Header = scnr.nextLine();
      System.out.println("You entered: " + column2Header);
      System.out.println("");

      // Prompting the user for data points
      ArrayList<String> dataString = new ArrayList<>();
      ArrayList<Integer> dataInteger = new ArrayList<>();

      while (true) {
         System.out.println("Enter a data point (-1 to stop input):");
         String data = scnr.nextLine().trim();

         if (data.equals("-1")) {
            break;
         }

         // Counting the no. of commas
         int commaCount = 0;
         for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) == ',') {
               commaCount++;
            }
         }

         // Checking no. of commas
         if (commaCount == 0) {
            System.out.println("Error: No comma in string.");
            System.out.println("");
            continue;
         } else if (commaCount > 1) {
            System.out.println("Error: Too many commas in input.");
            System.out.println("");
            continue;
         }

         String[] parts = data.split(",", 2); // Splitting data into two parts
         String dataStr = parts[0].trim();
         String dataIntStr = parts[1].trim();

         // Checking if the integer part is correct
         try {
            int dataInt = Integer.parseInt(dataIntStr);
            dataString.add(dataStr);
            dataInteger.add(dataInt);
            System.out.println("Data string: " + dataStr);
            System.out.println("Data integer: " + dataInt);
            System.out.println("");
         } catch (NumberFormatException e) {
            System.out.println("Error: Comma not followed by an integer.");
            System.out.println("");
         }
      }

      // Formatting table
      System.out.printf("\n%33s\n", title);
      System.out.printf("%-20s|%23s\n", column1Header, column2Header);
      System.out.println("--------------------------------------------");

      for (int i = 0; i < dataString.size(); i++) {
         String str = dataString.get(i);
         int num = dataInteger.get(i);
         System.out.printf("%-20s|%23d\n", str, num);
      }
      System.out.println("");

      // Showing histogram
      for (int i = 0; i < dataString.size(); i++) {
         String name = dataString.get(i);
         int num = dataInteger.get(i);
         StringBuilder stars = new StringBuilder();
         for (int j = 0; j < num; j++) {
            stars.append("*");
         }
         System.out.printf("%20s %s\n", name, stars.toString());
      }
   }
}
