public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
      if (x1==x2) {

      } else {
          this.x1 = x1;
          this.x2 = x2;
          this.y1 = y1;
          this.y2 = y2;
      }
    }

    public double roundedToHundredth(double toRound) {
        double roundMore = toRound*100.0;
        return Math.round(roundMore)/100.0;
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1)));
    }

    public double slope() {
        if (x2-x1>0) {
            return roundedToHundredth(((double) y2 - y1) / ((double) x2 - x1));
        } else {
            return roundedToHundredth(((double) y2-y1)*-1) / Math.abs(((double) x2-x1));
        }
    }
    public double yIntercept() {
        return roundedToHundredth((double) y1-slope()*x1);
    }

    public String equation() {
        if (yIntercept()>0) {
            return "y = " + ( y2 - y1) + "/" + ( x2 - x1) + "x + " + yIntercept();
        } else if (yIntercept()==0) {
            return "y = " + (y2 - y1) + "/" + (x2 - x1);
        } else {
            return "y = " + ( y2 - y1) + "/" + ( x2 - x1) + "x - " + Math.abs(yIntercept());
        }
    }
    public void lineinfo() {
        System.out.println("The two points are: ("+x1+", "+y1+") and ("+x2+", "+y2+")");
        System.out.println("The equation of the line between these points is: "+equation());
        System.out.println("The slope of this line is: "+slope());
        System.out.println("The y-intercept of the line is: "+yIntercept());
        System.out.println("The distance between the two points is: "+distance());
    }

    public String coordinateForX(double xValue) {
        return "The point on the line is ("+xValue+", "+(roundedToHundredth(xValue*slope()+yIntercept()))+")";
    }

}
