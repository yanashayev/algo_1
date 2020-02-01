package doughnut;

public class doughnut {
    public static void main(String[] args) {
        System.out.println(howmuch(5, 2));

    }

    public static int howmuch(int numofdo, int numofspace) {
        if (numofdo <= numofspace) {
            return 2;
        }
        if (numofdo % numofspace == 0) {
            return 2 * (numofdo / numofspace);
        }
        int shalem = numofdo / numofspace - 1;
        return 2 * shalem + 3;
    }
}