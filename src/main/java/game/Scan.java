package game;

import java.util.Scanner;

public class Scan {
    public static String scanString() {
        Scanner scan =  new Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }
}
