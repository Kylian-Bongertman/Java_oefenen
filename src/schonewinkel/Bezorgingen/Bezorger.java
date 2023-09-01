package schonewinkel.Bezorgingen;

public class Bezorger {

    public static void startBezorgAnimatie() throws InterruptedException {
        int huidigePositie = 0;
        int totaleAfstand = 10;
        StringBuilder animatieString = new StringBuilder();
        while (huidigePositie < totaleAfstand) {
            for (int i = 0; i < totaleAfstand; i++) {
                if (i == huidigePositie) {
                    // Tekening van het bezorgbusje
                    System.out.println(animatieString + "  ___");
                    System.out.println(animatieString + "    _-_-  _/\\______\\\\__");
                    System.out.println(animatieString + " _-_-__  / ,-. -|-  ,-.`-.");
                    System.out.println(animatieString + "    _-_- `( o )----( o )-'");
                    System.out.println(animatieString + "           `-'      `-'");
                }
            }
            animatieString.append("-----");
            Thread.sleep(1000); // Wacht 1 seconde voordat je de volgende toestand bijwerkt.
            huidigePositie++; // Verplaats het bezorgbusje met één positie naar rechts.
        }
    }
}
