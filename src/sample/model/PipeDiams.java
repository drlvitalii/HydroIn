package sample.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mr.Green on 17.05.2017.
 */
public class PipeDiams {
    public static Map<String, String> steelDiams = new HashMap<>();
    public static Map<String, String> cuprumDiams = new HashMap<>();
    public static Map<String, String> pprDiams = new HashMap<>();

    public static void setSteelDiams() {
        steelDiams.put("Dy15", "21.3x2.8");
        steelDiams.put("Dy20", "26.8x2.8");
        steelDiams.put("Dy25", "33.5x2.8");
        steelDiams.put("Dy32", "42.3x3.2");
        steelDiams.put("Dy40", "48x3.2");
        steelDiams.put("Dy50", "57.3x3.5");
        steelDiams.put("Dy65", "76x3.5");
    }

    public static void setCuprumDiams() {
        cuprumDiams.put("Dy15", "18x1");
        cuprumDiams.put("Dy20", "22x1");
        cuprumDiams.put("Dy25", "28x1");
        cuprumDiams.put("Dy32", "35x1.5");
        cuprumDiams.put("Dy40", "42x1.5");
        cuprumDiams.put("Dy50", "54x2");
        cuprumDiams.put("Dy65", "65x2");
    }

    public static void setPprDiams() {
        pprDiams.put("Dy15", "20x2.8");
        pprDiams.put("Dy20", "25x3.5");
        pprDiams.put("Dy25", "32x4.4");
        pprDiams.put("Dy32", "40x5.5");
        pprDiams.put("Dy40", "50x6.9");
        pprDiams.put("Dy50", "63x8.6");
        pprDiams.put("Dy65", "75x10.3");
    }

    public static void setAllDiams() {
        setSteelDiams();
        setCuprumDiams();
        setPprDiams();
    }

    public static String getDiam(String pipeInnerDiam, String pipeType) {
        setAllDiams();
        String pipeOutDiam = null;
        switch (pipeType) {
            case "steel":
                pipeOutDiam = steelDiams.get(pipeInnerDiam);
                break;
            case "cuprum":
                pipeOutDiam = cuprumDiams.get(pipeInnerDiam);
                break;
            case "ppr":
                pipeOutDiam = pprDiams.get(pipeInnerDiam);
                break;
        }
        return pipeOutDiam;
    }


}
