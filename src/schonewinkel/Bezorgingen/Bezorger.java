package schonewinkel.Bezorgingen;

import java.io.FileWriter;

public class Bezorger {
    public static void startBezorgAnimatie(double minutenOnderweg) throws Exception{
            char[] animationChars = new char[]{'|', '/', '-', '\\'};

            for (int i = 0; i <= minutenOnderweg; i++) {
                System.out.print("Nog: " + (minutenOnderweg - i) + " minuten onderweg " + animationChars[i % 4] + "\r");

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Hoi, hier is uw bestelling!");
        }
    }
