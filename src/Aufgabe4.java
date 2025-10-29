//Markus will ein USB Laufwerk und eine Tastatur kaufen. Der Elektronik- Shop hat
//verschiedene USB Laufwerke und Tastaturen mit verschiedene Preise.
//        1. Schreiben Sie eine Methode, welche die billigste Tastatur zurückgibt.
//z.B. [40 35 70 15 45] => 15
//        2. Schreiben Sie eine Methode, welche den teuersten Gegenstand zurückgibt.
//z.B. Tastatur = [15 20 10 35], USB = [20, 15, 40 15] => 40
//        3. Schreiben Sie eine Methode, welche das teuerste USB Laufwerk, das Markus kaufen
//kann, zurückgibt.
//        z.B. Preise = [15 45 20], Budget = 30 => 20
//        4. Finden Sie, anhand Markus’ Budget und der Preislisten für die Tastaturen und
//USB- Laufwerke, den maximalen Geldbetrag, der von Markus ausgegeben wird. Wenn
//er nicht genug für beide hat, geben Sie stattdessen  -1 zurück. Er kauft nur die zwei
//benötigten Gegenstände.
//z.B.
//        b=60, tastaturen = [40 50 60] und USB- Laufwerke = [8 12] => 50 + 8 = 58
//b=60, tastaturen = [60] und USB- Laufwerke = [8 12] => -1
//b=60, tastaturen = [40 60] und USB- Laufwerke = [8 12] => 40 + 12 = 52

public class Aufgabe4 {


    static int cheapestKeyboard(int[] k) {
        int min = k[0];
        for (int i = 1; i < k.length; i++) if (k[i] < min) min = k[i];
        return min;
    }


    static int mostExpensive(int[] k, int[] u) {
        int max = k[0];
        for (int x : k) if (x > max) max = x;
        for (int x : u) if (x > max) max = x;
        return max;
    }


    static int bestUsbWithinBudget(int[] u, int budget) {
        int best = -1;
        for (int x : u) if (x <= budget && x > best) best = x;
        return best;
    }


    static int maxSpend(int[] k, int[] u, int budget) {
        int best = -1;
        for (int a : k)
            for (int b : u) {
                int s = a + b;
                if (s <= budget && s > best) best = s;
            }
        return best;
    }


    public static void main(String[] args) {
        int[] keyboards = {40, 35, 70, 15, 45};
        int[] usbs      = {8, 12, 20};

        System.out.println("1) Cheapest keyboard = " + cheapestKeyboard(keyboards));          // 15
        System.out.println("2) Most expensive item = " + mostExpensive(keyboards, usbs));     // 70
        System.out.println("3) Best USB ≤30        = " + bestUsbWithinBudget(usbs, 30));      // 20
        System.out.println("4) Max spend ≤60       = " + maxSpend(keyboards, usbs, 60));      // 55 (ex.)
    }
}
