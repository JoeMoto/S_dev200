package Mod1PA1;

public class assign6_9 {

    public static void main(String[] args) {

        System.out.println("Feet\tMeters\t|\tMeters\tFeet");
        System.out.println("----------------|---------------------");

        double j = 20;
        for (double i = 1; i <= 10; i++, j = j + 5) {

            System.out.printf("%.1f\t%.3f\t|\t%.1f\t%.3f\n", i, footToMeter(i), j, meterToFoot(j));
        }
    }

    /** Convert from feet to meters */
    public static double footToMeter(double foot) {
        double f = foot;

        double meter = 0.305 * f;
        return meter;
    }

    /** Convert from meters to feet */
    public static double meterToFoot(double meter) {
        double m = meter;

        double foot = 3.279 * m;
        return foot;
    }
}