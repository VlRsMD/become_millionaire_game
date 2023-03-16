package game;

import java.util.Scanner;

public class StringScanner {
    public String scanString() {
        java.util.Scanner scan =  new java.util.Scanner(System.in);
        String str = scan.nextLine();
        return str;
    }
}
