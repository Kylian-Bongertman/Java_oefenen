package kebabzaak.Bezorgingen;

public class Bezorger {
    public void startBezorgAnimatie(double minutenOnderweg) {
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
