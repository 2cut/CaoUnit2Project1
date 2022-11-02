public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // 4 parameter constructor method to set both points' X and Y coordinates
    public LinearEquation(int x1, int y1, int x2, int y2) {
      if (x1==x2) {
        System.out.println("The two points you have entered are on a vertical line, x = "+x1);
        System.exit(0);
      } else {
          this.x1 = x1;
          this.x2 = x2;
          this.y1 = y1;
          this.y2 = y2;
      }
    }

   // Rounds double to the nearest Hundredth
    public double roundedToHundredth(double toRound) {
        double roundMore = toRound*100.0;
        return Math.round(roundMore)/100.0;
    }

    // Calculates distance of the two points rounded to the nearest hundredth
    public double distance() {
        return roundedToHundredth(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }

    // Calculates the slope of the two points rounded to the nearest hundredth in decimal form using the (y2-y1)/(x2-x1) formula
    // The double cast makes sure the int values can divide properly without losing data
    public double slope() {
        if (x2-x1>0) {
            return roundedToHundredth(((double) y2 - y1) / ((double) x2 - x1));
        } else {
            return roundedToHundredth(((double) y2-y1)*-1) / Math.abs(((double) x2-x1));
        }
    }

    //Calculates the Y intercept rounded to the nearest hundredth by plugging in a pair of X and Y values to the equation
    public double yIntercept() {
        return roundedToHundredth((double) y1-slope()*x1);
    }

    // Returns a String that prints out the equation of the line where the slope is in fractional form
    public String equation() {
        // Checks if line passes through origin
        if (slope()==1 & yIntercept()==0.0) {
            return "y = x";
        }

        // Checks if slope is 1 or -1 and only prints x or -x
        if (slope()==1) {
            return "y = x + "+yIntercept();
        } else if (slope()==-1) {
            return "y = -x + "+yIntercept();
        }

        // Checks if the line is horizontal
        if (y2==y1) {
            return "y = "+y1;
        }

        // Checks if slope is negative and moves the sign to the front of the expression instead of ex: 5/-4
        if (x2 - x1 < 0) {
                // Properly prints out whole numbers without the fraction
                if (slope() % 1 == 0) {
                    return "y = " + (int)(slope()) + "x + " + yIntercept();
                } else {
                    return "y = " + (y2 - y1) * -1 + "/" + Math.abs(x2 - x1) + "x + " + yIntercept();
                }
            }
        // Checks if yIntercept is greater than 0
        if (yIntercept() > 0) {
                if (slope() % 1 == 0) {
                    return "y = " + (int)(slope()) + "x + " + yIntercept();
                }
                return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
            }
        // If Y intercept is zero it does not include the Y intercept
        if (yIntercept() == 0) {
                if (slope() % 1 == 0) {
                    return "y = " + (int)(slope()) + "x";
                }
                return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x";
                // When the Y intercept is negative it exchanges the plus sign for a negative sign
            } else {
                if (slope() % 1 == 0) {
                    return "y = " + (int)(slope()) + "x - " + Math.abs(yIntercept());
                }
                return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x - " + Math.abs(yIntercept());
            }
        }


    // Prints all information of the line using previous methods
    public String lineinfo() {
        return ("The two points are: ("+x1+", "+y1+") and ("+x2+", "+y2+")\nThe equation of the line between these points is: "+equation()+"\nThe slope of this line is: "+roundedToHundredth(slope())+"\nThe y-intercept of the line is: "+yIntercept()+"\nThe distance between the two points is: "+distance());
    }

    // Plugs user given X value to the equation to find the point on the line
    public String coordinateForX(double xValue) {
        return "The point on the line is ("+xValue+", "+(roundedToHundredth(xValue*slope()+yIntercept()))+")";
    }

}
