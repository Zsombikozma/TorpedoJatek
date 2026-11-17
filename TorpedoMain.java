package Torpedo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TorpedoMain {
    public static void main(String[] args) {
        char[][] tabla = {
                {'h', 'h', 'h', 'v', 'v', 'v'},
                {'v', 'v', 'v', 'v', 'v', 'h'},
                {'v', 'h', 'v', 'v', 'v', 'h'},
                {'v', 'h', 'v', 'v', 'v', 'v'},
                {'v', 'v', 'v', 'h', 'v', 'v'},
                {'v', 'v', 'v', 'v', 'v', 'v'}
        };

        Scanner sc = new Scanner(System.in);

        try {
            Torpedo t = new Torpedo(tabla);
            boolean fut = true;

            while (fut) {
                System.out.println();
                System.out.println(t);
                System.out.print("Sor és oszlop (pl. 1 2): ");

                try {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    String valasz = t.lo(x, y);
                    System.out.println(valasz);

                    if (valasz.startsWith("Nyertél")) {
                        System.out.println();
                        System.out.println(t);
                        fut = false;
                    }
                } catch (TorpedoException e) {
                    System.out.println("Hiba: " + e.getMessage());
                } catch (InputMismatchException e) {
                    System.out.println("Hiba: számokat írj be");
                    sc.nextLine();
                }
            }
        } catch (TorpedoException e) {
            System.out.println("Hibás tábla: " + e.getMessage());
        }

        sc.close();
    }
}