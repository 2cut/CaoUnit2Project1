import java.util.Scanner;


public class LinearEquationRunner {
    public static void start() {
        System.out.println("Welcome!");
    }
    public static void main(String[] args) {

        // Using Scanner method to register user input for the two coordinate points
        Scanner scan = new Scanner(System.in);
        start();
        System.out.println("Enter coordinate 1:");
        String coord1 = scan.nextLine();
        System.out.println("Enter coordinate 2:");
        String coord2 = scan.nextLine();


        // removing symbols from the coordinate Strings, so it can be parsed
        if (coord1.contains("(")) {
            coord1 = coord1.replace("(","").replace(")","");
        }
        if (coord1.contains(",")) {
            coord1 = coord1.replace(",","");
        }
        if (coord2.contains("(")) {
            coord2 = coord2.replace("(","").replace(")","");
        }
        if (coord2.contains(",")) {
            coord2 = coord2.replace(",","");
        }

        // Parsing out the X and Y values from the user inputted String coords
        int x1 = Integer.parseInt(coord1.substring(0,coord1.indexOf(" ")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ")+1));
        int x2 = Integer.parseInt(coord2.substring(0,coord2.indexOf(" ")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ")+1));

        // Setting those X and Y values to a constructor
        LinearEquation eq = new LinearEquation(x1, y1, x2, y2);
        // Prints out the line's information
        System.out.println(eq.lineinfo());

        // To find the point on the line when a user enters a X value
        System.out.println("\nEnter a value for x: ");
        double x = scan.nextDouble();

        // Prints out the point found to the user
        System.out.println("The point on the line is "+ eq.coordinateForX(x));
    }
}