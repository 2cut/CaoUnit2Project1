import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        System.out.println("Enter coordinate 1:");
        String coord1 = scan.nextLine();
        System.out.println("Enter coordinate 2:");
        String coord2 = scan.nextLine();

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

        int x1 = Integer.parseInt(coord1.substring(0,coord1.indexOf(" ")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(" ")+1));
        int x2 = Integer.parseInt(coord2.substring(0,coord2.indexOf(" ")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(" ")+1));

        LinearEquation eq = new LinearEquation(x1, y1, x2, y2);
        eq.lineinfo();

        System.out.println("\nEnter a value for x: ");
        int x = scan.nextInt();

        System.out.println("The point on the line is "+ eq.coordinateForX(x));
    }
}