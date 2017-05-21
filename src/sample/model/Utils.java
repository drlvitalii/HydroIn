package sample.model;

import java.text.DecimalFormat;

/**
 * Created by mr.Green on 20.05.2017.
 */
public class Utils {
    public static final double WATER_HEAT_KOEF = 4.187;
    public static final int TIME_ENERGY_KOEF = 3600;
    public static final double SPEED_KOEF = 0.354;


    public static int calcRate(int power, int delta) {
        return (int) (TIME_ENERGY_KOEF * power / WATER_HEAT_KOEF / delta);
    }

    public static String calcDrop(String rateStr, String koefStr, String outDiamStr) {
        DecimalFormat format = new DecimalFormat("##.###");
        double koef = Double.parseDouble(koefStr);
        int rate = Integer.parseInt(rateStr);
        String[] parseDiam = outDiamStr.split("x");
        double outDiam = Double.parseDouble(parseDiam[0]);
        double pipeThick = Double.parseDouble(parseDiam[1]);
        double innerDiam = outDiam - 2 * pipeThick;
        double drop = 62544 * 0.97 * rate * rate / Math.pow(innerDiam, 5) * (0.25 / Math.pow((Math.log10(innerDiam / koef)
                + 0.57), 2) + Math.pow((0.938 / Math.log10(354 * rate / 0.36 / innerDiam)), 2.393)
                * Math.exp(-3.05 * Math.pow((koef * rate / 0.36 / innerDiam / innerDiam), 0.33)));
        return format.format(drop);
    }

    public static String calcSpeed(String rateStr, String outDiamStr) {
        DecimalFormat format = new DecimalFormat("##.###");
        int rate = Integer.parseInt(rateStr);
        String[] parseDiam = outDiamStr.split("x");
        double outDiam = Double.parseDouble(parseDiam[0]);
        double pipeThick = Double.parseDouble(parseDiam[1]);
        double innerDiam = outDiam - 2 * pipeThick;
        double speed = SPEED_KOEF * rate / innerDiam / innerDiam;
        return format.format(speed);
    }
}
